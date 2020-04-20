<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>FOODELIVER 배달원 : 비밀번호 변경</title>
<style>
	body{
		min-width:1000px;
		margin:0;padding:0;
	}
	table{
		width:550px;
		float:left;height:500px;font-size:15px;
		border-collapse:collapse;
		height:600px;
	}
	td,th{
		border-top:1px solid rgb(220,220,220);
		text-align:center;
		
		
	}
	.footer{
		width:100%;
		height:200px;
		background:rgb(250,250,250);
		min-width:1000px;
		margin-top:200px;
	}
	hr{
		border:1px solid rgb(230,230,230);
		
	}
	table a{
		color:#3EB1B0;
		font-size:18px;
		
	}
	input{
		height:40px;width:330px;
		padding-left:20px;
		font-size:15px;
		font-weight:bold;
		border:1px solid gray;
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
	<span style=" margin-left:85%;font-size:25px;display:inline-block;height:40px;font-family: 'Jua', sans-serif;" onmouseover="viewmenu(true)" onmouseout="viewmenu(false)">전체 메뉴</span>
	</div></div>
	<div id="menu_content" style="position:absolute; z-index:1; width:400px; height:200px;background:white;border:2px solid #c0c0c0;margin-left:60%; display:none" onmouseover="viewmenu(true)" onmouseout="viewmenu(false)">
	
	<ul style="list-style-type:none;padding-left:30px;float:left;">
		<li><img src="../rider_image/logo2.png"></li>
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
		<li><img src="../rider_image/logo3.png"></li>
		<li style="padding:10px 0px 20px 0px;font-size:20px;">내 정보</li>
		<li><a href="<%=request.getContextPath() %>/riderInfo.ridermem?Option=see">내 정보 보기</a></li>
		<li style="padding-bottom:5px"></li>
	</ul>
	<div style="border-left: 2px solid #f0f0f0;height:200px;float:left;margin-left:30px"></div>
	<ul style="list-style-type:none;padding-left:30px;float:left;">
		<li style="padding-left:10px;"><img src="../rider_image/logo4.png"></li>
		<li style="padding:10px 0px 20px 0px;font-size:20px;">배달 정보</li>
		<li><a href="<%=request.getContextPath() %>/deliveryInfo.ridermem">배달 목록</a></li>
		<li style="padding-bottom:5px"></li>
		<li><a href="<%=request.getContextPath() %>/deliverySuccessInfo.ridermem">배달 완료 목록</a></li>
	</ul>
</div>
	<div style="padding-bottom:10px;"></div>
	<jsp:include page="../menu_top3.jsp"/>
	
	<div style="padding-top:70px;width:1000px;margin:auto;" >
		<div style="float:left;margin-left:50px;"><img src="<%=request.getContextPath() %>/rider_image/logo16.png"></div>
		<div style="padding-top:17px;"><span style="font-size:30px;font-weight:700;margin-left:20px;">비밀 번호 변경</span></div><br><br>
		<hr>
	</div>
	
	<div style="width:500px;margin:auto;background:rgb(240,240,240);height:400px;margin-top:70px;">
		<div style="width:350px;margin:auto;">
		<form action="<%=request.getContextPath() %>/passchange.riderlog" method="post">
		<input type="password" style="margin-top:50px;" placeholder="현재 비밀번호" name="nowpass">
		<input type="password" style="margin-top:10px;" placeholder="새 비밀번호" name="newpass">
		<input type="password" style="border-top:0px;" placeholder="새 비밀번호 확인" name="newpass2">
	<button style="margin-top:30px;width:350px;height:50px;background:#3EB1B0;font-size:20px;border:0px;cursor:pointer;font-weight:600" onclick="javascript:f.submit()">확&nbsp;&nbsp;&nbsp;인</button>
		
		</form>
		<button style="margin-top:10px;width:350px;height:50px;background:white;font-size:20px;border:0px;cursor:pointer;font-weight:600" onclick="javascript:location.href='<%=request.getContextPath()%>/rider/rider_realmod.jsp'">
		취&nbsp;&nbsp;&nbsp;소</button>
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