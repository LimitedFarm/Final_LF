<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%-- <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%> --%>

 
<!DOCTYPE html>
<html>
<head>
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

.number {
	position: relative;
    right: -50px;
    font-size: large;
    bottom: -30px;
}

.email{
	position: relative;
    right: -50px;
    font-size: large;
    bottom: -60px;
}

.address{
	position: relative;
    right: -50px;
    font-size: large;
    bottom: -100px;
}

.textBtn{
	right: -310px;
    position: relative;
    bottom: -22px;
    width: 100px;
    height: 38px;
    vertical-align: top;
    background: #3333e8;
    color: white;
    border:none;
    cursor:pointer;
}

.password1{
	position: relative;
    right: -50px;
    font-size: large;
    bottom: -120px;
}

.password2{
	position: relative;
    right: -50px;
    font-size: large;
    bottom: -150px;
}

.num{
	right: -200px;
    position: relative;
    bottom: -5px;
    width: 250px;
    height: 30px;
    vertical-align: top;
}

.mail{
	right: -200px;
    position: relative;
    bottom: -35px;
    vertical-align: top;
    width: 250px;
    height: 30px;
}

.address1{
	right: -199px;
    position: relative;
    bottom: -76px;
    vertical-align: top;
    width: 100px;
    height: 32px;
}

.address2{
	position: relative;
    bottom: -80px;
    vertical-align: top;
    left: 93px;
    width: 280px;
    height: 32px;
}

.address3{
	right: -100px;
    position: relative;
    bottom: -80px;
    vertical-align: top;
    width: 140px;
    height: 32px;
}

.pwd1{
	right: -199px;
    position: relative;
    bottom: -96px;
    width: 280px;
    height: 32px;
}

.pwd2{
	right: -389px;
    position: relative;
    bottom: -125px;
    width: 280px;
    height: 32px;
}


/* .modifyBtn{
	position: relative;
    top: 250px;
    left: 410px;
    background: blue;
    cursor: pointer;
    color: white;
    width: 100px;
    height: 40px;
    border: none;
}

.deleteBtn{
	position: relative;
    top: 250px;
    left: 420px;
    background: blue;
    cursor: pointer;
    color: white;
    width: 100px;
    height: 40px;
    border: none;
}

 */
 
 .modifyBtn{
	position: relative;
    top: 250px;
    left: 410px;
    background: blue;
    cursor: pointer;
    color: white;
    width: 100px;
    height: 40px;
    border: none;
}

.deleteBtn {
	position: relative;
    top: 250px;
    left: 420px;
    background: blue;
    cursor: pointer;
    color: white;
    width: 100px;
    height: 40px;
    border: none;
}












	
</style>


<script src="https://t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>
<script src="https://unpkg.com/sweetalert/dist/sweetalert.min.js"></script>

</head>
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath }/views/css/mypage/modify.css" />

<body>
	<div class="container">
		<%@ include file="menubar.jsp" %>
		
		<form action="${pageContext.request.contextPath }/myModifyPro.bo">
		<input type="hidden" name="cId" value="${customer.cId }" />
		<div class="number">전화번호</div>
		<input type="text" class="num" name="phone" placeholder="전화번호를 입력하세요" value="${customer.phone }" name="phone">
		<div class="email">이메일</div>
		<input type="email" class="mail" placeholder="이메일을 입력하세요" value="${customer.email }" name="email">
		<div class="address">주소</div>
		<input type="text" class="address1" id="address1" name="address" onclick="execDaumPostcode()" placeholder="우편번호" readonly="readonly" value="${customer.address }"> <br><br>
		<input type="button" onclick="execDaumPostcode()" value="우편번호 찾기" class="textBtn">
		<input type="text" class="address2" id="address2" name="address2" onclick="execDaumPostcode()" placeholder="주소" readonly="readonly" value="${customer.address2 }">
		<input type="text" class="address3" id="address3" name="address3" placeholder="상세주소" value="${customer.address3 }">
		<div class="password1">비밀번호</div>
		<input type="password" class="pwd1" placeholder="비밀번호를 입력하세요" name="pwd" value="${customer.userPwd }">
		<span class="pwdcheck"></span>
		<div class="password2">비밀번호 확인</div>
		
		<input type="password" class="pwd2" placeholder="비밀번호를 입력하세요" value="${customer.userPwd }">
		
		<input type="submit" class="modifyBtn" value="수정 완료">
		<input type="button" class="deleteBtn" value="취소">
		
		</form>
		
	</div>
</body>

<script src="${pageContext.request.contextPath }/views/js/mypage/modify.js" ></script>
</html>