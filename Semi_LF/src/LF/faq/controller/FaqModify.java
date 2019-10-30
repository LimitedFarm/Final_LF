package LF.faq.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import LF.faq.model.service.fService;
import LF.faq.model.vo.Faq;

/**
 * Servlet implementation class FaqModify
 */
@WebServlet("/modi.co")
public class FaqModify extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FaqModify() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			int fId = Integer.parseInt(request.getParameter("fid"));
			
			int f = fId;
			
			Faq modifaq = new fService().selectmodifaq(f);
			
			request.setAttribute("modifaq", modifaq);
			RequestDispatcher view = request.getRequestDispatcher("/views/FAQ/FaqModify.jsp");
			
			view.forward(request, response);
			
	}
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
