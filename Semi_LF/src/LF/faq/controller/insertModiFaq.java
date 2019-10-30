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
 * Servlet implementation class insertModiFaq
 */
@WebServlet("/insertmodi.fo")
public class insertModiFaq extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public insertModiFaq() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int fid = Integer.parseInt(request.getParameter("fId"));
		String title = request.getParameter("title");
		String content = request.getParameter("content");
		int fWriter = Integer.parseInt(request.getParameter("fWriter"));
		
		Faq f = new Faq();
		
		f.setfId(fid);
		f.setfTitle(title);
		f.setfContent(content);
		f.setaId(fWriter);

		int result = new fService().insertmodiFaq(f);
		
		System.out.println(f);
		
		if (result > 0) {	
			System.out.println("수정성공");
			response.sendRedirect("list.fo");
		}else {
			System.out.println("수정실패");
			response.sendRedirect("list.fo");
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
