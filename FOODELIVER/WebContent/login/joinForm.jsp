<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.Calendar" %>
<%@page import="java.text.SimpleDateFormat" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Foodeliver</title>
<style>
	body{
		padding:0;
		margin:0;
		background:#3EB1B0;
	}
	.sub_box{
		position:absolute;
		top:50%;left:50%;
		width:500px;height:1350px;
		margin:-440px 0px 100px -250px;
		background:white;
		box-shadow:5px 5px 10px #333333;
		padding-top:5px;
	}
	table{
		margin-left:85px;
		width:500px;
		border:0;
	}
	.inputbox{
		height:40px;
		width:300px;
		padding-left:10px;
		font-size:15px;
		border:0;
		background:rgb(245,245,245);
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
		if(!chkId||idcheck!=f.id.value.trim()){
			alert("아이디 중복확인을 하세요!!!");
			return false;
		}
		if(f.pass.value.trim()==""){
			alert("비밀번호를 입력하세요");
			f.pass.focus();
			return false;
		}
		if(f.pass.value.length<6){
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
		}if(f.address1.value.trim()=='' || f.address2.value.trim()==''){
			alert("주소를 기입하세요.");
			f.address1.focus();
			return false;
		}if(f.name.value.trim()=='' ){
			alert('이름을 입력하세요.');
			f.name.focus();
			return false;
		}if(f.tel.value.trim()==''){
			alert('휴대폰 번호를 입력하세요');
			f.tel.focus();
			return false;
		}
		
		f.submit();
	} //아이디 받아서 널이거나 빈값이면 
	function checkemail(){
		var email = document.getElementById("email").value;
		var url = "<%=request.getContextPath()%>/checkemail2.mlog?" + "checkemail=" + email;
		window.open(url, '', 'width=700', 'height=500');
	}
	function checkemailsuccess(){
		var certifykeyEX=document.getElementById("certifykeyEX").value;
		var url="<%=request.getContextPath()%>/checkemailsuccess2.mlog?"+"certifykeyEX="+certifykeyEX;
		window.open(url,'','width=700','height=500');
	}
	function isSame(){
		
		
		if(document.getElementById('pass').value!=''&&document.getElementById('passcheck').value!=''){
			if(document.getElementById('pass').value==document.getElementById('passcheck').value){
				document.getElementById('same').innerHTML='비밀번호가 일치합니다.';
				document.getElementById('same').style.color='blue';
			}else{
				document.getElementById('same').innerHTML='비밀번호가 일치하지 않습니다.';
				document.getElementById('same').style.color='red';
			}
		}
		if(document.getElementById('passcheck').value.length<6 || 
				document.getElementById('passcheck').value.length>12){
			document.getElementById('same').innerHTML='비밀번호는 6~12자 입력하셔야 합니다.';
			document.getElementById('same').style.color='red';
		}
	}
</script>
</head>
<body>

<div class="sub_box">
	<div style="padding-left:115px">
	<a href="<%=request.getContextPath() %>/main.jsp"><img src="<%=request.getContextPath() %>/main_img/logo.png"></a></div><br><br>
