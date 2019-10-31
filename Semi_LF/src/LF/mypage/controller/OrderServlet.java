package LF.mypage.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import LF.member.model.vo.Customer;
import LF.mypage.model.service.OrderService;
import LF.mypage.model.vo.OrderVo;
import LF.mypage.model.vo.PageVo;

/**
 * Servlet implementation class ReviewServlet
 */
@WebServlet("/myOrder.bo")
public class OrderServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public OrderServlet() {
		super();
		// TODO Auto-generated constructor stubs
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String type = request.getParameter("type") == null ? "" : request.getParameter("type");
		int currentPage = request.getParameter("currentPage") == null ? 1
				: new Integer(request.getParameter("currentPage"));

		/*HttpSession session = request.getSession();
		Customer loginInfo = (Customer) session.getAttribute("loginUser");
		int cId = loginInfo.getCid();*/
		
		int cId = 1;

		OrderService oService = new OrderService();

		int listCount = oService.selectOrderListCount(cId);

		int limit = 5;

		PageVo pageVo = new PageVo(listCount, new Integer(currentPage), limit);

		ArrayList<OrderVo> orderList = oService.selectOrderList(currentPage, limit, cId);

		for (int i = 0; i < orderList.size(); i++) {
			int sale_id = orderList.get(i).getSale_id();
			int reviewCount = oService.getReviewCountbyOrder(sale_id);
			orderList.get(i).setReviewCount(reviewCount);
		}
		
		for(int i=0; i<orderList.size(); i++) {
			int pId = orderList.get(i).getpId();
			String imgPath = oService.selectImgPath(pId);
			orderList.get(i).setImgPath(imgPath);
		}
		
		
		request.setAttribute("orderList", orderList);
		request.setAttribute("pageVo", pageVo);
		request.setAttribute("type", type);
		request.getRequestDispatcher("views/mypage/order.jsp").forward(request, response);

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
