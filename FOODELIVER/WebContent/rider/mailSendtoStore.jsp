<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page import="java.util.*" %>
    <%@ page import="rider.vo.OrderList" %>
    <%ArrayList<OrderList> deliveryfinallist=(ArrayList<OrderList>)session.getAttribute("deliveryfinallist"); %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%System.out.println("이게 뜬다"+deliveryfinallist.get(0).getCompany_email()); %>
<script>
alert('확인(닫기)을 누르면 가게로 메일이 전송됩니다.');
</script>
<form action="mailSendtoStore" method="post" name="f">
	
		<input type="hidden" name="sender" value="opti5453@gmail.com">
		<input type="hidden" name="receiver" value="<%=deliveryfinallist.get(0).getCompany_email()%>">
		<input type="hidden" name="subject" value="주문 정보입니다">
		<input type="hidden" name="content"
		 value="<table>
		<tr>
			<td>주문 번호</td>
			<td colspan=<%=deliveryfinallist.size() %>><%=deliveryfinallist.get(0).getOrder_num() %></td>
		</tr>
		<tr>
			<td>주문 날짜</td>
			<td colspan=<%=deliveryfinallist.size() %>><%=deliveryfinallist.get(0).getOrder_date() %></td>
		</tr>
		<tr>
			<td>메뉴 이름</td>
			
			<%for(int i=0;i<deliveryfinallist.size();i++){ %>
			<td>
			<%=deliveryfinallist.get(i).getOrder_name() %>
			</td>
			<%} %>
			
		</tr>	
		<tr>	
			<td>메뉴 수량&nbsp;&nbsp;</td>
			<%for(int i=0;i<deliveryfinallist.size();i++){ %>
			
		
			<td>
			<%=deliveryfinallist.get(i).getOrder_quantity() %>
			&nbsp;&nbsp;
			</td>
			<%} %>
			
			
			
			
		</tr>
		<tr>	
			<td>메뉴 가격&nbsp;&nbsp;</td>
			<%for(int i=0;i<deliveryfinallist.size();i++){ %>
			<td>
			<%=deliveryfinallist.get(i).getOrder_price() %>
			&nbsp;&nbsp;
			</td>
			<%} %>
		</tr>
		<tr>
			<td>총가격&nbsp;&nbsp;</td>
			<%for(int i=0;i<deliveryfinallist.size();i++){
				
			}
			%>
			<td colspan=<%=deliveryfinallist.size() %>><%=deliveryfinallist.get(0).getTotalmoney() %></td>
		</tr>
		</table>
		<br><br>
		<table>
		<tr>	
			<td>고객 전화번호&nbsp;&nbsp;</td>
			<td><%=deliveryfinallist.get(0).getMember_tel() %>
		</tr>
		<tr>	
			<td>고객 주소&nbsp;&nbsp;</td>
			<td><%=deliveryfinallist.get(0).getMember_address1() %></td>
		</tr>
		<tr>	
			<td>고객 상세 주소&nbsp;&nbsp;</td>
			<%if(deliveryfinallist.get(0).getMember_address2()==null || deliveryfinallist.get(0).getMember_address2().equals("")){ %>
			<td></td>
			<%}else{ %>
			<td><%=deliveryfinallist.get(0).getMember_address2() %></td>
			<%} %>
		</tr>
		
		<tr>
			<td>배달원 이름</td>
			<td><%=deliveryfinallist.get(0).getRider_name() %></td>
		</tr>
		<tr>
			<td>배달원 휴대폰번호</td>
			<td><%=deliveryfinallist.get(0).getRider_tel() %></td>
		</tr>
		">

</form>
<script type="text/javascript"> 
	document.f.submit(); 
</script> 
</body>
</html>