<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%
    	String rider_id=null;
    	if(request.getParameter("rider_id")!=null){
    		rider_id=request.getParameter("rider_id");
    	}
    %>
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
		width:400px;height:360px;
		margin:-250px 0px 0px -200px;
		background:white;
		box-shadow:5px 5px 10px #333333;
		padding-top:5px;
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
	<div style="width:260px;margin:auto;">
	<a href="<%=request.getContextPath() %>/riderMain.jsp"><img src="<%=request.getContextPath() %>/rider_image/logo.png"></a></div><br>
	<div style="padding-left:50px;">
	<div style="padding-left:100px;font-size:20px;font-weight:bold">아이디 찾기</div><br>
	&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;고객님이 소유하신 아이디 입니다. <br><br>
	<span style="font-size:20px;">아이디 : <%=rider_id %><br> 이메일 : ${checkemail }</span><br><br><br>
	<span style="padding-left:38px;font-size:13px">
		<a href="#">로그인</a> | <a href="riderMain.jsp">배달원 페이지</a> | <a href="rider/checkpass.jsp">비밀번호 찾기</a>
		</span>
	</div>
	</div>
</body>
</html>