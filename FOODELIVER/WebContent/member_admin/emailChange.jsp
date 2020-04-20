<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>이메일 변경</title>
<style>
	table{
		margin:auto;
		border:1px solid gray;
		text-align:center;
		width:500px;
	}
	.td_title{
		font-weight:bold;
		font-size:x-large;
	}
</style>
</head>
<script>
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
	function useEmail(){
		
		var checkfinalemail=document.getElementById("checkfinalemail").value;
		var email=document.getElementById("email").value;
		
		if(checkfinalemail=="true"){
			opener.document.getElementById("email").value=email.trim();
			opener.document.getElementById("checkfinalemail").value="true";
			window.close();
		}else{
			alert('인증을 완료하세요!!');
		}
	}
</script>
<body>
	<table>
		<tr>
			<th><br>이메일 변경<br><br></th>
		</tr>
		<tr>
			<td><input type="text" name="email" id="email" required placeholder="이메일 주소"/>
			<input type="button" value="인증번호 받기" onclick="checkemail()"></td>
		</tr>
		<tr>
			<td><input type="text" name="certifykeyEX" id="certifykeyEX" placeholder="인증번호">
			<input type="button" value="확인" onclick="checkemailsuccess()" style="width:100px;"></td>
		</tr>
		<tr>
			<td><input type="button" name="useEmail" id="useEmail" onclick="useEmail()" value="사용하기" style="width:150px;margin-bottom:50px;margin-top:10px;height:30px;"></td>
		</tr>
		<input type="hidden" value="false" name="checkfinalemail" id="checkfinalemail">
	</table>
</body>
</html>