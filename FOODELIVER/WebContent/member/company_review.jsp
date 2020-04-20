<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
 
	

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
section{
	min-height: 700px;
	width: 
}
</style>

</head>
<body>

<jsp:include page='/top.jsp'/>

<section>
<table  style="margin-left: auto; margin-right: auto; width: 1000px;">
<tr>
<td colspan="2">
<table>
<tr >
			<td colspan="2">
				<input type="button" value="뒤로가기" onclick="window.location.href='<%=request.getContextPath() %>/menuback.main?company_id=${param.company_id}'">
			
			<input type="button" value="메뉴" onclick="window.location.href='<%=request.getContextPath()%>/ordermenu.main?company_id=${param.company_id }'"> 
			
			<input type="button" value="리뷰"> 
			</td>
</tr>
<tr>
<td colspan="2">
<c:forEach var="menu" items="${menu_list}" varStatus="status">
		
				<c:if test="${status.index==1 }">
				<div class="box" style="border: 1px solid black; width:1000px; height: 105px; ">
		<div style="box-sizing: border-box; float:left; height: 105px;">
		<img src="<%=request.getContextPath()%>/company_img/${menu.company_logo}" style="width: 100px;height: 100px;">
		</div>
		<div style="box-sizing: border-box; width: 30px;height: 105px; float:left;"></div>
				<div style="box-sizing: border-box; width: 800px;">
				<h1>${menu.company_name}</h1>
				주소: ${menu.company_address1}		
					 ${menu.company_address2}		
					 ${menu.company_address3}		
					 ${menu.company_address4}			
			| 전화번호: ${menu.company_tel}<br>						
				<span style="color: yellow; font-size: 20px;">★</span>${menu.company_score }점
				</div>
					</div>
				</c:if>
		</c:forEach>

</td>
</tr>
</table>
</td>
</tr>

<tr><td>


<h1 style="border:1px solid black;">리뷰</h1>
<c:choose>
<c:when test="${review.size()>0 }">
<table border="1px solid black" style=" margin-left: auto;margin-right: auto; ">

<c:forEach var="rev" items="${review }" varStatus="i">
<tr><td>
<div style="box-sizing: border-box; float: left; height: 100px; width: 500px;">
${rev.member_id }님  ${rev.review_date}<br>
<span style="color: yellow; font-size: 20px;">★</span> ${rev.review_score }점<br>
<span style="color: 080808#;">주문메뉴: ${rev.review_menu } </span>
<br>
리뷰: ${rev.review_content }

</div>
<c:if test="${rev.review_file!=null}">
<div style="box-sizing: border-box; float: left; height: 100px; width: 100px; margin: 10px;">
<img src="<%=request.getContextPath() %>/review_img/${rev.review_file }" style="height: 100px; width: 100px;">
</div>
</c:if>
</td></tr>
</c:forEach>

</table>




</c:when>
<c:otherwise>
<br>
<div>리뷰가 아직 없습니다.</div>

</c:otherwise>
</c:choose>
<div style="display:scroll;position:fixed;bottom:50px;right:50px;" >
<input type="button" onclick="location.href='#'" value="맨 위로">
</div>
</td></tr>

</table>
</section>


<jsp:include page="/footer.jsp"></jsp:include>
</body>
</html>