<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
	.sub_box{
		position:absolute;
		top:50%;left:50%;
		width:500px;height:300px;
		margin:-160px 0px 0px -250px;
		background:white;
		padding-top:5px;
	}
	.inputbox{
		height:40px;
		width:250px;
		padding-left:10px;
		font-size:15px;
		border:0;
		background:rgb(230,230,230);
	}
	a{
		text-decoration:none;
		color:black;
	}
	a:hover{
		color:#3EB1B0;
	}
</style>
</head>
<%
	request.setCharacterEncoding("utf-8");
	String openInit ="false";
	if(request.getParameter("openInit")!=null){
		openInit="true";
	}
%>
<script>
function init(){
	if(<%=(request.getParameter("openInit")!=null&&request.getParameter("openInit").equals("true"))?true:false %>){
		document.getElementById("company_memberid").value=opener.document.getElementById("company_memberid").value;
	}
}
function ok(v){
	opener.idcheck=v.trim();
	opener.document.getElementById("company_memberid").value=v;
	opener.chkId=true;
	window.close();
}
</script>
<body onload="init()">
<div class="sub_box">
<div style="padding-left:115px;padding-top:80px;">
<form action="<%=request.getContextPath() %>/idCheck.memb" method = "post" name=f>
	<input type=text name=company_memberid  id=company_memberid class="inputbox">
	<input type=submit value="중복확인" style="width:260px;height:40px;margin-top:10px;background:#3EB1B0;color:white;border:0px;cursor:pointer">
</form>
<%if (request.getAttribute("passibleId") != null){ %>
	<% if((boolean)request.getAttribute("passibleId")){ %>
		<%=request.getAttribute("company_memberid") %>는 사용가능한 아이디 입니다.<br>
		 <div style="margin-left:90px"><a href='#' onclick="ok('<%=request.getAttribute("company_memberid") %>')">사용하기</a></div>
	<%}else{ %>
		<h3><%=request.getAttribute("company_memberid") %>는 이미 사용중인 아이디 입니다.<br>다시 검색하세요.</h3>
<%}} %>
</div>
</div>
</body>
</html>