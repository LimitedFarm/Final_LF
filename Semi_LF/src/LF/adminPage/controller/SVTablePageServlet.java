package LF.adminPage.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import LF.adminPage.model.service.AdminService;
import LF.adminPage.model.vo.PageInfo;

/**
 * Servlet implementation class SVTablePageServlet
 */
@WebServlet("/proPage.ad")
public class SVTablePageServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SVTablePageServlet() {
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
		
		//페이징 정보 전송
		
		response.setContentType("application/json;");
		
		new Gson().toJson(page, response.getWriter());
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
