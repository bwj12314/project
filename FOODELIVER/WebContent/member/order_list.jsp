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
<script>
function go(order_num,member_id) {

var go=confirm('취소 하시겠습니까?');
if(go){
	alert('주문이 취소되었습니다.');
	location.href='<%=request.getContextPath()%>/order_delete.main?order_num='+order_num+'&member_id='+member_id;
}
}
</script>
</head>
<body>

<jsp:include page='/top.jsp'/>
<section style="min-height: 600px;">
<c:if test="${member_id==null }"><script>alert('로그인을 하세요'); location.href='loginform.mlog'</script></c:if>
<c:if test="${mainorder==null }">주문 정보가 없습니다.</c:if>
<table style="margin-left: auto; margin-right: auto;"><tr><td>
<div class="ord">
<c:set var="num" value="0"/>
<div style="box-sizing: border-box; background-color: #3EB1B0;color: black; text-align: center; margin-top: 40px; height: 50px;line-height: 50px;"><h1>주문 목록</h1></div><br>

<c:forEach var="order" items="${mainorder }" varStatus="i">
<c:if test="${order.order_state !='배달 완료' }">
<c:set var="total" value="0"/>
<c:set var="now" value="<%=new Date()%>"/>
<fmt:formatDate value="${now}" pattern="yyyy-MM-dd HH:mm:ss" var="now"/>
<fmt:parseDate var="now" value="${now }" pattern="yyyy-MM-dd HH:mm:ss"/>
<c:set var="now" value="${now.getTime() }"/>
<fmt:parseDate var="order_date" value="${order.order_date }" pattern="yyyy-MM-dd HH:mm:ss"/>
<c:set var="order_date" value="${order_date.getTime() }"></c:set>
<div style="border: 1px solid black;">
<table border="1" class="table_c" style="border-collapse:collapse">
<tr class="tr_c"><td style="width:150px;">회사명</td><td style="width: 200px;">주문상품</td><td style="width:150px;">총 가격</td><td style="width:150px;">주문날짜</td>
<c:if test="${(now-order_date)/(60*1000)<1 }"><td></td></c:if>
</tr>
<tr><td><span style=" font-size: large; ">${order.company_name }</td>
<td>
<c:forEach begin="0" end="${order.order_name.size()-1 }" varStatus="j">
<div style="box-sizing: border-box; float: left;"><span style=" font-size: larger; ">${order.order_name.get(j.index) }</span> ${order.order_price.get(j.index) } x ${order.order_quantity.get(j.index) }개</div><div style="clear: both;"></div>
<c:set var="total" value="${total+order.order_quantity.get(j.index)*order.order_price.get(j.index) }"/>

</c:forEach>
</td>
<td>${total }원</td><td>${order.order_date }</td>
<c:if test="${(now-order_date)/(60*1000)>1 }"></tr></c:if>



<c:if test="${(now-order_date)/(60*1000)<1 }">
<td>
<input type="button" value="취소하기" onclick="go('${order.order_num}','${order.member_id }');">
<div  style="font-size: smaller;">주문 취소는 결제후 1분내로 가능합니다.</div>
</td></tr>
<script>
	
	setTimeout(function(){
	location.reload();
	},(${60-((now-order_date)/1000)})*1000); 

</script>
</c:if>
</table>
</div>
<br>
<c:set var="num" value="${num+1 }"/>
</c:if>
</c:forEach>
</div>
</td></tr>
<c:if test="${num==0 }"><tr><td>주문 정보가 없습니다.</td></tr></c:if>
</table>

</section>
<jsp:include page="/footer.jsp"></jsp:include>
</body>
</html>