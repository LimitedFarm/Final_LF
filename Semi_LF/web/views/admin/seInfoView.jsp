<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.util.ArrayList, LF.adminPage.model.vo.PList, LF.adminPage.model.vo.SInfo, LF.adminPage.model.vo.PageInfo"%>
<%
	SInfo s = (SInfo)request.getAttribute("sinfo");
	ArrayList<PList> pList = (ArrayList<PList>)request.getAttribute("pListInfo");

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
<script type="text/javascript" src="https://www.gstatic.com/charts/loader.js"></script>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<script src="../js/bootstrap.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/Chart.js/2.2.1/Chart.min.js"></script>
 <!-- 테이블 CDN -->
 <link rel="stylesheet" href="https://cdn.datatables.net/1.10.20/css/dataTables.bootstrap4.min.css">
 <script src="https://cdn.datatables.net/1.10.20/js/jquery.dataTables.min.js"></script>
<title>판매자 정보</title>

<style>
.outer {
	width: 1500px;
}
.innerDiv {
	display: table;
	align: center;
	padding: 5px;
	width: 1200px;
	height: 1300px;
	float: left;
	margin-top: 110px;
	min-width: 1200px;
	text-align:center;
}
.chartDiv{
	display:table-cell;
	float:left;
	width:500px; 
	height:400px;
	margin-left:20px;
	margin-right:20px;
	margin-top:20px;
}
.tableDiv{
	min-width: 1000px;
}
.card.tableDiv{
	display:inline-block;
	float:left;
	margin-left:20px;
	margin-right:20px;
}
.table tr {
	border-bottom : 1px solid black;	
	margin-bottom : 20px;
}
.proTableDiv{
	display:table-cell;
	float:left;
	width:600px; 
	height:400px;
	margin-left:20px;
	margin-right:20px;
	margin-top:20px;
	font-size:12px;
}

