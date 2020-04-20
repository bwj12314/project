<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Foodelivery</title>
<style>
	body{
		padding:0;
		margin:0;
		background:#3EB1B0;
	}
	.sub_box{
		position:absolute;
		top:50%;left:50%;
		width:400px;height:360px;
		margin:-250px 0px 0px -200px;
		background:white;
		box-shadow:5px 5px 10px #333333;
		padding-top:5px;
	}
	.inputbox{
		height:40px;
		width:250px;
		font-size:15px;
		padding-left:10px;
		border:1px solid #d0d0d0;
		margin-left:40px;
		background:rgb(245,245,245);
		border:rgb(250,250,250);
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
function checkform(f){
	if(f.id.value==null||f.id.value.trim()==""){
		alert("아이디를 입력하세요");
		f.id.focus();
		return false;
	}
	if(f.pass.value==null||f.pass.value.trim()==""){
		alert("비밀번호를 입력하세요");
		f.pass.focus();
		return false;
	}
}
</script>
</head>
<body>
	<div class="sub_box"><div style="width:260px;margin:auto;">
	<a href="<%=request.getContextPath() %>/adminMain.jsp"><img src="<%=request.getContextPath() %>/rider_image/logo.png"></a></div><br>
	<div style="padding-left:30px">
		<form name="loginform" action="<%=request.getContextPath() %>/login.adm" method="post" onsubmit="return checkform(this)">
			<input type="text" name="id" id="id" class="inputbox" placeholder="아아디" style="margin-top:5px">
			<input type="password" name="pass" id="pass" class="inputbox" placeholder="비밀번호" style="margin-top:12px">
			<input type="submit" value="로그인" style="margin-top:12px;width:260px;height:40px;font-size:20px;margin-left:40px;background:#3EB1B0;color:white;border:0;cursor:pointer">
		</form><br>
		
	</div>
	</div>
		
</body>
</html>