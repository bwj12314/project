<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page import="rider.vo.OrderList"%>
    <%@ page import="java.util.*"%>
    <%
    	ArrayList<OrderList> detailSuccessList=(ArrayList<OrderList>)session.getAttribute("detailSuccessList");
    %>
   	
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>FOODELIVER 배달원 : 배달 완료 상세</title>
<style>
	body{
		min-width:1000px;margin:0;padding:0;
	}
	table{	
		width:450px;
		float:left;height:400px;font-size:16px;
		border-collapse:collapse;
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
	.buttonbox{
		height:50px;
		width:280px;
		font-size:25px;
		background:#3EB1B0;
		cursor:pointer;
		border:0;
		color:white;
		font-weight:bold;
		border:1px solid #3EB1B0;
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
		<div style="float:left;margin-left:50px;"><img src="<%=request.getContextPath() %>/rider_image/logo10.png"></div>
		<div style="padding-top:25px;"><span style="font-size:30px;font-weight:700;">배달 완료 목록 상세</span></div><br><br>
		<hr>
	</div>
	<br><br><br><br>
	<div style="width:951px;margin:auto;">
	<table>
		<tr>
			<td style="border-top:0px;" colspan="2"><span style="font-size:25px;font-weight:bold">주 문</span></td>
		</tr>
		<tr>
			<th style="width:100px;">주문 번호</th>
			<td><%=detailSuccessList.get(0).getOrder_num() %></td>
		</tr>
		<tr>
			<th>주문 날짜</th>
			<td colspan=<%=detailSuccessList.size() %>><%=detailSuccessList.get(0).getOrder_date() %></td>
		</tr>
		<tr>
			<th>메뉴 이름</th>
			
			<%for(int i=0;i<detailSuccessList.size();i++){ %>
			<td>
			<%=detailSuccessList.get(i).getOrder_name() %>
			</td>
			<%} %>
			
		</tr>	
		<tr>	
			<th>메뉴 수량</th>
			<%for(int i=0;i<detailSuccessList.size();i++){ %>
			
		
			<td>
			<%=detailSuccessList.get(i).getOrder_quantity() %>
			
			</td>
			<%} %>
		</tr>
		<tr>	
			<th>메뉴 가격</th>
			<%for(int i=0;i<detailSuccessList.size();i++){ %>
			<td>
			<%=detailSuccessList.get(i).getOrder_price() %>
			
			</td>
			<%} %>
		</tr>
		<tr>
			<th>총가격</th>
			<td colspan=<%=detailSuccessList.size() %>><%=detailSuccessList.get(0).getTotalmoney() %></td>
		</tr>
		</table>
		<table style="margin-left:50px;">
		<tr>
			<td style="border-top:0px" colspan="2"><span style="font-size:25px;font-weight:bold">고객, 가게</span></td>
		</tr>
		<tr>
			<th>가게 이름</th>
			<td><%=detailSuccessList.get(0).getCompany_name() %></td>
		</tr>
		<tr>	
			<th>가게 전화번호</th>
			<td><%=detailSuccessList.get(0).getCompany_tel() %></td>
		</tr>
		<tr>	
			<th rowspan="2">가게 주소</th>
			<%if(detailSuccessList.get(0).getCompany_address4()!=null){ %>
			<td><%=detailSuccessList.get(0).getCompany_address2().concat(" "+detailSuccessList.get(0).getCompany_address4()) %></td>
			<%}else{ %>
			<td><%=detailSuccessList.get(0).getCompany_address2() %></td>
			<%} %>
		</tr>
		<tr>	
			<%if(detailSuccessList.get(0).getCompany_address3()!=null&&!detailSuccessList.get(0).getCompany_address3().equals("")){ %>
			<td style="height:50px;"><%=detailSuccessList.get(0).getCompany_address3() %></td>
			<%}else{ %>
			<td style="height:50px;">상세 주소 없음</td>
			<%} %>
		</tr>
		
		<tr>	
			<th>고객 전화번호</th>
			<td><%=detailSuccessList.get(0).getMember_tel() %>
		</tr>
		<tr>	
			<th rowspan="2">고객 주소</th>
			
			<td><%=detailSuccessList.get(0).getMember_address1()%></td>
			
		</tr>
		<tr>
			<%if(detailSuccessList.get(0).getMember_address2()==null || detailSuccessList.get(0).getMember_address2().equals("")){ %>
			<td style="height:50px;">상세 주소 없음</td>
			<%}else{ %>
			<td style="height:50px;"><%=detailSuccessList.get(0).getMember_address2() %></td>
			<%} %>
		</tr>
	</table>
	</div>
	
	<div style="clear:both">
	</div>
	
	<div style="width:300px;margin:auto;padding-top:70px;">
	<input type="button" onclick="javascript:location.href='<%=request.getContextPath() %>/deliverySuccessInfo.ridermem'" value="완료 목록으로 돌아가기" class="buttonbox"/>
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


