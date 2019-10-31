<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<!DOCTYPE html>
<html>
<head>
<%-- <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath }/views/css/mypage/order.css" /> --%>
<meta charset="UTF-8">
<title>Insert title here</title>

<style>
.container {
   border: 1px solid black;
   width: 1280px;
   min-width: 1280px;
   margin: 0 auto;
   min-height: 800px;
   padding-bottom: 100px;
}

.infoText {
   position: relative;
   left: 40px;
}

.listType {
   position: relative;
   left: 584px;
   width: 120px;
   height: 30px;
}

.orderTable {
   width: 915px;
   border-top: 1px solid #ada9a9;
   text-align: center;
   margin-left: 80px;
   display: inline-table;
}

.orderTable th:nth-child(1) {
   width: 45%;
}

.orderTable th:nth-child(2) {
   width: 11%;
}

.orderTable th:nth-child(3) {
   width: 11%;
}

.orderTable th:nth-child(4) {
   width: 11%;
}

.orderTable th:nth-child(5) {
   width: 11%;
}

.orderTable th:nth-child(6) {
   width: 11%;
}

.orderTable .listHeader {
   height: 40px;
   line-height: 40px;
   background: #eaeaea;
}

.orderTable .listNumberArea {
   height: 28px;
   line-height: 28px;
   font-size: 13px;
}

.orderTable .listNumberArea td {
   text-align: left;
}

.orderTable .listContentArea {
   height: 100px;
   line-height: 100px;
}

.orderTable .listContentArea td:nth-child(1) {
   text-align: left;
}

.orderTable .listContentArea td:nth-child(6) {
   line-height: normal;
}

.orderTable .listContentArea td:nth-child(6) div {
   vertical-align: middle;
   display: -webkit-inline-box;
}

.orderTable .listContentArea img {
   width: 70px;
   height: 70px;
   vertical-align: middle;
   margin-left: 20px;
   margin-right: 10px;
}

.orderTable .listBtnArea {
   height: 40px;
   line-height: 40px;
}

.orderTable .listBtnArea .orderNum {
   margin-left: 20px;
   font-size: 13px;
   color: #525252;
}

.orderTable .listBtnArea .price {
   margin-right: 20px;
   font-weight: bold;
}

.orderTable .listBtnArea td {
   border-top: 1px solid #b7b7b7;
}

.orderTable .listBtnArea td:nth-child(1) {
   text-align: left;
   border-bottom: 1px solid #969494;
}

.orderTable .listBtnArea td:nth-child(2) {
   text-align: right;
   border-bottom: 1px solid #969494;
}

.orderTable .btn {
   color: #000;
   border: none;
   cursor: pointer;
   padding: 5px 10px;
   margin: 3px;
   background: #fff;
   border: 1px solid #d8d8d8;
}

.orderTable .btn:hover {
   background: #000;
   color: #fff;
}

/* .orderTable .refundBtn {
   background: #5555b9;
}

.orderTable .reviewBtn {
   background: green;
}
 */

.pagingArea {
   width: 450px;
   height: 70px;
   margin-left: 510px;
   margin-top: 20px;
   text-align: center;
}

.pageNum {
   border: 1px solid #d8d8d8;
   background: #fff;
   width: 40px;
   height: 40px;
   font-weight: bold;
   cursor: pointer;
   outline: none;
}

.selPageNum {
   box-shadow: 0px 0px 2px 1px #5E9ED6;
}



.modal {
   display: none;
   position: fixed;
   z-index: 1;
   left: 0;
   top: 0;
   width: 100%;
   height: 100%;
   overflow: auto;
   background-color: rgb(0, 0, 0);
   background-color: rgba(0, 0, 0, 0.4);
}


.modal-content {
   background-color: #fefefe;
   margin: 15% auto;
   padding: 20px 30px;
   border: 1px solid #888;
      width: 700px;
    height: 270px;
    display: block;
    border: 2px solid #676767;
    border-radius: 10px;
    position: relative;
}

.modalTitleArea {
   display: block;
   border-bottom: 1px solid #828282;
    padding-bottom: 10px;
}

.modal-pname {
   min-width: 300px;
   height: 30px;
   display: inline-block;
   line-height: 30px;
}

.starArea {
   width: 200px;
   height: 30px;
   margin-left: 20px;
   display: inline-block;
   float: right;
   text-align: right;
}

.starPoint {
   background-image: url(./images/star_empty.png);
   background-repeat: no-repeat;
   background-size: 30px;
    width: 30px;
    height: 30px;
    list-style: none;
   display:inline-block;
   margin: -1px;
   cursor: pointer;
}

.starPoint.on {
   background-image: url(./images/star_filled.png);
   background-position:0 0;
}

.reviewContent {
   margin-top: 10px;
    width: 100%;
    height: 180px;
    overflow-y: auto;
    margin-bottom: 15px;
    border-bottom: 1px solid #828282;
}

.reviewContent textarea {
   resize: none;
    width: 99%;
    height: 160px;
}

.modalBtnArea {
   text-align: right;
   /* margin-top: 15px; */
}

.modalBtn {
   border: 1px solid #d8d8d8;
    background: #fff;
    width: 90px;
    height: 25px;
   cursor: pointer;
}



