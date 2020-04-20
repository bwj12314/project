<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="company" value="${company }"></c:set>
<%@ page import ="comp.vo.*" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>기업정보 수정페이지(관리자용)</title>
<style type="text/css">
table {
	margin: auto;
	width: 500px;
	border: 1px solid gray;
	text-align: center;
}
.inputbox{
	height:40px;
	width:97%;
	padding-left:10px;
	font-size:17px;
	border:0;
	background:rgb(245,245,245);
}

.td_title {
	font-weight: bold;
	font-size: x-large;
	background : #3EB1B0;
	color : white;
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
	margin-top:150px;	
}
</style>
<script src="https://t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>
<script>
    function sample6_execDaumPostcode() {
        new daum.Postcode({
            oncomplete: function(data) {
                // 팝업에서 검색결과 항목을 클릭했을때 실행할 코드를 작성하는 부분.

                // 각 주소의 노출 규칙에 따라 주소를 조합한다.
                // 내려오는 변수가 값이 없는 경우엔 공백('')값을 가지므로, 이를 참고하여 분기 한다.
                var addr = ''; // 주소 변수
                var extraAddr = ''; // 참고항목 변수

                //사용자가 선택한 주소 타입에 따라 해당 주소 값을 가져온다.
                if (data.userSelectedType === 'R') { // 사용자가 도로명 주소를 선택했을 경우
                    addr = data.roadAddress;
                } else { // 사용자가 지번 주소를 선택했을 경우(J)
                    addr = data.jibunAddress;
                }

                // 사용자가 선택한 주소가 도로명 타입일때 참고항목을 조합한다.
                if(data.userSelectedType === 'R'){
                    // 법정동명이 있을 경우 추가한다. (법정리는 제외)
                    // 법정동의 경우 마지막 문자가 "동/로/가"로 끝난다.
                    if(data.bname !== '' && /[동|로|가]$/g.test(data.bname)){
                        extraAddr += data.bname;
                    }
                    // 건물명이 있고, 공동주택일 경우 추가한다.
                    if(data.buildingName !== '' && data.apartment === 'Y'){
                        extraAddr += (extraAddr !== '' ? ', ' + data.buildingName : data.buildingName);
                    }
                    // 표시할 참고항목이 있을 경우, 괄호까지 추가한 최종 문자열을 만든다.
                    if(extraAddr !== ''){
                        extraAddr = ' (' + extraAddr + ')';
                    }
                    // 조합된 참고항목을 해당 필드에 넣는다.
                    document.getElementById("company_address4").value = extraAddr;
                
                } else {
                    document.getElementById("company_address4").value = '';
                }

                // 우편번호와 주소 정보를 해당 필드에 넣는다.
                document.getElementById('company_address1').value = data.zonecode;
                document.getElementById("company_address2").value = addr;
                // 커서를 상세주소 필드로 이동한다.
                document.getElementById("company_address3").focus();
            }
        }).open();
    }
</script>
</head>
<div style="margin-left:150px;float:left;display:inline-block"><a href="company_admin.jsp"><img src="../image/logo.png"></a></div>
<div style="padding-top:65px;font-family: 'Jua', sans-serif;font-size:40px">
<span style="color:#3EB1B0">기업정보 수정</span>
</div>
<jsp:include page="/menu_top_admin.jsp" />
<body>
	<form name="modifyform" action="companymodipro.comadm" method="post" onsubmit="return chkForm(this);">
		<table border=1>
			<tr>
				<td colspan="2" class="td_title">기업정보 수정 페이지</td>
			</tr>
			<tr>
				<td><label for="company_id">기업 아이디 : </label></td>
				<td><input type="text" value="${company.company_id }" name="company_id" id="company_id" class="inputbox" required readonly/></td>
			</tr>
			<tr>
				<td><label for="company_name">기업 이름 : </label></td>
				<td><input type="text" value="${company.company_name }" name="company_name" id="company_name" class="inputbox"/></td>
			</tr>
			<tr>
				<td><label for = "company_businum">사업자 번호 : </label></td>
				<td><input type="text" value="${company.company_businum }" name="company_businum" id="company_busninum" class="inputbox"/></td>
			</tr>
			<tr>
				<td><label for="company_tel">전화번호 : </label></td>
				<td><input type="text" name="company_tel" id="company_tel."
					value="${company.company_tel }" class="inputbox"/></td>
			</tr>
			<tr>
				<td><label for="company_category">카테고리 : </label></td>
				<td><input type="text" name="company_category" id="company_category"
					value="${company.company_category }" class="inputbox" /></td>
			</tr>
			<tr>
				<td><label for="company_address1">우편번호 : </label></td>
				<td><input type="text" name="company_address1" id="company_address1" value="${company.company_address1 }" size="7" required readonly class="inputbox" style="width:70px;">
				<input type="button" onclick="sample6_execDaumPostcode()" value="우편번호 찾기" class="inputbox" style="width:220px;background:#3EB1B0;color:white;height:40px;cursor:pointer;margin-left:5px;"></td>
			</tr>	
			<tr>
				<td><label for="company_address2">주소 : </label></td>
				<td><input type="text" name="company_address2" id="company_address2" value="${company.company_address2 }" required readonly class="inputbox"> 
				</td> 
			</tr>
			<tr>
				<td><label for="company_address3">상세주소 : </label></td>
				<td style="padding-top:5px"><input type="text" name="company_address3" id="company_address3" value="${company.company_address3 }" class="inputbox"></td>
			</tr>
			<tr>
				<td><label for="company_address4">참고항목 : </label></td>
				<td style="padding-top:5px"><input type="text" name="company_address4" id="company_address4" value="${company.company_address4 }" readonly class="inputbox"></td>
			</tr>
			<tr>
				<td><label for="company_active">활성화상태 : </label></td>
				<td><input type="radio" name="company_active" id="company_active"
					value="활성상태" checked />활성
				<input type="radio" name="company_active" id="company_active"
					value="비활성상태" />비활성</td>
			</tr>
			<tr>
				<td class="td_left"><label for="company_logo"> 사진 첨부 </label></td>
				<td class="td_right"><input name="company_logo" type="file" id="company_logo" ></td>
				<input type="hidden" name="company_logo_orig"  value="${company.company_logo }">
			</tr>
			<tr>
				<td colspan="2">
					<input type="button" onclick="javascript:modifyform.submit()" value="수정하기" style="width:150px;background:#3EB1B0;color:white;height:40px; border:0;font-size:20px"/>
					<input type="button" onclick="javascript:location.href='company_admin.jsp'" value="목록으로 " style="width:150px;background:#3EB1B0;color:white;height:40px; border:0;font-size:20px"/>
				</td>
			</tr>
		</table>
	</form>
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
</body>
</html>