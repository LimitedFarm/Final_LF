<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
.mypageMenu {
    float: left;
    width: 150px;
    height: auto;
    text-align: center;
    margin-left: 40px;
}

.mypageMenu li {
        display: inline-block;
    width: 100%;
    height: 60px;
    line-height: 60px;
    margin-top: 6px;
    /* background: #dadada; */
    
    /* border-radius: 10px; */
    border-left: 1px solid #dadada;
    /* border-bottom: 1px solid #dadada; */
    box-shadow: 1px 1px 5px grey;
    z-index: 55;
}

.mypageMenu li:hover {
	background: #4343e6;
}

.mypageMenu li:hover a {
	color: #fff;
	font-weight: bold;
}

.mypageMenu li a {
	text-decoration: none;
	color: #000;
	width: 100%;
    display: table;
    font-size : small;S
}

.mypageMenu li.active a {
	background: #4343e6;
	color: #FFF;
	font-weight: bold;
}

.mpTitle {
	margin-top: 45px;
    font-size: 40px;
    border-bottom: 2px solid #afafaf;
    width: 1080px;
    margin-left: 200px;
    color: #484848;
    padding-bottom: 10px;
}

.mpTitle span {
	cursor: pointer;
}

html {
	font-family: "Nanum Gothic", sans-serif;
}

* {
	font-family: "Nanum Gothic", sans-serif !important;
	
	
}
</style>

<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath }/css/mypage/menubar.css" />
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath }/css/common/reset.css" />
<link href="https://fonts.googleapis.com/css?family=Nanum+Gothic&display=swap&subset=korean" rel="stylesheet">

<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script src="${pageContext.request.contextPath }/js/mypage/menubar.js" ></script>
<script src="https://unpkg.com/sweetalert/dist/sweetalert.min.js"></script>

</head>
<body>

<%@ include file="../common/menubar.jsp" %>	<!-- 추가함 -->
<h2 class="mpTitle"><span>MY PAGE</span></h2>

<div id="MyPageMenu">
<ul class="mypageMenu">   
	
			<li><a href="<%=request.getContextPath() %>/sellerInfoMng.selr?fid=<%=sellerUser.getFid()%>"><span>판매자 정보 관리</span></a></li>
			<li><a href="<%=request.getContextPath() %>/productMngList.prod?sid=<%=sellerUser.getSid()%>"><span>판매 상품 관리</span></a></li> <!-- PrMngListServlet -->
			<li><a href="<%=request.getContextPath() %>/reviewList.selr?sid=<%=sellerUser.getSid()%>"><span>상품 리뷰 확인</span></a></li>
			<li><a href="<%=request.getContextPath() %>/sReport.selr?sid=<%=sellerUser.getSid()%>"><span>주문 및 매출 관리</span></a></li>
	
	<!-- 여기까지 추가함 -->
</ul>  
</div>

<script>

$(function() {
	
	$(".mpTitle span").on("click", function() {
		location.href="/semiProject/myMain.bo";
	});
	
});
</script>

</body>
</html>

