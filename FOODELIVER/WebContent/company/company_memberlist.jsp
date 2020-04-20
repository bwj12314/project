<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원 관리 페이지</title>
<style>

td{
	height : 40px;
	border :1px solid gray;
	text-align : center;

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
</head>
<div style="margin-left:150px;float:left;display:inline-block"><a href="company_info.jsp"><img src="../image/logo.png"></a></div>
<div style="padding-top:65px;font-family: 'Jua', sans-serif;font-size:40px">
<span style="color:#3EB1B0">회원관리 </span>페이지
</div>
<jsp:include page="../topmenu.jsp" />

<body>
<table>
	<tr class="headline">
		<td>아이디</td>
		<td>이름</td>
		<td>이메일</td>
		<td>전화번호</td>
		<td colspan = 3>권한</td>
		
	</tr>
<c:forEach var="meml" items="${memberlist }">
	<tr>
	<td>${meml.company_memberid }&nbsp;</td>
	<td>${meml.company_membername }&nbsp;</td>
	<td>${meml.company_memberemail }&nbsp;</td>
	<td>${meml.company_membertel }&nbsp;</td>
	<c:choose>
		<c:when test="${meml.company_membergrade.equals('C') }">C<br></c:when>
		<c:otherwise>
			
			<form action="membergrademodi.memb?company_memberid=${meml.company_memberid }" method="post" name="f">
				<td><select id="selectgrade" name="selectgrade">
	    			<option value="modi" <c:if test="${meml.company_membergrade eq 'M'}">selected</c:if>>M</option>
	    			<option value="normal" <c:if test="${meml.company_membergrade eq 'N'}">selected</c:if>>N</option>
				</select></td>
				<td><input type="submit" value="권한변경"/></td>
			</form>
			<td>				
				<form action="memberdelete.memb?company_memberid=${meml.company_memberid }" method="post" name="f2">
					<input type="submit" value="탈퇴시키기"/>
				</form>
			</td>
		</c:otherwise>
	</c:choose>
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