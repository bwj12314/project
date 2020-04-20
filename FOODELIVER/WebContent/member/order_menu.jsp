<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <%@page import="delivery_member.vo.Company_menu"%>
	
<%@ page import="java.util.*"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
#listForm {
  
   border: 1px red solid;
   margin: auto;
   
}

h2 {
   text-align: center;
}

.tr_top {
   background-color: lime;
}

.div_empty {
   height:120px;
   margin-top:100px;
   text-align: center;
  
}

.td_command {
   text-align: right;
}
#productImage{
   width:150px;
   height:150px;
   border:none;
}
#cartImage{
   width:70px;
   height:70px;
   border:none;
}
#commandList{
	background-color:red;
	color:white;
	height:18px;
	text-align: center;
}
#upImage{
	width: 15px;
}
#downImage{
	width: 15px;
}
.cont{
	min-height: 700px;
}
</style>
<script>
	function checkQty(company_menuname,company_quantity,company_id){
		if(company_quantity != 1){
			location.href="<%=request.getContextPath() %>/ordercartquantitydown.main?company_menuname="+company_menuname+"&company_id="+company_id;
		}
	}
</script>
</head>
<body>
<section class="cont">
<jsp:include page='/top.jsp'/>

<table  style="margin-left: auto; margin-right: auto; width: 1000px;">
<tr>
<td colspan="2">
<table>
<tr >
			<td colspan="2">
				<input type="button" value="뒤로가기" onclick="location.href='<%=request.getContextPath() %>/menuback.main?company_id=${param.company_id}'">
			
			
			<input type="button" value="메뉴"> 
			
			
			<input type="button" value="리뷰" onclick="location.href='<%=request.getContextPath()%>/orderreview.main?company_id=${param.company_id }'"> 
			</td>
</tr>
<tr>
<td colspan="2">
<c:forEach var="menu" items="${menu_list}" varStatus="status">
		
				<c:if test="${status.index==1 }">
				<div class="box" style="border: 1px solid black; width:980px; height: 105px; ">
		<div style="box-sizing: border-box; float:left; height: 105px;">
		<img src="<%=request.getContextPath()%>/company_img/${menu.company_logo}" style="width: 100px;height: 100px;">
		</div>
		<div style="box-sizing: border-box; width: 30px;height: 105px; float:left;"></div>
				<div style="box-sizing: border-box; width: 800px;">
				<h1>${menu.company_name}</h1>
				주소: ${menu.company_address1}		
					 ${menu.company_address2}		
					 ${menu.company_address3}		
					 ${menu.company_address4}			
			| 전화번호: ${menu.company_tel}<br>						
				<span style="color: yellow; font-size: 20px;">★</span>${menu.company_score }점
				</div>
					</div>
				</c:if>
		</c:forEach>

</td>
</tr>

</table>
</td>
</tr>
<tr>
<td>	

<div style="box-sizing: border-box; float: left;">
<c:choose>
<c:when test="${menu_list!=null && menu_list.size()>0}">
		<c:forEach var="menu" items="${menu_list}" varStatus="status">
		<div class="box" style="border: 1px solid black; height: 105px; width: 500px; margin-top: 5px;">
			<div style="box-sizing: border-box; float: left;"><img src="<%=request.getContextPath() %>/menu/${menu.company_menupicture}" style="width: 100px;height: 100px;"></div>
			<div style="box-sizing: border-box; float: left; margin: 20px;">
				<b>${menu.company_menuname}</b>
				<br>
				가격: ${menu.company_menuprice}원
				<br>
				정보: ${menu.company_menuinfo}</div>
			<div style="box-sizing: border-box; float: left; margin-top: 40px;">	
			<input type="button" value="주문 담기" onClick="window.location.href='<%=request.getContextPath()%>/ordercartadd.main?company_id=${menu.company_id}&company_menuname='+encodeURI('${menu.company_menuname }')">
			</div>
	</div>
	<div style="clear: both;"></div>
		</c:forEach>
	</c:when>
	<c:otherwise>
	<div style="box-sizing: border-box; height: 100px; width: 500px; margin-top:100px; text-align: center;">
		메뉴정보가 없습니다.
		</div>
	</c:otherwise>
	</c:choose>
</div>
<div style="box-sizing: border-box; float: left; width: 400px;">
<table style="width: 485px; margin-top: 2px;">
			<tr>
				<td rowspan="2">
				<section id="listForm">
				<c:set var="check" value="false"/>
	
	<c:choose>
	<c:when test="${order_list !=null && order_list.size()>0}">
	 <c:forEach var="ordercheck" items="${order_list }" varStatus="status">
	 <c:if test="${ordercheck.company_id eq param.company_id}">
	 	<c:set var="check" value="true"/>
	 </c:if>
	 </c:forEach>
	 
	 <c:choose>
	<c:when test="${check eq true }">
   <h2>주문 목록</h2>
<form method="post">
      <table align="center" style="width: 400px; ">
    	
        <tr class = "tr_top">
        		<td></td>
             <td>번호</td>
             <td>상품명</td>
             <td>가격</td>
             <td>수량</td>
         </tr>
<c:set var="index" value="1"/>
<c:set var="totalmoney" value="0"/>
        <c:forEach var="order" items="${order_list }" varStatus="status">
        
        
        <c:if test="${order.company_id eq param.company_id }">
        <tr >
        	<td>
        		<a href="<%=request.getContextPath() %>/orderlistremove.main?company_menuname=${order.company_menuname }&company_id=${order.company_id }">[ X ]</a>
        	</td>
             <td>
             
             ${index }
             <c:set var="index" value="${index+1 }"/>
            </td>
             <td>
             ${order.company_menuname }
            </td>
             <td>
             ${order.company_menuprice }
            </td>
             <td>
             <a href="<%=request.getContextPath() %>/ordercartquantityup.main?company_menuname=${order.company_menuname }&company_id=${order.company_id}">
             <img src="<%=request.getContextPath() %>/main_img/up.jpg" id = "upImage" border=0/>
             </a><br>
             ${order.company_quantity }<br>
             <a href="javascript:checkQty('${order.company_menuname}','${order.company_quantity}','${order.company_id }')">
             <img src="<%=request.getContextPath() %>/main_img/down.jpg" id = "downImage" border=0/>
             </a>
            </td>
         </tr>
         <c:set var="totalmoney" value="${totalmoney+(order.company_menuprice*order.company_quantity) }"/>
         </c:if>
        </c:forEach>
      <tr>
         <td colspan="5" style="text-align:center;">
            총 금액 : ${totalmoney}원
         </td>
      </tr>
      </table>
</form>
<a href="<%=request.getContextPath() %>/order.main?company_id=${param.company_id}">
   <nav id="commandList">
   		주문하기
   </nav>
   </a>
   </c:when>
   <c:otherwise>
     <section class="div_empty">
     주문정보가 없습니다.
      </section>
   </c:otherwise>
   </c:choose>
	</c:when>
	<c:otherwise>
	 <section class="div_empty">
     주문정보가 없습니다.
      </section>
	</c:otherwise>
	</c:choose>


</section>
				</td>
			</tr>
</table>
</div>
</td></tr>
</table>
</section>
<jsp:include page="/footer.jsp"></jsp:include>

</body>
</html>