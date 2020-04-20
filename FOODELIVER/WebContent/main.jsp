<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script>
	function check(f){
		if(f.search.value.trim()==''){
			alert('검색어가 비어있습니다.')
			f.search.focus();
			return false
		}
		
			f.submit();
		
	}
</script>
<style>
.menu{
	width: 200px;
	height:200px;
}

</style>

</head>
<body>
<jsp:include page='top.jsp'/>
<c:choose>
	<c:when test="${pagefile!=null}">
	<form action="<%=request.getContextPath() %>/search.main" name="f" method="post" onsubmit="return check();">
	<table style="margin-left: auto; margin-right: auto;">
	<tr>
	<td>
	<script>
	
		document.getElementById("option").value=document.getElementById("opt").value;
	
	</script>
	<input type="hidden" id="option" name="option" value="">
	
	<input type="text" id="search" name="search" value="${param.search }"><input type="button" value="검색" onclick="check(this.form);">
	</td>
	
			<c:url value="company.main" var="url1">
  				<c:param name="category" value="all" />
 			    <c:param name="member_address2" value="${address.member_address2 }" />
		    </c:url>
				<td ><a href="${url1 }">| 전체보기 |</a></td>
			<c:url value="company.main" var="url2">
  				<c:param name="category" value="치킨" />
 			    <c:param name="member_address2" value="${address.member_address2 }" />
		    </c:url>
				<td><a href="${url2 }">치킨 | </a></td>
			<c:url value="company.main" var="url3">
  				<c:param name="category" value="피자" />
 			    <c:param name="member_address2" value="${address.member_address2 }" />
		    </c:url>
				<td><a href="${url3 }">피자 |</a></td>
			
			<c:url value="company.main" var="url4">
  				<c:param name="category" value="중식" />
 			    <c:param name="member_address2" value="${address.member_address2 }" />
		    </c:url>
				<td><a href="${url4 }">중식 |</a></td>
			<c:url value="company.main" var="url5">
  				<c:param name="category" value="한식" />
 			    <c:param name="member_address2" value="${address.member_address2 }" />
		    </c:url>
				<td><a href="${url5 }">한식 |</a></td>
			<c:url value="company.main" var="url6">
  				<c:param name="category" value="일식" />
 			    <c:param name="member_address2" value="${address.member_address2 }" />
		    </c:url>
				<td><a href="${url6 }">일식 |</a></td>
			
			<c:url value="company.main" var="url7">
  				<c:param name="category" value="족발" />
 			    <c:param name="member_address2" value="${address.member_address2 }" />
		    </c:url>
				<td><a href="${url7 }">족발 |</a></td>
			<c:url value="company.main" var="url8">
  				<c:param name="category" value="분식" />
 			    <c:param name="member_address2" value="${address.member_address2 }" />
		    </c:url>
				<td><a href="${url8 }">분식 |</a></td>
			<c:url value="company.main" var="url9">
  				<c:param name="category" value="디저트" />
 			    <c:param name="member_address2" value="${address.member_address2 }" />
		    </c:url>
				<td><a href="${url9 }">디저트 |</a></td>
			</tr>
		</table>
	</form>
	<hr>
		<jsp:include page='${pagefile }'/>
	</c:when>
	
	<c:otherwise>
  	 <div style="background-image: url('<%=request.getContextPath() %>/main_img/bg-top.png'); width:100%; height:200px; background-repeat:no-repeat; background-position:center; background-size:cover">
	<table style="margin-left: auto; margin-right: auto;">
	<tr><td>
<div style="padding-top: 120px;">
<form name="addshow" onclick="sample3_execDaumPostcode();">

<input type="text" id="sample3_addressshow" name="sample3_addressshow" placeholder="주소를 입력해주세요" readonly="readonly" value="${address.member_address2 }${address.member_address4 }" autocomplete="off">
<input type="button" onclick="sample3_execDaumPostcode()" value="우편번호 찾기" >
</form>
</div>
<div id="wrap" style="display:none;border:1px solid;width:500px;height:300px;margin:5px 0;position:absolute; z-index: 2;">
<img src="//t1.daumcdn.net/postcode/resource/images/close.png" id="btnFoldWrap" style="cursor:pointer;position:absolute;right:0px;top:-1px;z-index:2" onclick="foldDaumPostcode()" alt="접기 버튼">
</div>

