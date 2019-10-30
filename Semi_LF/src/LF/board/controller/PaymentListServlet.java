package LF.board.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import LF.board.model.vo.Board;

/**
 * Servlet implementation class PaymentList
 */
@WebServlet("/plist.bo")
public class PaymentListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PaymentListServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		
		String pName = request.getParameter("pName");
		int pid = Integer.valueOf(request.getParameter("pid"));
		int sid = Integer.valueOf(request.getParameter("sid"));
		int cid = Integer.valueOf(request.getParameter("cid"));
		int pPrice = Integer.valueOf(request.getParameter("pPrice"));
		int pCount = Integer.valueOf(request.getParameter("amount"));
		int mCount = Integer.valueOf(request.getParameter("pCount"));
		String pathImg = request.getParameter("pathImg");
		
		
		Board c = new Board();
		c.setpId(pid);
		c.setsId(sid);
		c.setpName(pName);
		c.setpPrice(pPrice);
		c.setpCount(pCount);
		
		request.setAttribute("cid", cid);
		request.setAttribute("pathImg", pathImg);
		request.setAttribute("mCount", mCount);
		request.setAttribute("board", c);
		request.getRequestDispatcher("views/Board/Payment.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
