package LF.mypage.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import LF.mypage.model.service.ReviewService;
import LF.mypage.model.vo.ReviewVo;

/**
 * Servlet implementation class ReviewModify
 */
@WebServlet("/myReviewMoidfy.bo")
public class ReviewModifyServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ReviewModifyServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        
        String reContent = request.getParameter("reContent");
        int reId = new Integer(request.getParameter("reid"));
        String currentPage = request.getParameter("currentPage");
        int grade = new Integer(request.getParameter("grade"));
        
        ReviewVo vo = new ReviewVo();
        
        vo.setReContent(reContent);
        vo.setReId(reId);
        vo.setGrade(grade);
        new ReviewService().modifyReview(vo);
        
        
        String type = "modify";
     
        // TODO Auto-generated method stub
        response.sendRedirect("myReview.bo?currentPage="+currentPage+"&type="+type);
     }
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
