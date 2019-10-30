package LF.seller.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import LF.seller.model.service.ProductService;
import LF.seller.model.vo.pAttachment;
import LF.seller.model.vo.pList;

/**
 * Servlet implementation class PrModifyServlet
 */
@WebServlet("/prModify.prod")
public class PrModifyServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PrModifyServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int pid = Integer.valueOf(request.getParameter("pid"));
		
		//1. 기존값 불러와서 넘겨주기 페이지.
		pList plist = new ProductService().selectpList(pid);
		ArrayList<pAttachment> paList = new ProductService().selectpAttachment(pid);
		
		//받은 결과에 따른 성공/실패 페이지 출력
		String page="";
		
		if(plist!=null && paList!=null) {
			request.setAttribute("plist", plist);
			request.setAttribute("paList", paList);
			request.getRequestDispatcher("views/seller/productUpdate.jsp").forward(request, response);
			
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
