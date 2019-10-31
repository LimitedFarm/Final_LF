<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"
	import="LF.adminPage.model.vo.PageInfo, LF.member.model.vo.Customer, java.util.ArrayList"%>
<%
	ArrayList<Seller> seInfo = (ArrayList<Seller>) request.getAttribute("seInfo");
	PageInfo pi = (PageInfo) request.getAttribute("pi");

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
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" />
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script>
<!-- 테이블 CDN -->
<link rel="stylesheet"
	href="https://cdn.datatables.net/1.10.20/css/dataTables.bootstrap4.min.css">
<script
	src="https://cdn.datatables.net/1.10.20/js/jquery.dataTables.min.js"></script>

<title>회원 관리</title>
<style>
.outer {
	width: 1500px;
}

.innerDiv {
	align: center;
	padding: 5px;
	width: 1200px;
	height: 700px;
	display: inline-block;
	float: right;
	margin-top: 110px;
	min-width: 1200px;
}

#insertCustomer {
	padding: 5px;
	width: 1000px;
	margin-left: 10px;
	vertical-align: middle;
	text-align: right;
	display: inline-block;
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
	<div class="outer">
		<%@ include file="../admin/adminMenubar.jsp"%>

		<div class="innerDiv">
			<div class="card" style="min-width: 1000px;">
				<div class="card-header">
					판매자 회원
					<div id="insertCustomer">
						<label for="sellerbName">판매자 아이디</label> <input type="text"
							id="sellerbName" name="sellerbName">
						<button id="searchSeller">찾기</button>
					</div>
				</div>
				<div class="card-body">
					<table class="table table-bordered" id="dataTable" width="100%" cellspacing="0">
						<thead>
							<tr>
								<th>회원번호</th>
								<th>사업자 이름</th>
								<th>사업자 번호</th>
								<th>은행</th>
								<th>예금주</th>
								<th>계좌번호</th>
								<th>판매자 등록날짜</th>
								<th>물품 권한</th>
								<th>권한 부여</th>
							</tr>
						</thead>
						<tbody id="selectTd">
							<%
								if (seInfo.size() == 0) {
							%>
							<tr>
								<td colspan=9>조회된 회원이 없습니다.</td>
							</tr>
							<%
								} else {
							%>
							<%
								for (Seller s : seInfo) {
							%>
							<tr>
								<input type="hidden" value="<%=s.getSid()%>" id="seller<%=s.getSid() %>" name="seller<%=s.getSid()%>">
								<td><%=s.getSid()%></td>
								<td><%=s.getbName()%></td>
								<td><%=s.getbNum()%></td>
								<td><%=s.getAcName()%></td>
								<td><%=s.getBankName()%></td>
								<td><%=s.getAcNum()%></td>
								<td><%=s.getsJoinDate()%></td>
								<td class="nonNextPage">
									<%if(s.getbStatus().equals("Y")) {%>
										<span class="toggleBG" style="background: #0099ff;">
										<button id="toggle<%=s.getSid() %>" class="toggleFG" style="left:20px;"></button>
										</span>
									<% } else {%>
										<span class="toggleBG">
										<button id="toggle<%=s.getSid() %>" class="toggleFG" style="left:-17px;"></button>
										</span>
									<%} %>
								</td>
								<td class="updateTds"><input type="button" value="권한 적용" id="insertAuthor<%=s.getSid()%>"></td>
							</tr>
							<% }%>
							<%for (int i = seInfo.size(); i < 10; i++) { %>
							<tr>
								<td>&nbsp;</td>
								<td>&nbsp;</td>
								<td>&nbsp;</td>
								<td>&nbsp;</td>
								<td>&nbsp;</td>
								<td>&nbsp;</td>
								<td>&nbsp;</td>
								<td>&nbsp;</td>
								<td>&nbsp;</td>
							</tr>
							<% } %>
							<% } %>

						</tbody>
					</table>
					<div>
						<ul class="pagination" style="float:right;">
						<li class="page-item"><a class="page-link" href="<%=request.getContextPath()%>/selInfo.ad?currentPage=1">FirstPage</a></li>
						
						<!-- 이전 페이지로 -->
						<% if (currentPage <= 1) { %>
							<li class="page-item"><a class="page-link" href="#">Previous</a></li>
						<% } else { %>
							<li class="page-item"><a class="page-link" href="<%=request.getContextPath()%>/selInfo.ad?currentPage=<%=currentPage - 1%>">Previous</a></li>
						<%} %>
						<!-- 10개의 페이지 목록 -->
						<% for (int p = startPage; p <= endPage; p++) { %>
							<% if (p == currentPage) { %>
								<li class="page-item"><a class="page-link" href="#"><%=p%></a></li>
							<%} else { %>
								<li class="page-item"><a class="page-link" href="<%=request.getContextPath()%>/selInfo.ad?currentPage=<%=p%>"><%=p%></a></li>
							<%}%>
						<%} %>
						<!-- 다음 페이지로(>) -->
						<% if (currentPage >= maxPage) { %>
							<li class="page-item"><a class="page-link" href="#">Next</a></li>
						<% } else { %>
							<li class="page-item"><a class="page-link" href="<%=request.getContextPath()%>/selInfo.ad?currentPage=<%=currentPage + 1%>">Next</a></li>
						<% } %>	
						<!-- 처음으로 -->
						<li class="page-item"><a class="page-link" href="<%=request.getContextPath()%>/selInfo.ad?currentPage=<%=maxPage%>">LastPage</a></li>
						</ul>
					</div>
				</div>
			</div>


		</div>
	</div>
	<script>
	$(function(){
	
	// 판매자 찾기 기능
	$("#searchSeller").click(function(){	
		var sellerId = $("#sellerbName").val();
		if(sellerId == ""){
			$selectTd = $("#selectTd");
			$selectTd.html(""); // 초기화
			
			<% for(Seller s : seInfo) { %>
				var $tr = $("<tr>");
				var $hiddenInput = $("<input>").attr({"type":"hidden", "id":"seller<%=s.getCid() %>", "value":"<%=s.getSid()%>" });
				var $sid = $("<td>").text("<%=s.getSid()%>");
				var $bName = $("<td>").text("<%=s.getbName()%>");
				var $bNum  = $("<td>").text(<%=s.getbNum()%>);
				var $bankName = $("<td>").text(<%=s.getBankName()%>);
				var $acName = $("<td>").text(<%=s.getAcName()%>);
				var $acNum = $("<td>").text(<%=s.getCpNum() %>);				
				var $sJoinDate = $("<td>").text(<%=s.getsJoinDate() %>);		
				var $bStatusTd = $("<td>").addClass("nonNextPage");
				var $bStatusSpan = $("<span>");
				var $spanButton = $("<button>");
				
				/* bStatus가 Y인지 N인지 판별 */
				<%if(s.getbStatus().equals("Y")) {%>
					$bStatusSpan.addClass("toggleBG")
					$bStatusSpan.css({"background": "#0099ff"});
					$spanButton.attr({"class":"toggleFG", "id":"toggle<%=s.getSid() %>"});
					$spanButton.css('left', "20px");
				<% } else {%>
					$bStatusSpan.addClass("toggleBG");
					$bStatusSpan.css({"background": "#CCCCCC"});
					$spanButton.attr({"class":"toggleFG", "id":"toggle<%=s.getSid() %>"});
					$spanButton.css('left', "-17px");
				<% } %>
				var $updateTd = $("<td>").addClass("updateTds");
				var $updateButton = $("<input>").attr({"type":"button", "value":"권한 적용", "id":"insertAuthor"+<%=s.getSid()%>});
				
				$bStatusSpan.append($spanButton);
				$bStatusTd.append($bStatusSpan);
				$updateTd.append($updateButton);
				
				$tr.append($hiddenInput);
				$tr.append($sid);
				$tr.append($bName);
				$tr.append($bNum);
				$tr.append($bankName);
				$tr.append($acName);
				$tr.append($acNum);
				$tr.append($sJoinDate);
				$tr.append($bStatusTd);
				$tr.append($updateTd);
				$selectTd.append($tr);
				
			<%} %>
		}else{
			$.ajax({
				url : "/Semi_LF/searchSe.ad",
				type : "post",
				data : {sellerbName : sellerId},
				success : function(data) {
					$selectTd = $("#selectTd");
					$selectTd.html(""); // 초기화
					
					
					for ( var key in data) {
						var $tr = $("<tr>");
						var $hiddenInput = $("<input>").attr({"type":"hidden", "id":"connectCid"+data[key].sid,"value":data[key].sid});
						var $sid = $("<td>").text(data[key].sid);
						var $bName = $("<td>").text(data[key].bName);
						var $bNum  = $("<td>").text(data[key].bNum);
						var $bankName = $("<td>").text(data[key].bankName);
						var $acName = $("<td>").text(data[key].acName);
						var $acNum = $("<td>").text(data[key].acNum);				
						var $sJoinDate = $("<td>").text(data[key].sJoinDate);
						
						var $bStatusTd = $("<td>").addClass("nonNextPage");
						var $bStatusSpan = $("<span>");
						var $spanButton = $("<button>");
						/* bStatus가 Y인지 N인지 판별 */
						if(data[key].bStatus == "Y") {
							$bStatusSpan.addClass("toggleBG");
							$bStatusSpan.css("background", "#0099ff");
							$spanButton.attr({"class":"toggleFG", "id":"toggle"+data[key].sid});
							$spanButton.css("left","20px");
						} else {
							$bStatusSpan.addClass("toggleBG");
							$bStatusSpan.css("background", "#CCCCCC");
							$spanButton.attr({"class":"toggleFG", "id":"toggle"+data[key].sid});
							$spanButton.css("left","-17px");
						}
						var $updateTd = $("<td>").addClass("updateTds");
						var $updateButton = $("<input>").attr({"type":"button", "value":"권한 적용", "id":"insertAuthor"+data[key].sid});
						
						$bStatusSpan.append($spanButton);
						$bStatusTd.append($bStatusSpan);
						$updateTd.append($updateButton);
						
						$tr.append($hiddenInput);
						$tr.append($sid);
						$tr.append($bName);
						$tr.append($bNum);
						$tr.append($bankName);
						$tr.append($acName);
						$tr.append($acNum);
						$tr.append($sJoinDate);
						$tr.append($bStatusTd);
						$tr.append($updateTd);
						$selectTd.append($tr);
						
						}
					}
				});
			}
			// 초기화
			$("#sellerbName").val("");
		});
	
	// 권한 버튼을 통한 업데이트
	$(document).on('click', ".updateTds input", function(){
		
		var sid=$(this).parent().parent().find("input").val();
		<% for(Seller se : seInfo) {%>
			
			if(<%=se.getSid()%> == sid) {
				var sAuthor = parseInt($("#toggle<%=se.getSid() %>").css("left"));
				var bStatus = "";
				if(sAuthor > -12){
					bStatus = "Y";
				}else{
					bStatus = "N";
				}
				$.ajax({
					url:"<%=request.getContextPath() %>/updateSeller.ad",
					type:"post",
					data:{sellerSid : sid, bStatus : bStatus},
					success:function(data){
						if(data.result == "success"){
							alert("권한이 변경되었습니다.");
						}else{
							alert("권한 변경을 실패하였습니다.");
						}
						
					}
				});
			} 
		<% } %>
		
		
	});
	
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
	</script>
	<script>
		// 게시판 상세보기 기능 구현하기
		$(function(){
			$(document).on('mouseenter', "#selectTd td", function(){
				$(this).parent().css({"background":"darkgray","cursor":"pointer"});
			});
			$(document).on('mouseout', "#selectTd td", function(){
				$(this).parent().css({"background":"white"});
			});
			$(document).on('click', "#selectTd td", function(){
				if($(this).attr("class") != "nonNextPage" && $(this).attr("class") != "updateTds"){
					var sid=$(this).parent().children("input").val();
					location.href="<%=request.getContextPath()%>/sinfo.ad?currentPage=1&sid=" + sid;
					/* selectSInfoServlet로 ㄱㄱ */
				}
			});
		});
		
	</script>
</body>