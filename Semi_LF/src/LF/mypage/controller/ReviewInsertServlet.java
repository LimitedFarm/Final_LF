package LF.mypage.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import LF.member.model.vo.Customer;
import LF.mypage.model.service.ReviewService;
import LF.mypage.model.vo.ReviewVo;

/**
 * Servlet implementation class ReviewInsertServlet
 */
@WebServlet("/myReviewInsert.bo")
public class ReviewInsertServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ReviewInsertServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		String reContent = request.getParameter("reContent");
		int grade = new Integer(request.getParameter("grade"));
		int sale_id = new Integer(request.getParameter("sale_id"));
		String currentPage = request.getParameter("currentPage");
		
		String type = request.getParameter("type") == null ? "" : request.getParameter("type");
		
		HttpSession session = request.getSession();
		Customer loginInfo = (Customer) session.getAttribute("loginUser");
		int cId = loginInfo.getCid();
		
		/* int cId = 1; */
		
		ReviewVo vo = new ReviewVo();
		
		vo.setReContent(reContent);
		vo.setGrade(grade);
		vo.setSale_id(sale_id);
		vo.setcId(cId);
		
		int result = new ReviewService().insertReview(vo);
		
		response.sendRedirect("myOrder.bo?type="+type+"&currentPage="+currentPage);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
