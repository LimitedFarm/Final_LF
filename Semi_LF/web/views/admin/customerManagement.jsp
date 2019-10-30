<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="LF.adminPage.model.vo.PageInfo, LF.member.model.vo.Customer, java.util.ArrayList"%>
<%
	ArrayList<Customer> cuInfo = (ArrayList<Customer>)request.getAttribute("cuInfo");
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
 <!-- 테이블 CDN -->
 <link rel="stylesheet" href="https://cdn.datatables.net/1.10.20/css/dataTables.bootstrap4.min.css">
 <script src="https://cdn.datatables.net/1.10.20/js/jquery.dataTables.min.js"></script>
 
<title>회원 관리</title>
<style>
.outer{
	width:1500px;
}
.innerDiv{
	align:center;
	padding: 5px;	
	width: 1200px;
	height: 700px;
	display:inline-block;
	float:right;
	margin-top:110px;
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
</style>
</head>
<body>
	<div class="outer">
		<%@ include file="../admin/adminMenubar.jsp"%>
		
		<div class="innerDiv">
			<div class="card" style="min-width:1000px;">
  				<div class="card-header">
  					일반 회원
					<div id="insertCustomer">
						<label for="customerId">회원 아이디</label> <input type="text" id="customerId" name="customerId">
						<button id="searchCustomer">찾기</button>
					</div>
				</div>
  				<div class="card-body">
					<table class="table table-bordered" id="dataTable" width="100%" cellspacing="0">
						<thead>
							<tr>
								<th>회원번호</th>
								<th>아이디</th>
								<th>이름</th>
								<th>주소</th>
								<th>핸드폰</th>
								<th>이메일</th>
								<th>가입날짜</th>
							</tr>
						</thead>
						<tbody id="selectTd">
							<% if(cuInfo.size() == 0) {%>
							<tr>
								<td colspan=7>조회된 회원이 없습니다.</td>
							</tr>
						<%} else { %>
							<%for(Customer c : cuInfo) {%>
								<tr>
									<td><%=c.getCid() %></td>
									<td><%=c.getUserId() %></td>
									<td><%=c.getUserName() %></td>
									<td><%=c.getAddress2()%>&nbsp;<%=c.getAddress3() %></td>
									<td><%=c.getPhone() %></td>
									<td><%=c.getEmail() %></td>
									<td><%=c.getJoinDate() %></td>
								</tr>
							<%} %>
							<% for(int i=cuInfo.size(); i<10; i++) {%>
								<tr>
									<td>&nbsp;</td>
									<td>&nbsp;</td>
									<td>&nbsp;</td>
									<td>&nbsp;</td>
									<td>&nbsp;</td>
									<td>&nbsp;</td>
									<td>&nbsp;</td>
								</tr>
							<%} %>
						<%} %>
						
						</tbody>
					</table>
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
	</div>
	<script>
		$(function() {
				
			// 찾기 기능
			$("#searchCustomer").click(function(){
				var searchId = $("#customerId").val();
				if(searchId == ""){
					$selectTd = $("#selectTd");
					$selectTd.html(""); // 초기화
					
					<% for(Customer c : cuInfo) { %>
						var $tr = $("<tr>");
						var $userCId = $("<td>").text("<%=c.getCid()%>");
						var $userId = $("<td>").text("<%=c.getUserId()%>");
						var $userName = $("<td>").text("<%=c.getUserName()%>");
						var $Address = $("<td>").text("<%=c.getAddress2()%> <%=c.getAddress3()%>");
						var $phone = $("<td>").text("<%=c.getPhone()%>");
						var $email = $("<td>").text("<%=c.getEmail()%>");
						var $joinDate = $("<td>").text("<%=c.getJoinDate()%>");
						
						$tr.append($userCId);
						$tr.append($userId);
						$tr.append($userName);
						$tr.append($Address);
						$tr.append($phone);
						$tr.append($email);
						$tr.append($joinDate);
						$selectTd.append($tr);
					
					<%} %>
					<% if(cuInfo.size() < 10){%>
						for(var i=<%=cuInfo.size()%>; i<10;i++){
							var $tr = $("<tr>");
							var $userCId = $("<td>").text(" ");
							var $userId = $("<td>").text(" ");
							var $userName = $("<td>").text(" ");
							var $Address = $("<td>").text(" ");
							var $phone = $("<td>").text(" ");
							var $email = $("<td>").text(" ");
							var $joinDate = $("<td>").text(".");
							
							$tr.append($userCId);
							$tr.append($userId);
							$tr.append($userName);
							$tr.append($Address);
							$tr.append($phone);
							$tr.append($email);
							$tr.append($joinDate);
							$selectTd.append($tr);
						}
					<%}%>
				}else{
					$.ajax({
						url : "/Semi_LF/searchCu.ad",
						type : "post",
							data : {
								searchId : searchId
							},
							success : function(data) {
								$selectTd = $("#selectTd");
								$selectTd.html(""); // 초기화
								
								for ( var key in data) {
										var $tr = $("<tr>");
										var $userCId = $("<td>").text(data[key].cid);
										var $userId = $("<td>").text(data[key].userId);
										var $userName = $("<td>").text(data[key].userName);
										var $Address = $("<td>").text(data[key].address2+" "+ data[key].address3);
										var $phone = $("<td>").text(data[key].phone);
										var $email = $("<td>").text(data[key].email);
										var $joinDate = $("<td>").text(data[key].joinDate);
											
										$tr.append($userCId);
										$tr.append($userId);
										$tr.append($userName);
										$tr.append($Address);
										$tr.append($phone);
										$tr.append($email);
										$tr.append($joinDate);
										$selectTd.append($tr);
									}
								
								}
							});
					
						}

					});
		});

	</script>
</body>