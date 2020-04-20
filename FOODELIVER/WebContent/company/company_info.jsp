<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import ="comp.vo.*" %>
<!DOCTYPE html>
	<c:if test="${sessionScope.company_memberid==null }">
		<script>
			alert('로그인을 하세요!!');
			location.href='../company_main.jsp';
		</script>
	</c:if>
<html>
<style>
.logo{
	height : 500px; 
	width :  500px;
}
a {
	text-decoration: none;
}
table {
	margin: auto;
	width: 700px;
	text-align: center;
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
	margin-top:5%;	
}
</style>
<head>
<meta charset="UTF-8">
<title>기업정보 페이지</title>
</head>
<body>
<div style="margin-left:150px;float:left;display:inline-block"><a href="company_info.jsp"><img src="../image/logo.png"></a></div>
<div style="padding-top:65px;font-family: 'Jua', sans-serif;font-size:40px">
<span style="color:#3EB1B0">내가게 정보</span> 페이지
</div>
<jsp:include page="../topmenu.jsp" />

<div class="right">
${company_memberid }님 반갑습니다.&nbsp;&nbsp;
	<a href="../logout.login">로그아웃</a>&nbsp;&nbsp;
	<c:if test="${company.company_memberid!=null&&company.company_membergrade.equals('C') }">
		<a href="memberlist.memb?company_id=${company.company_id }">직원목록보기</a>
	</c:if>&nbsp;&nbsp;
</div>

<table>
<tr>
	<td>
	<h3>내 가게 정보</h3><br>
	<img class ="logo" src = "../company_img/${company.company_logo }"><br>
	가게이름 : ${company.company_name }<br>
	사업자 번호 : ${company.company_businum }<br>
	카테고리 : ${company.company_category }<br>
	전화번호 : ${company.company_tel }<br>
	등록날짜 : ${company.company_regdate }<br>
	우편번호 : ${company.company_address1 }<br>
	상세주소 : ${company.company_address2 }<br>
	상세주소2: ${company.company_address3 }<br>		
	활성/비활성 상태여부 : ${company.company_active }<br>
	</td>
</tr>
</table>

<table>
<tr>
	<td>
	<h3>내 가게 점수</h3><br>
		점수 : ${company.company_score }점<br>
		참여자 수 : ${company.company_count }명<br>
	</td>
</tr>
</table>

<table>
<tr>
	<td>
	<h3>나의 정보</h3><br>
		이름 : ${company.company_membername }<br>
		등급 : ${company.company_membergrade }<br>
		이메일 : ${company.company_memberemail }<br>
		전화번호 : ${company.company_membertel }<br>
	</td>
</tr>
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