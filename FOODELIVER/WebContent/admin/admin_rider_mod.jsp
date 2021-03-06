<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page import="java.sql.*" %>
    <%@ page import="javax.sql.*" %>
    <%@ page import="javax.naming.*" %>
    <%@ page import="rider.vo.Rider"%>
	<%Rider rider=(Rider)session.getAttribute("rider"); %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
	body{
		min-width:1000px;padding:0;margin:0;
	}
	.footer{
		width:100%;
		height:200px;
		background:rgb(250,250,250);
		margin-top:200px;	
		min-width:1000px;
	}
	hr{
		border:1px solid rgb(230,230,230);
		
	}
	table{
		width:800px;font-size:20px;
		margin:auto;
		border-collapse:collapse;
		height:800px;
	}
	td,th{
		border-top:1px solid rgb(220,220,220);
		text-align:center;
	}
	input{
		border-radius:5px/5px;
		font-size:15px;
		padding-left:10px;
		height:25px;
	}
	@media screen and (max-width: 2000px) {
  		.totalmenu{
  			margin-left:55%;
  		}
	}
	@media screen and (max-width: 1200px) {
  		.totalmenu{
  			margin-left:35%;
  		}
	}
</style>


<script src="https://t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>
<script>
    function sample6_execDaumPostcode() {
        new daum.Postcode({
            oncomplete: function(data) {
                // 팝업에서 검색결과 항목을 클릭했을때 실행할 코드를 작성하는 부분.

                // 각 주소의 노출 규칙에 따라 주소를 조합한다.
                // 내려오는 변수가 값이 없는 경우엔 공백('')값을 가지므로, 이를 참고하여 분기 한다.
                var addr = ''; // 주소 변수
                var extraAddr = ''; // 참고항목 변수

                //사용자가 선택한 주소 타입에 따라 해당 주소 값을 가져온다.
                if (data.userSelectedType === 'R') { // 사용자가 도로명 주소를 선택했을 경우
                    addr = data.roadAddress;
                } else { // 사용자가 지번 주소를 선택했을 경우(J)
                    addr = data.jibunAddress;
                }

                // 사용자가 선택한 주소가 도로명 타입일때 참고항목을 조합한다.
                if(data.userSelectedType === 'R'){
                    // 법정동명이 있을 경우 추가한다. (법정리는 제외)
                    // 법정동의 경우 마지막 문자가 "동/로/가"로 끝난다.
                    if(data.bname !== '' && /[동|로|가]$/g.test(data.bname)){
                        extraAddr += data.bname;
                    }
                    // 건물명이 있고, 공동주택일 경우 추가한다.
                    if(data.buildingName !== '' && data.apartment === 'Y'){
                        extraAddr += (extraAddr !== '' ? ', ' + data.buildingName : data.buildingName);
                    }
                    // 표시할 참고항목이 있을 경우, 괄호까지 추가한 최종 문자열을 만든다.
                    if(extraAddr !== ''){
                        extraAddr = ' (' + extraAddr + ')';
                    }
                    // 조합된 참고항목을 해당 필드에 넣는다.
                    document.getElementById("sample6_extraAddress").value = extraAddr;
                
                } else {
                    document.getElementById("sample6_extraAddress").value = '';
                }

                // 우편번호와 주소 정보를 해당 필드에 넣는다.
                document.getElementById('sample6_postcode').value = data.zonecode;
                document.getElementById("sample6_address").value = addr;
                // 커서를 상세주소 필드로 이동한다.
                document.getElementById("sample6_detailAddress").focus();
            }
        }).open();
    }
