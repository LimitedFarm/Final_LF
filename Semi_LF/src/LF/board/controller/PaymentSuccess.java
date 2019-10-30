package LF.board.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import LF.board.model.service.BoardService;
import LF.board.model.vo.PaymentInfo;

/**
 * Servlet implementation class PaymentSuccess
 */
@WebServlet("/PaySuccess.bo")
public class PaymentSuccess extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PaymentSuccess() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		int pid = Integer.valueOf(request.getParameter("pid"));
		int sid = Integer.valueOf(request.getParameter("sid"));
		int cid = Integer.valueOf(request.getParameter("cid"));
		int mCount = Integer.valueOf(request.getParameter("mCount"));
		String name = request.getParameter("Cname");	// 이름
		String phone = request.getParameter("phone");	// 핸드폰번호
		String address = request.getParameter("address");	// 주소
		String pname = request.getParameter("Pname");	// 상품명
		String pplz = request.getParameter("pPlz");	// 배송요청사항
		int count = Integer.valueOf(request.getParameter("pCount"));	// 판매 수량
		int price = Integer.valueOf(request.getParameter("pPrice"));	// 가격
		
		int minusCount = mCount-count;
		
		System.out.println(cid);
		
		PaymentInfo p = new PaymentInfo();
		p.setPid(pid);
		p.setSid(sid);
		p.setCid(cid);
		p.setpName(pname);
		p.setsCount(count);
		p.setDaName(name);
		p.setOrPhone(phone);
		p.setDaAddress(address);
		p.setDaMessage(pplz);
		
		int result = new BoardService().insertPayInfo(p);
		
		int result2 = new BoardService().updatePListInfo(pid, minusCount);
		
		if(result>0 && result2>0) {
			System.out.println("insert성공!");
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
