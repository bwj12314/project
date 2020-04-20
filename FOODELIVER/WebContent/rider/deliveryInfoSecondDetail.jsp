<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%	String lat=request.getParameter("lat");
	String lon=request.getParameter("lon");
	session.setAttribute("lat",lat);
	session.setAttribute("lon", lon);
	
%>
<script>
	location.href='<%=request.getContextPath()%>/rider/deliveryInfoDetail.jsp';
</script>
</body>
</html>