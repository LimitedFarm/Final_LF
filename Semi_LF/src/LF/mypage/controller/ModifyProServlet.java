package LF.mypage.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import LF.mypage.model.service.CustomerService;
import LF.mypage.model.vo.CustomerVo;

/**
 * Servlet implementation class ModifyOkServlet
 */
@WebServlet("/myModifyPro.bo")
public class ModifyProServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ModifyProServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		System.out.println("myModifyPro.bo 실행");

		System.out.println("execute() ! ");

		String pwd = request.getParameter("pwd");
		String address = request.getParameter("address");
		String address2 = request.getParameter("address2");
		String address3 = request.getParameter("address3");
		String phone = request.getParameter("phone");
		String email = request.getParameter("email");
		String cid = request.getParameter("cId");

		CustomerVo customer = new CustomerVo();

		customer.setUserPwd(pwd);
		customer.setAddress(address);
		customer.setAddress2(address2);
		customer.setAddress3(address3);
		customer.setPhone(phone);
		customer.setEmail(email);
		customer.setcId(new Integer(cid));
		
		System.out.println(customer.toString());

		int flag = new CustomerService().modifyCustomer(customer);
		request.setAttribute("flag", flag);

		System.out.println("flag : " + flag);

		/*response.setContentType("text/html; charset=UTF-8");
		
		PrintWriter out;
		try {
			out = response.getWriter();
			out.println("<script src='https://unpkg.com/sweetalert/dist/sweetalert.min.js' ></script>");
			out.println("<script>swal('수정완료', '', 'success'); location.href='/semiProject/myModify.bo';</script>'");
		} catch(IOException e) {
			e.printStackTrace();
		}*/
		
		response.sendRedirect("myMain.bo?flag="+flag);
		
		//request.getRequestDispatcher("views/mypage/modify.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response, CustomerVo customerVo)
			throws ServletException, IOException {
		// TODO Auto-generated method stub

		doGet(request, response);
	}

}
