package LF.adminPage.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONObject;

import com.google.gson.Gson;

import LF.adminPage.model.service.AdminService;
import LF.adminPage.model.vo.ChartPData;

/**
 * Servlet implementation class SchartDateServlet
 */
@WebServlet("/chartpData.ad")
public class SchartDateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SchartDateServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int pid = Integer.valueOf(request.getParameter("pid"));
		int sid = Integer.valueOf(request.getParameter("sid"));
		AdminService ad = new AdminService();
		
		// 판매된 수량
		int sale = 0;
		
		// 남은 재고량
		int pcount = 0;
		
		if(sid >= 1) {	
			sale = ad.pChartDate(pid);
			pcount = ad.pInventory(pid);
		}else { // 상품 하나의 값
			sale = ad.pChartAllDate(sid);
			pcount = ad.pAllInventory(sid);
		}
		
		int[] reulst = {sale, pcount};
		
		ChartPData cp = new ChartPData(sale, pcount);
		response.setContentType("application/json;");
		new Gson().toJson(cp, response.getWriter());
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
