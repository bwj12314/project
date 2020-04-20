<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
html, body {
    min-width: 320px;
    letter-spacing: 0px;
    font-family: 맑은고딕, "malgun gothic", 돋움, Dotum, "Apple SD Gothic Neo", Helvetica, sans-serif;
    width: auto !important;
}
</style>
</head>
<body>

<jsp:include page='../top.jsp'/>

<section style="min-height: 600px;">
<form action="<%=request.getContextPath()%>/member/order_getlocation.jsp" method="get">
<table style="margin-left: auto; margin-right: auto; margin-top: 40px;">
<tr>
<td>

<div style="box-sizing: border-box;  float: left;">
<table style="width: 600px; border: 1px solid black;">
<tr>
	<td colspan="2" style="background-color: black;color: white;">결제하기</td>
</tr>
<tr>
	<td colspan="2" style="background-color: #e6e6e6;color: black;">배달정보</td>
</tr>
<tr>
	<td width="100px;">주소</td><td ><input type="text" style="width: 99%;"  name="member_address1" value="${address.member_address2 }" readonly="readonly"></td>
</tr>
<tr>
	<td width="100px;">상세 주소</td><td><input type="text" style="width: 99%;" name="member_address2" value="" placeholder="상세주소를 입력해주세요."></td>
</tr>
<tr>
	<td width="100px;">전화번호</td><td ><input type="text" style="width: 99%;"  name="member_tel" value="${member.member_tel }"  readonly="readonly"></td>
</tr>
</table></div>
<div style="background-color: #fff8eb; box-sizing: border-box; float: left;">
<table border="1" style="border-collapse:collapse;">
<tr >
	<td style="background-color: #e6e6e6;color: black;">주문내역</td>
</tr>
<tr>
	<td >
	<table >
	<c:set var="totalmoney" value="0"/>
	<c:forEach var="name" items="${menu_list }" varStatus="status2">
	<c:if test="${status2.index==1 }">
	<input type="hidden" name="company_name" value="${name.company_name  }">
	<tr><td>
	<h2>${name.company_name }</h2>
	
	</td></tr>
	</c:if>
	</c:forEach>
	
	<c:forEach var="order" items="${order_list }" varStatus="status">
        <c:if test="${order.company_id eq param.company_id }">
        
        <tr>
        <td>
        	${order.company_menuname} x ${order.company_quantity }개 
        </td>
        <td>
        	${order.company_menuprice*order.company_quantity }원
       	<td>
       	</tr>
       	<c:set var="totalmoney" value="${totalmoney+(order.company_menuprice*order.company_quantity) }"></c:set>
        </c:if>
        
	</c:forEach>
	
	</table>
	 </td>
</tr>
<tr>
<td >
	<table>
	<tr>
		<td style="color: red;">총 결제 금액 :    </td>
		<td style="color: red;">${totalmoney }원</td>
	</tr>
	</table>
</td>
</tr>
<tr>
	<td><input type="submit" value="결제하기" style="width:80px;background:#3EB1B0;color:white;height:30px;cursor:pointer;border:0;font-size:14px">
	<input type="button" value="상품 추가" onclick="history.back()" style="width:80px;background:#3EB1B0;color:white;height:30px;cursor:pointer;border:0;font-size:14px"></td>
</tr>

<input type="hidden" name="company_id" value="${param.company_id }">
</table>

</div>

</td>
</tr>
</table>
</form>
</section>
<jsp:include page="/footer.jsp"></jsp:include>
</body>
</html>