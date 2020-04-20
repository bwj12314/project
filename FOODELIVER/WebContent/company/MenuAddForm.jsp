<%@ page language="java" contentType="text/html; charset=UTF-8"%>

<!DOCTYPE html>
<html>

<head>
<meta charset="UTF-8">
<title>메뉴 등록폼</title>
<style type="text/css">
#registForm {
	width: 500px;
	height: 610px;
	border: 1px solid red;
	margin: auto;
}

h2 {
	text-align: center;
}

table {
	margin: auto;
	width: 450px;
}
.td_left {
	width: 150px;
	background: #3EB1B0;
	color : white;
	text-align : center;
	font-weight: bold;
}

.td_right {
	width: 300px;
	background: #3EB1B0;
	color : white;
}

#commandCell {
	text-align: center;
}
a {
	text-decoration: none;
}
#table_tm{
		border : 1px solid gray;
		text-align : center;
	}
.right{
	text-align:right;
}
.right a{
	font-size:12px;
}
.footer{
		width:100%;
		height:200px;
		background:rgb(250,250,250);
		margin-top:5%;	
}
</style>
</head>
<body>
<div style="margin-left:150px;float:left;display:inline-block"><a href="company_info.jsp"><img src="../image/logo.png"></a></div>
<div style="padding-top:65px;font-family: 'Jua', sans-serif;font-size:40px">
<span style="color:#3EB1B0">메뉴 등록</span>
</div>
<jsp:include page="../topmenu.jsp" />
<h2>메뉴 등록하기</h2>
	<section id="writeForm">
		<form action="menuAdd.menu" method="post"
			enctype="multipart/form-data" name="menuaddform">
			<table>
				<tr>
					<td class="td_left"><label for="company_menuname">메뉴 이름</label></td>
					<td class="td_right"><input type="text" name="company_menuname"
						id="company_menuname" required="required"/></td>
				</tr>
				<tr>
					<td class="td_left"><label for="company_menuprice">메뉴 가격</label></td>
					<td class="td_right"><input name="company_menuprice" type="text"
						id="company_menuprice" required="required" /></td>
				</tr>
				<tr>
					<td class="td_left"><label for="company_menuinfo">메뉴 설명</label></td>
					<td><textarea id="company_menuinfo" name="company_menuinfo"
							cols="40" rows="15" required="required"></textarea></td>
				</tr>
				<tr>
					<td class="td_left"><label for="company_menupicture"> 사진 첨부 </label></td>
					<td class="td_right"><input name="company_menupicture" type="file"
						id="company_menupicture"/></td>
				</tr>
				<tr><td>

				<input type="hidden" name="company_id" value="${param.company_id }" id="company_id">
				
				</td>
				</tr>
			</table>
			<section id="commandCell">
				<input type="submit" value="등록">&nbsp;&nbsp; 
				<input type="reset" value="다시쓰기" />
			</section>
		</form>
	</section>
</body>
<div style="clear:both;"></div>
	
<div class="footer">
	<div style="padding-left:150px;padding-top:20px">
	<span style="font-size:17px;">(유)푸딜리버리</span><br><br>
	<p>대구광역시 수성구 국채보상로 924 동우빌딩 2층 (유)푸딜리버리 &nbsp;&nbsp;&nbsp;&nbsp;
		|&nbsp;&nbsp;&nbsp;&nbsp; 대표자 : kbe &nbsp;&nbsp;&nbsp;&nbsp;
		| &nbsp;&nbsp;&nbsp;&nbsp;사업자 등록번호 : 311-41-564245</p><br>
	<span style="font-size:18px;font-weight:bold">배달원 문의 : 1577-8282</span>		
	</div>
</div>
</html>