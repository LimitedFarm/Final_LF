package LF.seller.model.dao;

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

import LF.seller.model.vo.Review;

public class ReviewDao {

	Properties prop = new Properties();

	public ReviewDao() {
		String fileName = ProductDao.class.getResource("/LF/sql/seller/seller-query.properties").getPath();
		
		try {
			prop.load(new FileReader(fileName));
		} catch (FileNotFoundException e) {		
			e.printStackTrace();
		} catch (IOException e) {	
			e.printStackTrace();
		}
	}
	public int getListCount(Connection conn, int sid) {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		int listCount = 0;
		
		String query = prop.getProperty("getReviewCount");
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, sid);
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
	
	public ArrayList<Review> selectList(Connection conn, int currentPage, int limit, int sid) {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		ArrayList<Review>list = null;
		
		String query = prop.getProperty("selectRvList");
		System.out.println("셋팅 전 cp, li, sid : " + currentPage + limit + sid);
		
		// 쿼리문 실행시 조건절에 넣을 변수들(rownum에 대한 조건 시 필요)
		int startRow = (currentPage-1)*limit +1;	//(2-1) * 5 + 1
		// ex) 2page면 시작 번호가 11번일 것이다.S
		int endRow = startRow + limit -1;		//(6+5) - 1
		
		System.out.println("셋팅 후 cp, li, sid sr er : " + currentPage + ", " + limit + ", " + sid + ", " + startRow + ", " + endRow);
		try {
			pstmt = conn.prepareStatement(query);
			
			pstmt.setInt(1, sid);
			pstmt.setInt(2, startRow);
			pstmt.setInt(3, endRow); 	// 1은 게시판 타입을 의미함 -> 1=일반게시판, 2=사진게시판
			
			System.out.println("쿼리 전 셋팅값  sr, er, sid: " + startRow + endRow + sid);
			rs=pstmt.executeQuery();
			System.out.println("=============쿼리 이 후");
			list = new ArrayList<Review>();	// 컬렉션(ArrayList)는 반드시 기본생성자로 초기화 해놓고 활용하자!!
			
			while(rs.next()) {
				System.out.println("rs.next 내부");
				//요기까지ㅏ 봤음. DB 뷰 컬럼명이랑 getint 또는 string의 명시된 이름이 달라서 그렇다. 확인하고 고치셈!
				Review b = new Review(rs.getInt("reid"),
									rs.getString("recontent"),
									rs.getInt("grade"),
									rs.getDate("review_date"),
									rs.getDate("review_modify"),
									rs.getString("status"),
									rs.getInt("cid"),
									rs.getInt("sale_id")
						);
				list.add(b);
				System.out.println("list add함.");
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rs);
			close(pstmt);
		}

		return list;
	}
	public ArrayList<Review> selectList(Connection conn, int currentPage, int limit, int sid, String op, String word,
			String sDay, String lDay) {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		ArrayList<Review>list = null;
		
		String query = prop.getProperty("searchRvList");
		System.out.println("셋팅 전 cp, li, sid : " + currentPage + limit + sid);
		
		// 쿼리문 실행시 조건절에 넣을 변수들(rownum에 대한 조건 시 필요)
		int startRow = (currentPage-1)*limit +1;	//(2-1) * 5 + 1
		// ex) 2page면 시작 번호가 11번일 것이다.
		int endRow = startRow + limit -1;		//(6+5) - 1
		
		System.out.println("op, word, sDay, lDay = " + op + ", " + word + ", " + sDay + ", " + lDay);
		
		try {
			pstmt = conn.prepareStatement(query);
			
			pstmt.setInt(1, sid);
			pstmt.setString(2, op);
			pstmt.setString(3, word);
			pstmt.setString(4, sDay);
			pstmt.setString(5, lDay);
			pstmt.setInt(6, startRow);
			pstmt.setInt(7, endRow); 	// 1은 게시판 타입을 의미함 -> 1=일반게시판, 2=사진게시판
			
			System.out.println("쿼리 전 셋팅값  op, word, sDay, lDay = " + op + ", " + word + ", " + sDay + ", " + lDay);
			rs=pstmt.executeQuery();
			System.out.println("=============쿼리 이 후");
			list = new ArrayList<Review>();	// 컬렉션(ArrayList)는 반드시 기본생성자로 초기화 해놓고 활용하자!!
			
			while(rs.next()) {
				System.out.println("rs.next 내부");
				//요기까지ㅏ 봤음. DB 뷰 컬럼명이랑 getint 또는 string의 명시된 이름이 달라서 그렇다. 확인하고 고치셈!
				Review b = new Review(rs.getInt("reid"),
									rs.getString("recontent"),
									rs.getInt("grade"),
									rs.getDate("review_date"),
									rs.getDate("review_modify"),
									rs.getString("status"),
									rs.getInt("cid"),
									rs.getInt("sale_id")
						);
				list.add(b);
				System.out.println("list add함.");
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rs);
			close(pstmt);
		}

		return list;
	}
}
