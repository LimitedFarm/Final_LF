<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="LF.seller.model.vo.*, LF.member.model.vo.*, java.util.*"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="http://code.jquery.com/jquery-3.4.1.min.js"></script>
<script src="http://ajax.googleapis.com/ajax/libs/jquery/1.9.1/jquery.min.js"></script>
<style>
	.outer{
	position: absolute;
   	margin-top: 250px;
   	pading-top:50px;
   	top: 150px;
   	left: 220px;
    width: 1280px;
    min-width: 1280px;
    min-height: 800px;
    display: inline-block; 
    pading-left:300px;
	
	margin:0 auto;
	
	}
	h1{
	text-align:left;

</style>
</head>
<body>

	<%@ include file="../seller/sellerMain.jsp" %>
	
	<div class="outer">
		<br>
		
		<h2 align="center">상품 리뷰 확인</h2>
		
		<%-- <!-- 공지사항 때와 마찬가지로 검색 부분이 있다. 기능 구현은 생략 -->
		<div class="searchArea" align="center">
			<form id="searchReview" action="<%=request.getContextPath() %>/reviewList.selr" method="post">
				<input type="hidden" id="sid" name="sid" value="<%=sellerUser.getSid()%>">
				<select id="searchCondition" name="searchCondition">
					<option>----</option>
					<option value="PNAME">상품명</option>
					<option value="DANAME">작성자</option>
					<option value="RECONTENT">내용</option>
				</select>
				<input type="search" id="word" name="word">
				<button type="submit" onclick="search();">검색하기</button>
				<br><br>
				<!-- <label>기간설정</label> --><!-- 기간설정 달력 선택하는거 만들어서 붙여주기. 리뷰,상품관리페이지 전부 다 똑같이 만들어줘야됨, 버튼이 아니라 달력으로 수정해야함 -->
				<input type="date" id="startDate" name="startDate">~<input type="date" id="lastDate" name="lastDate">
			</form>
		</div> --%>
		
		<div class="tableArea">
		</div>
		<br>
		
	</div>
	
	<script>
	function search(){
		alert("search!");
		
		//옵션 값 검사
		var op = $("#searchReview select[name='searchCondition']").val();
		
		if(!(op == "PNAME" || op=="DANAME" || op=="RECONTENT")){
			alert("검색 항목을 선택하세요");
			return false;
		}
		
		
		//서치 인풋 박스 값 검사
		var word = $("#searchReview input[name='word']").val();
		
		if(word.length < 2){
			alert("최소 두 글자 이상 입력해야 합니다.");
			return false;
		}
		
		//기간 값 검사 - 값을 입력했을 때만 포함한다.
		var startDate = $("#searchReview input[name='startDate']").val();
		var lastDate = $("#searchReview input[name='lastDate']").val();
		
		if(!startDate==null || !lastDate==null){
			if(startDate==null){
				alert("시작 날짜를 확인해주세요");
				return false;
			}else if(lastDate==null){
				alert("종료 날짜를 확인해주세요");
				return false;
			}else{
				var startDateArr = startDate.split('-');
				var lastDateArr = lastDate.split('-');
				
				var startDateCompare = new Date(startDateArr[0], parseInt(startDateArr[1])-1, startDateArr[2]);
				var lastDateCompare = new Date(lastDateArr[0], parseInt(lastDateArr[1])-1, lastDateArr[2]);
				
				if(startDateCompare.getTime() > endDateCompare.getTime()){
					
					alert("시작 날짜와 종료 날짜를 확인해 주세요.");
					return false;
				}else{
					alert("return true");
					return true;
				}
			}
			alert("return true");
			return true;
		}
		
	}
	
	
	
	
	 $(document).ready(function(){
		
		 if($("body").height() < $(window).height()){	//화면에 표시된 내용이 적어서 스크롤바가 생기지 않는 경우 => 최초 로딩
		 		/* window.alert("There isn't a vertical scroll bar"); */
		 		<%
					ArrayList<Review> list = (ArrayList<Review>)request.getAttribute("list");
		 			ListObj lo = (ListObj)request.getAttribute("lo");
					
					//상품 대표 이미지도 불러와야 함. 대표 이미지는 물품번호가 같은 이미지 중 정보순서가 가장 이른 것(또는 파일 번호가 가장 이른 것)
				%>    
					
		 		<%if(list.isEmpty()){ %>
		 			$(".tableArea").append("<a href='"+<%=request.getContextPath()%>+"/views/Main/MainPage.jsp'>아직 등록된 리뷰가 없습니다.</a>");
				<%}else{ %>
					<%for(Review r : list){ %>
					//값 받아오는거는 for문 돌리든 해서 넣기.
					var reId = <%=r.getReId()%>;
					var grade = <%=r.getGrade()%>;
					var sale_Id = <%=r.getSaleId()%>;
					var review_Date = "<%=r.getReviewModify()%>";
					var reContent = "<%=r.getReContent()%>";
	
					$(".tableArea").append("<hr><table align='center' width='1000px' border='1px solid black' style='border-collapse:collapse'>"
							+ "<tr><td colspan='3' width='60%' >리뷰번호 : " + reId + "</td><td colspan='1' width='30%'>별점 : " + grade + "</td></tr>"
							+ "<tr><td width='45%'>주문번호 : " + sale_Id + "</td><td colspan='3' align='right'>리뷰 작성일 : " + review_Date + "</td></tr>"
							+ "<tr><td colspan='4' width='90%'>" + reContent 
							/* + "<br><div align='right'><button>신고하기</button></div>" */
							+"</td></tr>"
							+ "</table>");
					
					<%} %>
				<%} %>
		 	}
		 
		 	sid = <%=lo.getSid()%>;
			currentPage = <%=lo.getCurrentPage()%>;
				
			$(document).scroll(function(){   //스크롤 이벤트 
		           var scrollHeight = $(document).height();
		            var scrollPosition = $(window).height() + $(window).scrollTop();      

		            $("#scrollHeight").text(scrollHeight);
		            $("#scrollPosition").text(scrollPosition);
		            $("#bottom").text(scrollHeight - scrollPosition);

		            if (scrollPosition > scrollHeight - 500) {         
		               currentPage++;
		               $.ajax({
		                  url : "<%=request.getContextPath()%>/reviewRoad.selr",      /* PrMngRoad */
		                  method:"post",
		                  data: {sid : sid, currentPage : currentPage},
		                  success: function(data){
		                     console.log("clear");
		                     for(var key in data){
		                     //값 받아오는거는 for문 돌리든 해서 넣기.
		                     var reId = data[key].reId;
		                     var grade = data[key].grade
		                     var sale_Id = data[key].saleId;
		                     var review_Date = data[key].reviewModify;
		                     var reContent = data[key].reContent;
		                     $(".tableArea").append("<hr><table align='center' width='1000px' border='1px solid black' style='border-collapse:collapse'>"
		                           + "<tr><td colspan='3' width='60%' >리뷰번호 : " + reId + "</td><td colspan='1' width='30%'>별점 : " + grade + "</td></tr>"
		                           + "<tr><td width='45%'>주문번호 : " + sale_Id + "</td><td colspan='3' align='right'>리뷰 작성일 : " + review_Date + "</td></tr>"
		                           + "<tr><td colspan='4' width='90%'>" + reContent 
		                           /* + "<br><div align='right'><button>신고하기</button></div>" */
		                           +"</td></tr>"
		                           + "</table>");
		                     }
		                  } ,
		                  error:function(){
		                  },
		                  complete : function(data) {
		                 }
		               }); 
		               
		            }
		         /* if($(window).scrollTop() == $(document).height() - $(window).height()){   //스크롤바 바닥까지 내려가면 내용 추가 스크롤 위치 == 문서길이 - 화면 길이
		            
		            
		            //추가해야 할 내용
		            //초기에 데이터 몇개나 불러올 것인지(되도록 스크롤바가 생길 수 있는 만큼의 값을 불러와야 함[대충 5개에서 10개 생각함])
		            //스크롤 끝까지 닿으면 새로운 데이터 n개 불러온다
		            //데이터가 더 이상 없으면 '데이터가 없음'을 알려줘야 한다 (+ 신규 판매 게시글 추가 버튼을 넣어서 신규 판매 게시글을 작성하는 링크 달아주기)
		         }
		        */
		 
		 });
	 });
	 
	 
	
	</script>
	
	
	


</body>
</html>