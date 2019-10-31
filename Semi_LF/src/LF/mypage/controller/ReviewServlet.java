package LF.mypage.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import LF.member.model.vo.Customer;
import LF.mypage.model.service.ReviewService;
import LF.mypage.model.vo.PageVo;
import LF.mypage.model.vo.ReviewVo;

/**
 * Servlet implementation class ReviewServlet
 */
@WebServlet("/myReview.bo")
public class ReviewServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ReviewServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		/*HttpSession session = request.getSession();
		Customer loginInfo = (Customer) session.getAttribute("loginUser");
		int cId = loginInfo.getCid();*/
		
		int cId = 1;
		
		ReviewService rService = new ReviewService();
		
		int listCount = rService.selectReviewListCount(cId);
		
		// 페이징 처리
		// 페이지 수 처리용 변수 선언
		String type = request.getParameter("type") == null ? "" : request.getParameter("type"); 
		int currentPage = request.getParameter("currentPage") == null ? 1 : new Integer(request.getParameter("currentPage"));
		int limit = 5;
		
		PageVo pageVo = new PageVo(listCount, new Integer(currentPage), limit);
		
		ArrayList<ReviewVo> reviewList = rService.selectReviewList(currentPage, limit, cId);
		
		/*System.out.println(orderList.get(1).toString());*/
		request.setAttribute("reviewList", reviewList);
		request.setAttribute("pageVo", pageVo);
		request.setAttribute("type", type);
		
		request.getRequestDispatcher("views/mypage/review.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
