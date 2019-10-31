package LF.faq.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import LF.faq.model.service.fService;
import LF.faq.model.vo.Faq;

/**
 * Servlet implementation class FaqinsertServlet
 */
@WebServlet("/Faqinsert.fi")
public class FaqinsertServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public FaqinsertServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String title = request.getParameter("title");
		String content = request.getParameter("content");
		String fWriter = request.getParameter("fWriter");


		Faq f = new Faq();

		f.setfTitle(title);
		f.setfContent(content);
		f.setaId(Integer.valueOf(fWriter));


		int result = new fService().insertFaq(f);
		if (result > 0) {
			PrintWriter writer = response.getWriter();
			writer.println("<script>location.href='/Semi_LF/list.fo';</script>");
			writer.flush();
			writer.close();
			return;
		}

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
