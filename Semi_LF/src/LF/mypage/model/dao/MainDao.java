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

import LF.mypage.model.vo.BasketVo;
import LF.mypage.model.vo.CustomerVo;
import LF.mypage.model.vo.MainCountVo;
import LF.mypage.model.vo.OrderVo;

public class MainDao {
	
	private Properties prop = new Properties();
	
	public MainDao() {
		String fileName = MainDao.class.getResource("/LF/sql/mypage/main-query.properties").getPath();
		
		try {
			prop.load(new FileReader(fileName));
		} catch(FileNotFoundException e) {
			e.printStackTrace();
		} catch(IOException e) {
			e.printStackTrace();
		}
	}
	
	public CustomerVo selectCustomer(Connection conn, int cId) {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		CustomerVo customer = null;

		String query = prop.getProperty("selectCustomer");
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, cId);

			rs = pstmt.executeQuery();

			if (rs.next()) { // resultSet의 결과가 있으면...
				customer = new CustomerVo(rs.getInt("CID"), rs.getString("USERId"), rs.getString("USERPWD"),
						rs.getString("ADDRESS"), rs.getString("ADDRESS2"), rs.getString("ADDRESS3"), rs.getString("PHONE"), rs.getString("EMAIL"), rs.getDate("JOINDATE"),
						rs.getDate("MODIFYDATE"), rs.getString("STATUS"));
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
			close(rs);
		}
		return customer;
	}
	
	public MainCountVo selectMainCount(Connection conn, int cId) {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		MainCountVo vo = null;
		
		String query = prop.getProperty("selectMainCount");
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, cId);
			pstmt.setInt(2, cId);
			pstmt.setInt(3, cId);
			pstmt.setInt(4, cId);
			
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				vo = new MainCountVo(
						rs.getInt("o_count"),
						rs.getInt("b_count"),
						rs.getInt("r_count"),
						rs.getInt("q_count"));
			}
			
		} catch(SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
			close(rs);
		}
		
		return vo;
	}
	
	public ArrayList<OrderVo> selectOrderList(Connection conn, int cId) {
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		ArrayList<OrderVo> orderList = null;

		String query = prop.getProperty("selectOrderList");

		try {
			pstmt = conn.prepareStatement(query);
			
			pstmt.setInt(1, cId); 	
			
			rs=pstmt.executeQuery();
			
			orderList = new ArrayList<OrderVo>();	// 컬렉션(ArrayList)는 반드시 기본생성자로 초기화 해놓고 활용하자!!
			
			while(rs.next()) {
				OrderVo vo = new OrderVo(rs.getInt("sale_id"),
									rs.getInt("cId"),
									rs.getInt("sId"),
									rs.getInt("pId"),
									rs.getString("pName"),
									rs.getInt("scount"),
									rs.getDate("sale_date"),
									rs.getString(9),
									rs.getString("userId"),
									rs.getString("totalPrice"));
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
	
	public ArrayList<BasketVo> selectBasketList(Connection conn, int cId) {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		ArrayList<BasketVo> basketList = null;
		
		String query = prop.getProperty("selectBasketList");
		
		try {
			pstmt = conn.prepareStatement(query);
			
			pstmt.setInt(1, cId);
			
			rs=pstmt.executeQuery();
			
			basketList = new ArrayList<BasketVo>();
			
			while(rs.next()) {
				BasketVo vo = new BasketVo(
						rs.getInt("basketId"),
						rs.getInt("cId"),
						rs.getInt("pId"),
						rs.getInt("sId"),
						rs.getInt("count"),
						rs.getString("pName"),
						rs.getString("userId"),
						rs.getInt("price"));
				basketList.add(vo);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rs);
			close(pstmt);
		}
		return basketList;
	}
	
	public int deleteBasket(Connection conn, int basketId) {
		PreparedStatement pstmt = null;
		int result = 0;
		String query = prop.getProperty("deleteBasket");
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, basketId);
			result = pstmt.executeUpdate();
			
		} catch(SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		return result;
	}
	

}
