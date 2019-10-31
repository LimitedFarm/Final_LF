package LF.mypage.model.service;

import static LF.common.JDBCTemplate.close;
import static LF.common.JDBCTemplate.commit;
import static LF.common.JDBCTemplate.getConnection;
import static LF.common.JDBCTemplate.rollback;

import java.sql.Connection;
import java.util.ArrayList;

import LF.mypage.model.dao.CustomerDao;
import LF.mypage.model.dao.ReviewDao;
import LF.mypage.model.vo.CustomerVo;
import LF.mypage.model.vo.ReviewVo;

public class ReviewService {
	
	public int insertReview(ReviewVo vo) {
		Connection conn = getConnection();
		
		int result = new ReviewDao().insertReview(conn, vo);
		
		if(result>0) {
			commit(conn);
		}else {
			rollback(conn);
		}
		close(conn);
		
		return result;
	}
	
	public ArrayList<ReviewVo> selectReviewList(int currentPage, int limit, int cId) {
		Connection conn = getConnection();

		ArrayList<ReviewVo> reviewList = new ReviewDao().selectReviewList(conn, currentPage, limit, cId);

		close(conn);

		return reviewList;
	}
	
	public int selectReviewListCount(int cId) {
		Connection conn = getConnection();

		int listCount = new ReviewDao().selectReviewListCount(conn, cId);

		close(conn);

		return listCount;

	}
	
	public int deleteReview(int reid) {
		Connection conn = getConnection();

		int listCount = new ReviewDao().deleteReview(conn, reid);

		close(conn);

		return listCount;

	}
	
	public int modifyReview(ReviewVo vo) {
		Connection conn = getConnection();

		int flag = new ReviewDao().modifyReview(conn, vo);

		close(conn);

		return flag;
	}
	
}
