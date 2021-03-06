<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="rider.vo.PageInfo" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>FOODELIVER 배달원 : 배달 완료 목록</title>
<style>
	body{
		min-width:1300px;margin:0;padding:0;
	}
	.a {
	text-align:center;
	width: 400px;
	height:350px;
	margin-left:30px;
	}
	.padding{
		padding-left:30px;
		text-align:center;
	}
	.footer{
		width:100%;
		height:200px;
		background:rgb(250,250,250);
		margin-top:200px;	
		min-width:1300px;
	}
	hr{
		border:1px solid rgb(230,230,230);
		
	}
	table{
		width:300px;
		border-collapse:collapse;
		
	}
	th{
		border-top:1px solid rgb(220,220,220);
		text-align:center;
		font-size:15px;
	}
	td{
		border-top:1px solid rgb(220,220,220);
		text-align:center;
		font-size:15px;
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
	<div style="min-width:1300px;margin:auto;padding-top:20px">
	<div style="width:270px;margin:auto;">
	<a href="<%=request.getContextPath() %>/riderMain.jsp"><img src="<%=request.getContextPath() %>/rider_image/logo.png"/></a></div></div>
	<div style="min-width:1300px;margin:auto">
	<div style="min-width:1300px;margin:auto">
	<span style=" margin-left:77%;font-size:25px;display:inline-block;height:40px;font-family: 'Jua', sans-serif;" onmouseover="viewmenu(true)" onmouseout="viewmenu(false)">전체 메뉴</span>
	</div></div>
	<div id="menu_content" style="position:absolute; z-index:1; width:400px; height:200px;background:white;border:2px solid #c0c0c0;margin-left:70%; display:none" onmouseover="viewmenu(true)" onmouseout="viewmenu(false)">
	
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
	<jsp:include page="../menu_top2.jsp"/>
<%if(session.getAttribute("rider_active").equals("활성상태")){ %>

<%
PageInfo pageInfo = (PageInfo)request.getAttribute("pageInfo");

if(pageInfo!=null){
int listCount=pageInfo.getListCount();
int nowPage=pageInfo.getPage(); //jsp에서는 page쓸수 없다.**
int maxPage=pageInfo.getMaxPage();
int startPage=pageInfo.getStartPage();
int endPage=pageInfo.getEndPage();

%>
	<div style="padding-top:70px;width:1310px;margin:auto;" >
		<div style="float:left;margin-left:50px;"><img src="<%=request.getContextPath() %>/rider_image/logo10.png"></div>
		<div style="padding-top:25px;"><span style="font-size:30px;font-weight:700;">배달 완료 목록</span></div><br><br>
		<hr>
	</div>
<table style="width:1300px;margin-left:auto;margin-right:auto;margin-top:60px;">
<c:forEach var="test" items="${successOrderList }" varStatus="status">

<c:if test="${(status.index+1)%3==1 }">
<tr><td style="border-top:0px;float:left;">
</c:if>
<c:if test="${(status.index+1)%3!=1 }">
<td style="border-top:0px;float:left;">
</c:if>
<table class="a">
<tr>
	<th style="border-top:0px">주문 번호</th><td style="border-top:0px;">${test.order_num }</td>
</tr>
<tr>
	<th>주문 날짜</th><td>${test.order_date }</td>
</tr>
<tr>
	<th>가게 이름</th><td>${test.company_name}</td>
</tr>
<tr>
	<th>가게 전화번호</th><td>${test.company_tel }</td>
</tr>
<tr>
	<th rowspan="2">가게 주소</th><td>${test.company_address2 }<c:if test="${test.company_address4!=null && test.company_address4!='' }">${test.company_address4 }</c:if></td>
</tr>
<tr>
	<td style="height:30px"><c:if test="${test.company_address3!=null && test.company_address3!='' }">
		${test.company_address3 }
	</c:if>
	<c:if test="${test.company_address3==null || test.company_address3=='' }">상세 주소 없음</c:if>
	</td>
</tr>
<tr>
	<th>고객 전화번호</th><td>${test.member_tel }</td>
</tr>
<tr>
	<th rowspan="2">고객 주소</th><td>${test.member_address1 }</td>
</tr>
<tr>
	<td style="height:30px"><c:if test="${test.member_address2!=null || test.member_address2!='' }">
		${test.member_address2 }
	</c:if>
	<c:if test="${test.member_address2==null || test.member_address2=='' }">상세 주소 없음</c:if>
	</td>
</tr>	
<tr>
	<th colspan="2" style="padding-top:15px;"><a href="<%=request.getContextPath()%>/deliverySuccessDetail.ridermem?Order_num=${test.order_num}">상세보기</a></th>
</tr>
</table>
<br><br>
<c:if test="${(status.index+1)%3==0||status.index==index.last }">
</td></tr>
</c:if>
<c:if test="${(status.index+1)%3!=0 }">
</td>
</c:if>

</c:forEach>
<tr>
		<td class="padding" colspan="3" style="border-top:0px;padding-top:30px;"> 
		<%if(nowPage<=1){ %>
		<c:if test="${successOrderList!='[]' }">
		[이전]&nbsp;
		</c:if>
		<%}else{ %>
		<a href="deliverySuccessInfo.ridermem?page=<%=nowPage-1 %>">[이전]</a>&nbsp;
		<%} %>

		<%for(int a=startPage;a<=endPage;a++){
				if(a==nowPage){%>
		[<%=a %>]
		<%}else{ %>
		<a href="deliverySuccessInfo.ridermem?page=<%=a %>">[<%=a %>]
		</a>&nbsp;
		<%} %>
		<%} %>

		<%if(nowPage>=maxPage){ %>
		<c:if test="${successOrderList!='[]' }">
		[다음]
		</c:if>
		<%}else{ %>
		<a href="deliverySuccessInfo.ridermem?page=<%=nowPage+1 %>">[다음]</a>
		<%} %>
		
		</td></tr>
</table>
<%
    }
%>
	<c:if test="${successOrderList=='[]' }">
		<div style="width:1300px;margin:auto;margin-top:-30px">
		<div style="width:530px;margin:auto">
		<img src="<%=request.getContextPath() %>/rider_image/logo7.png"></div></div><br>
		<div style="width:1300px;margin:auto;">
		<div style="width:300px;margin:auto;font-size:20px;font-weight:bold">배달 완료 목록이 없습니다. </div>
		</div>
	</c:if>
	
<%}else{ %>
		<div style="padding-top:40px;width:1300px;margin:auto;" >
		<div style="float:left;margin-left:20px;"><img src="<%=request.getContextPath() %>/rider_image/logo10.png"></div>
		<div style="padding-top:25px;"><span style="font-size:30px;font-weight:700;">배달 완료 목록</span></div><br><br>
		<hr>
		</div>
		<div style="width:500px;margin:auto;margin-top:60px;">
		<img src="<%=request.getContextPath() %>/rider_image/logo7.png"><br>
		<div style="width:450px;margin:auto;font-size:20px;font-weight:bold">회원님은 배달 비활성화 상태입니다. 완료 목록을 알고 싶으시면 배달원 문의 전화주세요</div>
		</div>
	
	
<% }%>

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