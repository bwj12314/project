<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <%@ page import="java.util.Date" %>
    <%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>




    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<style>
body{
	font:bold 20px/30px 'Jua', sans-serif;
}
.ord{

float:left;

}
.tr_c td{

background-color: #3EB1B0;
color: white;

}
.table_c td{
text-align: center;
}

</style>

</head>
<body>

<jsp:include page='/top.jsp'/>
<section style="min-height: 600px;">
<c:if test="${member_id==null }"><script>alert('로그인을 하세요'); location.href='loginform.mlog'</script></c:if>
<c:if test="${mainorder==null }">주문 정보가 없습니다.</c:if>
<table style="margin-left: auto; margin-right: auto;"><tr><td>
<div class="ord">
<c:set var="num" value="0"/>
<div style="box-sizing: border-box; background-color: #3EB1B0;color: black;text-align: center; margin-top: 40px; height: 50px;line-height: 50px;"><h1>주문 완료 목록</h1></div><br>

<c:forEach var="order" items="${mainorder }" varStatus="i">
<c:if test="${order.order_state == '배달 완료' }">
<c:set var="total" value="0"/>
<div style="border: 1px solid black;">
<table border="1" class="table_c" style="border-collapse:collapse;">
<tr class="tr_c"><td style="width:150px;">회사명</td><td style="width: 200px;">주문상품</td><td style="width:150px;">총 가격</td><td style="width:150px;">주문날짜</td>
<td></td>
</tr>

<tr><form action="reviewform.review" method="post" ><td>
<span style=" font-size: large; ">${order.company_name }</span></td> 
<c:set var="menu" value=""/>
<td>
<c:forEach begin="0" end="${order.order_name.size()-1 }" varStatus="j">

<div style="box-sizing: border-box; float: left;"><span style=" font-size: larger; ">${order.order_name.get(j.index) }</span> ${order.order_price.get(j.index) } x ${order.order_quantity.get(j.index) }개</div><div style="clear: both;"></div>

<c:set var="total" value="${total+order.order_quantity.get(j.index)*order.order_price.get(j.index) }"/>
<c:set var="menu" value="${menu} ${order.order_name.get(j.index)} ${order.order_quantity.get(j.index) }개 "/>
</c:forEach>
</td>
<input type="hidden" value="${menu }" name="menu">
<td>${total }원</td>
<td>${order.order_date }</td>

<c:if test="${i.index==0 || num2!=order.order_num}">
<input type="hidden" name="company_id" value="${order.company_id }">
<input type="hidden" name="company_name" value="${order.company_name }">
<input type="hidden" name="member_id" value="${order.member_id }">
<td><input type="submit" value="리뷰 쓰기" ></td>
</c:if>
</form>
<tr>
</table>
</div>
<br>
<c:set var="num" value="${num+1 }"/>
</c:if>
</c:forEach>
</div>
</td></tr>
<c:if test="${num==0 }"><tr><td>주문 완료 정보가 없습니다.</td></tr></c:if>
</table>

</section>
<jsp:include page="/footer.jsp"></jsp:include>
</body>
</html>