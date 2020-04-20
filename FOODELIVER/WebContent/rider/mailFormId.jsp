<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%
    	request.setCharacterEncoding("utf-8");
    	String checkemail=(String)session.getAttribute("checkemail");
    	String certifykey=(String)session.getAttribute("certifykey");
    	String option=request.getParameter("option");
    %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>FOODELIVER 배달원</title>
</head>
<body>
<%if(option.equals("id")){ %>
<form action="<%=request.getContextPath() %>/mailSendRiderId" method="post" name="f">
	
		<input type="hidden" name="sender" value="opti5453@gmail.com">
		<input type="hidden" name="receiver" value="<%=checkemail%>">
		<input type="hidden" name="subject" value="아아디 찾기 인증 번호입니다.">
		<input type="hidden" name="content" value="<%=certifykey %>">
		
</form>
<%}else{ %>
	<form action="<%=request.getContextPath() %>/mailSendRiderCertify" method="post" name="f">
	
		<input type="hidden" name="sender" value="opti5453@gmail.com">
		<input type="hidden" name="receiver" value="<%=checkemail%>">
		<input type="hidden" name="subject" value="이메일 인증 번호입니다.">
		<input type="hidden" name="content" value="<%=certifykey %>">
		
</form>
<%} %>
<script type="text/javascript"> 
	document.f.submit(); 
</script> 
</body>
</html>