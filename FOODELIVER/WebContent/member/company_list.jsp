<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <%@page import="java.util.ArrayList" %>
    <%@page import="java.io.*" %>
    <%@page import="delivery_member.vo.Company" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
.list{
	margin-top:20px;
	border:1px solid black;
	box-sizing:border-box;

	min-width:590px;
	height:105px;
		float:left;
}
section{
	min-height:500px;
	margin-top: 40px;
	
	
	
}
.box{
	
	width: 1200px;
}
</style>
</head>
<body>
	

	<section>
	
	<table style="margin-left: auto; margin-right: auto;">
	<tr><td align="right">
	<select id="opt" name="opt" onchange="change('${param.search }','${param.category }')">
		<option value="company_name" ${param.optv eq'1'?'selected':'' }>기본정렬순</option>
		<option value="company_score" ${param.optv eq'2'?'selected':'' } >별점순</option>
	</select>
	
	<script>
	function change(search,category){
		var select=document.getElementById("opt").value;
		var uri="change.main?option="+select+"&search="+search+"&category="+category
		var enc=encodeURI(uri);
		location.href="<%=request.getContextPath()%>/"+enc;
	}
	
	</script>
	</td></tr>
	<tr><td>
	<c:if test="${companylist==null }">회사 정보가 없습니다.</c:if>
	<c:set var="count" value="false"></c:set>
		<c:forEach var="com" items="${companylist}" varStatus="status">
		<c:if test="${(status.index+1)%2==1 }"><div class="box"></c:if>
		<c:if test="${(status.index+1)%2==0 }"><div style="box-sizing: border-box; float:left; width: 20px; height:100px;"></div></c:if>
		<a href="ordermenu.main?company_id=${com.company_id}"><div class="list">
		<div style="box-sizing: border-box; float:left;">
		<img src="<%=request.getContextPath() %>/company_img/${com.company_logo}" style="width: 100px;height: 100px;">
		</div>
		<div style="box-sizing: border-box; width: 30px;height: 100px; float:left;"></div>
		<div style="box-sizing: border-box;  ">
			<!--${com.company_id}-->
			
			<!--${com.company_businum}-->
		
			<h1>${com.company_name}</h1>
		
			
		
		<!--	${com.company_category}-->
		
			<!-- ${com.company_regdate} -->
		
			주소: ${com.company_address2}
		
			${com.company_address4}
			
			| 전화번호: ${com.company_tel}
		<!--	${com.company_active}-->
		<br>
			<span style="color: yellow; font-size: 20px;">★</span>${com.company_score }점
		</div>
		</div></a>
			<c:if test="${(status.index+1)%2==0 }"></div></c:if>
			<c:set var="count" value="true"></c:set>
		</c:forEach>
		<c:if test="${count=='false' }">회사 정보가 없습니다.</c:if>
		</td></tr></table>
		
	</section>
<footer>
<jsp:include page="/footer.jsp"></jsp:include>
</footer>
</body>
</html>