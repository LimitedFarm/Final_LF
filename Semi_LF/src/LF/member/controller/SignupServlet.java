package LF.member.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import LF.member.model.service.MenubarService;
import LF.member.model.vo.Customer;

/**
 * Servlet implementation class SignupServlet
 */
@WebServlet("/signup.me")
public class SignupServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public SignupServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String userId = request.getParameter("signupId");
		String userPwd = request.getParameter("signupPwd");
		String userName = request.getParameter("userName");
		String address1 = request.getParameter("address1");
		String address2 = request.getParameter("address2");
		String address3 = request.getParameter("address3");
		String phone = request.getParameter("phoneNum");
		String emailId = request.getParameter("emailAddress");
		String emailLog = request.getParameter("emailLog");
		String email = emailId + "@" + emailLog;

		
		Customer customer = new Customer(userId, userPwd, userName, address1, address2, address3, phone, email);

		int result = new MenubarService().insertCustomer(customer);

		response.setContentType("text/html;");
		PrintWriter out = response.getWriter();
		if (result > 0) {
			out.println("<script> alert('회원가입에 성공하였습니다.' ); location.href='views/member/MainPag.jsp'; </script>");
		} else {
			out.println("<script> alert('회원가입에 실패하였습니다.' ); location.href='views/member/MainPag.jsp'; </script>");
		}

		out.flush();
		out.close();
		 

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