.close {
   color: #676767;
    float: right;
    font-size: 25px;
    font-weight: bold;
    position: absolute;
    right: 5px;
    top: 0px;
}

.close:hover, .close:focus {
   color: black;
   text-decoration: none;
   cursor: pointer;
}

</style>

</head>


<body>
	
      <%@ include file="menubar.jsp" %>
      
      <span class="infoText">${sessionScope.loginUser.userId }님의 주문내역입니다.</span>
      <select class="listType">
         <option>주문내역전체</option>
         <option>배송중</option>
         <option>배송완료</option>
         <option>환불신청</option>
         <option>환불완료</option>
      </select>
      
      <table class="orderTable">
         <tr class="listHeader">
            <th>상품명/주문번호</th>
            <th>수량</th>
            <th>판매자</th>
            <th>주문상태</th>
            <th>주문일</th>
            <th>기타</th>
         </tr>
         
         <c:forEach var="list" items="${orderList }" >
         <tr class="listContentArea">
            <td><img src="${pageContext.request.contextPath }/uploadFiles/${list.imgPath }"/><span class="pName">${list.pName}</span></td>
            <td>${list.scount }</td>
            <td>${list.userId }</td>
            <td>
               <c:if test="${list.status eq 'Y' }">주문완료</c:if>
               <c:if test="${list.status eq 'X' }">배송중</c:if>
               <c:if test="${list.status eq 'B' }">환불완료</c:if>
               <c:if test="${list.status eq 'N' }">배송완료</c:if>
            </td>
            <td>${list.sale_date}</td>
            <td>
               <div>
                  <c:if test="${list.status ne 'B' }">
                     <input type="button" class="btn refundBtn" value="환불신청" data-sId="${list.sale_id }" />
                  </c:if>
                  
                  <c:if test="${list.reviewCount < 1 }">
                     <input type="button" class="btn reviewBtn" value="구매후기" data-sId="${list.sale_id }" />
                  </c:if>
               </div>
            </td>
         </tr>
         
         <tr class="listBtnArea">
            <td><span class="orderNum">주문번호 | ${list.sale_id }</span></td>
         
            <td colspan="5">
               <span class="price">결제금액 : <fmt:formatNumber value="${list.totalPrice }" pattern="#,###" />원</span>
            </td>
         </tr>
         </c:forEach>
      </table>
      
      <div class="pagingArea">
      
         <c:choose>
            <c:when test="${1 == pageVo.curPage }">
               <input type="button" class="pageNum prevPage false" value="◀"/>
            </c:when>
            
            <c:otherwise>
               <input type="button" class="pageNum prevPage" value="◀" onclick="location.href='${pageContext.request.contextPath}/myOrder.bo?currentPage=${pageVo.prevPage}'"/>
            </c:otherwise>
         </c:choose>
         
         
         <c:forEach var="pageNum" begin="${pageVo.blockStart}" end="${pageVo.blockEnd}">
            <c:choose>
                <c:when test="${pageNum == pageVo.curPage }">
                   <input type="button" class="pageNum selPageNum" value="${pageNum }"/>
                </c:when>
             
                <c:otherwise>
                   <input type="button" class="pageNum" value="${pageNum }" onclick="location.href='${pageContext.request.contextPath}/myOrder.bo?currentPage=${pageNum}'"/>
                </c:otherwise>
            </c:choose>
         </c:forEach>
       
         <c:choose>
            <c:when test="${pageVo.totPage == pageVo.curPage }">
               <input type="button" class="pageNum nextPage false" value="▶"/>
            </c:when>
            
            <c:otherwise>
               <input type="button" class="pageNum nextPage" value="▶" onclick="location.href='${pageContext.request.contextPath}/myOrder.bo?currentPage=${pageVo.nextPage}'"/>
            </c:otherwise>
         </c:choose>
      </div>
   </div>
<input type="hidden" class="currentPage" value="${pageVo.curPage }" />   
<input type="hidden" class="flagType" value=${type } />
      
<div id="myModal" class="modal">
 
   <!-- Modal content -->
     <div class="modal-content">
     
        <span class="close">&times;</span>
     
        <form action="${pageContext.request.contextPath }/myReviewInsert.bo" onsubmit="return insertReview()">
           <input type="hidden" name="type" value="reviewInsert" />
           <div class="modalTitleArea">
              <div class="modal-pname">왕감자</div>
              
              <div class="starArea">
                 <ul>
                    <li class="starPoint on always"></li>
                    <li class="starPoint"></li>
                    <li class="starPoint"></li>
                    <li class="starPoint"></li>
                    <li class="starPoint"></li>
                 </ul>
              </div>
           </div>
           
           <div class="reviewContent">
              <textarea name="reContent" class="reContent"></textarea>
           </div>
           
           <div class="modalBtnArea">
              <input type="submit" value="등록" class="modalBtn modalSubmitBtn"/>
              <input type="button" value="취소" class="modalBtn modalCancelBtn"/>
           </div>
           
           <input type="hidden" class="review_sId" name="sale_id" />
           <input type="hidden" class="review_grade" name="grade" />
           <input type="hidden" name="currentPage" value="${pageVo.curPage }" />
           
        </form>
       
     </div>

</div>
      
      
</body>
<script src="${pageContext.request.contextPath }/views/js/mypage/order.js" ></script>

</html>