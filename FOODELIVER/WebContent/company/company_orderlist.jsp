<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<style>
table {
	margin: auto;
	width: 730px;
	text-align: center;
}
a {
	text-decoration: none;
}
td{
	height : 40px;
	border :1px solid gray;
	text-align : center;
}
#deliver{
	color : red;
}

.right{
	text-align:right;
}
.right a{
	font-size:12px;
}
.footer{
	width:100%;
	height:200px;
	background:rgb(250,250,250);
	margin-top:20%;	
}
.headline{
	background:#3EB1B0;
	color:white;
	font-weight: bold;
	font-size : 14px;
}
</style>
<head>
<meta charset="UTF-8">
<title>주문내역 페이지</title>
</head>
<div style="margin-left:150px;float:left;display:inline-block"><a href="company_info.jsp"><img src="../image/logo.png"></a></div>
<div style="padding-top:65px;font-family: 'Jua', sans-serif;font-size:40px">
<span style="color:#3EB1B0">주문내역</span>
</div>
<jsp:include page="../topmenu.jsp" />
<body>
<table border = 1>
<tr class="headline">
	<td>주문번호</td>
	<td>주문날짜</td>
	<td>메뉴</td>
	<td>메뉴가격</td>
	<td>수량</td>
	<td>주문자아이디</td>
	<td>배달원아이디</td>
	<td>상태</td>
	<td>총가격</td>
</tr>

<c:forEach var="ol" items="${orderlist }">
<c:if test="${ol.order_state.equals('배달중')||ol.order_state.equals('배달 완료') }">
	<tr>
		<td>${ol.order_num }&nbsp;</td>
		<td>${ol.order_date }&nbsp;</td>
		<td>${ol.order_name }&nbsp;</td>
		<td>${ol.order_price }원&nbsp;</td>
		<td>${ol.order_quantity }개&nbsp;</td>
		<td>${ol.member_id }&nbsp;</td>
		<td>${ol.rider_id }&nbsp;</td>
		<c:choose>
		<c:when test="${ol.order_state.equals('배달중') }">
		<td id="deliver">${ol.order_state }&nbsp;</td>
		</c:when>
		<c:otherwise>
		<td>${ol.order_state }&nbsp;</td>
		</c:otherwise>
		</c:choose>
		<td>${ol.order_price*ol.order_quantity }원</td>		
	</tr>
	</c:if>
	</c:forEach>
</table>	
<div style="clear:both;"></div>
<div class="footer">
	<div style="padding-left:150px;padding-top:20px">
	<span style="font-size:17px;">(유)푸딜리버리</span><br><br>
	<p>대구광역시 수성구 국채보상로 924 동우빌딩 2층 (유)푸딜리버리 &nbsp;&nbsp;&nbsp;&nbsp;
		|&nbsp;&nbsp;&nbsp;&nbsp; 대표자 : kbe &nbsp;&nbsp;&nbsp;&nbsp;
		| &nbsp;&nbsp;&nbsp;&nbsp;사업자 등록번호 : 311-41-564245</p><br>
	<span style="font-size:18px;font-weight:bold">배달원 문의 : 1577-8282</span>		
	</div>
</div>
</body>
</html>