</script>
<script>
	var chkId=false;
	var idcheck;
	function chkForm(f){
		
		if(f.pass.value.trim()==""){
			alert("비밀번호를 입력하세요");
			f.pass.focus();
			return false;
		}
		if(f.passcheck.value.length<6){
			alert("비밀번호는 6자에서 12까지 가능합니다.");
			f.pass.focus();
			return false;
		}
		if(f.passcheck.value.length>12){
			alert("비밀번호는 6자에서 12자까지 가능합니다.");
			f.pass.focus();
			return false;
		}
		if(f.pass.value.trim()!=f.passcheck.value.trim()){
			alert("비밀번호가 일치하지 않습니다.");
			f.pass.value="";
			f.passcheck.value="";
			f.pass.focus();
			return false;
		}
		if(f.address1.value==''){
			alert('주소를 기입하세요');
			f.address1.focus();
			return false;
		}
		if(f.address2.value==''){
			alert('주소를 기입하세요');
			f.address2.focus();
			return false;
		}
		
		f.submit();
	} //아이디 받아서 널이거나 빈값이면 
	function checkemail(){
		var email = document.getElementById("email").value;
		var url = "<%=request.getContextPath()%>/checkemail.riderlog?" + "checkemail=" + email;
		window.open(url, '', 'width=700', 'height=500');
	}
	function checkemailsuccess(){
		var certifykeyEX=document.getElementById("certifykeyEX").value;
		var certifyid=document.getElementById("id").value;
		var url="<%=request.getContextPath()%>/checkemailsuccess.riderlog?"+"certifykeyEX="+certifykeyEX;
		window.open(url,'','width=700','height=500');
	}
	
	function isSame(){
		
		
		if(document.getElementById('pass').value.length<6 ||
				document.getElementById('pass').value.length>12){
			document.getElementById('same').innerHTML='비밀번호는 6~12자 입력하셔야 합니다.';
			document.getElementById('same').style.color='red';
		}else{
			document.getElementById('same').innerHTML='';
		}
		if(document.getElementById('passcheck').value.length<6 || 
				document.getElementById('passcheck').value.length>12){
			document.getElementById('same2').innerHTML='비밀번호는 6~12자 입력하셔야 합니다.';
			document.getElementById('same2').style.color='red';
		}else{
			document.getElementById('same2').innerHTML='';
		}
		if(document.getElementById('pass').value==document.getElementById('passcheck').value&&document.getElementById('pass').value!=''&&document.getElementById('passcheck').value!=''){
			document.getElementById('same2').innerHTML='비밀번호가 일치합니다.';
			document.getElementById('same2').style.color='blue';
		}else{
			document.getElementById('same2').innerHTML='비밀번호가 일치하지 않습니다.';
			document.getElementById('same2').style.color='red';
		}
		if(document.getElementById('pass').value==''&&document.getElementById('passcheck').value==''){
			document.getElementById('same').innerHTML='';
			document.getElementById('same2').innerHTML='';
		}
	}
	function viewmenu(opt) {
		  if(opt) {
			  menu_content.style.display = "block";
		  }
		  else {
			  menu_content.style.display = "none";
		  }
		
	}
</script>
</head>
<body>
	<div style="min-width:1000px;margin:auto;padding-top:20px">
	<div style="width:270px;margin:auto;">
	<a href="<%=request.getContextPath() %>/adminMain.jsp"><img src="<%=request.getContextPath() %>/rider_image/logo.png"/></a></div></div>
	<div style="min-width:1000px;margin:auto">
	<div style="min-width:1000px;margin:auto">
	<span style=" margin-left:77%;font-size:25px;display:inline-block;height:40px;font-family: 'Jua', sans-serif;" onmouseover="viewmenu(true)" onmouseout="viewmenu(false)">전체 메뉴</span>
	</div></div>
	<div id="menu_content" class="totalmenu" style="position:absolute; z-index:1; width:550px; height:200px;background:white;border:2px solid #c0c0c0; display:none" onmouseover="viewmenu(true)" onmouseout="viewmenu(false)">
	
	<ul style="list-style-type:none;padding-left:30px;float:left;">
		<li><img src="<%=request.getContextPath() %>/rider_image/logo2.png"></li>
		<li style="padding:10px 0px 20px 0px;font-size:20px;">로그인</li>
		<%if((String)session.getAttribute("adminid")==null){ %>
		<li><a href="<%=request.getContextPath() %>/admin/loginForm.jsp">로그인하기</a></li>
		<li style="padding-bottom:5px"></li>
		<%}else{ %>
		<li style="padding-left:5px;"><a href="<%=request.getContextPath()%>/logout.adm">로그아웃</a>
		<%} %>
	</ul>
	<div style="border-left: 2px solid #f0f0f0;height: 200px;float:left;margin-left:30px"></div>
	<ul style="list-style-type:none;padding-left:30px;float:left;">
		<li><img src="<%=request.getContextPath() %>/rider_image/logo3.png"></li>
		<li style="padding:10px 0px 20px 0px;font-size:20px;">내 정보</li>
		<li><a href="<%=request.getContextPath() %>/adminInfo.adm?Option=see">내 정보 보기</a></li>
		<li style="padding-bottom:5px"></li>
	</ul>
	<div style="border-left: 2px solid #f0f0f0;height:200px;float:left;margin-left:30px"></div>
	<ul style="list-style-type:none;padding-left:30px;float:left;">
		<li style="padding-left:15px;padding-top:10px;"><img src="<%=request.getContextPath() %>/rider_image/logo12.png"></li>
		<li style="padding:10px 0px 20px 0px;font-size:20px;">회원 관리</li>
		<li style="padding-left:15px;"><a href="<%=request.getContextPath() %>/getRiderList.adm">배달 회원</a></li>
		<li style="padding-left:15px;"><a href="<%=request.getContextPath()%>/companylist.comadm">기업 목록</a></li>
		<li style="padding-bottom:5px"></li>
	</ul>
	<div style="border-left: 2px solid #f0f0f0;height:200px;float:left;margin-left:30px"></div>
	<ul style="list-style:none;padding-left:30px;float:left;">
		<li style="padding-left:10px;padding-top:5px"><img src="<%=request.getContextPath() %>/rider_image/logo13.png"></li>
		<li style="padding:10px 0px 20px 0px;font-size:20px;">기업 관리</li>
		<li style="padding-left:15px;"><a href="#">가게 목록</a></li>
	</ul>
