<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath }/css/mypage/menubar.css" />
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath }/views/css/common/reset.css" />
<link href="https://fonts.googleapis.com/css?family=Nanum+Gothic&display=swap&subset=korean" rel="stylesheet">

<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script src="${pageContext.request.contextPath }/views/js/mypage/menubar.js" ></script>
<script src="https://unpkg.com/sweetalert/dist/sweetalert.min.js"></script>

<style>
/*
html5doctor.com Reset Stylesheet
v1.6.1
Last Updated: 2010-09-17
Author: Richard Clark - http://richclarkdesign.com
Twitter: @rich_clark
*/

html, body, div, span, object, iframe,
h1, h2, h3, h4, h5, h6, p, blockquote, pre,
abbr, address, cite, code,
del, dfn, em, img, ins, kbd, q, samp,
small, strong, sub, sup, var,
b, i,
dl, dt, dd, ol, ul, li,
fieldset, form, label, legend,
table, caption, tbody, tfoot, thead, tr, th, td,
article, aside, canvas, details, figcaption, figure,
footer, header, hgroup, menu, nav, section, summary,
time, mark, audio, video {
    margin:0;
    padding:0;
    border:0;
    outline:0;
    font-size:100%;
    vertical-align:baseline;
    background:transparent;
}

body {
    line-height:1;
}

article,aside,details,figcaption,figure,
footer,header,hgroup,menu,nav,section {
    display:block;
}

nav ul {
    list-style:none;
}

blockquote, q {
    quotes:none;
}

blockquote:before, blockquote:after,
q:before, q:after {
    content:'';
    content:none;
}

a {
    margin:0;
    padding:0;
    font-size:100%;
    vertical-align:baseline;
    background:transparent;
}

/* change colours to suit your needs */
ins {
    background-color:#ff9;
    color:#000;
    text-decoration:none;
}

/* change colours to suit your needs */
mark {
    background-color:#ff9;
    color:#000;
    font-style:italic;
    font-weight:bold;
}

del {
    text-decoration: line-through;
}

abbr[title], dfn[title] {
    border-bottom:1px dotted;
    cursor:help;
}

table {
    border-spacing:0;
}

/* change border colour to suit your needs */
hr {
    display:block;
    height:1px;
    border:0;  
    border-top:1px solid #cccccc;
    margin:1em 0;
    padding:0;
}

input, select {
    vertical-align:middle;
}

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
    border-radius: 0 0 10px 0;
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
<div style="display:none"><%@ include file = "../common/menubar.jsp" %></div>
<h2 class="mpTitle"><span>MY PAGE</span></h2>

<ul class="mypageMenu">
	
	<li><a href="${pageContext.request.contextPath}/myConfirm.bo">정보수정</a></li>
	<li><a href="${pageContext.request.contextPath}/myOrder.bo">주문/배송</a></li>
	<li><a href="${pageContext.request.contextPath}/myBasket.bo">장바구니</a></li>
	<li><a href="${pageContext.request.contextPath}/myReview.bo">나의 리뷰</a></li>
	<%-- <li><a href="${pageContext.request.contextPath}/myQna.bo">문의 내역</a></li> --%>
	
	
	<!-- 여기 에러나면 주석해서 테스트 -->
	<%if(loginUser.getGroupNum().equals("1")) {%> 
		<li><a href="<%=request.getContextPath() %>/views/seller/SellerRegist.jsp">판매자 등록</a></li>
	<%}else if(loginUser.getGroupNum().equals("2")) {%>	
			<li><a href="<%=request.getContextPath() %>/sellerInfoMng.selr?fid=<%=sellerUser.getFid()%>"><span>판매자 정보 관리</span></a></li>
			<li><a href="<%=request.getContextPath() %>/productMngList.prod?sid=<%=sellerUser.getSid()%>"><span>판매 상품 관리</span></a></li> <!-- PrMngListServlet -->
			<li><a href="<%=request.getContextPath() %>/reviewList.selr?sid=<%=sellerUser.getSid()%>"><span>상품 리뷰 확인</span></a></li>
			<li><a href="<%=request.getContextPath() %>/sReport.selr?sid=<%=sellerUser.getSid()%>"><span>주문 및 매출 관리</span></a></li>
		<%} %>
	<!-- 여기까지 추가함 -->
	
</ul>  

