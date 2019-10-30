package LF.member.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import LF.member.model.service.SellerService;
import LF.member.model.vo.Seller;

/**
 * Servlet implementation class SellerInfoUpdate
 */
@WebServlet("/sellerUpdate.selr")
public class SellerInfoUpdate extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SellerInfoUpdate() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		
		String bankName = request.getParameter("bName");
		String acNum = request.getParameter("acN");
		String acName = request.getParameter("acNa");
		int sid = Integer.valueOf(request.getParameter("sid"));
		
		int result = new SellerService().updateSeller(new Seller(sid, acNum, acName, bankName));
		
		//받은 결과에 따른 성공/실패 페이지 출력
		String page="";
		if(result > 0) {
			
			
			//팝업창 종료 및 부모창 새로고침
			page = "views/seller/close.jsp";
			request.setAttribute("msg", "판매자 정보 수정 완료");
			
			
			
		}else {
			page = "views/seller/errorPage.jsp";
			request.setAttribute("msg", "실패");
		}		
		
		RequestDispatcher view = request.getRequestDispatcher(page);
		view.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
