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
import LF.mypage.model.service.BasketService;
import LF.mypage.model.vo.BasketVo;

/**
 * Servlet implementation class CartServlet
 */
@WebServlet("/myBasket.bo")
public class BasketServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BasketServlet() {
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
		
		String type = request.getParameter("type");
		
		BasketService bService = new BasketService();
		
		ArrayList<BasketVo> basketList = bService.selectBasketList(cId);
		
		for(int i=0; i<basketList.size(); i++) {
			int pId = basketList.get(i).getpId();
			String imgPath = bService.selectImgPath(pId);
			basketList.get(i).setImgPath(imgPath);
		}
		
		request.setAttribute("basketList", basketList);
		request.setAttribute("flag", type);
		request.getRequestDispatcher("views/mypage/basket.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
