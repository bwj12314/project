<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%
    	request.setCharacterEncoding("utf-8");
    	
    	String email=(String)session.getAttribute("email");
    	String password=(String)session.getAttribute("password");
		
    %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>자바 메일 보내기 폼</title>
<style>
	table{
		width:450px;
		margin:auto;
	}
	h1{
		text-align:center;
	}
	td{
		border:1px dotted gray;
	}
</style>
</head>
<body>
<form action="mailSendRiderPass" method="post" name="f">
	
		<input type="hidden" name="sender" value="opti5453@gmail.com">
		<input type="hidden" name="receiver" value="<%=email%>">
		<input type="hidden" name="subject" value="바뀐 비밀번호">
		<input type="hidden" name="content" value="<%=password %>">

</form>
<script type="text/javascript"> 
	document.f.submit(); 
</script> 


</body>
</html>