<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" import="LF.member.model.vo.*"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath }/css/mypage/main.css" />
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
.container {
	border: 1px solid black;
	width: 1280px;
	min-width: 1280px;
	margin:0 auto;
	min-height: 800px;
	padding-bottom: 100px;
}

.nameArea {
   min-width: 320px;
    min-height: 195px;
    float: left;
    margin-top: 20px;
    margin-left: 40px;
    
}

.nameArea > span:nth-child(1) {
    margin-top: 20px;
    margin-left: 10px;
    display: inline-block;
    font-size: 23px;
    font-weight: bold;
}

.nameArea > span:nth-child(2) {
	font-size: 13px;
}


/* 수정 */
.nameArea > span:nth-child(2) a {
	text-decoration: none;
	color: #2c2cff;
	font-size: 13px;
	font-weight: bold;
	margin-left: 5px;
}

/* 수정 */

.nameArea > span:nth-child(3) {
	display: block;
    margin-left: 10px;
    margin-top: 15px;
    color: #5d5d5d;
    font-size: 15px;
    border-bottom: 2px solid #929292;
    padding-bottom: 15px;
}

.nameArea img {
	width: 80px;
    margin-left: 10px;
    margin-top: 20px;
}

.nameArea > span:nth-child(4) {
	font-size: 35px;
    float: right;
    margin-top: 40px;
    /* margin-right: 75px; */
    font-weight: bold;
}

.nameArea .number {
	font-size: 35px;
}



.infoArea {
    min-height: 200px;
    margin-top: 30px;
    margin-left: 590px;
}

.infoArea ul {
	float: left;
}

/* 수정 */
.infoArea ul li {
	display: inline-block;
    width: 160px;
    height: 190px;
    text-align: center;
    
    background: #fff;
    background-repeat: no-repeat;
    background-size: 35px;
    background-position: 10px 10px;
    
    cursor: pointer;
    
    box-shadow: 4px 4px 10px 1px #868686;
    font-weight: bold;
}
/* 수정 */


.infoArea ul li:nth-child(1) {
	background-image: url(./images/order.png);
}

.infoArea ul li:nth-child(2) {
	background-image: url(./images/cart.png);
}

.infoArea ul li:nth-child(3) {
	background-image: url(./images/review.png);
}

.infoArea ul li:nth-child(4) {
	background-image: url(./images/qna.png);
}

/* 수정 */
.infoArea ul li span:nth-child(1) {
    display: inline-block;
    margin-top: 19px;
    font-size: 20px;
    float: left;
    margin-left: 59px;
}
/* 수정 */


.infoArea ul li span:nth-child(2) {
	display: block;
    font-size: 50px;
    margin-top: 88px;
}

/* 수정 */
.orderListArea, .cartListArea {
	width: 1015px;
    border: 1px solid #cccccc;
    margin-left: 40px;
    display: inline-block;
    margin-top: 10px;
}

.cartListArea {
    margin-left: 230px;
    display: block;
}
/* 수정 */

.orderListArea table, .cartListArea table {
	width: 100%;
	text-align: center;
}

.orderListArea table tr th, .cartListArea table tr th {
	background: #cccccc;
	height: 30px;
	line-height: 30px;
}

.orderListArea table tr td, .cartListArea table tr td {
	border-bottom: 1px solid #cccccc;
	height: 30px;
	line-height: 30px;
}

.orderListArea table tr td:nth-child(1), .cartListArea table tr td:nth-child(1) {
	text-align: left;
	padding-left: 15px;
}

.orderListArea table tr th:nth-child(1), .cartListArea table tr th:nth-child(1) {
	width:45%
}
.orderListArea table tr th:nth-child(2), .cartListArea table tr th:nth-child(2){
	width:20%;
}
.orderListArea table tr th:nth-child(3), .cartListArea table tr th:nth-child(3){
	width:20%;
}
.orderListArea table tr th:nth-child(4), .cartListArea table tr th:nth-child(4) {
	width:15%;
}


/* 추가 */
.listTitle {
	width: 1015px;
    margin-top: 20px;
    margin-left: 230px;
    display: block;
    font-weight: bold;
}

.listTitle span a {
	color: #2c2cff;
	font-size: 13px;
	text-decoration: none;
	margin-left: 10px;
}

.cartListArea .deleteBtn {
	border: 1px solid #d8d8d8;
    box-sizing: border-box;
    text-align: center;
    background: #fff;
    cursor: pointer;
    width: 80px;
}
/* 추가 */
</style>
</head>
<body>
		<div class="container" >	
		<%@ include file="./menubar.jsp" %>		
			<div class="nameArea">
				<span>${customerVo.userId }</span>
				<span><a href="${pageContext.request.contextPath }/myConfirm.bo">[ 회원정보수정 ]</a></span>
				<span>가입일자&nbsp;${customerVo.joinDate }</span>
				<span><span class="number comma" data-count="4800"></span>원</span>
				<img src="${pageContext.request.contextPath }/images/coins.png" />
			</div>
			
			<div class="infoArea">
				<ul>
					<li class="Order">
						<span>주문배송</span>
						<span class="number" data-count="${mainCountVo.o_count }"></span>
					</li>
					
					<li class="Basket">
						<span>장바구니</span>
						<span class="number" data-count="${mainCountVo.b_count }"></span>
					</li>
					
					<li class="Review">
						<span>나의 리뷰</span>
						<span class="number" data-count="${mainCountVo.r_count }"></span>
					</li>
					
					<li class="Qna">
						<span>문의 내역</span>
						<span class="number" data-count="${mainCountVo.q_count }"></span>
					</li>
				</ul>
			</div>
			
			<div class="listTitle">최근 주문내역<span><a href="${pageContext.request.contextPath }/myOrder.bo">[ 바로가기 ]</a></span></div>
			<div class="orderListArea">
				<table>
					<tr>
						<th>상품명</th>
						<th>수량</th>
						<th>판매자</th>
						<th>주문일자</th>
					</tr>
					
					<c:forEach var="list" items="${orderList }">
					
						<tr>
							<td>${list.pName }</td>
							<td>${list.scount }</td>
							<td>${list.userId }</td>
							<td>${list.sale_date }</td>
						</tr>
					
					</c:forEach>
					
				</table>	
			</div>
			
			<div class="listTitle">최근 장바구니<span><a href="${pageContext.request.contextPath }/myCart.bo">[ 바로가기 ]</a></span></div>
			<div class="cartListArea">
				<table>
					<tr>
						<th>상품명</th>
						<th>수량</th>
						<th>판매자</th>
						<th>삭제</th>
					</tr>
					
					<c:forEach var="list" items="${basketList }">
					
						<tr>
							<td>${list.pName }</td>
							<td>${list.count }</td>
							<td>${list.userId }</td>
							<td><input type="button" value="삭제" class="deleteBtn" data-bId="${list.basketId }" /></td>
						</tr>
					
					</c:forEach>
					
				</table>	
			
			</div>
		
		
		</div>
		
<input type="hidden" class="flag" value="${flag }" />
</body>
<script src="${pageContext.request.contextPath }/views/js/mypage/main.js" ></script>
</html>