<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="member" value="${member }"></c:set>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원수정 페이지</title>
<style type="text/css">
table{
	text-align : center;
	margin : auto;
	width:410px;
	}
.inputbox{
	height:40px;
	width:310px;
	padding-left:10px;
	font-size:17px;
	border:0;
	background:rgb(245,245,245);
}

.td_title {
	font-weight: bold;
	font-size: x-large;
	background:#3EB1B0;
	color:white;
}
a {
	text-decoration: none;
}
.right{
	text-align:right;
}
.footer{
	width:100%;
	height:200px;
	background:rgb(250,250,250);
	margin-top:150px;	
}
</style>
</head>
<div style="margin-left:150px;float:left;display:inline-block"><a href="company_info.jsp"><img src="../image/logo.png"></a></div>
<div style="padding-top:65px;font-family: 'Jua', sans-serif;font-size:40px">
<span style="color:#3EB1B0">회원정보 수정</span>
</div>
<jsp:include page="../topmenu.jsp" />
<body>
	<form name="modifyform" action="membermodpro.memb" method="post">
		<table border=1>
			<tr>
				<td colspan="2" class="td_title">회원 정보 수정 페이지</td>
			</tr>
			<tr>
				<td><label for="company_id">기업 아이디 : </label></td>
				<td><input type="text" value="${member.company_id }" name="company_id" id="company_id" class="inputbox"/></td>
			</tr>
			<tr>
				<td><label for = "company_memberid">아이디 : </label></td>
				<td><input type="text" value="${member.company_memberid }" name="company_memberid" id="company_memberid" class="inputbox" required readonly/></td>
			</tr>
			<tr>
				<td><label for="company_memberpass">비밀번호 : </label></td>
				<td><input type="password" name="company_memberpass" id="company_memberpass"
					value="${member.company_memberpass }" class="inputbox" required /></td>
			</tr>
			<tr>
				<td><label for="company_membername">이름 : </label></td>
				<td><input type="text" name="company_membername" id="company_membername"
					value="${member.company_membername }" class="inputbox" required /></td>
			</tr>
			<tr>
				<td><label for="company_memberemail">이메일 주소 : </label></td>
				<td><input type="text" name="company_memberemail" id="company_memberemail" 
					value="${member.company_memberemail}" class="inputbox"/></td>
			</tr>
			<tr>
				<td><label for="company_membertel">전화번호 : </label></td>
				<td><input type="text" name="company_membertel" id="company_membertel"
					value="${member.company_membertel}"class="inputbox" /></td>
			</tr>
			<tr>
				<td colspan="2">
					<input type="button" onclick="javascript:modifyform.submit()" value="수정하기" style="width:150px;background:#3EB1B0;color:white;height:40px; border:0;font-size:20px"/>
					<input type="button" onclick="javascript:location.href='company_info.jsp'" value="메인으로 가기" style="width:150px;background:#3EB1B0;color:white;height:40px; border:0;font-size:20px"/>
				</td>
			</tr>
		</table>
	</form>
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