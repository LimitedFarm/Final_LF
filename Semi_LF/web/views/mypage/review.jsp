<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<!DOCTYPE html>
<html>
<head>
<%-- <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath }/views/css/mypage/review.css" /> --%>
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


.reviewTitle{
   margin-left: 40px;
    display: inline-block;
    font-size: large;
    margin-top: 30px;
    color: black;
    font-weight: bold;   
}

.reviewTable{
    width: 1010px;
    margin-left: 230px;
    margin-top: 40px;
    
}
.reviewListHeader{
   height: 40px;
   line-height: 40px;
   background: #eaeaea;   
}

.reviewTable tr{
   text-align: center;
}
.reviewTable th:nth-child(1){
   width: 10%;
}

.reviewTable th:nth-child(2){
   width: 30%;
}

.reviewTable th:nth-child(3){
   width: 30%;
}

.reviewTable th:nth-child(4){
   width: 10%;
}

.reviewTable th:nth-child(5){
   width: 20%;
}

.reviewListContent {
   height: 50px;
    line-height: 50px;
    cursor: pointer;
}

.reviewListContent:hover {
   background: #e4e4e4;
}

.reviewListContent td{
   border-bottom : 1px solid #969696;
}

.reviewListContent td:nth-child(3) {
   overflow: hidden;
    text-overflow: ellipsis;
    display: -webkit-box;
    -webkit-line-clamp: 1;
    -webkit-box-orient: vertical;
    word-wrap: break-word;
    height: 50px;
}

.reviewListContent img{
   width: 20px;
    vertical-align: text-bottom;
}

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

.reviewContent {
   margin-top: 10px;
    width: 100%;
    height: 180px;
    overflow-y: auto;
    margin-bottom: 15px;
    border-bottom: 1px solid #828282;
}

/* .reviewContent textarea {
   resize: none;
   width: 100%;
   height: 100%;
} */

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

.reviewContent .reContentModify, .modalModifyProBtn, .modalCancelBtn {
   display: none;
}

.reviewContent .reContentModify {
   resize: none;
    width: 99%;
    height: 160px;
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
   /* cursor: pointer; */
}

.starPoint.on {
   background-image: url(./images/star_filled.png);
   background-position:0 0;
}

.starPoint.modify {
   cursor: pointer;
}


</style>
</head>
<body>
   <div class="container">
   <%@ include file="menubar.jsp" %>
      
      <div class="reviewTitle">${sessionScope.loginUser.userId }님의 리뷰목록입니다.</div>
         <table class="reviewTable">
            <tr class="reviewListHeader">
               <th>주문번호</th>
               <th>상품명</th>
               <th>리뷰내용</th>
               <th>별점</th>
               <th>작성일</th>
            </tr>
            
            <c:forEach var="list" items="${reviewList }">
            
            <tr class="reviewListContent" data-reid="${list.reId }" data-grade="${list.grade }">
               <td>${list.sale_id }</td>
               <td class="pName">${list.pName }</td>
               <td class="reContent">${list.reContent }</td>
               <td><img src="${pageContext.request.contextPath }/images/star_filled.png"/>${list.grade }</td>
               <td>${list.review_date }</td>
            </tr>
            
            </c:forEach>
         
         </table>
         
         <div class="pagingArea">
      
         <c:choose>
            <c:when test="${1 == pageVo.curPage }">
               <input type="button" class="pageNum prevPage false" value="◀"/>
            </c:when>
            
            <c:otherwise>
               <input type="button" class="pageNum prevPage" value="◀" onclick="location.href='${pageContext.request.contextPath}/myReview.bo?currentPage=${pageVo.prevPage}'"/>
            </c:otherwise>
         </c:choose>
         
         
         <c:forEach var="pageNum" begin="${pageVo.blockStart}" end="${pageVo.blockEnd}">
            <c:choose>
                <c:when test="${pageNum == pageVo.curPage }">
                   <input type="button" class="pageNum selPageNum" value="${pageNum }"/>
                </c:when>
             
                <c:otherwise>
                   <input type="button" class="pageNum" value="${pageNum }" onclick="location.href='${pageContext.request.contextPath}/myReview.bo?currentPage=${pageNum}'"/>
                </c:otherwise>
            </c:choose>
         </c:forEach>
         
         
       
         <c:choose>
            <c:when test="${pageVo.totPage == pageVo.curPage }">
               <input type="button" class="pageNum nextPage false" value="▶"/>
            </c:when>
            
            <c:otherwise>
               <input type="button" class="pageNum nextPage" value="▶" onclick="location.href='${pageContext.request.contextPath}/myReview.bo?currentPage=${pageVo.nextPage}'"/>
            </c:otherwise>
         </c:choose>
      </div>
      
<div id="myModal" class="modal">
 
   <!-- Modal content -->
     <div class="modal-content">
     
        <span class="close">&times;</span>
     
        <form action="${pageContext.request.contextPath }/myReviewMoidfy.bo" onsubmit="return modifyReview()">
           <div class="modalTitleArea">
              <div class="modal-pname"></div>
              
              <div class="starArea" data-grade="">
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
              <div class="reContent"></div>
              <textarea name="reContent" class="reContentModify"></textarea>
           </div>
           
           <div class="modalBtnArea">
              <input type="button" value="수정" class="modalBtn modalModifyBtn"/>
              <input type="submit" value="수정완료" class="modalBtn modalModifyProBtn" />
              <input type="button" value="삭제" class="modalBtn modalDeleteBtn" data-reid=""/>
              <input type="button" value="취소" class="modalBtn modalCancelBtn" />
           </div>
           
           <input type="hidden" class="reid" name="reid"/>
           <input type="hidden" class="review_grade" name="grade" />
           <input type="hidden" class="currentPage" name="currentPage" value="${pageVo.curPage }" />
           
        </form>
       
     </div>


<input type="hidden" class="reviewType" value="${type }" />
</div>
</div>
   
   
   

</body>
<script src="${pageContext.request.contextPath }/views/js/mypage/review.js" ></script>
</html>