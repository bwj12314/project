<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
		width:400px;height:350px;
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
</head>
<body>
	<div class="sub_box">
	&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
	<a href="../main.jsp"><img src="../main_img/logo.png"></a><br><br>
	<div style="padding-left:50px;">
	<div style="padding-left:80px;font-size:20px;font-weight:bold">비밀번호 찾기</div>
	<form action="<%=request.getContextPath() %>/checkpass.mlog" method="post" name="form">
		<input type="text" name="checkid" class="inputbox" placeholder="아이디" style="margin-top:5px;margin-bottom:12px" required="required">
		<input type="text" name="checkemail" class="inputbox" placeholder="이메일" required="required">
		<input type="submit" style="margin-left:40px;height:30px;width:222px;margin-top:12px" value="임시 비밀번호 발송">
		
	</form>
		<br>
		<span style="padding-left:38px;font-size:13px">
		<a href="loginForm.jsp">로그인</a> | <a href="<%=request.getContextPath() %>/main.jsp">메인 페이지</a> | <a href="checkid.jsp">아이디 찾기</a>
		</span>
	</div>
	</div>
</body>
</html>