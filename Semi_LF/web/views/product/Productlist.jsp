<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"
	import="LF.product.model.vo.ProductList,java.util.ArrayList"%>
<%
	ArrayList<ProductList> plist = (ArrayList<ProductList>)request.getAttribute("plist"); 
	
	int category = (Integer)request.getAttribute("cate");
%>
<!DOCTYPE html>
<html>
<head>
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
.cataWrap {
	margin: 0 auto;
	width: 950px;
}

.productlistWrap {
	position: relative;
	padding: 10px;
	margin: 0 auto;
	border-radius: 5px;
	width: 1000px;
	height: 1500px;
}

.productWrap {
	margin: 10px;
	display: inline-block;
	border: 1px solid black;
	width: 220px;
	height: 300px;
	border: 1px solid #ccc;
 	background: #fff;
 	 border-radius:10px;
 	transition: box-shadow .4s;
}


.productWrap:hover {
  box-shadow: 0 0 11px rgba(33,33,33,.2); 
}
.cateBtn {
	border-radius: 5px;
	 background-color: white;
	  color: black;
  	border: 2px solid #e7e7e7;
}

.product_imgwraper {
	margin: 0px auto;
	margin-top :6px;
	border: 1px solid black;
	width: 210px;
	height: 200px;
}

.gocart {
	float: right;
	border-radius: 5px;
	text-align: center;
	margin: 4px;
	margin-top: 1px;
	background-color: #ff6a57;
	color: white;
	border: 1px solid black;
	width: 90px;
	height: 25px;
}

.gocart:hover {
	background-color: #ff2235;
	cursor: pointer;
	transition: 0.5s;
}

.product_title {
	text-align: center;
	margin: 2px;
    margin-top: 10px;
    margin-bottom: 5px;
	width: 210px;
	height: 25px;
}

.product_price {
	text-align: center;
	margin: 2px;
	width: 210px;
	height: 25px;
}

.test1 {
	margin: 0px auto;
	width: 215px;
	height: 265px;
}

/* Pagination links */
.pagination { /* 페이지네이션 div */
	align: center;
	position: absolute;
	bottom: 10px;
	border: 2px solid red;
	width: 97.7%;
	height: 60px;
}

.awrap { /* A태그 묶음 div */

	margin-top: 3px;
	margin-left: 3px;
	margin-right: 2px;
	margin-bottom: 2px;
	padding: 5px;
	height: 50px;
	display: inline-block;
}

.pagination1 a {
	color: black;
	float: left;
	padding: 8px 16px;
	text-decoration: none;
	transition: background-color .3s;
}

/* Style the active/current link */
.pagination1 a.active {
	background-color: dodgerblue;
	color: white;
}

/* Add a grey background color on mouse-over */
.pagination1 a:hover:not (.active ) {
	background-color: #ddd;
}
</style>
</head>
<body>
	<%@ include file="../common/menubar.jsp"%>

	<div class = "board" style="margin-top: 120px; margin-bottom: 20px; min-width:1000px;">
		<h1 align="center">상품 리스트</h1>
		<hr>
		
		<div class="cataWrap">
			<button class="cateBtn" onclick = "cateBtn_Click(1);">과일</button>
		
			<button class="cateBtn"  onclick = "cateBtn_Click(2);">채소</button>
		
			<button class="cateBtn" onclick = "cateBtn_Click(3);">견과류</button>
		
			<button class="cateBtn" onclick = "cateBtn_Click(4);">가공품</button>

		</div>
	
		<hr>
		
		<div class="productlistWrap">
			<%if(plist.isEmpty()){  %>
			<p>등록된 상품이 없습니다</p>
			<%}else { %>
			<%for (ProductList p : plist) {%>
		<div class="productWrap">
			<input type= "hidden" value = <%=p.getpId()%>>
				<div class="pContent" >
					<div class="test1">
						<div class="product_imgwraper">
							<img src="">
						</div>
						<div class="product_title"><%=p.getpName() %></div>
						<div class="product_price"><%=p.getpPrice() %></div>
					</div>
				</div>
		</div>
		
			<%} %>
			<%} %>
			</div>
			
		
	</div>
	<script>
		function cateBtn_Click(cateNum){
			var cateNums = cateNum;
		
			
		$.ajax({
				url:"/Semi_LF/selectCa.pl",
 				type:"post" ,
 				data:{"cateNum" : cateNums}, 
 				success:function(data){
 					
 					var $selectpl = $(".productlistWrap");
 					$selectpl.html(""); //리스트 초기화
 					
 					for(var key in data){
 						var	$productWrap = $("<div>").addClass('productWrap');
 						var	$pContent = $("<div>");
 						var	$test1 = $("<div>").addClass('test1');
 						var	$product_imgwraper = $("<div>").addClass('product_imgwraper');
 						var	$img = $("<img src=>");
 						var $product_title = $("<div>").text(data[key].pName).addClass('product_title');
 						var $product_price = $("<div>").text(data[key].pPrice).addClass('product_price');
 						var $pid = $("<input>").val(data[key].pId).attr("type","hidden");
 						var $gocart = $("<div>").text("go cart").addClass('gocart');
 				
 
 						$product_imgwraper.append($img);
 						$test1.append($product_imgwraper);
 						$test1.append($product_title);
 						$test1.append($product_price);
 						$pContent.append($test1);
 						$productWrap.append($pContent);
 						$productWrap.append($pid);
 						$selectpl.append($productWrap);
 								
 					}
 					},
 					error:function(request,status,error){
 					    alert("code:"+request.status+"\n"+"message:"+request.responseText+"\n"+"error:"+error);
 				
 					}});
				
			}
	</script>
	
	<script>
		$(document).on('click', ".productWrap", function(){
			var pId = $(this).find('input').val();
			
			alert(pId);
		location.href = "<%=request.getContextPath()%>/board.do?pId="+pId;
		});
	</script>
</body>
</html>