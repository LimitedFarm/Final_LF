package LF.adminPage.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.JsonObject;

import LF.adminPage.model.service.AdminService;

/**
 * Servlet implementation class UpdateSeller
 */
@WebServlet("/updateSeller.ad")
public class UpdateSellerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateSellerServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 판매자 권한 업데이트
		int sid = Integer.valueOf(request.getParameter("sellerSid"));
		String bStatus = request.getParameter("bStatus");
		int result = new AdminService().updateSellerAuth(sid, bStatus);

		JsonObject userObj = new JsonObject();
		if(result >0) {	// 성공시 success를 실패시 fail을 전송
			userObj.addProperty("result", "success");
		}else {
			userObj.addProperty("result", "fail");
		}
		response.setContentType("application/json;");
		PrintWriter out = response.getWriter();
		out.println(userObj);
		out.flush();
		out.close();
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