<form name="joinform" action="<%=request.getContextPath() %>/memberJoinProcess.join" method="post" onsubmit="return chkForm(this)">
	<table>
		
		<tr>
			<td><label for="id">아이디 </label></td>
		</tr>
		<tr>
			<td><input type="text" name="id" id="id" class="inputbox"></td>
		</tr>
		<tr>	
			<td><input type="button" name="idCheck" value="아이디 중복 검사" id="idCheck"
			onclick="window.open('<%=request.getContextPath()%>/login/idCheck.jsp?openInit=true','','width=500,height=300')" class="inputbox" style="background:#3EB1B0;margin-top:5px;color:white;width:310px;height:43px;cursor:pointer"></td>
			
		</tr>
		<tr>
			<td style="padding-top:20px;"><label for="pass">비밀번호 </label></td>
		</tr>
		<tr>
			<td><input type="password" name="pass" id="pass" class="inputbox"></td>
		</tr>
		<tr>
			<td style="padding-top:20px;"><label for="passcheck">비밀번호확인 </label></td>
		</tr>
		<tr>
			<td><input type="password" name="passcheck" id="passcheck" onkeyup="isSame()" class="inputbox"></td>
		</tr>
		<tr>	
			<td style="height:22px;font-size:15px;"><span id="same"></span></td>
			
		</tr>
		
		<tr>
			<td><label for="name">이름 </label></td>
		</tr>
		<tr>
			<td><input type="text" name="name" id="name" class="inputbox"></td>
		</tr>	
		
		<tr>
			<td style="padding-top:20px;"><label for="birth1" >생년월일</label></td> 
		</tr>
		<tr>
		<td>
			<select name="birth1" id="birth1">
	       <%Calendar currentCalendar = Calendar.getInstance();
					int year=currentCalendar.get(Calendar.YEAR);
	       for(int i=year; i>=year-100; i--){ %>
	       <option value="<%=i %>"><%=i %></option>
	       <%} %>
	     </select>년&nbsp;
	     <select name="birth2">
	       <%for(int i=1; i<=12; i++){ %>
	       <option value="<%=i %>"><%=i %></option>
	       <%} %>
	     </select>월&nbsp;
	     <select name="birth3">
	       <%
	       for(int i=1; i<=31; i++){ %>
	       <option value="<%=i %>"><%=i %></option>
	       <%} %>
	     </select>일
     	</td>
     	</tr>
		<tr>
			<td style="padding-top:20px;"><label for="gender1"></label>성별 </td>
		</tr>
		<tr>
			<td>
				<input type="radio" name="gender" value="남" checked id="gender1"/>남자
				<input type="radio" name="gender" value="여" id="gender2"/>여자
			</td>
		</tr>
		<tr>
			<td style="padding-top:20px;"><label for="tel"></label>휴대폰번호</td>
		</tr>
		<tr>
			<td>
				<input type="text" name="tel" id="tel" placeholder="하이픈(-)을 제외하고 입력" class="inputbox">
			</td>
		</tr>
		<tr>
			<td style="padding-top:20px;"><label for="email">이메일 주소 </label></td>
		</tr>
		<tr>
			<td><input type="text" name="email" id="email" class="inputbox"></td>
		</tr>
		<tr>
			<td><input type="button" value="인증번호 받기" onclick="checkemail()" class="inputbox" style="background:#3EB1B0;margin-top:5px;color:white;width:310px;height:43px;cursor:pointer"></td>
		</tr>
		<tr>
			<td style="padding-top:5px;"><input type="text" name="certifykeyEX" id="certifykeyEX" placeholder="이메일 인증번호" class="inputbox" style="width:150px">
			<input type="button" value="확인" onclick="checkemailsuccess()" class="inputbox" style="width:140px;background:#3EB1B0;color:white;height:40px;cursor:pointer;margin-left:5px;">
		</tr>
		
		<tr>
			<td style="padding-top:20px">주소 </td>
		</tr>
		<tr>
			<td><input type="text" name="address1" id="sample6_postcode" placeholder="우편번호" size="7" required readonly class="inputbox" style="width:70px;">
			<input type="button" onclick="sample6_execDaumPostcode()" value="우편번호 찾기" class="inputbox" style="width:220px;background:#3EB1B0;color:white;height:40px;cursor:pointer;margin-left:5px;"></td>
		</tr>	
		<tr>
			<td><input type="text" name="address2" id="sample6_address" placeholder="주소" size="40" required readonly class="inputbox" style="margin-top:5px"> 
			</td> 
		</tr>
		<tr>
			<td style="padding-top:5px"><input type="text" name="address3" id="sample6_detailAddress" placeholder="상세주소" class="inputbox"></td>
		</tr>
		<tr>
			<td style="padding-top:5px"><input type="text" name="address4" id="sample6_extraAddress" placeholder="참고항목" readonly class="inputbox"></td>
		</tr>
		<tr>
			<td style="padding-top:40px">
				<input type="button" value="회원가입" onclick="javascript:chkForm(document.joinform)" style="width:150px;background:#3EB1B0;color:white;height:40px;cursor:pointer;border:0;font-size:20px">
				<input type="button" onclick="javascript:joinform.reset()" value="다시 작성" style="width:150px;background:#3EB1B0;color:white;height:40px;cursor:pointer;margin-left:5px;border:0;font-size:20px">
			</td>
		</tr>
		<input type="hidden" value="N" name="grade">
		<input type="hidden" value="false" name="checkfinalemail" id="checkfinalemail">
	
	</table>
</form>
</div>
	
	
	
</body>
</html>