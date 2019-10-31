package LF.mypage.model.service;

import static LF.common.JDBCTemplate.close;
import static LF.common.JDBCTemplate.getConnection;

import java.sql.Connection;
import java.util.ArrayList;

import LF.mypage.model.dao.BasketDao;
import LF.mypage.model.dao.OrderDao;
import LF.mypage.model.vo.OrderVo;

public class OrderService {

	public OrderService() {

	}

	public int selectOrderListCount(int cId) {
		Connection conn = getConnection();

		int listCount = new OrderDao().selectOrderListCount(conn, cId);

		close(conn);

		return listCount;

	}

	public ArrayList<OrderVo> selectOrderList(int currentPage, int limit, int cId) {
		Connection conn = getConnection();

		ArrayList<OrderVo> orderList = new OrderDao().selectOrderList(conn, currentPage, limit, cId);

		close(conn);

		return orderList;
	}

	public int modifyOrderRefund(int sId) {
		Connection conn = getConnection();

		int result = new OrderDao().modifyOrderRefund(conn, sId);

		close(conn);

		return result;
	}

	public int getReviewCountbyOrder(int sale_id) {
		Connection conn = getConnection();

		int reviewCount = new OrderDao().getReviewCountByOrder(conn, sale_id);

		close(conn);

		return reviewCount;

	}

	public String selectImgPath(int pId) {
		Connection conn = getConnection();

		String imgPath = new BasketDao().selectImgPath(conn, pId);

		close(conn);

		return imgPath;

	}

}
