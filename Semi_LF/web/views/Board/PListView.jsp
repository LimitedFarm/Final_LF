<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import = "LF.board.model.vo.*, java.util.*"%>

<%
    	Board b = (Board)request.getAttribute("board");
    	ArrayList<Reply> rList = (ArrayList<Reply>)request.getAttribute("reply");
    	ArrayList<Attachment> fileList = (ArrayList<Attachment>)request.getAttribute("fileList"); 

    	Attachment titleImg = fileList.get(0);	// 대표사진(fileLevel=0)
    	
%>
<!DOCTYPE html>
<html>
<head>
<link href="https://fonts.googleapis.com/css?family=Noto+Serif+KR:200,300&display=swap&subset=korean" rel="stylesheet">
<link rel="stylesheet" type="text/css" href="../css/buttons.css" />

<meta charset="EUC-KR">
<meta charset="UTF-8">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<title>상품 정보페이지</title>
<style>
	.mainInfo{
	   
		border: 1px solid;
		border-color: #ddd #ddd #CACACA;
		width: 1200px;
		min-width:1200px;
    	height: 461px;
    	margin-left:auto;
        margin-right:auto;
        margin-top:50px;
    

	}

	.mainArea{
		width: 935px;

    	border: 1px solid;
    	border-color: #ddd #ddd #CACACA;
    	margin-left:auto;
        margin-right:auto;
        margin-top:10px;
	}
	.btnArea{
		width: 100px;
		margin-left: auto;
	}

	.info {
    display: block;
    overflow: hidden;
    height: 13px;
    width: 100%;
    font-size: 15px;
    line-height: 13px;
    color: #999;
    white-space: nowrap;
    letter-spacing: -1px;
    text-overflow: ellipsis;
    white-space: nowrap;
    word-wrap: normal;
    }
    
    
	.title {
	    min-height: 86px;
	    margin: 9px 0 26px 0;
	    font-size: 21px;
	    line-height: 29px;
	    color: #333;
	    font-weight: bold;
	    letter-spacing: -1px;
	    word-wrap: break-word;
	    word-break: break-all;
	}
	.dearArea {
		display:inline;float:left; width:466px; height: 

	}
	

	.layer{
		margin-top: auto; 
	}
	
	.navList{
		padding: 0;
		margin: 0;
		list-style: none;
	}

	.tab ul {
		display: flex;
		height: 60px;
		border-bottom: 1px solid #5da62b;
	}
	
	.tab ul li {
		flex:1; 
	}

	.tab ul li:first-child a {
		border-left: 1px solid #ddd; 
	}
	.tab ul li a {
		display: block;
		height: 59px;
		border: 1px solid #ddd; 
		border-left: none;
		border-bottom: none;
		font-size: 14px;
		color: 505050;
		text-align: center;
		line-height: 59px; 
		text-decoration: none;
	}
	.tab ul li a.on:hover{
		position: relative;
		height: 58px;
		border-color: #5da62b;
		border-top-width: 2px;
		line-height: 57px;
		border-bottom: 1px solid #fff;
	}

	#imgArea{
		display:inline;
		float:left;
		width:465px; 
		height:460px;
		border: 1px solid; 
		border-color: #ddd #ddd #CACACA;
	}
	#imgArea:hover {
		cursor: pointer;
	}
	 
</style>

<script>
	$( window ).scroll( function() {
		if ( $( this ).scrollTop() > 200 ) {
			$( '.top' ).fadeIn();
		} else {
			$( '.top' ).fadeOut();
		}
	} );
	
	$( '.top' ).click( function() {
		$( 'html, body' ).animate( { scrollTop : 0 }, 400 );
		return false;
	} );
</script>

<!-- 수량 증가감소 합계 스크립트 -->
					<script language="JavaScript">
						var sell_price;
						var amount;
						
						
						function init () {
							sell_price = document.form.sell_price.value;
							amount = document.form.amount.value;
							document.form.sum.value = sell_price;
							change();
						}
						function add () {
							hm = document.form.amount;
							sum = document.form.sum;
							hm.value ++ ;
							
							sum.value = parseInt(hm.value) * sell_price;
						}
						function del () {
							hm = document.form.amount;
							sum = document.form.sum;
								if (hm.value > 1) {
									hm.value -- ;
									sum.value = parseInt(hm.value) * sell_price;
								}
						}
						function change () {
							hm = document.form.amount;
							sum = document.form.sum;
						
								if (hm.value < 0) {
									hm.value = 0;
								}
							sum.value = parseInt(hm.value) * sell_price;
						}
						
						</script>

