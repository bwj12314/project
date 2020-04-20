<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page import="javax.naming.*" %>
    <%@page import="rider.vo.Rider"%>
    <%
    
    
    Rider rider=(Rider)session.getAttribute("rider");
    
    %>
    
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">

<link href="https://fonts.googleapis.com/css?family=Jua&display=swap&subset=korean" rel="stylesheet">
<title>FOODELIVER 배달원 : 내 정보</title>
<style>
	body{
		min-width:1000px;
		margin:0;
		padding:0;
	}
	table{
		width:450px;
		float:left;font-size:15px;
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
		margin-top:200px;	
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
		<li><img src="<%=request.getContextPath() %>/rider_image/logo2.png"></li>
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
		<li><img src="<%=request.getContextPath() %>/rider_image/logo3.png"></li>
		<li style="padding:10px 0px 20px 0px;font-size:20px;">내 정보</li>
		<li><a href="<%=request.getContextPath() %>/riderInfo.ridermem?Option=see">내 정보 보기</a></li>
		<li style="padding-bottom:5px"></li>
	</ul>
	<div style="border-left: 2px solid #f0f0f0;height:200px;float:left;margin-left:30px"></div>
	<ul style="list-style-type:none;padding-left:30px;float:left;">
		<li style="padding-left:10px;"><img src="<%=request.getContextPath() %>/rider_image/logo4.png"></li>
		<li style="padding:10px 0px 20px 0px;font-size:20px;">배달 정보</li>
		<li><a href="<%=request.getContextPath() %>/deliveryInfo.ridermem">배달 목록</a></li>
		<li style="padding-bottom:5px"></li>
		<li><a href="<%=request.getContextPath() %>/deliverySuccessInfo.ridermem">배달 완료 목록</a></li>
	</ul>
</div>
	
	<div style="clear:both;"></div>
	<jsp:include page="/menu_top3.jsp"/>
	
	<div style="padding-top:70px;width:1000px;margin:auto;" >
		<div style="float:left;margin-left:50px;"><img src="<%=request.getContextPath()%>/rider_image/logo9.png"></div>
		<div style="padding-top:20px"><span style="font-size:30px;font-weight:700;padding-left:30px;">회원 정보</span><br><br><br></div>
		<hr>
	</div>
	
	<div style="width:952px;margin:auto; height:500px;padding-top:50px;">
	<table>
		<tr>
			<td colspan="2" style="text-align:center;border-top:0px"><h3>개인 정보</h3></td>
		</tr>
		<tr>
			<th>아이디</th>
			<td><%=rider.getRider_id() %></td>
		</tr>
		<tr>
			<th>이름</th>
			<td><%=rider.getRider_name() %></td>
		</tr>
		<tr>
			<th>나이</th>
			<td><%=rider.getRider_age() %></td>
		</tr>
		<tr>
			<th>성별</th>
			<td><%=rider.getRider_gender() %></td>
		</tr>
		<tr>
			<th>이메일 주소</th>
			<td><%=rider.getRider_email() %></td>
		</tr>
		<tr>
			<th>휴대폰 번호</th>
			<td><%=rider.getRider_tel() %></td>
		</tr>
		<tr>
			<th rowspan="3">주소</th>
			<td><%=rider.getRider_address1() %></td>
		</tr>
		<tr>
			<td><%=rider.getRider_address2() %>
			<%if(rider.getRider_address4()!=null){ %>
			<%=rider.getRider_address4() %>
			</td>
			<%} %>
		</tr>
		<tr>
			<td height="40px;">
			<%if( !rider.getRider_address3().equals(""))%>
				<%=rider.getRider_address3() %>
			<%if(rider.getRider_address3().equals("")) %>
			상세 주소 없음
			
			
			</td>
		</tr>
		<tr>
			<td colspan="2">
			<button onclick="javascript:location.href='<%=request.getContextPath()%>/riderInfo.ridermem?Option=mod'"
			 style="font-size:20px;margin-top:20px;font-weight:700;width:200px;height:50px;border:1px solid black;background:white;cursor:pointer">
				수정하기
			</button>
			</td>
		</tr>
	</table>
	<table style="margin-left:50px;height:300px">
		<tr>	
			<td colspan="2" style="text-align:center;border-top:0px"><h3>배달 정보</h3></td>
		</tr>
		<tr>
			<th>배달완료 건 수</th> 
			<td><%=rider.getRider_count() %></td>
		</tr>
		<tr>
			<th>배달 가능 상태(활성 상태, 비활성 상태)</th>
			<td><%=rider.getRider_active() %></td>
		</tr>
		<tr>
			<th>비활성 상태 사유</th>
			<td><%=rider.getRider_reason() %></td>
		</tr>
		<tr>
			<th>배달 중 상태</th>
			<td><%=rider.getRider_state()%></td>
		</tr>
	</table>
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
