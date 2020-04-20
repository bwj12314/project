<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import ="comp.vo.*" %>
<!DOCTYPE html>
<html>
<style>
table{
	margin : auto;
	text-align : center;
	width : 1000px;
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
td{
	height : 40px;
	border :1px solid gray;
	text-align : center;
}
.logo{
	width : 70px;
	height : 70px;
}
</style>
<head>
<meta charset="UTF-8">
<title>기업목록 페이지(관리자용)</title>
</head>
<div style="margin-left:150px;float:left;display:inline-block"><a href="<%=request.getContextPath() %>/adminMain.jsp"><img src="../image/logo.png"></a></div>
<div style="padding-top:65px;font-family: 'Jua', sans-serif;font-size:40px">
<span style="color:#3EB1B0">기업 목록</span>&nbsp;페이지
</div>
<jsp:include page="/menu_top_admin.jsp" />
<body>
<table border=1>
<tr class="headline">
	<td></td>
	<td>기업아이디</td>
	<td>기업이름</td>
	<td>사업자번호</td>
	<td>카테고리</td>
	<td>주소</td>
	<td>활성화상태</td>
	<td></td>	
</tr>
	<c:forEach var="cl" items="${companylist }">
		<tr>
		<td><img class ="logo" src = "../company_img/${cl.company_logo  }"></td>
		<td>${cl.company_id }</td>
		<td>${cl.company_name }</td>
		<td>${cl.company_businum }</td>
		<td>${cl.company_category }</td>
		<td>${cl.company_address1 }
			${cl.company_address2 }
			${cl.company_address3 }
			${cl.company_address4 }</td>
		<td>${cl.company_active }</td>
		<td><input type="button" onclick="javascript:location.href='../companymodi.comadm?company_id=${cl.company_id}'" value="수정하기" /></td>			
		</tr>
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