</head>

<body onload="init()">
<%@include file="../common/menubar.jsp" %>
<Br><Br><Br>
	<jsp:include page="buttons.jsp" />
<form name="form" method="post">
		<div class="layer">
			<div class="mainInfo">
				<div id="imgArea">
					<img src="<%=request.getContextPath() %>/uploadFiles/<%=titleImg.getChangeName() %>" id="titleImg" width="465px" height="460px" name="mainImg">
				</div>
				<input type="hidden" id="pid" name="pid" value="<%=b.getpId() %>">
				<input type="hidden" id="sid" name="sid" value="<%=b.getsId() %>">
				<input type="hidden" id="cid" name="cid" value="<%=loginUser.getCid() %>">
				<input type="hidden" id="pathImg" name="pathImg" value="<%=request.getContextPath() %>/uploadFiles/<%=titleImg.getChangeName() %>">
			<br><br>
				<div class="dearArea" >
				<br>
					<table style="margin-left: 10%">
						<tr>
							<td>
								<font size="3em" color="green" style="font-family: Noto Serif KR; font-weight: bold; font-family: Noto Serif KR">물품명 : </font>
							</td>
							<td>
								<input type="text" name="pName" size="30" style="outline:none; font-size:17px; border: 0px;" id="pInput1" readonly="readonly" value="<%=b.getpName() %>">
							</td>
						</tr>
						
						<tr>
							<td>
								<font size="3em" color="green" style="font-family: Noto Serif KR; font-weight: bold;">가격 : </font>
							</td>
							<td>
								<input type="text" name="pPrice" size="8" style="outline:none; text-align:right; font-size:17px; border: 0px;" id="pInput2" readonly="readonly" value=<%= b.getpPrice() %>>원<br>
							</td>
						</tr>
						
						<tr>
							<td>
								<font size="3em" color="green" style="font-family: Noto Serif KR; font-weight: bold;">재고량 : </font>
							</td>
							<td>
								<input type="text" name="pCount" size="8" style="outline:none; text-align:right; font-size:17px; border: 0px;" id="pInput3" readonly="readonly" value=<%=b.getpCount() %>>개
							</td>
						</tr>
						
						<tr>
							<td>
								<font size="3em" color="green" style="font-family: Noto Serif KR; font-weight: bold;"> 원산지 : </font>
							</td>
							<td>
								<input type="text" size="30" id="add1" name="add1" style="outline:none; font-size:17px; border: 0px;" readonly="readonly" value="<%=b.getpAddress() %>">
							</td>
						</tr>
						
						<tr>
							<td>
								<font size="3em" color="green" style="font-family: Noto Serif KR; font-weight: bold;">생산일자 :</font>
							</td>
							<td>
								<input type="text" name="pDay" style="outline:none; font-size:17px; border: 0px;" id="pInput5" readonly="readonly" value="<%=b.getpDay() %>">
							</td>
						</tr>
						
						<tr>
							<td>
								<font size="3em" color="green" style="font-family: Noto Serif KR; font-weight: bold;">유통기한 :</font>
							</td>
							<td>
								<input type="text" name="pPeriod" style="outline:none; font-size:17px;  border: 0px;" id="pInput6" readonly="readonly" value="<%=b.getpPeriod() %>">
							</td>
						</tr>
						<tr>
							<td>
								<br>
							</td>
							<td>
								
							</td>
						</tr>
						<tr>
							<td>
							<input type="hidden" name="sell_price" value=<%=b.getpPrice()%>>
								<font style="font-family: Noto Serif KR;">수량 :</font>
							</td>
							<td>
								<input type="button" value=" - " onclick="del();">
									<input type="text" name="amount" value="1" size="3" onchange="change();" readonly="readonly" style="text-align: center;" >
									<input type="button" value=" + " onclick="add();">
							</td>
						</tr>
						<tr>
							<td>
								<font style="font-family: Noto Serif KR;">금액 :</font>
							</td>
							<td>
								<input type="text" name="sum" size="11" readonly="readonly" style="border: 0px; text-align: right;">원
							</td>
							
						</tr>
					
					</table>
					<div style="margin-left: 25%; margin-right: 30%; margin-top: 10%; width: 300px;">
					
						<span>
							<button class="button small orange rounded" id="basket" style="background-image: ../css/button_bg.png">장바구니 담기</button>
						</span>
						<span>
							<button class="button small green rounded" id="buy">바로 구매</button>
						</span>
						<!-- <button id="modify">수정하기</button> -->
						
					</div>
					<script type="text/javascript">
						$("#buy").click(function () {
						       $("form").attr("action", "<%=request.getContextPath()%>/plist.bo");
						});
						$("#basket").click(function () {
						       $("form").attr("action", "<%=request.getContextPath()%>/basket.bo");
						});
						$("#modify").click(function () {
						       $("form").attr("action", "<%=request.getContextPath()%>/views/Board/PListUpdate.jsp");
						});
						
					</script>
   						
   					<br><br><br>
				
				</div>
			</div>
		</div>
		
		<div style="width: 935px; margin-left: auto; margin-right: auto;">
			<hr>
		</div>
		
		<div class="mainArea">
			<nav class="tab">
				<ul class="navList">
					<li><a href="#sList1" class="on" style="color: green">1. 상품정보</a></li>
					<li><a href="#sList2" class="on" style="color: green">2. 상품 유의사항</a></li>
					<li><a href="#sList3" class="on" style="color: green">3. 배송 유의사항</a></li>
					<li><a href="#sList4" class="on" style="color: green">4. 구매자 리뷰</a></li>
				</ul>
			
			</nav>
			
			<div id="sList1" style="margin-left: auto; margin-right: auto; margin-top: 20px; border: 1px solid; border-color: #ddd #ddd #CACACA;">
					<br>
					
					
					<br>
					
						
					<div id="ImgsTextArea" style="margin-left: 10%; margin-right:10%; width: 800px; height: 100%;">
						<div id ="Imgss" style="margin-left: auto; margin-right:auto; width: 800px; height: 100%;">		
							
							<table>
							
							
							
							<%
								String[] sarray =  {"",b.getpText1(),b.getpText2(),b.getpText3(),b.getpText4(),b.getpText5()};
							
							for(int i=1;i<fileList.size();i++) { %>
							<tr>
								<td>
									<img  id="imgView1" src="<%=request.getContextPath() %>/uploadFiles/<%=fileList.get(i).getChangeName()%>" style="width:750px; height: 600px; margin-left: 3% margin-right:3%">
								</td>
								<tr>					
									<td>
										<textarea id="textView1" style="outline:none; margin-right: 10%; width: 744px; height: 200px; resize: none; border: 0px solid;" readonly="readonly"><%=sarray[i]%></textarea>
									</td>
								</tr>
							</tr> 
							<%} %>
							
							</table>
						</div>
					</div>
				</div>

			<div id="sList2" style="margin-left: auto; margin-right: auto; margin-top: 20px; border: 1px solid; border-color: #ddd #ddd #CACACA;">
			<font size="5">상품 유의사항</font>
				<textarea name="pNotice" id="notice" rows="10" cols="130" style="outline:none; width: 927px; height: 250px; border: 0px solid;" readonly="readonly"><%=b.getpNotice()%></textarea>
			</div>
			
			<div id="sList3" style="margin-left: auto; margin-right: auto; margin-top: 20px; border: 1px solid; border-color: #ddd #ddd #CACACA;">
			<font size="5">배송 유의사항</font>
				<textarea name="pDelivery" id="delivery" rows="10" cols="130" style="outline:none; width: 927px; height: 250px; border: 0px solid;" readonly="readonly"><%=b.getpDelivery()%></textarea>
			</div>
			
			<div id="sList4" style="margin-left: auto; margin-right: auto; margin-top: 20px; border: 1px solid; border-color: #ddd #ddd #CACACA;">
			<font size="5">구매자 리뷰</font>
				<div style="width: 600px; height: 100px;" >
					<table style="margin-left: 30%; padding: 5px;">
						<% for(Reply r: rList){ %>
						<tr>
							<td style="width: 10px; text-align: center;">
								<%=r.getSaleid()%>
							</td>
							<td style="width: 400px; text-align: center;">
								<%=r.getRecontent()%>
							</td>
							<td style="width: 50px; text-align: center;">
								<%=r.getGrade()%>
							</td>
							<td style="width: 120px; text-align: center;">
								<%=r.getReviewmodify() %>
							</td>
							<td style="width: 30px; text-align: center;">
								<%=r.getCid()%>
							</td>
						</tr>
						<%} %>
					</table>
				</div>
			</div>
			
		</div>
		
		<br><Br><Br><br><Br><Br><br><Br><Br>
	</form>
	
</body>
</html>