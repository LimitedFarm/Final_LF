package LF.product.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import LF.product.model.service.pService;
import LF.product.model.vo.ProductList;

/**
 * Servlet implementation class serchCatePlist
 */
@WebServlet("/selectCa.pl")
public class serchCatePlist extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public serchCatePlist() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int cateNum = Integer.valueOf(request.getParameter("cateNum"));
		
		ArrayList<ProductList> scplist = new pService().SelectCate(cateNum);
		
	
		
		response.setContentType("application/json;");
		new Gson().toJson(scplist, response.getWriter());
		

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
