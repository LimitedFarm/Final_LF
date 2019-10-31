package LF.board.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import LF.board.model.service.BoardService;
import LF.board.model.vo.Basket;

/**
 * Servlet implementation class BasketServlet
 */
@WebServlet("/basket.bo")
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
		/* int cId = Integer.valueOf(request.getParameter("cid")); */
		int count = Integer.valueOf(request.getParameter("amount"));
		int pId = Integer.valueOf(request.getParameter("pid"));
		int sId = Integer.valueOf(request.getParameter("sid"));
		int cId = Integer.valueOf(request.getParameter("cid"));
		
		System.out.println(cId);
		System.out.println(count);
		System.out.println(pId);
		System.out.println(sId);
		
		Basket b = new Basket();
		b.setcId(cId);
		b.setCount(count);
		b.setpId(pId);
		b.setsId(sId);
		
		int result = new BoardService().insertBasket(b);
		
		if(result>0) {
			System.out.println("insert성공!");
			request.getRequestDispatcher("/myBasket.bo").forward(request, response);
		}else {
			request.setAttribute("msg", "게시판 작성 실패!!");
			request.getRequestDispatcher("views/common/erropPage.jsp").forward(request, response);
		}
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
