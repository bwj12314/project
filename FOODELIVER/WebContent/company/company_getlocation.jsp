<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%request.setCharacterEncoding("utf-8");
    System.out.println(request.getParameter("address2"));
    System.out.println(request.getParameter("company_id"));
    %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

</head>
<body>
 	<script type="text/javascript" src="//dapi.kakao.com/v2/maps/sdk.js?appkey=80987fa3b69721c11605fe407c3f3135&libraries=services"></script>
<script>
var geocoder = new kakao.maps.services.Geocoder();
//주소로 좌표를 검색합니다
geocoder.addressSearch('<%=request.getParameter("address2")%>', function(result, status) {
 // 정상적으로 검색이 완료됐으면 
  if (status === kakao.maps.services.Status.OK) {
     var coords = new kakao.maps.LatLng(result[0].y, result[0].x);
	var lat=result[0].y;
	var lng=result[0].x;
	
	
	var form = document.createElement("form");
	form.setAttribute("charset", "UTF-8");
	form.setAttribute("method", "Post"); // Get 또는 Post 입력
	form.setAttribute("action", "<%=request.getContextPath()%>/companyaddaddress.comadm");
	
	var hiddenField = document.createElement("input");
	hiddenField.setAttribute("type", "hidden");
	hiddenField.setAttribute("name", "lat");
	hiddenField.setAttribute("value", lat);
	form.appendChild(hiddenField);
	
	hiddenField = document.createElement("input");
	hiddenField.setAttribute("type", "hidden");
	hiddenField.setAttribute("name", "lng");
	hiddenField.setAttribute("value", lng);
	form.appendChild(hiddenField);
	
	hiddenField = document.createElement("input");
	hiddenField.setAttribute("type", "hidden");
	hiddenField.setAttribute("name", "company_id");
	hiddenField.setAttribute("value", "<%=request.getParameter("company_id")%>");
	form.appendChild(hiddenField);

	
	document.body.appendChild(form);
	form.submit();
 } 
});    

</script>
</body>
</html>