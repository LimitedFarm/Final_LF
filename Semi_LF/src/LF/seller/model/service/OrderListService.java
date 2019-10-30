package LF.seller.model.service;

import static LF.common.JDBCTemplate.close;
import static LF.common.JDBCTemplate.getConnection;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.HashMap;

import LF.seller.model.dao.OrderListDao;
import LF.seller.model.vo.OrderList;

public class OrderListService {

	public ArrayList getListCount(int sid) {
		Connection conn = getConnection();
		
		ArrayList allChart = new OrderListDao().getListCount(conn, sid);
		close(conn);
		
		return allChart;
	}

	public ArrayList<OrderList> getTodaySel(int sid) {
		Connection conn = getConnection();
		ArrayList<OrderList> toDaySel = new OrderListDao().getTodaysel(conn, sid);
		
		close(conn);
		
		return toDaySel;
		
	}

	public int getListAllCount(int sid) {
		Connection conn = getConnection();
		
		int listCount = new OrderListDao().getListAllCount(conn, sid);
		
		close(conn);
		
		return listCount;
	}

	public ArrayList<OrderList> selectList(int currentPage, int limit, int sid) {
		Connection conn = getConnection();
		
		ArrayList<OrderList> list = new OrderListDao().selectList(conn, currentPage, limit, sid);
		
		close(conn);
		
		return list;
	}

	public HashMap<Integer,Integer> selectPrice(int sid) {
		Connection conn = getConnection();
		
		HashMap<Integer,Integer> price = new OrderListDao().selectPrice(conn, sid);
		
		close(conn);
		
		return price;
	}
	

}
