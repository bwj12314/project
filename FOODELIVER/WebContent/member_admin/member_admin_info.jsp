<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page import="java.sql.*" %>
    <%@ page import="javax.sql.*" %>
    <%@ page import="javax.naming.*" %>
    <%@page import="delivery_member.vo.Member"%>
    <%
    	Member member=(Member)request.getAttribute("member");
    %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Foodeliver</title>
<style>
	table{
		width:800px;
		height:700px;
		border-collapse:collapse;
		font-size:20px;
		margin:auto;
	}
	td,th{
		border-top:1px solid rgb(220,220,220);
		text-align:center;
	}
	.footer{
		width:100%;
		height:200px;
		background:rgb(250,250,250);
		margin-top:100px;	
		min-width:1200px;
	}
	hr{
		border:1px solid rgb(230,230,230);
		
	}
	.buttonbox{
		height:50px;
		width:70px;
		background:#3EB1B0;
		cursor:pointer;
		color:white;
		font-weight:bold;
		border-radius:5px/5px;
	}
	.buttonbox2{
		background:#3EB1B0;
		border:0;
		color:white;
		font-weight:bold;
		border-radius:5px/5px;
	}
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
	<div style="width:1000px;margin-left:43%;padding-top:20px"><a href="adminMain.jsp"><img src="<%=request.getContextPath() %>/rider_image/logo.png"/></a>
			<span style="margin-left:30%;font-size:25px;display:inline-block;height:40px;font-family: 'Jua', sans-serif;" onmouseover="viewmenu(true)" onmouseout="viewmenu(false)">전체 메뉴</span>
		</div>
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
					<li style="padding-left:15px;"><a href="<%=request.getContextPath() %>/member_admin_list.mem_admin">배달 회원</a></li>
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
<br>

	<div style="padding-top:40px;width:1300px;margin:auto;" >
		<div style="float:left;margin-left:20px;"><img src="<%=request.getContextPath()%>/rider_image/logo9.png"></div>
		<div style="padding-top:20px"><span style="font-size:30px;font-weight:700;padding-left:30px;">일반 회원 정보</span><br><br><br></div>
		<hr>
	</div>
	<table style="margin-top:60px;">
		<tr>
			<th style="border-top:0px;">아이디</th>
			<td style="border-top:0px;"><%=member.getMember_id() %></td>
		</tr>
	<tr>
		<td>비밀번호 : </td>
		<td><%=member.getMember_pass()%></td>
	</tr>
	<tr>
		<td>이름 : </td>
		<td><%=member.getMember_name() %></td>
	</tr>
	<tr>
		<td>나이 : </td>
		<td><%=member.getMember_birth() %></td>
	<tr>
		<td>성별 : </td>
		<td><%=member.getMember_gender() %></td>
	</tr>
	<tr>
		<td>이메일 주소 : </td>
		<td><%=member.getMember_email() %></td>
	</tr>
	<tr>
		<td>전화 번호 : </td>
		<td><%=member.getMember_tel() %></td>
	</tr>
	<tr>
		<td>주소1 : </td>
		<td><%=member.getMember_address1() %></td>
	</tr>
	<tr>
		<td>주소2 : </td>
		<td><%=member.getMember_address2() %></td>
	</tr>
	<tr>
		<td>주소3 : </td>
		<td><%=member.getMember_address3() %></td>
	</tr>
	<tr>
		<td>주소4 : </td>
		<td><%=member.getMember_address4() %></td>
	</tr>
	<tr>
		<td>등급 : </td>
		<td><%=member.getMember_grade() %></td>
	</tr>
		<tr>
			<th colspan="2" style="padding-top:50px;">
			<a href="<%=request.getContextPath() %>/member_admin_list.mem_admin">일반 회원 목록으로</a>
			</th>
		</tr>
	</table>
	
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
	
