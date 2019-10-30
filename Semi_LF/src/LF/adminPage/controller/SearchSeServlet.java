package LF.adminPage.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import LF.adminPage.model.service.AdminService;
import LF.member.model.vo.Seller;

/**
 * Servlet implementation class SearchSe
 */
@WebServlet("/searchSe.ad")
public class SearchSeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SearchSeServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 찾을 유저의 아이디
		String searchbName = request.getParameter("sellerbName");
				
		// 일반 회원의 정보를 가져온다.
		Seller searchCu = new AdminService().searchSeller(searchbName);
			
		ArrayList<Seller> throwSe = new ArrayList();
		
		throwSe.add(searchCu);
		
		response.setContentType("application/json;");
		new Gson().toJson(throwSe,response.getWriter());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
