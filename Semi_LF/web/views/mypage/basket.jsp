<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>


<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath }/views/css/mypage/basket.css" />
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

.btnArea {
	
    min-width: 300px;
    margin-left: 80px;
    margin-top: 30px;
    display: inline-block;
}

.btnArea .allDltBtn, .btnArea .selDltBtn {
	width: 120px;
	height: 40px;
	
    border: 1px solid #d8d8d8;
    box-sizing: border-box;
    text-align: center;
    background: #fff;
    cursor: pointer;
    
}

.tableArea {
   	margin-left: 80px;
    margin-top: 30px;
    display: inline-block;
}

.cartTable {
	width: 915px;
	/*min-height: 300px;*/
	border-top: 1px solid #ada9a9;
	/* position: relative;
    left: 40px;
    top: 40px; */
    text-align: center;
}

.cartTable th:nth-child(1) {
	width: 7%;
}

.cartTable th:nth-child(2) {
	width: 43%;
}

.cartTable th:nth-child(3) {
	width: 20%;	
}

.cartTable th:nth-child(4) {
	width: 15%;
}

.cartTable th:nth-child(5){
	width: 15%;
}

.cartTable .listHeader {
	height: 40px;
	line-height: 40px;
	background: #eaeaea;
}

.cartTable .listContentArea {
	height: 100px;
	line-height: 100px;
}

.cartTable .listContentArea td {
	border-bottom: 1px solid #ddd;
}

.cartTable .listContentArea td:nth-child(2) {
	text-align: left;
}

.cartTable .listContentArea img {
	width: 70px;
    height: 70px;
    vertical-align: middle;
    margin-left: 20px;
    margin-right: 10px;
}

.listContentArea .amount {
	width: 35px;
    text-align: center;
    height: 21px;
    border: 1px solid #cacaca;
}

.listContentArea .amountBtn {
	width: 25px;
    cursor: pointer;
    background: #cacaca;
    font-weight: bold;
    border: none;
    height: 25px;
}

.payArea {
	border: 1px solid black;
	display: block;
	margin: 30px 0 0 270px;
	width: 915px;
	min-height: 200px;
}


</style>
</head>

<body>
		<div class="container">
		<%@ include file="menubar.jsp" %>
		  
		<form action="${pageContext.request.contextPath }/myBasketDelete.bo" onsubmit="return validateSubmit()" class="basketDltForm">
		<input type="hidden" class="deleteType" name="type" value="select" />
		<input type="hidden" class="flag" value="${flag }" />
		
		<div class="btnArea">
			<input type="button" value="전체삭제" class="allDltBtn"/>
			<input type="submit" value="선택삭제" class="selDltBtn" />
		
		</div>		
		
		<div class="tableArea">
		<table class="cartTable">
			<tr class="listHeader">
				<th>
					<input type="checkbox" class="allCheck">
				</th>
				<th>상품명</th>
				<th>수량</th>
				<th>판매자</th>
				<th>금액</th>
			</tr>
			
			<c:forEach var="list" items="${basketList }">
			
				<tr class="listContentArea">
					<td>
						<input type="checkbox" class="selCheck" name="checkArr" value="${list.basketId }"">
					</td>
					<td><img src="${pageContext.request.contextPath }/uploadFiles/${list.imgPath }"/>${list.pName }</td>
					<td>
						<input type="button" value="-" class="minusBtn amountBtn" data-price="${list.price }" />
							<input type="text" value="${list.count }" class="amount" readonly="readonly" />
						<input type="button" value="+" class="plusBtn amountBtn" data-price="${list.price }" />
					</td>
					<td>${list.userId }</td>
					<td class="listTotalPrice">${list.price * list.count }</td>
				</tr>
			
			</c:forEach>
		</form>
			
		</table>
		
		</div>
		
		<div class="payArea">
		
		</div>
		
		
		</div>

</body>
<script src="${pageContext.request.contextPath }/views/js/mypage/basket.js" ></script>
</html>