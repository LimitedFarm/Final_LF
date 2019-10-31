package LF.mypage.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import LF.mypage.model.service.OrderService;

/**
 * Servlet implementation class OrderRefundServlet
 */
@WebServlet("/myOrderRefund.bo")
public class OrderRefundServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public OrderRefundServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		int sId = new Integer(request.getParameter("sId"));
		
		System.out.println("sId :: " + sId);
		
		String type = request.getParameter("type") == null ? "" : request.getParameter("type");
		String currentPage = request.getParameter("currentPage") == null ? "" : request.getParameter("currentPage");
		
		System.out.println("type :: " + type);
		
		OrderService oService = new OrderService();
		
		oService.modifyOrderRefund(sId);
		
		response.sendRedirect("myOrder.bo?type="+type+"&currentPage="+currentPage);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
