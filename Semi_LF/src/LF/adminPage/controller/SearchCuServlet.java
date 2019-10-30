package LF.adminPage.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import LF.adminPage.model.service.AdminService;
import LF.adminPage.model.vo.PageInfo;
import LF.member.model.vo.Customer;

/**
 * Servlet implementation class SearchCu
 */
@WebServlet("/searchCu.ad")
public class SearchCuServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SearchCuServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 찾을 유저의 아이디
		String searchId = request.getParameter("searchId");
		
		// 일반 회원의 정보를 가져온다.
		Customer searchCu = new AdminService().searchCustomer(searchId);
		
		ArrayList<Customer> throwCu = new ArrayList();
		
		throwCu.add(searchCu);
		
		response.setContentType("application/json;");
		new Gson().toJson(throwCu,response.getWriter());
		
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
