<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import ="comp.vo.*" %>
<!DOCTYPE html>
<html>
<head>
<style>
.menupicture{
	height : 90px; 
	width : 130px;
}
td,tr{
	border : 1px solid gray;
}
table {
	margin: auto;
	width: 700px;
	text-align: center;
}
a {
	text-decoration: none;
}
#table_tm{
		border : 1px solid gray;
		text-align : center;
	}
.right{
	text-align:right;
}
.right a{
	font-size:12px;
}
.headline{
	background:#3EB1B0;
	color:white;
	font-weight: bold;
	font-size : 14px;
}
.footer{
	width:100%;
	height:200px;
	background:rgb(250,250,250);
	margin-top:250px;	
}
</style>
<meta charset="UTF-8">
<title>메뉴 리스트 페이지</title>
</head>
<body>
<div style="margin-left:150px;float:left;display:inline-block"><a href="company_info.jsp"><img src="../image/logo.png"></a></div>
<div style="padding-top:65px;font-family: 'Jua', sans-serif;font-size:40px">
<span style="color:#3EB1B0">메뉴리스트</span>
</div>
<jsp:include page="../topmenu.jsp" />
<table border=1>
	<c:choose>
		<c:when test="${menulist!=null }">
		<tr class="headline">
			<td>메뉴사진</td>
			<td>메뉴이름</td>
			<td>메뉴가격</td>
			<td colspan = 3>메뉴설명</td>
		</tr>
		<c:forEach var="ml" items="${menulist }"> <!-- menulist : arraylist로 만든배열 -->
		<tr>
			<td><img class ="menupicture" src = "../menu/${ml.company_menupicture }"></td>
			<td>${ml.company_menuname }</td>
			<td>${ml.company_menuprice }원</td>
			<td>${ml.company_menuinfo }</td>
				<c:if test="${company.company_memberid!=null&&company.company_membergrade.equals('C')||company.company_membergrade.equals('M') }">  <!-- C등급이상만 수정,삭제 버튼을 볼수있음 -->
					<td><input type="button" onclick="javascript:location.href='MenuModiForm.menu?company_id=${company.company_id }&company_menunum=${ml.company_menunum}'" value="수정" /></td>
					<td><input type="button" onclick="javascript:location.href='MenuDelte.menu?company_id=${company.company_id }&company_menunum=${ml.company_menunum}'" value="삭제" /></td>
				</c:if>
		</tr><br>
		</c:forEach>	
		</c:when>
		<c:otherwise>
		<div style="text-align: center;">
		<img src="<%=request.getContextPath() %>/image/menuerror.jpg" >
		</div>
		<br>
		</c:otherwise>
	</c:choose>


	<c:if test="${company.company_memberid!=null&&company.company_membergrade.equals('C') }">
	<tr>
		<td colspan = 6>
			<input type="button" onclick="javascript:location.href='menuAddForm.menu?company_id=${company.company_id }'" value="등록하기" />
		</td>
		</tr>
	</c:if>

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