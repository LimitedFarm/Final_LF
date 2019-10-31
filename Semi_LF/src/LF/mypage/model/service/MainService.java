package LF.mypage.model.service;

import static LF.common.JDBCTemplate.close;
import static LF.common.JDBCTemplate.getConnection;

import java.sql.Connection;
import java.util.ArrayList;

import LF.mypage.model.dao.CustomerDao;
import LF.mypage.model.dao.MainDao;
import LF.mypage.model.vo.BasketVo;
import LF.mypage.model.vo.CustomerVo;
import LF.mypage.model.vo.MainCountVo;
import LF.mypage.model.vo.OrderVo;

public class MainService {

	public MainService() {

	}
	
	public CustomerVo selectCustomer(int cId) {
		Connection conn = getConnection();

		CustomerVo customer = new CustomerDao().selectCustomer(conn, cId);

		close(conn);

		return customer;
	}
	
	public MainCountVo selectMainCount(int cId) {
		Connection conn = getConnection();
		
		MainCountVo vo = new MainDao().selectMainCount(conn, cId);
		
		close(conn);
		
		return vo;
	}

	public ArrayList<OrderVo> selectOrderList(int cId) {
		Connection conn = getConnection();

		ArrayList<OrderVo> orderList = new MainDao().selectOrderList(conn, cId);

		close(conn);

		return orderList;
	}
	
	public ArrayList<BasketVo> selectBasketList(int cId) {
		Connection conn = getConnection();
		
		ArrayList<BasketVo> basketList = new MainDao().selectBasketList(conn, cId);
		
		close(conn);
		
		return basketList;
	}
	
	public int deleteBasket(int basketId) {
		Connection conn = getConnection();
		
		int result = new MainDao().deleteBasket(conn, basketId);
		
		close(conn);
		
		return result;
	}

}
