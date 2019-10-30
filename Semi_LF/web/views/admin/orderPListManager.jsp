<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="LF.adminPage.model.vo.PageInfo, LF.adminPage.model.vo.AdOrderList, java.util.ArrayList"%>
<%
	ArrayList<AdOrderList> oList = (ArrayList<AdOrderList>)request.getAttribute("oList");
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
				<div class="card-header">상품 주문 리스트</div>
				<div class="card-body">
					<table class="table table-bordered" width="100%">
						<thead>
							<tr>
								<th>주문 번호</th>
								<th>아이디</th>
								<th>상품 이름</th>
								<th>주문 수량</th>
								<th>이름</th>
								<th>전화번호</th>
								<th>배송지</th>
								<th>구매날짜</th>
								<th>상태</th>
							</tr>
						</thead>
						<tbody id="pListTable">
						<% if(oList.size() == 0) { %>
							<tr>
							<td colspan=9>조회된 물품이 없습니다.</td>
							</tr>
						<%} else {%>
							<% for(AdOrderList o : oList) {%>
							<tr>
								<input type="hidden" value="<%=o.getSale_Id()%>" id="sale<%=o.getSale_Id() %>" name="sale<%=o.getSale_Id()%>">
								<td><%=o.getSale_Id() %></td>
								<td><%=o.getUserId() %></td>
								<td><%=o.getpName() %></td>
								<td><%=o.getsCount() %></td>
								<td><%=o.getDaName() %></td>
								<td><%=o.getOrPhone() %></td>
								<td><%=o.getDaAddress() %></td>
								<td><%=o.getSale_Date() %></td>
								<% if(o.getStatus().equals("Y")) {%>
									<td>주문완료</td>
								<%} else if(o.getStatus().equals("X")){%>
									<td>배송중</td>
								<%} else if(o.getStatus().equals("B")){%>
									<td>환불완료</td>
								<%} else {%>
									<td>배송완료</td>
								<%} %>
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
		$(document).on('click', ".updateTds input", function(){
		var result = confirm('환불신청 내역의 상태를 변경하시겠습니까?');
		var sale_id=$(this).parent().parent().find("input").val();
		<% for(AdOrderList ro : oList) {%>
			
			if(<%=ro.getSale_Id()%> == sale_id && result) {
				
				$.ajax({
					url:"<%=request.getContextPath() %>/updateRefund.ad",
					type:"post",
					data:{saleId : sale_id, status : "N"},
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