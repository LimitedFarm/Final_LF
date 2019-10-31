<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<link href="https://fonts.googleapis.com/css?family=Noto+Serif+KR:200,300&display=swap&subset=korean" rel="stylesheet">
<link rel="stylesheet" type="text/css" href="buttons.css" />
<meta charset="EUC-KR">
<meta charset="UTF-8">

<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<title>상품 등록페이지</title>
<style>
	.mainInfo{
	   
		border: 1px solid;
		border-color: #ddd #ddd #CACACA;
		width: 935px;
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
		display:inline;float:left; width:466px; border: 0px solid;
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
		border: 0px solid; 
	}
	#imgArea:hover {
		cursor: pointer;
	}
	#imgs1:hover {
		cursor: pointer;
	}
	#imgs2:hover {
		cursor: pointer;
	}
	#imgs3:hover {
		cursor: pointer;
	}
	#imgs4:hover {
		cursor: pointer;
	}
	#imgs5:hover {
		cursor: pointer;
	}
	a.top {
	  position: fixed;
	  left: 50%;
	  bottom: 50px;
	  display: none;
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
			
<script>
			$(function() {
				$("#fileArea").hide();
				
				$("#imgArea").click(function() {
					$("#mainImg").click();
				});
				
				
				$("#imgs1").click(function() {
					$("#ImgList1").click();
				});
				$("#imgs2").click(function() {
					$("#ImgList2").click();
				});
				$("#imgs3").click(function() {
					
					$("#ImgList3").click();
				});
				$("#imgs4").click(function() {
					$("#ImgList4").click();
				});
				$("#imgs5").click(function() {
					$("#ImgList5").click();
				});
				
				index = 1;
				
				
				
				// 추가버튼 클릭시 작동
				
				$("#addTable").click(function(){
				var fileCheck = document.getElementById("mainImg").value;
					if(!fileCheck){ // 대표이미지 파일업로드가 안되있을시
						alert("대표이미지를 먼저 등록 해주세요!");
					}else{ // 업로드파일 있을 경우 addDiv해서 테이블 추가버튼 누를때마다 생성
						$addDiv = $("#ImgsTextArea");
						if(index <6){
							/* var $div = $("<div>").attr("id", "imgss"+index); */
							var $img = $("<img>").attr("id","imgs"+index).css({"width":"751px","height":"100%","margin-left":"3%","margin-right":"3%"});
							var $input = $("<input>").attr({"type":"file",
															"id":"ImgList"+index,
															"multiple":"multiple",
															"name":"pImg"+index,
															"onchange":"LoadImg(this,"+(1+index)+"); checkFile(this);"
															});
							var $textarea =$("<textarea>").attr({"rows":"15",
																 "cols":"104",
																 "id":"textList"+index,
																 "name":"pText"+index
															}).css({"margin-left":"3%","margin-right":"3%", "width":"745px"});
							$img.click(function(){
								$input.click();
							});
							$addDiv.append($img);
							$addDiv.append($textarea);
							$addDiv.append($input);
							
							index = index +1;
							
						}
					}
				});
			});
 
			
			function LoadImg(value, num) {

				if(value.files[0]!=undefined) {	

					// value는 함수를 발동시킨 객체(file타입 input태그)이고

					// value.files[0]은 input태그로 파일을 선택 했으면 undefined가 아니고 선택 안했으면 undefined다.

					var reader = new FileReader();

					reader.onload = function(e) {

						switch (num) {
						case 1:
							$("#titleImg").attr("src",e.target.result);
							break;
						case 2:
							$("#imgs1").attr("src",e.target.result);
							break;
						case 3:
							$("#imgs2").attr("src",e.target.result);
							break;
						case 4:
							$("#imgs3").attr("src",e.target.result);
							break;
						case 5:
							$("#imgs4").attr("src",e.target.result);
							break;
						case 6:
							$("#imgs5").attr("src",e.target.result);
							break;
						
						}

					}

					reader.readAsDataURL(value.files[0]);

				}

			}
	        function openChild() {
	            // window.name = "부모창 이름"; 
	            window.name = "PList.jsp";
	            // window.open("open할 window", "자식창 이름", "팝업창 옵션");
	            window.open("Popup.jsp",
	                    "childForm", "margin-left=auto margin-right=auto width=660, height=300, location = no, resizable = no, scrollbars = no");    
	        }
		</script>
</head>
<body>
<%@include file="../common/menubar.jsp" %>
<Br><Br><Br>
<jsp:include page="button.jsp" />
	<form action = "<%=request.getContextPath()%>/insert.bo" method="post" id="Plist" name="Plist" encType="multipart/form-data">
	
		<div class="layer">
			<div class="mainInfo">
				<div id="imgArea" onclick="javascript:checkFile()">
					<img src="<%=request.getContextPath()%>/images/ImgMain.png" id="titleImg" width="465px" height="460px" name="pMainimg">
				</div>

			<br><br><br><br>
				<div class="dearArea">
					<div id="List" style="margin-left: 10%">
	   						<font size="5em" color="black" style="font-family: Noto Serif KR">카테고리 : </font>
	   						<input type="hidden" id="test1" value="1" name="cates">
	   						<select onclick="ssds();" disabled="disabled" id="cate" name="cate">
	   							<option value="1" selected="selected">과일</option>
	   							<option value="2">채소</option>
	   							<option value="3">견과류</option>
	   							<option value="4">가공품</option>
	   						</select>
	   						
	   						<br>
	   						<font size="5em" color="black" style="font-family: Noto Serif KR">물품명 : </font> <input type="text" name="pName" style="text-align:center; outline:none; width:250px; height:30px; font-size:20px; border: 0px;" id="pInput1" readonly="readonly"><br>
	   						 <font size="5em" color="black" style="font-family: Noto Serif KR">가격 : </font><input type="text" name="pPrice" style="outline:none; width:150px; text-align:right; font-size:20px;  border: 0px;" id="pInput2" readonly="readonly" >원<br>
	   						 <font size="4em" color="black" style="font-family: Noto Serif KR">재고량 : </font> <input type="text" name="pCount" style="outline:none; width:150px; text-align:right; font-size:18px; color:black; border: 0px;" id="pInput3" readonly="readonly">개<br>
	   						<font size="4em" color="black" style="font-family: Noto Serif KR"> 원산지 : </font>
								<input type="text" size="25" id="add1" name="add1" style="font-size:18px; color:black; border: 0px; outline:none;" readonly="readonly"><br>
								<input type="text" style="border: 0px solid; width: 61px;" readonly="readonly">
								<input type="text" size="10"id="add2" name="add2" style="font-size:18px; color:black; border: 0px; outline:none;" readonly="readonly">
								<input type="text" size="15" id="add3" name="add3"style="font-size:18px; color:black; border: 0px; outline:none;" readonly="readonly"><br>
	   						 <font size="3em" color="black" style="font-family: Noto Serif KR">생산일자 : </font> <input type="date" name="pDay" style="font-size:15px; color:black; border: 0px; outline:none;" id="pInput5" readonly="readonly"><br>
	   						 <font size="3em" color="black" style="font-family: Noto Serif KR">유통기한 : </font> <input type="date" name="pPeriod" style="font-size:15px; color:black; border: 0px; outline:none;" id="pInput6" readonly="readonly"><br><br>
					</div>
   						 <br>
   					<div style="margin-left: 20%">
   						<span><a onclick="reset();" class="button small orange">모든 내용 지우기</a></span>
	   					<span><a class="button small green"  onclick="openChild()">기본정보 입력하기</a></span>
   					</div>
   					
   					<script>
   						 function reset(){
   							$('#pInput1').val('');
		   					$('#pInput2').val('');
		   					$('#pInput3').val('');
		   					$('#add1').val('');
		   					$('#add2').val('');
		   					$('#add3').val('');
		   					$('#pInput5').val('');
		   					$('#pInput6').val('');
						}
   					</script>
   					
   					<br><br><br>
				</div>
			</div>
		</div>
		
		<div style="width: 935px; margin-left: auto; margin-right: auto;">
			<hr>
		</div>
		
		
		
		<div class="mainArea">
		<div>
			 &nbsp;
		</div>
			<nav class="tab">
				<ul class="navList">
					<li><a href="#sList1" class="on" style="color: green">1. 상품정보</a></li>
					<li><a href="#sList2" class="on" style="color: green">2. 상품 유의사항</a></li>
					<li><a href="#sList3" class="on" style="color: green">3. 배송 유의사항</a></li>
					<li><a href="#sList4" class="on" style="color: green">4. 상품 등록요청</a></li>
				</ul>
			</nav>
			
			<div id="sList1" style="margin-left: auto; margin-right: auto; margin-top: 20px; border: 1px solid; border-color: #ddd #ddd #CACACA;">
					<br><br>
					
					<div id="ImgsTextArea" style="margin-left: auto; margin-right:auto; width: 800px; height: 100%;">
						<div id ="Imgss">								
				     		
						</div>
					</div>
					
					<div style="margin-left: 45%; margin-right: 45%">
						<a class="button small blue" id="addTable">내용 추가하기</a>
					</div>
					
					<br>
				</div>
				
			
			
			<div id="sList2" style="margin-left: auto; margin-right: auto; margin-top: 20px; border: 1px solid; border-color: #ddd #ddd #CACACA;">
				<font size="5">상품 유의사항 작성</font><br><br>
				<textarea name="pNotice" class="DOC_TEXT" rows="10" cols="130" style="width: 927px; height: 250px; border: 0px; outline:none" placeholder="이곳에 내용을 입력해주세요."></textarea>
				<span style="color:#aaa;" id="counter">(0 / 최대 200자)</span>
			</div>
			
			<div id="sList3" style="margin-left: auto; margin-right: auto; margin-top: 20px; border: 1px solid; border-color: #ddd #ddd #CACACA;">
				<font size="5">배송 유의사항 작성</font><br><br>
				<textarea name="pDelivery" class="DOC_TEXT2" rows="10" cols="130" style="width: 927px; height: 250px; border: 0px; outline:none" placeholder="이곳에 내용을 입력해주세요."></textarea>
				<span style="color:#aaa;" id="counter2">(0 / 최대 200자)</span>


			</div>
			<input type="hidden" name="sid" value="<%=sellerUser.getSid() %>">
			<div id="sList4" style="margin-left: auto; margin-right: auto; margin-top: 20px; border: 0px solid; border-color: #ddd #ddd #CACACA;">
				<div style="width: 600px; height: 100px; margin-left: 43%; margin-right: 43%; margin-top: 5%; border: 0px solid;">
					<a href="javascript:void(0);" onclick="gogo();" class="button gray medium">상품 등록요청</a>
				</div>
			</div>
		</div>

		<script type="text/javascript">
			$('.DOC_TEXT').keyup(function (e){
			    var content = $(this).val();
			    $('#counter').html("("+content.length+" / 최대 200자)");    //글자수 실시간 카운팅
			
			    if (content.length > 200){
			        alert("최대 200자까지 입력 가능합니다.");
			        $(this).val(content.substring(0, 200));
			        $('#counter').html("(200 / 최대 200자)");
			    }
			});
			$('.DOC_TEXT2').keyup(function (e){
			    var content2 = $(this).val();
			    $('#counter2').html("("+content2.length+" / 최대 200자)");    //글자수 실시간 카운팅
			
			    if (content2.length > 200){
			        alert("최대 200자까지 입력 가능합니다.");
			        $(this).val(content2.substring(0, 200));
			        $('#counter2').html("(200 / 최대 200자)");
			    }
			});
		</script>
		<a href="#" class="top" style="margin-left: 40%"><img src="<%=request.getContextPath()%>/images/upup.png"></a>

		<div id="fileArea">
			<input type="file" id="mainImg" multiple="multiple" name="mainImg" onchange="LoadImg(this,1); checkFile(this)">
		</div>
		
		<script type="text/javascript">
		function checkFile(f){
		      var file = f.files;
		      if (!/\.(jpg|jpeg|png)$/i.test([file[0].name])) alert('jpg, jpeg, png 파일만 업로드 가능합니다')
		      else return;
		      f.outerHTML = f.outerHTML;
		   }
		</script>
		
		<script type="text/javascript">
			function gogo() {
				var form = document.Plist;
				var fileCheck = document.getElementById("mainImg").value;
				var check = $('#pInput1').val();
				
				if(check == "" || !fileCheck){
					alert("대표 이미지와 기본 물품정보를 등록해주세요")
				}else{
			    	if (confirm("이대로 등록요청 하시겠습니까?") == true){
			    		form.submit();
			    	}else{
			    	    return;
			    	}
				}
			}
		</script>
				<br><br><br><br><br>
	</form>
</body>
</html>