package LF.adminPage.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import LF.adminPage.model.service.AdminService;

/**
 * Servlet implementation class UpdateProductServlet
 */
@WebServlet("/updateProduct.ad")
public class UpdateProductServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateProductServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 판매자 권한 업데이트
		int pid = Integer.valueOf(request.getParameter("pid"));
		String status = request.getParameter("status");
		int result = new AdminService().updatePdStatus(pid, status);

		response.setContentType("application/json");

		if (result > 0) { // 성공시 success를 실패시 fail을 전송
			response.getWriter().println("success");
		} else {
			response.getWriter().println("fail");
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
