<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<jsp:include page='../top.jsp'/>
<section style="min-height: 600px;">
<table style="margin-left: auto; margin-right: auto; margin-top: 40px;"><tr><td>
<form action="reviewwrite.review" method="post"  name="review" enctype="multipart/form-data">
<table border="1" style="width: 900px;">
	<tr>
		<td colspan="2" class="td_title">
			<h1>${company_name } 리뷰작성</h1>
		</td>
	</tr>
	
		<input type="hidden" name="company_id" value="${company_id }"/>
		<input type="hidden" name="member_id" value="${member_id }"/>

	
	<tr>
		<td><label for="review_score">평점 : </label></td>
		<td><select id="review_score" name="review_score">
		<option value="1" selected="selected">★☆☆☆☆</option>
		<option value="2">★★☆☆☆</option>
		<option value="3">★★★☆☆</option>
		<option value="4">★★★★☆</option>
		<option value="5">★★★★★</option>
		</select> </td>
		
	</tr>	
	<tr>
		<td><label for="review_file">리뷰 사진 : </label></td>
		<td><input type="file" name="review_file" id="review_file"/></td>
	</tr>
	<tr>
		<td>메뉴 : </td><td>
		<input type="text" style="width: 100%;" name="review_menu" value="${menu }" readonly="readonly">
		</td>
	</tr>
	<tr>
		<td><label for="review_content">내용 : </label></td>
		<td><textarea cols="60" rows="5" placeholder="내용을 간략하게 써주세요." name="review_content" id="review_content" style="max-height: 300px; max-width: 800px; min-width: 500px;min-height: 100px; width: 99%;"></textarea></td>
	</tr>	
	<tr>
		<td colspan="2">
			<input type="submit" value="전송"> <input type="reset" value="다시쓰기"> 
		</td>
		
	</tr>
</table>
</form>
</td></tr></table>
</section>
<jsp:include page="/footer.jsp"></jsp:include>

</body>
</html>