<script src="https://t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>
<script>
    // 우편번호 찾기 찾기 화면을 넣을 element
    var element_wrap = document.getElementById('wrap');

    function foldDaumPostcode() {
        // iframe을 넣은 element를 안보이게 한다.
        element_wrap.style.display = 'none';
    }

    function sample3_execDaumPostcode() {
    	
        // 현재 scroll 위치를 저장해놓는다.
        var currentScroll = Math.max(document.body.scrollTop, document.documentElement.scrollTop);
        new daum.Postcode({
            oncomplete: function(data) {
                // 검색결과 항목을 클릭했을때 실행할 코드를 작성하는 부분.

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
                    document.getElementById("sample3_extraAddress").value = extraAddr;
                
                } else {
                    document.getElementById("sample3_extraAddress").value = '';
                }

                // 우편번호와 주소 정보를 해당 필드에 넣는다.
                document.getElementById('sample3_postcode').value = data.zonecode;
                document.getElementById("sample3_address").value = addr;
                document.getElementById("sample3_addressshow").value = addr+extraAddr;
                // 커서를 상세주소 필드로 이동한다.
                
                // iframe을 넣은 element를 안보이게 한다.
                // (autoClose:false 기능을 이용한다면, 아래 코드를 제거해야 화면에서 사라지지 않는다.)
                element_wrap.style.display = 'none';

                // 우편번호 찾기 화면이 보이기 이전으로 scroll 위치를 되돌린다.
                document.body.scrollTop = currentScroll;
            },
            // 우편번호 찾기 화면 크기가 조정되었을때 실행할 코드를 작성하는 부분. iframe을 넣은 element의 높이값을 조정한다.
            onresize : function(size) {
                element_wrap.style.height = size.height+'px';
            },
            width : '100%',
            height : '100%'
        }).embed(element_wrap);

        // iframe을 넣은 element를 보이게 한다.
        element_wrap.style.display = 'block';
    }
</script>
<script>
function check(cate,menu){
	if(!document.addshow.sample3_addressshow.value.trim()){
		
		alert('주소를 입력해주세요');
		document.addshow.sample3_addressshow.focus();
		return false;
	}	
	document.getElementById("category").value = menu;
		cate.submit();
	
}
</script>
	</td></tr>
	</table>
	</div>
	<form action="company.main" method="post" name="cate" >
		<table  style="margin-left: auto; margin-right: auto;">
			<tr>
				<td><button type="button" onclick="javascript:check(document.cate,'all')"><div style="position:absolute; margin:30px; z-index:1">전체보기</div><img src="main_img/category-01all.png" class="menu"></button></td>
				<td><button type="button" onclick="javascript:check(document.cate,'치킨')"><div style="position:absolute; margin:30px; z-index:1">치킨</div><img src="main_img/category-02치킨.png" class="menu"></button></td>
				<td><button type="button" onclick="javascript:check(document.cate,'피자')"><div style="position:absolute; margin:30px; z-index:1">피자</div><img src="main_img/category-03피자.png" class="menu"></button></td>
			</tr>
			<tr>
				<td><button type="button" onclick="javascript:check(document.cate,'중식')"><div style="position:absolute; margin:30px; z-index:1">중식</div><img src="main_img/category-04중식.png" class="menu"></button></td>
				<td><button type="button" onclick="javascript:check(document.cate,'한식')"><div style="position:absolute; margin:30px; z-index:1">한식</div><img src="main_img/category-05한식.png" class="menu"></button></td>
				<td><button type="button" onclick="javascript:check(document.cate,'일식')"><div style="position:absolute; margin:30px; z-index:1">일식</div><img src="main_img/category-06일식.png" class="menu"></button></td>
			</tr>
			<tr>
				<td><button type="button" onclick="javascript:check(document.cate,'족발')"><div style="position:absolute; margin:30px; z-index:1">족발</div><img src="main_img/category-07족발.png" class="menu"></button></td>
				<td><button type="button" onclick="javascript:check(document.cate,'분식')"><div style="position:absolute; margin:30px; z-index:1">분식</div><img src="main_img/category-08분식.png" class="menu"></button></td>
				<td><button type="button" onclick="javascript:check(document.cate,'디저트')"><div style="position:absolute; margin:30px; z-index:1">디저트</div><img src="main_img/category-09디저트.png" class="menu"></button></td>
			</tr>
		</table>
		<input type="hidden" id="category" name="category" value="all">
		<input type="hidden" id="sample3_postcode" name="member_address1" value="${address.member_address1 }">
		<input type="hidden" id="sample3_address" name="member_address2" value="${address.member_address2 }">
		<input type="hidden" id="sample3_extraAddress" name="member_address4" value="${address.member_address4 }">
		</form>
		
		<jsp:include page='footer.jsp'/>
	</c:otherwise>
</c:choose>



</body>
</html>