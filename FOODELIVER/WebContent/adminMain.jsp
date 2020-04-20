<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%String adminid=(String)session.getAttribute("adminid"); %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">

<link href="https://fonts.googleapis.com/css?family=Jua&display=swap&subset=korean" rel="stylesheet">
<title>Foodeliver</title>
</head>
<style>
	body{
		min-width:1000px;padding:0;margin:0;
	}
	.footer{
		width:100%;
		height:200px;
		background:rgb(250,250,250);
		margin-top:200px;	
		min-width:1000px;
	}
	@media screen and (max-width: 2000px) {
  		.totalmenu{
  			margin-left:55%;
  		}
	}
	@media screen and (max-width: 1200px) {
  		.totalmenu{
  			margin-left:35%;
  		}
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
<body>	
	<div style="position:relative;min-width:1000px;">
<div style="margin-left:13%;float:left;"><a href="<%=request.getContextPath() %>/adminMain.jsp"><img src="<%=request.getContextPath() %>/rider_image/logo.png"></a></div>
<div style="padding-top:50px;font-family: 'Jua', sans-serif;font-size:40px">
<span style="color:#3EB1B0">관리자</span> 페이지

<span style="margin-left:37%;font-size:25px;display:inline-block;height:40px;" onmouseover="viewmenu(true)" onmouseout="viewmenu(false)">전체 메뉴</span>
</div>
</div>
<div id="menu_content" class="totalmenu" style="position:absolute;margin-top:-2px; z-index:1; width:550px; height:200px;background:white;border:2px solid #c0c0c0; display:none" onmouseover="viewmenu(true)" onmouseout="viewmenu(false)">
	
	<ul style="list-style-type:none;padding-left:30px;float:left;">
		<li><img src="<%=request.getContextPath() %>/rider_image/logo2.png"></li>
		<li style="padding:10px 0px 20px 0px;font-size:20px;">로그인</li>
		<%if(adminid==null){ %>
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
		<li style="padding-left:15px;"><a href="<%=request.getContextPath() %>/member_admin_list.mem_admin">일반 회원</a></li>
		<li style="padding-left:15px;"><a href="<%=request.getContextPath() %>/getRiderList.adm">배달 회원</a></li>
		<li style="padding-left:15px;"><a href="<%=request.getContextPath()%>/companylist.comadm">기업 목록</a></li>
		<li style="padding-bottom:5px"></li>
	</ul>
	<div style="border-left: 2px solid #f0f0f0;height:200px;float:left;margin-left:30px"></div>
	<ul style="list-style:none;padding-left:30px;float:left;">
		<li style="padding-left:10px;padding-top:5px"><img src="<%=request.getContextPath() %>/rider_image/logo13.png"></li>
		<li style="padding:10px 0px 20px 0px;font-size:20px;">기업 관리</li>
		<li style="padding-left:15px;"><a href="<%=request.getContextPath() %>/companyaddform.comadm">기업 추가</a></li>
	</ul>
</div>
<div style="clear:both;"></div>
<br><br>
<jsp:include page="menu_top_admin.jsp" />
	
	
	<div style="min-width:1000px;margin:auto;margin-top:50px;">
		
		<div style="width:830px;margin:auto;">
			<a href="<%=request.getContextPath() %>/member_admin_list.mem_admin"><img src="<%=request.getContextPath() %>/rider_image/admin_image1.png"></a>
		</div>
		<div style="width:830px;margin:auto;margin-top:30px">
			<a href="<%=request.getContextPath()%>/getRiderList.adm"><img src="<%=request.getContextPath() %>/rider_image/admin_image2.png"></a>
		</div>
		<div style="width:830px;margin:auto;margin-top:30px;">
			<a href="<%=request.getContextPath()%>/companylist.comadm"><img src="<%=request.getContextPath()%>/rider_image/admin_image3.png"></a>
		</div>
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