</style>
</head>
<body>
	<%@ include file="/views/admin/adminMenubar.jsp" %>
	<div class="outer">
		<div class="innerDiv">
			<h2>사업체 : <%=s.getbName() %>&nbsp;아이디 : <%=s.getUserId() %></h2>
			<hr>
			<div class="card tableDiv" style="width:900px; height:400px; ">
				<div class="card-header bg-primary text-white">판매자 정보</div>
				<div class="card-body">
					<table class="table table-borderless">
						<tr>
							<td rowspan=3 colspan=2>
								<img src="<%=request.getContextPath()%>/sellerImg/examImg.png" style="width:150px; height:190px">
							</td>
							<th>사업자 이름</th>
							<td><%=s.getUserName() %></td>
							<th>사업자 번호</th>
							<td><%=s.getbNum() %></td>
							<th>등록일자</th>
							<td><%=s.getsJoinDate() %></td>
						</tr>
						<tr>
							<th>전화번호</th>
							<td><%=s.getPhone()%></td>
							<th>은행명</th>
							<td><%=s.getBankName() %></td>
							<th>계좌주</th>
							<td><%=s.getAcName() %></td>
						</tr>
						<tr>
							<th>이메일</th>
							<td><%=s.getEmail()%></td>
							<th>계좌 번호</th>
							<td><%=s.getAcNum() %></td>
						</tr>
						<tr>
							<th colspan=8>주소</th>
						</tr>
						<tr>
							<td colspan=8><%=s.getAddress2() %>&nbsp;<%=s.getAddress3() %></td>
						</tr>
					</table>
				</div>
			</div>
			<!-- 판매물품 차트 -->
			<div class="card chartDiv">
				<div class="card-header bg-primary text-white">전체 판매 차트</div>
				<div class="card-body" style="width:500px; height:500px">
					<canvas id="chart1"></canvas>
				</div>
			</div>
			
			<!-- 판매 물품 정보 -->
			<div class="card proTableDiv">
			<div class="card-header bg-primary text-white">등록 물품</div>
				<div class="card-body" style="overflow:auto">
					<table class="table table-bordered" id="dataTable" cellspacing="0">
					    <thead>
					        <tr>
								<th>상품번호</th>
								<th>상품명</th>
								<th>가격</th>
								<th>생산일자</th>
								<th>유통기한</th>
								<th>등록날짜</th>
								<th>판매유무</th>
							</tr>
					    </thead>
					    <tbody id="pListCol">
					    
					    </tbody>
					</table>
					<div>
						<ul class="pagination" style="float:right;">
						<li class="page-item"><a class="page-link" href="<%=request.getContextPath()%>/sinfo.ad?currentPage=1">FirstPage</a></li>
						
						<!-- 이전 페이지로 -->
						<% if (currentPage <= 1) { %>
							<li class="page-item"><a class="page-link" href="#">Previous</a></li>
						<% } else { %>
							<li class="page-item"><a class="page-link" href="<%=request.getContextPath()%>/sinfo.ad?currentPage=<%=currentPage - 1%>">Previous</a></li>
						<%} %>
						<!-- 5개의 페이지 목록 -->
						<% for (int p = startPage; p <= endPage; p++) { %>
							<% if (p == currentPage) { %>
								<li class="page-item"><a class="page-link" href="#"><%=p%></a></li>
							<%} else { %>
								<li class="page-item"><a class="page-link" href="<%=request.getContextPath()%>/sinfo.ad?currentPage=<%=p%>"><%=p%></a></li>
							<%}%>
						<%} %>
						<!-- 다음 페이지로(>) -->
						<% if (currentPage >= maxPage) { %>
							<li class="page-item"><a class="page-link" href="#">Next</a></li>
						<% } else { %>
							<li class="page-item"><a class="page-link" href="<%=request.getContextPath()%>/sinfo.ad?currentPage=<%=currentPage + 1%>">Next</a></li>
						<% } %>	
						<!-- 처음으로 -->
						<li class="page-item"><a class="page-link" href="<%=request.getContextPath()%>/sinfo.ad?currentPage=<%=maxPage%>">LastPage</a></li>
						</ul>
					</div>
				</div>
			</div>
			
		</div>
		
	</div>
	
	
	<script>
		
		 function tableBody(current){
			$.ajax({
				url:"/Semi_LF/proCol.ad",
				type:"post",
				data: {sid : <%=s.getSid()%>, currentPage : current},
				success: function(data){
					var $pListCol = $("#pListCol");
					$pListCol.html("");
					for(var key in data){
						var $tr = $("<tr>");
						var $hid = $("<input>").attr({"value":data[key].pId,"type":"hidden"});
						var $pidTd = $("<td>").text(data[key].pId);
						var $pNameTd = $("<td>").text(data[key].pName);
						var $pDayTd = $("<td>").text(data[key].pPrice);
						var $makTd = $("<td>").text(data[key].pDay);
						var $pPreTd = $("<td>").text(data[key].pPeriod);
						var $creTd = $("<td>").text(data[key].createDate);
						var $staTd = $("<td>").text(data[key].status);
						
						$tr.append($hid);
						$tr.append($pidTd);
						$tr.append($pNameTd);
						$tr.append($pDayTd);
						$tr.append($makTd);
						$tr.append($pPreTd);
						$tr.append($creTd);
						$tr.append($staTd);
						$pListCol.append($tr);
					}
				}
			});
		}
	</script>
	<script type="text/javascript">
	// 차트 정보 입력
		$(function() {
			
			/* var LFChart = $('#chart1');
			LFChart.html("");
			var myPieChart = new Chart(LFChart, {

				type: 'pie',
				data : {
					datasets : [ {
						data : [ 10, 20, 30, 20, 10 ],
						backgroundColor : [

						'rgba(190, 190, 190, 1)',

						'rgba(241, 196, 15, 1)',

						'rgba(244, 7, 7, 1)',

						'rgba(52, 152, 219, 1)',

						'rgba(46, 204, 113, 1)'

						],

					} ],

					labels : [ '미지정', '다음주 이후', '이번주 까지', '완료', '기한 만료' ]
				},

				options : {
					maintainAspectRatio : false,
					cutoutPercentage : 50,
					legend : {
						display : true,
						position : 'left',
						labels : {
							fontSize : 12,
							fontFamily : 'sans-serif',
							fontColor : '#000000',
							fontStyle : 'bold'
						}
					}
				}
			}); */
			
			chartpDate(0, <%=s.getSid()%>);
			tableBody(1);
			
		});
		
		// 판매자 물품 테이블
		function ProductTData(){
			var $tBody = $("#pListCol");
			$tBody.html("");
			$.ajax({
				url:"/Semi_LF/proCol.ad",
				type:"post",
				data:{ "sid" : <%=s.getSid() %>, currentPage: <%=currentPage%>},
				success:function(data){
					for(var key in data){
						var $tr = $("<tr>").text(data[key][i]);
						var $hid = $("<input>").attr({"value":data[key].get(i).sid,"type":"text"});
						var $pidTd = $("<td>");
						var $pNameTd = $("<td>");
						var $pDayTd = $("<td>");
						var $makTd = $("<td>");
						var $pPreTd = $("<td>");
						var $creTd = $("<td>");
						var $staTd = $("<td>");
						
						$tr.append($hid);
						$tr.append($pidTd);
						$tr.append($pNameTd);
						$tr.append($pDayTd);
						$tr.append($makTd);
						$tr.append($pPreTd);
						$tr.append($creTd);
						$tr.append($staTd);
						$tBody.append($tr);
					}
				} 
			});
		}
		
		// 판매자 거래률 차트
		function chartPDraw(sale, count){
			var ctx = $('#chart1');
			var myPieChart = new Chart(ctx, {
				type: 'pie',
				data : {
					datasets : [ {
						data : [ count, sale ],
						backgroundColor : [
							'rgba(244, 7, 7, 1)',

							'rgba(46, 204, 113, 1)'
						],

					} ],

					labels : [ '전체 재고량' , '전체 판매 수량']
				},

				options : {
					maintainAspectRatio : false,
					cutoutPercentage : 50,
					legend : {
						display : true,
						position : 'left',
						labels : {
							fontSize : 12,
							fontFamily : 'sans-serif',
							fontColor : '#000000',
							fontStyle : 'bold'
						}
					}
				}
			});
		}
		
		function chartpDate(product, all){
			var sid = 0;
			var pid = 0;
			if(product > 0){	// product가 0이면 모든 상품 정보
				sid = all;
			}else{
				pid = sid;
			}
			$.ajax({
				url:"/Semi_LF/chartpData.ad",
				type:"post",
				data:{"pid": pid, "sid" : <%=s.getSid()%>},
				success:function(data){
					chartPDraw(data.sale, data.pCount);
				}
			});
		}
	</script>
</body>
</html>