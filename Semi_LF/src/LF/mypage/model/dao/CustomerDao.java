package LF.mypage.model.dao;

import static LF.common.JDBCTemplate.close;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;

import LF.mypage.model.vo.CustomerVo;

public class CustomerDao {

	private Properties prop = new Properties();

	public CustomerDao() {

		String fileName = CustomerDao.class.getResource("/LF/sql/mypage/customer-query.properties").getPath();

		try {
			prop.load(new FileReader(fileName));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public String getCustomerEmail(Connection conn, int cId) {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String email = "";
		
		String query = prop.getProperty("getCustomerEmail");
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, cId);
			
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				email = rs.getString("email");
			}
		} catch(SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
			close(rs);
		}
		return email;
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
	
	public int modifyCustomer(Connection conn, CustomerVo vo) {
		PreparedStatement pstmt = null;
		int flag = 1;
		
		String query = prop.getProperty("modifyCustomer");
		
		try {
			pstmt = conn.prepareStatement(query);
			
			pstmt.setString(1, vo.getPhone());
			pstmt.setString(2, vo.getEmail());
			pstmt.setString(3, vo.getAddress());
			pstmt.setString(4, vo.getAddress2());
			pstmt.setString(5, vo.getAddress3());
			pstmt.setString(6, vo.getUserPwd());
			pstmt.setInt(7, vo.getcId());
			
			flag = pstmt.executeUpdate();
		}catch(SQLException e){
			e.printStackTrace();
		}finally {
			close(pstmt);
		}
		return flag;
	}
}
