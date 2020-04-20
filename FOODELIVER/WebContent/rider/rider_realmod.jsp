<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page import="rider.vo.Rider" %>
    <%
    Rider rider=(Rider)session.getAttribute("rider");
    %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>FOODELIVER 배달원 : 정보 수정</title>
<style>
	body{
		min-width:1000px;margin:0;padding:0;
	}
	table{
		width:700px;
		height:500px;font-size:20px;
		border-collapse:collapse;
		height:800px;
	}
	td,th{
		border-top:1px solid rgb(220,220,220);
		text-align:center;
		
		
	}
	.footer{
		width:100%;
		height:200px;
		background:rgb(250,250,250);
		min-width:1000px;
		margin-top:200px;
	}
	hr{
		border:1px solid rgb(230,230,230);
		
	}
	table a{
		color:#3EB1B0;
		font-size:18px;
		
	}
	input{
		padding-left:10px;
		height:30px;
		font-size:20px;
		border-radius:2px/2px;
	}
	
</style>
<script>

function viewmenu(opt) {
	  if(opt) {
		  menu_content.style.display = "block";
	  }
	  else {
		  menu_content.style.display = "none";
	  }
	
}
function chkForm(f){
	
	if(f.age.value==''){
		alert('나이를 입력하세요');
		f.age.focus();
		return false;
	}
	if(f.tel.value==''){
		alert('휴대폰 번호를 입력하세요');
		f.tel.focus();
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
}
</script>
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
</head>
<body>
<div style="min-width:1000px;margin:auto;padding-top:20px">
	<div style="width:270px;margin:auto;">
	<a href="<%=request.getContextPath() %>/riderMain.jsp"><img src="<%=request.getContextPath() %>/rider_image/logo.png"/></a></div></div>
	<div style="min-width:1000px;margin:auto">
	<div style="min-width:1000px;margin:auto">
	<span style=" margin-left:77%;font-size:25px;display:inline-block;height:40px;font-family: 'Jua', sans-serif;" onmouseover="viewmenu(true)" onmouseout="viewmenu(false)">전체 메뉴</span>
	</div></div>
	<div id="menu_content" style="position:absolute; z-index:1; width:400px; height:200px;background:white;border:2px solid #c0c0c0;margin-left:60%; display:none" onmouseover="viewmenu(true)" onmouseout="viewmenu(false)">
	
	<ul style="list-style-type:none;padding-left:30px;float:left;">
		<li><img src="<%=request.getContextPath() %>/rider_image/logo2.png"></li>
		<li style="padding:10px 0px 20px 0px;font-size:20px;">로그인</li>
		<%if(session.getAttribute("riderid")==null){ %>
		<li><a href="<%=request.getContextPath() %>/rider/loginForm.jsp">로그인하기</a></li>
		<li style="padding-bottom:5px"></li>
		<li><a href="<%=request.getContextPath() %>/joinForm.ridermem">회원가입</a></li>
		<%}else{ %>
		<li><a href="<%=request.getContextPath()%>/logout.riderlog">로그아웃</a>
		<%} %>
	</ul>
	<div style="border-left: 2px solid #f0f0f0;height: 200px;float:left;margin-left:30px"></div>
	<ul style="list-style-type:none;padding-left:30px;float:left;">
		<li><img src="<%=request.getContextPath() %>/rider_image/logo3.png"></li>
		<li style="padding:10px 0px 20px 0px;font-size:20px;">내 정보</li>
		<li><a href="<%=request.getContextPath() %>/riderInfo.ridermem?Option=see">내 정보 보기</a></li>
		<li style="padding-bottom:5px"></li>
	</ul>
	<div style="border-left: 2px solid #f0f0f0;height:200px;float:left;margin-left:30px"></div>
	<ul style="list-style-type:none;padding-left:30px;float:left;">
		<li style="padding-left:10px;"><img src="<%=request.getContextPath() %>/rider_image/logo4.png"></li>
		<li style="padding:10px 0px 20px 0px;font-size:20px;">배달 정보</li>
		<li><a href="<%=request.getContextPath() %>/deliveryInfo.ridermem">배달 목록</a></li>
		<li style="padding-bottom:5px"></li>
		<li><a href="<%=request.getContextPath() %>/deliverySuccessInfo.ridermem">배달 완료 목록</a></li>
	</ul>
</div>
	
	<jsp:include page="../menu_top3.jsp"/>
	
	<div style="padding-top:70px;width:1000px;margin:auto;" >
		<div style="float:left;margin-left:50px;">
		<img src="<%=request.getContextPath() %>/rider_image/logo14.png"></div>
		<div style="padding-top:20px;">
		<span style="font-size:30px;font-weight:700;padding-left:30px;">회원 정보 수정</span></div><br><br>
		<hr>
	</div>
	
	<div style="width:700px;margin:auto;padding-top:50px;">
	<form name="modifycheck" action="<%=request.getContextPath() %>/riderModPro.ridermem" method="post" onsubmit="return chkForm(this)">
	<table>
		<tr>
			<th style="border-top:0px">아이디</th>
			<td style="border-top:0px"><%=rider.getRider_id() %><input type="hidden" value="<%=rider.getRider_id()%>" name="id"></td>
		</tr>
		<tr>
			<th>비밀번호</th>
			<td><a href="<%=request.getContextPath() %>/rider/passChange.jsp" style="font-size:25px;font:bold">비밀번호 변경</a></td>
		<tr>
			<th>이름</th>
			<td><%=rider.getRider_name() %><br> (개명하신 분은 고객센터로 전화주셔야 합니다.)</td>
		</tr>
		<tr>
			<th><label for="age">나이 </label></th>
			<td><input type="text" name="age" id="age"
			value="<%=rider.getRider_age()%>" required style="width:50px;text-align:center;text-align:center;padding-left:0px;"/></td>
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
			<th><label for="email">이메일 주소</label></th>
			<td><input type="text" name="email" id="email"
			value="<%=rider.getRider_email()%>" readonly/>
			<input type="button" value="이메일 변경"
			 onclick="window.open('<%=request.getContextPath()%>/rider/emailChange.jsp?openInit=true','','width=600,height=300')"
			 style="height:40px;"></td>
		</tr>
		<tr>
			<th><label for="tel"></label>휴대폰번호</th>
			<td>
				<input type="text" name="tel" id="tel" value="<%=rider.getRider_tel() %>">
			</td>
		</tr>
		<tr>
			<th rowspan="3">주소 </th>
			<td><input type="text" name="address1" id="sample6_postcode" value="<%=rider.getRider_address1() %>" size="7" readonly>
			<input type="button" style="height:40px;" onclick="sample6_execDaumPostcode()" value="우편번호 찾기"></td>
		</tr>
		<tr>
			<td><input type="text" name="address2" id="sample6_address" value="<%=rider.getRider_address2() %>" size="40" readonly> 
			</td> 
		</tr>
		<tr>
			<td><input type="text" name="address3" id="sample6_detailAddress" value="<%=rider.getRider_address3() %>">
			<input type="text" name="address4" id="sample6_extraAddress" value="<%=rider.getRider_address4() %>" readonly style="margin-top:10px;"></td>
		</tr>
		<tr>
			<td colspan="2" style="padding-top:30px;">
			<button onclick="javascript:chkForm(document.modifycheck)'"
			 style="font-size:20px;font-weight:700;width:200px;height:50px;border:1px solid black;background:white;cursor:pointer">
				수정하기
			</button>
			
			<button type="button" onclick="location.href='<%=request.getContextPath() %>/riderInfo.ridermem?Option=see';"
			style="font-size:20px;font-weight:700;width:200px;height:50px;border:1px solid black;background:white;cursor:pointer;margin-left:10px;">
			취소
			</button>
			</td>
		</tr>
	</table>
	<input type="hidden" value="false" name="checkfinalemail" id="checkfinalemail">
	</form>
	</div>
	
	
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