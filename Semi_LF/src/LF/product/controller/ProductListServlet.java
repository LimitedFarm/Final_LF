package LF.product.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import LF.product.model.service.pService;
import LF.product.model.vo.ProductList;

/**
 * Servlet implementation class ProductListServlet
 */
@WebServlet("/list.po")
public class ProductListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ProductListServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int cate = Integer.parseInt(request.getParameter("cate"));
		
		ArrayList<ProductList> plist = null;
		
		if(cate == 0) {
			plist = new pService().selectList();
		}else {
			plist = new pService().SelectCate(cate);
		}
		
		
		RequestDispatcher view = null;
		
			if(plist != null) {
				view = request.getRequestDispatcher("views/product/Productlist.jsp");
				request.setAttribute("plist", plist);
				request.setAttribute("category", cate);
			}else {
				System.out.println("plist 불러오기 실패");
			}
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
