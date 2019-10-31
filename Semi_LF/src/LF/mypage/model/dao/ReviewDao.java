package LF.mypage.model.dao;

import static LF.common.JDBCTemplate.close;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Properties;

import LF.mypage.model.vo.ReviewVo;

public class ReviewDao {
	private Properties prop = new Properties();

	public ReviewDao() {

		String fileName = CustomerDao.class.getResource("/LF/sql/mypage/review-query.properties").getPath();

		try {
			prop.load(new FileReader(fileName));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public int insertReview(Connection conn, ReviewVo vo) {
		PreparedStatement pstmt = null;
		int result = 0;
		
		
		String query = prop.getProperty("insertReview");
		
		try {
			pstmt= conn.prepareStatement(query);
			pstmt.setString(1, vo.getReContent());
			pstmt.setInt(2,  vo.getGrade());
			pstmt.setInt(3, vo.getcId());
			pstmt.setInt(4, vo.getSale_id());
			
			result = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close(pstmt);
		}
		
		return result;
	}
	
	public ArrayList<ReviewVo> selectReviewList(Connection conn, int currentPage, int limit, int cId) {
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		ArrayList<ReviewVo> reviewList = null;

		String query = prop.getProperty("selectReviewList");

		// 쿼리문 실행시 조건절에 넣을 변수들(rownum에 대한 조건 시 필요)
		int startRow = (currentPage - 1) * limit + 1;
		// ex) 2page면 시작 번호가 11번일 것이다.
		int endRow = startRow + limit - 1;
		
		try {
			pstmt = conn.prepareStatement(query);
			
			pstmt.setInt(2, startRow);
			pstmt.setInt(3, endRow);
			pstmt.setInt(1, cId); 	// 1은 게시판 타입을 의미함 -> 1=일반게시판, 2=사진게시판
			
			rs=pstmt.executeQuery();
			
			reviewList = new ArrayList<ReviewVo>();	// 컬렉션(ArrayList)는 반드시 기본생성자로 초기화 해놓고 활용하자!!
			
			while(rs.next()) {
				ReviewVo rvo = new ReviewVo(rs.getInt("reid"),
									rs.getString("recontent"),
									rs.getInt("grade"),
									rs.getDate("review_Date"),
									rs.getDate("review_Modify"),
									rs.getString("status"),
									rs.getInt("cid"),
									rs.getInt("sale_Id"),
									rs.getString("pName"));
				reviewList.add(rvo);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rs);
			close(pstmt);
		}

		return reviewList;
	}
	public int selectReviewListCount(Connection conn, int cId) {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		int listCount = 0;
		
		String query = prop.getProperty("selectReviewListCount");
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, cId);
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				listCount=rs.getInt(1);	// 쿼리에서의 resultSet 컬럼 값(count(*))을 뽑아내서 int listCount에 담음
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close(pstmt);
			close(rs);
		}
		return listCount;
	}
	
	public int deleteReview(Connection conn, int reid) {
		PreparedStatement pstmt = null;
		int result = 0;
		
		String query = prop.getProperty("deleteReview");
		
		try {
			pstmt = conn.prepareStatement("delete from review where reid=?");
			
			pstmt.setInt(1,  reid);
			
			result = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close(pstmt);
		}
		
		return result;
	}
	
	public int modifyReview(Connection conn, ReviewVo vo) {
	      PreparedStatement pstmt = null;
	      int result = 0;
	      
	      String query = prop.getProperty("modifyReview");
	      
	      try {
	         pstmt = conn.prepareStatement(query);
	         
	         pstmt.setString(1,  vo.getReContent());
	         pstmt.setInt(2, vo.getGrade());
	         pstmt.setInt(3, vo.getReId());
	         
	         result = pstmt.executeUpdate();
	         
	      } catch (SQLException e) {
	         e.printStackTrace();
	      }finally {
	         close(pstmt);
	      }
	      
	      return result;
	   }
}
