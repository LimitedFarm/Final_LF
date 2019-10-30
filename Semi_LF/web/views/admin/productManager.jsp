<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.util.ArrayList, LF.adminPage.model.vo.AdPList, LF.adminPage.model.vo.PageInfo"%>
<%
	ArrayList<AdPList> pList = (ArrayList<AdPList>)request.getAttribute("pList");
	PageInfo pi = (PageInfo)request.getAttribute("pi");

	int listCount = pi.getListCount();
	int currentPage = pi.getCurrentPage();
	int maxPage = pi.getMaxPage();
	int startPage = pi.getStartPage();
	int endPage = pi.getEndPage();
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
 <meta name="viewport" content="width=device-width, initial-scale=1">
 <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"/>
 <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
 <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"></script>
 <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script>


<title>Insert title here</title>
<style>
.outer{
	width:1500px;
	margin-top:110px;
}
.innerDiv{
	align:center;
	padding: 5px;	
	width: 1000px;
	height: 700px;
	display:inline-block;
	float:right;
	min-width:1200px;
}
#insertCustomer{
	padding: 5px;
	width: 1000px;
	margin-left: 10px;
	vertical-align : middle;
	text-align:right;
	display:inline-block;
}
.cardDiv{
	min-width: 1200px;
	width:1200px;
	text-align:center;
}
#pListTable tr th{
	width:110px;
}
#pListTable{
	font-size:12px;
}
.toggleBG{
	display:inline-block;
	background: #CCCCCC;
	width: 70px;
	height: 30px;
	border: 1px solid #CCCCCC;
	border-radius: 15px;
}

.toggleFG{
	background: #FFFFFF;
	float:left;
	width: 25px;
	height: 25px;
	border: none;
	border-radius: 15px;
	position: relative;
	left: 0px;
	top: 1px;
}
</style>
</head>
<body>
	<%@ include file="../admin/adminMenubar.jsp"%>
	<div class="outer">
		<div id="innerDiv">
			<div class="card cardDiv">
				<div class="card-header">판매물품 리스트</div>
				<div class="card-body">
					<table class="table table-bordered" width="100%">
						<tbody id="pListTable">
						<% if(pList.size() == 0) {%>
							<tr colspan=11>조회된 물품이 없습니다.</tr>
						<%} else {%>
							<% for(AdPList p : pList) {%>
							<tr>
								<th rowspan=2><%=p.getpId() %></th>
								<th width="50px">물품 이름</th>
								<td><%=p.getpName() %></td>
								<th width="50px">카테고리번호</th>
								<td><%=p.getCateId() %></td>
								<th width="50px">판매자 아이디</th>
								<td><%=p.getUserId() %></td>
								<th>사업체 이름</th>
								<td><%=p.getbName() %></td>
								<td><%if(p.getStatus().equals("Y")) {%>
										<span class="toggleBG" style="background: #0099ff;">
										<button id="toggle<%=p.getpId() %>" class="toggleFG" style="left:20px;"></button>
										</span>
									<% } else {%>
										<span class="toggleBG">
										<button id="toggle<%=p.getpId() %>" class="toggleFG" style="left:-17px;"></button>
										</span>
									<%} %></td>
								<td class="updateTds"><input type="button" value="권한 적용" id="insertAuthor<%=p.getpId()%>"></td>
							</tr>
							<tr>
								<th>재고량</th>
								<td><%=p.getbCount() %></td>
								<th>가격</th>
								<td><%=p.getpPrice() %></td>
							</tr>
							<tr>
								<th>원산지</th>
								<td colspan=10><%=p.getpAddress() %></td>
							</tr>
							<%} %>
						<%} %>
						</tbody>
					</table>
				</div>
				<div>
						<ul class="pagination" style="float:right;">
						<li class="page-item"><a class="page-link" href="<%=request.getContextPath()%>/cuInfo.ad?currentPage=1">FirstPage</a></li>
						
						<!-- 이전 페이지로 -->
						<% if (currentPage <= 1) { %>
							<li class="page-item"><a class="page-link" href="#">Previous</a></li>
						<% } else { %>
							<li class="page-item"><a class="page-link" href="<%=request.getContextPath()%>/cuInfo.ad?currentPage=<%=currentPage - 1%>">Previous</a></li>
						<%} %>
						<!-- 10개의 페이지 목록 -->
						<% for (int p = startPage; p <= endPage; p++) { %>
							<% if (p == currentPage) { %>
								<li class="page-item"><a class="page-link" href="#"><%=p%></a></li>
							<%} else { %>
								<li class="page-item"><a class="page-link" href="<%=request.getContextPath()%>/cuInfo.ad?currentPage=<%=p%>"><%=p%></a></li>
							<%} %>
						<%} %>
						<!-- 다음 페이지로(>) -->
						<% if (currentPage >= maxPage) { %>
							<li class="page-item"><a class="page-link" href="#">Next</a></li>
						<% } else { %>
							<li class="page-item"><a class="page-link" href="<%=request.getContextPath()%>/cuInfo.ad?currentPage=<%=currentPage + 1%>">Next</a></li>
						<% } %>	
						<!-- 처음으로 -->
						
						<li class="page-item"><a class="page-link" href="<%=request.getContextPath()%>/cuInfo.ad?currentPage=<%=maxPage%>">LastPage</a></li>
							
						</ul>
					</div>

			</div>
		</div>
	</div>
	<script>
		$(function(){
			// 토글버튼 클릭시 on, off 변경
			$(document).on('click', ".toggleBG", function(){
				var toggleBG = $(this);
				var toggleFG = $(this).find('.toggleFG');
				var left = toggleFG.css('left');
				if (left == '20px') {
					toggleBG.css('background', '#CCCCCC');
					toggleActionStart(toggleFG, 'TO_LEFT');
				} else if (left == '-17px') {
					toggleBG.css('background', '#0099ff');
					toggleActionStart(toggleFG, 'TO_RIGHT');
				}
			});
			
			$("#insertAuthor").click(function(){
				var toggleFG = $(this).find('.toggleFG');
			});
		});
		function tableCol(currentNum){
			
			$.ajax({
				url:"/Semi_LF/pagingPr.ad",
				type:"post",
				data:{"currentPage":currentNum},
				success:function(data){
					
				}
			});
			
		}
		
		//토글 버튼 이동 모션 함수
		function toggleActionStart(toggleBtn, LR) {
			// 0.01초 단위로 실행
			var intervalID = setInterval(function() {
				// 버튼 이동
				var left = parseInt(toggleBtn.css('left'));
				left += (LR == 'TO_RIGHT') ? 37 : -37;
				if (left >= -17 && left <= 20) {
					left += 'px';
					toggleBtn.css('left', left);
				}
			}, 10);
			setTimeout(function() {
				clearInterval(intervalID);
			}, 201);
		}
		
		// 권한 버튼을 통한 업데이트
		$(document).on('click', ".updateTds input", function(){
			
			var pid=$(this).parent().parent().find("input").val();
			
			<% for(AdPList pl : pList) {%>
				
				if(<%=pl.getpId()%> == sid) {
					var sAuthor = parseInt($("#toggle<%=pl.getpId() %>").css("left"));
					var status = "";
					if(sAuthor > -12){
						status = "Y";
					}else{
						status = "N";
					}
					$.ajax({
						url:"<%=request.getContextPath() %>/updateProduct.ad",
						type:"post",
						data:{pid : pid, status : status},
						success:function(data){
							console.log(data);
							// 나중에 해보자
						}
					});
				} 
			<% } %>
			
			
		});
	</script>
</body>
</html>