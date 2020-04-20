<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page import="rider.vo.OrderList"%>
    <%@ page import="java.util.*"%>
    <%
    	ArrayList<OrderList> detailarraylist=(ArrayList<OrderList>)session.getAttribute("detailarraylist");
    %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script>
	var startY='<%=detailarraylist.get(0).getCompany_address_lat()%>';
	var startX='<%=detailarraylist.get(0).getCompany_address_lng()%>';
	var endY='<%=detailarraylist.get(0).getMember_address_lat()%>';
	var endX='<%=detailarraylist.get(0).getMember_address_lng()%>';
	location.href='<%=request.getContextPath()%>/rider/deliveryInfoDetail.jsp?startY='+startY+'&startX='+startX+'&endY='+endY+'&endX='+endX;
</script>
</head>
<body>

</body>
</html>