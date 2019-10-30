package LF.faq.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import LF.faq.model.service.fService;
import LF.faq.model.vo.Faq;

/**
 * Servlet implementation class FaqDeleteServlet
 */
@WebServlet("/del.fd")
public class FaqDeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FaqDeleteServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	
		int fId = Integer.parseInt(request.getParameter("fid"));
		

		int result = new fService().Faqdelete(fId);
		if(result > 0) {
			response.sendRedirect("list.fo");
			System.out.println("faq 삭제 성공");
		}else {
			response.sendRedirect("list.fo");
			System.out.println("삭제 안됨 ㅋㅋ");
		}
				
	}
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
