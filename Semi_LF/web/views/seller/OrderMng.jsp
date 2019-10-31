<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="LF.seller.model.vo.*, java.util.*"%>
<%
	String aChart = (String)request.getAttribute("aChart");
	String bChart = (String)request.getAttribute("bChart");
	ArrayList<OrderList> list = (ArrayList<OrderList>)request.getAttribute("list");
	HashMap<Integer,Integer> price = (HashMap<Integer,Integer>)request.getAttribute("price");
	PageInfo pi = (PageInfo)request.getAttribute("pi");
	int listCount = pi.getListCount();
	int currentPage = pi.getCurrentPage();
	int maxPage = pi.getMaxPage();
	int startPage = pi.getStartPage();
	int endPage = pi.getEndPage();
	
	System.out.println("jsp bChart = " + bChart);
	
	/* Map<String, Object> map = new HashMap<String, Object>(); */
%>  
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="http://code.jquery.com/jquery-3.4.1.min.js"></script>
<script type="text/javascript" src="https://www.gstatic.com/charts/loader.js"></script>
 <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"/>
 <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
 <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"></script>
 <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script>
 <!-- 테이블 CDN -->
 <link rel="stylesheet" href="https://cdn.datatables.net/1.10.20/css/dataTables.bootstrap4.min.css">
 <script src="https://cdn.datatables.net/1.10.20/js/jquery.dataTables.min.js"></script>
<style>
	/* .outer{
	position: absolute;
   	margin-top: 130px;
    width: 800px;
    height: 500px;
    display: inline-block;
    text-align: center;
	} */
	.outer{
	position: absolute;
   	margin-top:250px;
   	pading-top:50px;
   	pading-bottom:50px;
   	top: 150px;
   	left: 220px;
    width: 1280;
    min-width: 1280px;
    min-height: 800px;
    display: inline-block; 
    pading-left:300px;
	margin:0 auto;
	
	}
	h1{
	text-align:left;

	}
	.chartOuter {
	width: 1000px;
	}
	.innerDiv {
	display: table;
	align: center;
	padding: 5px;
	width: 1200px;
	height: 500px;
	float: left;
	margin-top: 110px;
	min-width: 1200px;
	text-align:center;
	}
	.chartDiv{
		display:table-cell;
		float:right;
		width:500px; 
		height:400px;
		margin-left:20px;
		margin-right:20px;
	}
	.tableDiv{
		min-width: 1000px;
	}
	.tableArea{
		 margin-bottom:100px;
	}
