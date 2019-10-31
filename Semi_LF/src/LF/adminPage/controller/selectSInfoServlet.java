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
import LF.adminPage.model.vo.PageInfo;
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
		
		int currentPage;	//현재 페이지를 표시할 변수
		int limit;			//한 페이지에 게시글이 몇개가 보여질지와 한 페이지에서 처리가능한 페이지 수
		int maxPage;		//전체 페이지에서 가장 마지막 페이지
		int startPage;		//한번에 표시될 페이지가 시작할 페이지
		int endPage;		//한번에 표시될 페이지가 끝나는 페이지
		
		currentPage = Integer.valueOf(request.getParameter("currentPage"));
		
		AdminService aService = new AdminService();
		
		int listCount = aService.getsViewColCount(sid);
		
		limit = 5;
		maxPage = (int)((double)listCount/limit + 0.8);
		
		startPage = (((int)((double)currentPage/limit+0.8))-1)*limit + 1;
		endPage = startPage + limit - 1;
		
		endPage = maxPage;
		
		if(maxPage < endPage) {
			endPage = maxPage;
		}
		
		PageInfo page = new PageInfo(currentPage, listCount, limit, maxPage, startPage, endPage);
		
		SInfo sinfo = aService.selectSInfo(sid);
		
		RequestDispatcher views = null;
		
		if(sinfo.getSid() > 0) {
			views = request.getRequestDispatcher("views/admin/seInfoView.jsp");
			request.setAttribute("sinfo", sinfo);
			request.setAttribute("pi", page);
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