</div>
<div style="clear:both;"></div>
<br>
<jsp:include page="../menu_top_admin.jsp" />

	<div style="padding-top:70px;width:1000px;margin:auto;" >
		<div style="float:left;margin-left:50px;">
		<img src="<%=request.getContextPath() %>/rider_image/logo14.png"></div>
		<div style="padding-top:20px;">
		<span style="font-size:30px;font-weight:700;padding-left:30px;">배달 회원 정보 수정</span></div><br><br>
		<hr>
	</div>

	<form name="modifycheck" action="riderModPro.adm" method="post" onsubmit="return chkForm(this)">
	<table style="margin-top:70px;">
		
		<tr>
			<th style="border-top:0px;">아이디</th>
			<td style="border-top:0px;"><%=rider.getRider_id() %>
			<input type="hidden" value="<%=rider.getRider_id()%>" name="id" required>
			</td>
		</tr>
		<tr>
			<th rowspan="2"><label for="pass">비밀번호</label></th>
			<td><input type="password" name="pass" id="pass" autocomplete="new-password"
			value="<%=rider.getRider_pass()%>" style="width:150px;" onkeyup="isSame()"></td>
		</tr>
		<tr>
			<td style="height:30px;border-top:0"><span id="same"></span></td>
		</tr>
		<tr>
			<th rowspan="2"><label for="passcheck">비밀번호 확인</label></th>
			<td><input type="password" name="passcheck" id="passcheck" onkeyup="isSame()" style="width:150px;"></td>
		</tr>
		<tr>
			<td style="height:30px;border-top:0px"><span id="same2"></span></td>
		</tr>
		<tr>
			<th><label for="name">이름</label></th>
			<td><input type="text" name="name" id="name"
			value="<%=rider.getRider_name()%>" style="width:100px;"></td>
		</tr>
		<tr>
			<th><label for="age">나이</label></th>
			<td><input type="text" name="age" id="age"
			value="<%=rider.getRider_age()%>" style="width:50px;"></td>
		</tr>
		<tr>
			<th><label for="gender1"></label>성별</th>
			<td>
				<div style="width:180px;margin:auto;">
				<div style="float:left">
				<input type="radio" name="gender" value="남" id="gender1"
				<%if(rider.getRider_gender().equals("남")) {%>checked<%} %>></div>
				<div style="float:left;padding-top:1px;"><label for="gender1">남자</label></div><div style="float:left;">&nbsp;&nbsp;</div>
				<div style="float:left;"><input type="radio" name="gender" value="여" id="gender2"
				<%if(rider.getRider_gender().equals("여")) {%>checked<%} %>></div>
				<div style="float:left;padding-top:1px;"><label for="gender2">여자</label></div>
				</div>
			</td>
		</tr>
		<tr>
			<th><label for="tel"></label>휴대폰번호</th>
			<td>
				<input type="text" name="tel" id="tel" value="<%=rider.getRider_tel() %>" style="width:150px;">
			</td>
		</tr>
		<tr>
			<th><label for="email">이메일 주소</label></th>
			<td><input type="text" name="email" id="email"
			value="<%=rider.getRider_email()%>" required/>
			</td>
		</tr>
		
		<tr>
			<th rowspan="3">주소 </th>
			<td><input type="text" name="address1" id="sample6_postcode" value="<%=rider.getRider_address1() %>" size="7" required>
			<input type="button" onclick="sample6_execDaumPostcode()" value="우편번호 찾기" style="height:33px;"></td>
		</tr>
		<tr>
			<td><input type="text" name="address2" id="sample6_address" value="<%=rider.getRider_address2() %>" size="40" required> 
			</td> 
		</tr>
		<tr>
			<td><input type="text" name="address3" id="sample6_detailAddress" value="<%=rider.getRider_address3() %>">
			<input type="text" name="address4" id="sample6_extraAddress" value="<%=rider.getRider_address4() %>"></td>
		</tr>
		<tr>
			<th><label for="count">배달 완료 건 수</label></th>
			<td><input type="text" name="count" id="count" value="<%=rider.getRider_count() %>" style="width:50px;"></td>
		</tr>
		<tr>
			<th><label for="action1"></label>활성상태</th>
			<td>
				<div style="width:180px;margin:auto;">
				<div style="float:left">
				<input type="radio" name="action" value="활성상태" id="action1"
				<%if(rider.getRider_active().equals("활성상태")) {%>checked<%} %>/></div>
				<div style="float:left;padding-top:1px;"><label for="action1">활성</label></div><div style="float:left;">&nbsp;&nbsp;</div>
				<div style="float:left;">
				<input type="radio" name="action" value="비활성상태" id="action2"
				<%if(rider.getRider_active().equals("비활성상태")) {%>checked<%} %>/></div>
				<div style="float:left;padding-top:1px;"><label for="action2">비활성</label></div>
				</div>
			</td>
		</tr>
		<tr>
			<th><label for="reason">비활성 사유</label></th>
			<td><input type="text" name="reason" id="reason" value="<%=rider.getRider_reason() %>" style="width:150px;"></td>
		</tr>
		<tr>
			<th><label for="state">배달 중 상태</label></th>
			<td><input type="text" name="state" id="state" value="<%=rider.getRider_state() %>" style="width:150px;"></td>
		</tr>
		<tr>
			<th colspan="2" style="padding-top:70px;">
				<button type="button" onclick="javascript:chkForm(document.modifycheck)"
				style="cursor:pointer;width:130px;height:40px;font-size:20px;font-weight:bold;border:1px solid black;background:white;">
				수정</button>
				&nbsp;&nbsp;<button type="button" onclick="javascript:history.back()"
				style="cursor:pointer;width:130px;height:40px;font-size:20px;font-weight:bold;border:1px solid black;background:white;margin-left:50px;">
				취소</button>
			</th>
		</tr>	
	</table>
		<input type="hidden" value="true" name="checkfinalemail" id="checkfinalemail">
	</form>
	
		 
	<div class="footer">
		<div style="padding-left:10%;padding-top:20px">
			<span style="font-size:17px;">(유)푸딜리버리</span><br><br>
			<p>대구광역시 수성구 국채보상로 924 동우빌딩 2층 (유)푸딜리버리 &nbsp;&nbsp;&nbsp;&nbsp;
			|&nbsp;&nbsp;&nbsp;&nbsp; 대표자 : kbe &nbsp;&nbsp;&nbsp;&nbsp;
			| &nbsp;&nbsp;&nbsp;&nbsp;사업자 등록번호 : 311-41-564245</p><br>
			<span style="font-size:18px;font-weight:bold">배달원 문의 : 1577-8282</span>
		</div>
	</div>
</body>
</html>