</style>
</head>
<body>


	<%@ include file="../seller/sellerMain.jsp" %>
	
	<div class="outer">
		<br>
		<h2 align="center">주문 및 매출 관리</h2>
		
			<div class="chartOuter">
				<div class="innerDiv">
					<div class="card chartDiv" style="width:500px; height:400px;">
						<div class="card-header bg-primary text-white">최근 판매 내역</div>
						<div class="card-body" id="chart2"></div>
					</div>
					<div class="card chartDiv">
						<div class="card-header bg-primary text-white">전체 판매 차트</div>
						<div class="card-body" id="chart1"></div>
					</div>
				</div>
				<!-- <div class="card tableDiv" align="center">
						<div class="card-header bg-primary text-white">전체 판매 차트</div>
						<div class="card-body" ></div>
					</div> -->
			</div>
		
		
		<!-- 공지사항 때와 마찬가지로 검색 부분이 있다. 기능 구현은 생략 -->
		<!-- <div class="searchArea" align="center">
			<select id="searchCondition" name="searchCondition">
				<option>----</option>
				<option value="category">상품명</option>
				<option value="writer">주문번호</option>
			</select>
			<input type="search">
			<button type="submit">검색하기</button>
			<br><br>
			<input type="date" id="startDate">~<input type="date" id="lastDate">
		</div> -->
		
		<br>
		
		<div class="tableArea">
			<table id="orderTable" align="center" width="1000px" border="1px solid black" style="border-collapse:collapse">
				<tr>
					<td>주문번호</td>
					<td>상품명</td>
					<td>구매수량</td>
					<td>총금액</td>
					<td>주문일시</td>
				</tr>
				<% if(list.isEmpty()){ %>
				<tr>
					<td colspan="5">조회된 리스트가 없습니다.</td>
				</tr>
				<%}else{ %>
					<% for(OrderList o : list){ %>
						<tr>
							<input type="hidden" value="<%=o.getSaleId() %>">
							<td><%=o.getSaleId() %></td>
							<td><%=o.getpName() %> </td>
							<td><%=o.getsCount()%> 개</td>
							
							<%for(Integer mapkey : price.keySet()){ %>
							<%if(mapkey==o.getPid()){%>
							<td><%= price.get(mapkey)*o.getsCount()%> 원</td>
								<%} %>
							<%} %>
							<td><%=o.getSaleDate() %></td>
						</tr>
					<%} %>
				<%} %>
			</table>
		</div>
		<div class="pagingArea" align="center">
			<!-- 맨 처음으로(<<) -->
			<button onclick="location.href='<%=request.getContextPath() %>/sReport.selr?currentPage=1&sid=<%=sellerUser.getSid()%>'"> << </button>
			
			<!-- 이전 페이지로(<) -->
			<%if(currentPage <= 1) {%>
				<button disabled> < </button>
			<%} else{ %>
				<button onclick="location.href='<%=request.getContextPath() %>/sReport.selr?currentPage=<%=currentPage-1 %>&sid=<%=sellerUser.getSid()%>'"> < </button>
			<%} %>
			
			<!-- 10개의 페이지 목록 -->
			<%for(int p = startPage; p<=endPage; p++){ %>
				<% if(p == currentPage){ %>
					<button disabled><%=p %></button>
				<%} else{%>
					<button onclick="location.href='<%=request.getContextPath() %>/sReport.selr?currentPage=<%=p %>&sid=<%=sellerUser.getSid()%>'"><%=p %></button>
				<%} %>
			<%} %>
			
			<!-- 다음 페이지로(>) -->
			<%if(currentPage >= maxPage){ %>
				<button disabled> > </button>
			<%}else{ %>
				<button onclick="location.href='<%=request.getContextPath() %>/sReport.selr?currentPage=<%=currentPage+1 %>&sid=<%=sellerUser.getSid()%>'"> > </button>
			<%} %>
			
			<!-- 맨 끝으로(>>) -->
			<button onclick="location.href='<%=request.getContextPath() %>/sReport.selr?currentPage=<%=maxPage %>&sid=<%=sellerUser.getSid()%>'"> >> </button>
			
		</div>
	</div>
	
	<script>
	/* 구글 차트 1 */
    google.charts.load('current', {'packages':['corechart']});
    google.charts.setOnLoadCallback(drawChart);

    function drawChart() {

    	var Arr = new Array();
    	var Brr = [[],[],[],[],[]];
    	var swt = 0;
    	
    	Arr = <%=aChart%>;
    	
    	for(var i=0; i<Arr.length; i++) {
    	  // HashMap
    	  var map = Arr[i];
    	  // HashMap loop
    	   swt=0;
    	  for(var key in map ) {
    	    Brr[i][swt] = map[key];
    	    swt++;
    	    }
    	  }
    	var data = new google.visualization.DataTable();
    	data.addColumn('string', 'pName');
    	data.addColumn('number', 'sCount');
    	
    	for(var i = 0; i<Brr.length; i++){
    		data.addRow([Brr[i][1],Brr[i][0]]);
    	}
      
      var options = {
        title: '전체 판매량'
      };

      var chart = new google.visualization.PieChart(document.getElementById('chart1'));

      chart.draw(data, options);
      
    }
    
    /* 구글 차트 2 */
    google.charts.load('current', {'packages':['table']});
    google.charts.setOnLoadCallback(drawTable);

    function drawTable() {
    	
    	var Arr = new Array();
    	var Brr = [[],[],[],[],[],[],[],[],[],[]];
    	var swt = 0;
    	
    	Arr = <%=bChart%>;
    	console.log("AllChart = " + <%=bChart%>);
    	console.log("Arr = " + Arr);
    	
    	for(var i=0; i<Arr.length; i++) {
    	  // HashMap
    	  var map = Arr[i];
    	  // HashMap loop
    	   swt=0;
    	  for(var key in map ) {
    	    console.log("컬럼 : " + key + " value : " + map[key] + ", i = " + i +", " + swt);
    	    if(swt==1 || swt==2 || swt==3|| swt==4){
    	    	 Brr[i][swt] = map[key];
    	    	    console.log("타입 : " + typeof Brr[i][swt]);
    	    }
    	    swt++;
    	    }
    	  }
    	console.log("Brr = " + Brr);
    	
    	
    	var data = new google.visualization.DataTable();
    	data.addColumn('string', '상품명');
    	data.addColumn('number', '수량');
    	data.addColumn('string', '구매자');
    	data.addColumn('string', '요청사항');
    	
    	for(var i = 0; i<Brr.length; i++){
    		data.addRow([Brr[i][1],Brr[i][2],Brr[i][3],Brr[i][4]]);
    	}

        var table = new google.visualization.Table(document.getElementById('chart2'));

        table.draw(data, {showRowNumber: true, width: '100%', height: '100%'});
      }
	
	</script>
	
	
</body>
</html>