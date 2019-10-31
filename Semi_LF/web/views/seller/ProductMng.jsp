<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="LF.seller.model.vo.*, LF.member.model.vo.*, java.util.*, java.io.*"%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="http://code.jquery.com/jquery-3.4.1.min.js"></script>
<script src="http://ajax.googleapis.com/ajax/libs/jquery/1.9.1/jquery.min.js"></script>
<style>
	.inBtn{
	margin-left:auto;
	margin-right:auto;
	margin-top:20px;
	margin-bottom:20px;
		}
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

	}
</style>
</head>
<body>


	<%@ include file="../mypage/menubar.jsp" %>
	
	<div class="outer">
		<br>
		<h2 align="center">판매 상품 관리</h2>
		
		<!-- 공지사항 때와 마찬가지로 검색 부분이 있다. 기능 구현은 생략 -->
		<div class="searchArea" align="center">
			<select id="searchCondition" name="searchCondition">
				<option>----</option>
				<option value="category">상품명</option>
				<option value="title">내용</option>
				<option value="writer">작성일자</option>
			</select>
			<input type="search">
			<button type="submit">검색하기</button>
			<br><br>
			<label>기간설정</label> <!-- 기간설정 달력 선택하는거 만들어서 붙여주기. 리뷰,상품관리페이지 전부 다 똑같이 만들어줘야됨, 버튼이 아니라 달력으로 수정해야함-->
			<input type="date" id="startDate">~<input type="date" id="lastDate">
			 
			<!-- 추천순, 최신순 정렬 만들기 -->
			
			<!-- 공지사항 때와는 다르게 여기선 로그인을 한 사람만 게시글을 작성하게 하자 -->
			<%-- <% if(loginUser != null){%>
				<button onclick="location.href='views/board/boardInsertForm.jsp'">작성하기</button>
			<%} %> --%>
			<!-- boardInsertForm.jsp 만들러 ㄱㄱ씽 -->
		</div>
		
		<br>
		
		<!-- 실제로 작업은 아래 스크립트에서 진행해야 함 -->
		
		<div class="tableArea">
			
		</div>
		<br>
		
	</div>
	
 	<script>
	 $(document).ready(function(){
		 	if($("body").height() < $(window).height()){	//화면에 표시된 내용이 적어서 스크롤바가 생기지 않는 경우 => 최초 로딩
		 		/* window.alert("There isn't a vertical scroll bar"); */
		 		<%
					ArrayList<pList> list = (ArrayList<pList>)request.getAttribute("list");
					ListObj lo = (ListObj)request.getAttribute("lo");
					ArrayList<pAttachment> paList = (ArrayList<pAttachment>)request.getAttribute("paList");
					
					int cnt = 0;
				%>    
					
		 		<%if(list.isEmpty()){ %>
		 			$(".tableArea").append("<a href='"+<%=request.getContextPath()%>+"/views/common/menubar.jsp'>아직 등록된 물품이 없습니다.</a>");
				<%}else{ %>
					<%for(pList p : list){ %>
					//값 받아오는거는 for문 돌리든 해서 넣기.
					pId = <%=p.getpId()%>;
					var pName = "<%=p.getpName()%>";
					var pPrice = <%=p.getpPrice()%>;
					var pCount = <%=p.getpCount()%>;
					var createDate = "<%=p.getpDay()%>";
					var pPeriod = "<%=p.getpPeriod()%>";
					var pContent = "<%=p.getpText1()%>";
					
					$(".tableArea").append("<hr><table id='productTable' align='center' width='1000px' border='1px solid black' style='border-collapse:collapse'>"
							+ "<tr><td rowspan='5' width='20%' height='30%'>" 
							+ "<div align='center' border='1px solid black'><img id='prodImg' src='<%=request.getContextPath() %>/uploadFiles/<%=paList.get(cnt).getChangeName()%>' width='300px' height='300px'></div></td>"
							+ "<td rowspan='1' width='65%'>상품명 : " + pName + "</td>"
							/* + "<td rowspan='5' width='20%'>"
							+ "<div class='inBtn' align='center' onclick='productUpdate();'><button>정보 수정</button></div>" 
							+ "<div class='inBtn' align='center'><button>재고 추가</button></div>" 
							+ "<div class='inBtn' align='center'><button>판매 중지</button></div>" 
							+ "<div class='inBtn' align='center'><button>리뷰 확인</button></div>"
							+ "</td>" */
							+"</tr>"
							+ "<tr><td rowspan='1'>판매 가격 : " +pPrice+"</td></tr>"
							+ "<tr><td rowspan='1'>재고 상태 : " +pCount +"</td></tr>"
							+ "<tr><td rowspan='1'>판매 기간 : " + createDate +"~"+ pPeriod +"</td></tr>"
							+ "<tr><td>상품소개 : "+pContent +  
							+ "<br><div align='right'><button>신고하기</button></div> "
							+ "</td></tr>"
							+ "</table>");
					<%cnt ++;} %>
				<%} %>
		 	}
		 
		 	sid = <%=lo.getSid()%>;
			currentPage = <%=lo.getCurrentPage()%>;
				
		  $(window).scroll(function(){	//스크롤 이벤트 
			if($(window).scrollTop() == $(document).height() - $(window).height()){	//스크롤바 바닥까지 내려가면 내용 추가 스크롤 위치 == 문서길이 - 화면 길이
				currentPage++;
				<%cnt = 0;%>
				$.ajax({
					url : "<%=request.getContextPath()%>/prMngRoad.prod",		/* PrMngRoad */
					method:"post",
					data: {sid : sid, currentPage : currentPage},
					success: function(data){
						console.log("clear");
						//키값 저장할 배열
						var pName = new Array();
						var pPrice = new Array();
						var pCount = new Array();
						var pDay = new Array();
						var pPeriod = new Array();
						var pContent = new Array();
						var fileName = new Array();
						var cnt1 = 0, cnt2 = 0, cnt3=0, cnt4=0, cnt5=0, cnt6=0, cnt7=0;
						
						for(var key in data){
							/* console.log(data[key]);	//Object
							console.log(key);	//hash2 */
							for(var i in data[key]){
								/* console.log(data[key][i]);	//Objec;t */
								for(var j in data[key][i]){
									/* console.log(i  + ", " + j);
									console.log(data[key][i][j]);	//58, 11, File_Name, image3.jpg, FILE_OATH, 날짜, 날짜,  */
									if(j=="changeName"){
										fileName[cnt1] = data[key][i][j];
										cnt1++;
										console.log(fileName[cnt1] + " , cnt1 = " + cnt1);
										
									}else if(j=="pText1"){
										pContent[cnt2] = data[key][i][j];
										cnt2++;
										console.log(pContent[cnt2] + " , cnt2 = " + cnt2);
										
									}else if(j=="pPeriod"){
										pPeriod[cnt3] = data[key][i][j];
										cnt3++;
										console.log(pPeriod[cnt3] + " , cnt3 = " + cnt3);
										
									}else if(j=="pDay"){
										pDay[cnt4] = data[key][i][j];
										cnt4++;
										console.log(pDay[cnt4] + " , cnt4 = " + cnt4);
										
									}else if(j=="pCount"){
										pCount[cnt5] = data[key][i][j];
										cnt5++;
										console.log(pCount[cnt5] + " , cnt5 = " + cnt5);
										
									}else if(j=="pPrice"){
										pPrice[cnt6] = data[key][i][j];
										cnt6++;
										console.log(pPrice[cnt6] + " , cnt6 = " + cnt6);
										
									}else if(j=="pName"){
										pName[cnt7] = data[key][i][j];
										cnt7++;
										console.log(pName[cnt7] + " , cnt7 = " + cnt7);
									}
								}
							}
						}
						
						for(var i=0; i<5;i++){
							console.log("for문 " + i);
							console.log(pName[i]);
							console.log(pPrice[i]);
							console.log(pCount[i]);
							console.log(pDay[i]);
							console.log(pPeriod[i]);
							console.log(pContent[i]);
							console.log(fileName[i]);
						}
						
						for(var i=0; i<5;i++){
							console.log(fileName[i]);
						$(".tableArea").append("<hr><table id='productTable' align='center' width='1000px' border='1px solid black' style='border-collapse:collapse'>"
								+ "<tr><td rowspan='5' width='20%' height='30%'>" 
								+ "<div align='center' border='1px solid black'><img id='prodImg'  src='<%=request.getContextPath() %>/uploadFiles/" +fileName[i] +"' width='300px' height='300px'></div></td>"
								+ "<td rowspan='1' width='65%'>상품명 : " + pName[i] + "</td>"
								/* + "<td rowspan='5' width='20%'>"
								+ "<div class='inBtn' align='center' onclick='productUpdate();'><button>정보 수정</button></div>"
								+ "<div class='inBtn' align='center'><button>재고 추가</button></div>"
								+ "<div class='inBtn' align='center'><button>판매 중지</button></div>"
								+ "<div class='inBtn' align='center'><button>리뷰 확인</button></div> </td> " */
								+"</tr>"
								+ "<tr><td rowspan='1'>판매 가격 : " +pPrice[i]+"</td></tr>"
								+ "<tr><td rowspan='1'>재고 상태 : " +pCount[i] +"</td></tr>"
								+ "<tr><td rowspan='1'>판매 기간 : " + pDay[i] +"~"+ pPeriod[i] +"</td></tr>"
								+ "<tr><td>상품소개 : "+pContent[i]
								/* + "<br><div align='right'><button>신고하기</button></div>" */
								+"</td></tr>"
								+ "</table>");
						}
					} ,
					error:function(request,status,error){
						/* alert("error : " + data);
						console.log("error"); */
						alert("code:"+request.status+"\n"+"message:"+request.responseText+"\n"+"error:"+error);
					},
					complete : function(data) {
		        }
				}); 
				
				//추가해야 할 내용
				//초기에 데이터 몇개나 불러올 것인지(되도록 스크롤바가 생길 수 있는 만큼의 값을 불러와야 함[대충 5개에서 10개 생각함])
				//스크롤 끝까지 닿으면 새로운 데이터 n개 불러온다
				//데이터가 더 이상 없으면 '데이터가 없음'을 알려줘야 한다 (+ 신규 판매 게시글 추가 버튼을 넣어서 신규 판매 게시글을 작성하는 링크 달아주기)
				//https://velopert.com/1890
				//https://sir.kr/qa/212594
			}
		 
		 });
	 });
	 
	 function productUpdate(){
		 //해당 판매글의 정보 가져올 PrModifyServlet
		 location.href="<%=request.getContextPath()%>/prModify.prod?pid=pId";
	 }
	
	</script>
	
	
	


</body>
</html>