<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
	body{
		padding:0;
		margin:0;
		background:#3EB1B0;
	}
	.sub_box{
		position:absolute;
		top:50%;left:50%;
		width:400px;height:480px;
		margin:-250px 0px 0px -200px;
		background:white;
		box-shadow:5px 5px 10px #333333;
		padding-top:5px;
	}
	.inputbox{
		height:30px;
		width:210px;
		font-size:15px;
		padding-left:10px;
		border:1px solid #d0d0d0;
		margin-left:40px;
	}
	a{
		text-decoration:none;
		color:black;
	}
	a:hover{
		color:#3EB1B0;
	}
</style>
<script>
function checkid() {
	var name = document.getElementById("checkname").value;
	var email = document.getElementById("checkemail").value;
	
	var url = "<%=request.getContextPath()%>/checkid.mlog?checkname=" + name + "&checkemail=" + email;
	window.open(url, '', 'width=700', 'height=500');
}
</script>
</head>
<body>
	
	<div class="sub_box">
	&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
	<a href="../main.jsp"><img src="../main_img/logo.png"></a><br><br>
	<div style="padding-left:50px;">
	<form action="<%=request.getContextPath() %>/checkidsuccess.mlog" method="post" name="form">
		<div style="padding-left:100px;font-size:20px;font-weight:bold">아이디 찾기</div>
		<input type="text" name="checkname" id="checkname" class="inputbox" placeholder="이름" style="margin-top:5px">
		<input type="text" name="checkemail" id="checkemail" class="inputbox" placeholder="이메일" style="margin-top:12px">
		<input type="button" onclick="checkid()" style="width:222px;height:30px;margin-left:40px;margin-top:12px" value="인증번호 받기">
		<div style="clear:both;"></div>
		<br><br>
		<input type="text" name="certifykeyEX" class="inputbox" placeholder="인증번호 숫자 입력" style="margin-left:40px;">
		<br>
		<button onclick="javascript:form.submit()" style="margin-left:40px;height:30px;width:222px;margin-top:12px">
		다음
		</button><br><br>
		
	</form>
		<span style="padding-left:38px;font-size:13px">
		<a href="loginForm.jsp">로그인</a> | <a href="<%=request.getContextPath() %>/main.jsp">메인 페이지</a> | <a href="checkpass.jsp">비밀번호 찾기</a>
		</span>
	</div>
	</div>
	
</body>
</html>