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
import LF.mypage.model.service.MainService;
import LF.mypage.model.vo.BasketVo;
import LF.mypage.model.vo.CustomerVo;
import LF.mypage.model.vo.MainCountVo;
import LF.mypage.model.vo.OrderVo;

/**
 * Servlet implementation class CartServlet
 */
@WebServlet("/myMain.bo")
public class MainServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MainServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		// 회원번호 세션에서 받아오기
		HttpSession session = request.getSession();
		Customer loginInfo = (Customer) session.getAttribute("loginUser");
		int cId = loginInfo.getCid();
		
		/*
		 * int cId = 1;
		 */
		String flag = request.getParameter("flag");
		
		request.setAttribute("flag", flag);
		
		MainService mService = new MainService();
		
		CustomerVo customerVo = mService.selectCustomer(cId);
		MainCountVo mainCountVo = mService.selectMainCount(cId);
		ArrayList<OrderVo> orderList = mService.selectOrderList(cId);
		ArrayList<BasketVo> basketList = mService.selectBasketList(cId);
		
		request.setAttribute("customerVo", customerVo);
		request.setAttribute("mainCountVo", mainCountVo);
		request.setAttribute("orderList", orderList);
		request.setAttribute("basketList", basketList);
		
		request.getRequestDispatcher("views/mypage/main.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
