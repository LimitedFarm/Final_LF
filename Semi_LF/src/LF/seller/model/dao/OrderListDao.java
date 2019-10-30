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
import java.util.HashMap;
import java.util.Properties;

import LF.seller.model.vo.OrderList;
import LF.seller.model.vo.aChart;

public class OrderListDao {
	Properties prop = new Properties();

	public OrderListDao() {
		String fileName = ProductDao.class.getResource("/LF/sql/seller/order-query.properties").getPath();
		
		try {
			prop.load(new FileReader(fileName));
		} catch (FileNotFoundException e) {		
			e.printStackTrace();
		} catch (IOException e) {	
			e.printStackTrace();
		}
	}

	public ArrayList getListCount(Connection conn, int sid) {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		String query = prop.getProperty("getListCount");
		
		ArrayList ol= new ArrayList();
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, sid);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				aChart achart = new aChart(
						rs.getInt(1),
						rs.getString("pname")
						);
				
				ol.add(achart);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close(pstmt);
			close(rs);
		}
		return ol;
	}

	
	public ArrayList<OrderList> getTodaysel(Connection conn, int sid) {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		int listCount = 0;
		System.out.println("Dao sid = " + sid);
		String query = prop.getProperty("getTodayList");
		
		ArrayList<OrderList> ol= new ArrayList<OrderList>();
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, sid);
			rs = pstmt.executeQuery();
			System.out.println("Dao sid = " + sid);
			while(rs.next()) {
				OrderList o = new OrderList(
//							rs.getInt(1),
							rs.getString(2),
							rs.getInt(3),
							rs.getString(4),
							rs.getString(5)
//							rs.getInt(6)
						);
				System.out.println("Dao o = " + o);
				ol.add(o);
				System.out.println("Dao ol = " + ol);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close(pstmt);
			close(rs);
		}
		System.out.println("Dao return ol = " + ol);
		return ol;
	}

	public int getListAllCount(Connection conn, int sid) {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		int listCount = 0;
		
		String query = prop.getProperty("getListAllCount");
		
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

	public ArrayList<OrderList> selectList(Connection conn, int currentPage, int limit, int sid) {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		ArrayList<OrderList>list = null;
		
		String query = prop.getProperty("selectList");
		
		// 쿼리문 실행시 조건절에 넣을 변수들(rownum에 대한 조건 시 필요)
		int startRow = (currentPage-1)*limit +1;	
		// ex) 2page면 시작 번호가 11번일 것이다.
		int endRow = startRow + limit -1;
		
		try {
			pstmt = conn.prepareStatement(query);
			
			pstmt.setInt(1, sid);
			pstmt.setInt(2, startRow);
			pstmt.setInt(3, endRow);
			
			rs=pstmt.executeQuery();
			
			list = new ArrayList<OrderList>();	// 컬렉션(ArrayList)는 반드시 기본생성자로 초기화 해놓고 활용하자!!
			
			while(rs.next()) {
				OrderList o = new OrderList(
						rs.getInt("sale_Id"),
						rs.getString("status"),
						rs.getString("pname"),
						rs.getDate("sale_date"),
						rs.getInt("scount"),
						rs.getString("daname"),
						rs.getString("orphone"),
						rs.getString("daaddress"),
						rs.getString("damessage"),
						rs.getInt("pid"),
						rs.getInt("sid"),
						rs.getInt("cid")
						);
				list.add(o);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rs);
			close(pstmt);
		}

		return list;
	}

	public HashMap<Integer,Integer> selectPrice(Connection conn, int sid) {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		HashMap<Integer,Integer> list = null;
		
		String query = prop.getProperty("selectPrice");
		
		try {
			pstmt = conn.prepareStatement(query);
			
			pstmt.setInt(1, sid);
			
			rs=pstmt.executeQuery();
			
			list = new HashMap<Integer,Integer>();	// 컬렉션(ArrayList)는 반드시 기본생성자로 초기화 해놓고 활용하자!!
			
			while(rs.next()) {
				list.put(rs.getInt("pid"), rs.getInt("pprice"));
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
