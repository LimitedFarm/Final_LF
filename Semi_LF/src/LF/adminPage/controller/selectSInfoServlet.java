package LF.adminPage.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import LF.adminPage.model.service.AdminService;
import LF.adminPage.model.vo.PList;
import LF.adminPage.model.vo.SInfo;

/**
 * Servlet implementation class selectSInfo
 */
@WebServlet("/sinfo.ad")
public class selectSInfoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public selectSInfoServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int sid = Integer.valueOf(request.getParameter("sid"));
		SInfo sinfo = new AdminService().selectSInfo(sid);
		
		RequestDispatcher views = null;
		if(sinfo.getSid() != 0) {
			views = request.getRequestDispatcher("views/admin/seInfoView.jsp");
			request.setAttribute("sinfo", sinfo);
			views.forward(request, response);
		}else {
			System.out.println("실패");
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
