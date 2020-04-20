<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page import="java.sql.*" %>
    <%@ page import="javax.sql.*" %>
    <%@ page import="javax.naming.*" %>
    <%@ page import="rider.vo.Admin" %>
    <%
    Admin admin=(Admin)session.getAttribute("admin");
    %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Foodeliver</title>
<style>
	body{
		min-width:1000px;
		margin:0;padding:0;
	}
	.footer{
		width:100%;
		height:200px;
		background:rgb(250,250,250);
		margin-top:100px;	
		min-width:1000px;
	}
	hr{
		border:1px solid rgb(230,230,230);
		
	}
	table{
		width:600px;
		float:left;font-size:15px;
		border-collapse:collapse;
		height:500px;
	}
	td,th{
		border-top:1px solid rgb(220,220,220);
		text-align:center;
		
		
</style>
<script>
function viewmenu(opt) {
	  if(opt) {
		  menu_content.style.display = "block";
	  }
	  else {
		  menu_content.style.display = "none";
	  }
	
}
</script>
</head>
<body>
	<div style="min-width:1300px;margin:auto;padding-top:20px">
	<div style="width:270px;margin:auto;">
	<a href="<%=request.getContextPath() %>/adminMain.jsp"><img src="<%=request.getContextPath() %>/rider_image/logo.png"/></a></div></div>
	<div style="min-width:1300px;margin:auto">
	<div style="min-width:1300px;margin:auto">
	<span style=" margin-left:77%;font-size:25px;display:inline-block;height:40px;font-family: 'Jua', sans-serif;" onmouseover="viewmenu(true)" onmouseout="viewmenu(false)">전체 메뉴</span>
	</div></div>
	<div id="menu_content" style="position:absolute; z-index:1; width:550px; height:200px;background:white;border:2px solid #c0c0c0;margin-left:60%; display:none" onmouseover="viewmenu(true)" onmouseout="viewmenu(false)">
	
	<ul style="list-style-type:none;padding-left:30px;float:left;">
		<li><img src="<%=request.getContextPath() %>/rider_image/logo2.png"></li>
		<li style="padding:10px 0px 20px 0px;font-size:20px;">로그인</li>
		<%if((String)session.getAttribute("adminid")==null){ %>
		<li><a href="<%=request.getContextPath() %>/admin/loginForm.jsp">로그인하기</a></li>
		<li style="padding-bottom:5px"></li>
		<%}else{ %>
		<li style="padding-left:5px;"><a href="<%=request.getContextPath()%>/logout.adm">로그아웃</a>
		<%} %>
	</ul>
	<div style="border-left: 2px solid #f0f0f0;height: 200px;float:left;margin-left:30px"></div>
	<ul style="list-style-type:none;padding-left:30px;float:left;">
		<li><img src="<%=request.getContextPath() %>/rider_image/logo3.png"></li>
		<li style="padding:10px 0px 20px 0px;font-size:20px;">내 정보</li>
		<li><a href="<%=request.getContextPath() %>/adminInfo.adm?Option=see">내 정보 보기</a></li>
		<li style="padding-bottom:5px"></li>
	</ul>
	<div style="border-left: 2px solid #f0f0f0;height:200px;float:left;margin-left:30px"></div>
	<ul style="list-style-type:none;padding-left:30px;float:left;">
		<li style="padding-left:15px;padding-top:10px;"><img src="<%=request.getContextPath() %>/rider_image/logo12.png"></li>
		<li style="padding:10px 0px 20px 0px;font-size:20px;">회원 관리</li>
		<li style="padding-left:15px;"><a href="<%=request.getContextPath() %>/getRiderList.adm">배달 회원</a></li>
		<li style="padding-left:15px;"><a href="<%=request.getContextPath()%>/companylist.comadm">기업 목록</a></li>
		<li style="padding-bottom:5px"></li>
	</ul>
	<div style="border-left: 2px solid #f0f0f0;height:200px;float:left;margin-left:30px"></div>
	<ul style="list-style:none;padding-left:30px;float:left;">
		<li style="padding-left:10px;padding-top:5px"><img src="<%=request.getContextPath() %>/rider_image/logo13.png"></li>
		<li style="padding:10px 0px 20px 0px;font-size:20px;">기업 관리</li>
		<li style="padding-left:15px;"><a href="#">가게 목록</a></li>
	</ul>
</div>
<div style="clear:both;"></div>
<br>
<jsp:include page="../menu_top_admin.jsp" />
	
	<div style="padding-top:70px;width:1000px;margin:auto;" >
		<div style="float:left;margin-left:20px;"><img src="<%=request.getContextPath()%>/rider_image/logo9.png"></div>
		<div style="padding-top:20px"><span style="font-size:30px;font-weight:700;padding-left:30px;">관리자 정보</span><br><br><br></div>
		<hr>
	</div>
	<div style="width:600px;margin:auto;margin-top:50px;">
	<table>
		<tr>
			<td style="border-top:0px;" colspan="2"><h3>내 정보</h3></td>
		</tr>
		<tr>
			<th>아이디</th>
			<th><%=admin.getAdmin_id() %></th>
		</tr>
		<tr>
			<th>비밀번호</th>
			<td><a href="<%=request.getContextPath() %>/admin/passAdminChange.jsp" style="color:#3EB1B0;font-weight:bold">비밀번호 수정</a></td>
		</tr>
		
		<tr>
			<th>이메일 주소</th>
			<td><%=admin.getAdmin_email() %></td>
		</tr>
		<tr>
			<th>휴대폰 번호</th>
			<td><%=admin.getAdmin_tel() %></td>
		</tr>
		
		<tr>
			<td colspan="2">
			<a href="<%=request.getContextPath() %>/adminInfo.adm?Option=mod" style="font-weight:bold;font-size:20px;">수정하기</a>
			</td>
		</tr>
	</table>
	</div>
	<div style="clear:both;"></div>
	<div class="footer">
		<div style="padding-left:10%;padding-top:20px">
		<span style="font-size:17px;">(유)푸딜리버리</span><br><br>
		<p>대구광역시 수성구 국채보상로 924 동우빌딩 2층 (유)푸딜리버리 &nbsp;&nbsp;&nbsp;&nbsp;
		|&nbsp;&nbsp;&nbsp;&nbsp; 대표자 : kbe &nbsp;&nbsp;&nbsp;&nbsp;
		| &nbsp;&nbsp;&nbsp;&nbsp;사업자 등록번호 : 311-41-564245</p><br>
		<span style="font-size:18px;font-weight:bold">배달원 문의 : 1577-8282</span>
		</div>
	</div>
</body>
</html>