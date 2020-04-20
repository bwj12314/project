<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page import="java.sql.*" %>
    <%@ page import="javax.sql.*" %>
    <%@ page import="javax.naming.*" %>
    <%@ page import="rider.vo.Rider"%>
	<%Rider rider=(Rider)session.getAttribute("rider"); %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>FOODELIVER 배달원 : 비밀번호 확인</title>
<style>
	body{
		min-width:1000px;margin:0;padding:0;
	}
	.footer{
		height:200px;
		background:rgb(250,250,250);
		margin-top:150px;	
		min-width:1000px;
	}
	hr{
		border:1px solid rgb(230,230,230);
		
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
		<div style="min-width:1000px;margin:auto;padding-top:20px">
	<div style="width:270px;margin:auto;">
	<a href="<%=request.getContextPath() %>/riderMain.jsp"><img src="<%=request.getContextPath() %>/rider_image/logo.png"/></a></div></div>
	<div style="min-width:1000px;margin:auto">
	<div style="min-width:1000px;margin:auto">
	<span style=" margin-left:77%;font-size:25px;display:inline-block;height:40px;font-family: 'Jua', sans-serif;" onmouseover="viewmenu(true)" onmouseout="viewmenu(false)">전체 메뉴</span>
	</div></div>
	<div id="menu_content" style="position:absolute; z-index:1; width:400px; height:200px;background:white;border:2px solid #c0c0c0;margin-left:60%; display:none" onmouseover="viewmenu(true)" onmouseout="viewmenu(false)">
	
	<ul style="list-style-type:none;padding-left:30px;float:left;">
		<li><img src="rider_image/logo2.png"></li>
		<li style="padding:10px 0px 20px 0px;font-size:20px;">로그인</li>
		<%if(session.getAttribute("riderid")==null){ %>
		<li><a href="<%=request.getContextPath() %>/rider/loginForm.jsp">로그인하기</a></li>
		<li style="padding-bottom:5px"></li>
		<li><a href="<%=request.getContextPath() %>/joinForm.ridermem">회원가입</a></li>
		<%}else{ %>
		<li><a href="<%=request.getContextPath()%>/logout.riderlog">로그아웃</a>
		<%} %>
	</ul>
	<div style="border-left: 2px solid #f0f0f0;height: 200px;float:left;margin-left:30px"></div>
	<ul style="list-style-type:none;padding-left:30px;float:left;">
		<li><img src=rider_image/logo3.png></li>
		<li style="padding:10px 0px 20px 0px;font-size:20px;">내 정보</li>
		<li><a href="<%=request.getContextPath() %>/riderInfo.ridermem?Option=see">내 정보 보기</a></li>
		<li style="padding-bottom:5px"></li>
	</ul>
	<div style="border-left: 2px solid #f0f0f0;height:200px;float:left;margin-left:30px"></div>
	<ul style="list-style-type:none;padding-left:30px;float:left;">
		<li style="padding-left:10px;"><img src="rider_image/logo4.png"></li>
		<li style="padding:10px 0px 20px 0px;font-size:20px;">배달 정보</li>
		<li><a href="<%=request.getContextPath() %>/deliveryInfo.ridermem">배달 목록</a></li>
		<li style="padding-bottom:5px"></li>
		<li><a href="<%=request.getContextPath() %>/deliverySuccessInfo.ridermem">배달 완료 목록</a></li>
	</ul>
</div>
	
	<jsp:include page="../menu_top3.jsp"/>
	
	<div style="padding-top:70px;width:1000px;margin:auto;">
		<div style="float:left;margin-left:50px;"><img src="rider_image/logo5.png"></div>
		<div style="padding-top:20px;">
		<span style="font-size:30px;font-weight:700;padding-left:20px;">비밀 번호 재확인</span></div><br><br>
		<hr><br>
	</div>
	<br><br><br>
	<div style="width:700px;margin:auto;background:rgb(250,250,250);height:200px;">
		
		<form method="post" action="<%=request.getContextPath() %>/passRecheck.riderlog" name="f">
		<br><br>
			<div style="font-size:20px;padding-left:50px;padding-top:20px;font-weight:bold">아이디 &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
			<span style="font-weight:bold;font-size:20px;padding-left:20px;">${riderid }</span><br><br>
			비밀번호&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
			<input type="password" name="pass" id="pass" style="height:30px;font-size:17px;padding-left:10px;border-radius:5px/5px" placeholder="비밀번호 입력" size="15"><br>
			</div>
			
		</form>
	</div>
	
	<div style="width:400px;margin:auto;">
		<div style="padding-left:100px;padding-top:30px;">
		<button style="width:100px;font-size:20px;height:40px;background:white;border:1px solid black;cursor:pointer" onclick="javascript:history.back();">	
			이전
		</button>
		&nbsp;&nbsp;
		<button style="width:100px;font-size:20px;height:40px;border:1px solid black;background:white;cursor:pointer" onclick="javascript:f.submit();">
			다음
		</button>
		</div>
	</div>
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
