package LF.seller.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import LF.seller.model.service.OrderListService;
import LF.seller.model.vo.OrderList;
import LF.seller.model.vo.PageInfo;

/**
 * Servlet implementation class SellerOrderReportServlet
 */
@WebServlet("/sReport.selr")
public class SellerOrderReportServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SellerOrderReportServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// Servlet을 만들면 vo클래스가 필요하다는 생각을 하자!(vo클래스의 객체(request에 담긴 값으로 생성된)를 dao까지 넘길꺼니깐)
		
		//sid 받아주기
		int sid = Integer.valueOf(request.getParameter("sid"));
		
		//전체 판매 차트 (상좌), 최근 판매 내역 (상우) ,전체 판매 차트(하)
		//전체 판매 차트 - orderlist => 모든 값 불러오기
		//최근 판매 내역 - orderlist -> 최근 값 10개정도만
		//전체 판매 차트 - orderlist -> 10개씩 불러오기
		
		// 두개의 서비스를 호출할꺼기 때문에 서비스 객체를 참조형 자료형 변수로 담아두자
		OrderListService olService = new OrderListService();
				
		// sid의 물품별 판매 개수 구하기 => 차트1
		ArrayList allChart = olService.getListCount(sid);
		
		//최근 판매 물품(오늘 하루 팔린 것) => 차트2		//상품명 / 개수/ 구매자명  / 요청사항
		ArrayList<OrderList> toDaySel = olService.getTodaySel(sid);
		
		//전체 판매 물품 조회
		// 게시판 리스트 갯수 구하기
				int listCount = olService.getListAllCount(sid);
				
			//-------------페이징 처리 추가----------------
				// 페이지 수 처리용 변수 선언
				int currentPage;	//현재 페이지를 표시할 변수
				int limit;			//한 페이지에 게시글이 몇개가 보여질지와 한 페이지에서 처리가능한 페이지 수
				int maxPage;		//전체 페이지에서 가장 마지막 페이지
				int startPage;		//한번에 표시될 페이지가 시작할 페이지
				int endPage;		//한번에 표시될 페이지가 끝나는 페이지
				
				// ex) 총 123개의 게시글이 있다면..
				// 		<<1 2 3 4 5 6 7 8 9 10>> 이후에도 페이지가 더 있어야 한다.
				//		<<11 12 13>>		<--여기서 11이 startPage, 13이 endPage, 13이 maxPage
				
				// * currentPage - 현재 페이지
				// 기본 게시판은 1페이지부터 시작함
				currentPage = 1;	//1 페이지를 default로 가져가자
				// 하지만, 페이지 전환시 전달받은 현재 페이지가 있을 시 해당 페이지를 currentPage로 적용
				if(request.getParameter("currentPage")!=null) {
					currentPage = Integer.parseInt(request.getParameter("currentPage"));
				}
				
				// * limit - 한 페이지에 보여질 목록 갯수
				limit = 10;
				
				// * maxPage - 총 페이지 수
				// 목록 수가 123개이면 13페이지가 마지막 페이지다
				// 짜투리 목록이 최소 1개일 때, 한 page로써 의미를 갖게 하기 위해서 0.9를 더해주자
				maxPage=(int)((double)listCount/limit + 0.9);
				
				// * startPage - 현재 페이지에 보여질 시작 페이지 수
				// 아래쪽에 페이지 수가 10개씩 보여지게 할 경우
				// 1, 11, 21, 31, ...
				startPage = (((int)((double)currentPage/limit+0.9))-1)*limit + 1;
				
				
				// * endPage - 현재 페이지에서 보여질 마지막 페이지 수
				// 아래쪽에 페이지 수가 10개씩 보여지게 할 경우
				// 10, 20, 30, 40, ...
				endPage = startPage + limit - 1;
				
				// 하지만!!! 마지막 페이지 수가 총 페이지 수보다 클 경우
				// maxPage가 13이고 endpage가 20페이지일 경우
				if(maxPage < endPage) {
					endPage = maxPage;
				}
				
				// 자 위에서 계산된 모든 페이지 관련 변수들을 request에 담아서 보내야 될텐데 너무 많다!
				// 그래서 페이지 정보를 공유할 vo 객체 PageInfo를 만들러 가자!(page정보만 지닌 객체를 만들어서 넘기기 위해)
				PageInfo pi = new PageInfo(currentPage, listCount, limit, maxPage, startPage, endPage);
				
				// 게시판 리스트 조회해오기
				ArrayList<OrderList> list = olService.selectList(currentPage, limit, sid);
				RequestDispatcher view = null;
				
				
				//해당 사용자의 판매 물품들에 대한 단가 구하기
				HashMap<Integer,Integer> price = olService.selectPrice(sid);
				
				Gson gson = new Gson();
				String aChart = gson.toJson(allChart);
				String bChart = gson.toJson(toDaySel);
				if(list !=null) {
					view = request.getRequestDispatcher("views/seller/OrderMng.jsp");
					request.setAttribute("aChart", aChart);
					request.setAttribute("bChart", bChart);
					request.setAttribute("list", list);
					request.setAttribute("price", price);
					request.setAttribute("pi", pi);
				
					view.forward(request, response);
				}else {
					view = request.getRequestDispatcher("/views/common/errorPage.jsp");
					request.setAttribute("msg", "게시판 리스트 조회 실패!");
					
					view.forward(request, response);
				}
				
				
				
				//boardListView.jsp 페이지 만들러 ㄱㄱ씽
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
