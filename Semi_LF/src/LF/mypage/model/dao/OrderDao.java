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

import LF.mypage.model.vo.OrderVo;

public class OrderDao {

	private Properties prop = new Properties();

	public OrderDao() {

		String fileName = CustomerDao.class.getResource("/LF/sql/mypage/order-query.properties").getPath();

		try {
			prop.load(new FileReader(fileName));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public int selectOrderListCount(Connection conn, int cId) {
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		int listCount = 0;

		String query = prop.getProperty("selectOrderListCount");

		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, cId);
			rs = pstmt.executeQuery();

			if (rs.next()) {
				listCount = rs.getInt(1); // 쿼리에서의 resultSet 컬럼 값(count(*))을 뽑아내서 int listCount에 담음
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
			close(rs);
		}
		return listCount;
	}

	public ArrayList<OrderVo> selectOrderList(Connection conn, int currentPage, int limit, int cId) {
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		ArrayList<OrderVo> orderList = null;

		String query = prop.getProperty("selectOrderList");

		// 쿼리문 실행시 조건절에 넣을 변수들(rownum에 대한 조건 시 필요)
		int startRow = (currentPage - 1) * limit + 1;
		// ex) 2page면 시작 번호가 11번일 것이다.
		int endRow = startRow + limit - 1;

		try {
			pstmt = conn.prepareStatement(query);

			pstmt.setInt(2, startRow);
			pstmt.setInt(3, endRow);
			pstmt.setInt(1, cId); // 1은 게시판 타입을 의미함 -> 1=일반게시판, 2=사진게시판

			rs = pstmt.executeQuery();

			orderList = new ArrayList<OrderVo>(); // 컬렉션(ArrayList)는 반드시 기본생성자로 초기화 해놓고 활용하자!!

			while (rs.next()) {
				OrderVo vo = new OrderVo(rs.getInt("SALE_ID"), rs.getInt("CID"), rs.getInt("SID"), rs.getInt("PID"),
						rs.getString("PNAME"), rs.getInt("SCOUNT"), rs.getDate("SALE_DATE"), rs.getString(9),
						rs.getString("USERID"), rs.getString("TOTALPRICE"));
				orderList.add(vo);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rs);
			close(pstmt);
		}

		return orderList;
	}

	public int modifyOrderRefund(Connection conn, int sId) {

		PreparedStatement pstmt = null;
		int result = 0;

		String query = prop.getProperty("modifyOrderRefund");

		try {
			pstmt = conn.prepareStatement(query);

			pstmt.setInt(1, sId);

			result = pstmt.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		return result;
	}

	public int getReviewCountByOrder(Connection conn, int sale_id) {
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		int reviewCount = 0;

		String query = prop.getProperty("getReviewCountByOrder");

		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, sale_id);
			rs = pstmt.executeQuery();

			if (rs.next()) {
				reviewCount = rs.getInt(1); // 쿼리에서의 resultSet 컬럼 값(count(*))을 뽑아내서 int listCount에 담음
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
			close(rs);
		}
		return reviewCount;
	}

	public String selectImgPath(Connection conn, int pId) {
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		String imgPath = "";

		String query = prop.getProperty("selectImgPath");

		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, pId);
			rs = pstmt.executeQuery();

			if (rs.next()) {
				imgPath = rs.getString(1); // 쿼리에서의 resultSet 컬럼 값(count(*))을 뽑아내서 int listCount에 담음
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
			close(rs);
		}
		return imgPath;
	}

}
