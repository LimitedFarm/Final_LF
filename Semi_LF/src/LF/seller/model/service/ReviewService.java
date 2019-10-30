package LF.seller.model.service;

import static LF.common.JDBCTemplate.close;
import static LF.common.JDBCTemplate.getConnection;

import java.sql.Connection;
import java.util.ArrayList;

import LF.seller.model.dao.ReviewDao;
import LF.seller.model.vo.Review;

public class ReviewService {
	
	public int getListCount(int sid) {
		Connection conn = getConnection();
		int listCount = new ReviewDao().getListCount(conn, sid);
		close(conn);
		
		return listCount;
	}
	

	public ArrayList<Review> selectList(int currentPage, int limit, int sid) {
		Connection conn = getConnection();
		
		ArrayList<Review> list = new ReviewDao().selectList(conn, currentPage, limit, sid);
		
		close(conn);
		
		return list;
	}


	public ArrayList<Review> selectList(int currentPage, int limit, int sid, String op, String word, String sDay,
			String lDay) {
		Connection conn = getConnection();
		
		ArrayList<Review> list = new ReviewDao().selectList(conn, currentPage, limit, sid, op, word, sDay, lDay);
		
		close(conn);
		
		return list;
	}
}
