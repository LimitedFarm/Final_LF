package LF.mypage.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import LF.member.model.vo.Customer;
import LF.mypage.model.service.CustomerService;
import LF.mypage.model.vo.CustomerVo;

/**
 * Servlet implementation class ReviewServlet
 */
@WebServlet("/myModify.bo")
public class ModifyServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ModifyServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		HttpSession session = request.getSession();
		Customer loginInfo = (Customer) session.getAttribute("loginUser");
		int cId = loginInfo.getCid();
		
		/* int cId = 1; */
		
		CustomerVo customer = new CustomerService().selectCustomer(cId);
		
		request.setAttribute("customer", customer);
		
		request.getRequestDispatcher("views/mypage/modify.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response, CustomerVo customerVo) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}


