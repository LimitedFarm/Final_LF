package LF.member.model.dao;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Properties;

import LF.member.model.vo.Admin;
import LF.member.model.vo.Customer;
import LF.member.model.vo.MReview;
import LF.member.model.vo.Seller;

import static LF.common.JDBCTemplate.*;

public class MenubarDao {
	Properties prop = new Properties();

	public MenubarDao() {
		String fileName = MenubarDao.class.getResource("/LF/sql/member/member-query.properties").getPath();

		try {
			prop.load(new FileReader(fileName));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public Customer selectCustomer(Connection conn, String userId, String userPwd) {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		Customer cuInfo = new Customer();
		String query = prop.getProperty("selectCustomer");
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, userId);
			pstmt.setString(2, userPwd);
			
			rs = pstmt.executeQuery();
			System.out.println(userId +" "+ userPwd);
			if(rs.next()) {
				cuInfo = new Customer(rs.getInt("cid"),
									rs.getString("userid"),
									rs.getString("userPwd"),
									rs.getString("userName"),
									rs.getString("address"),
									rs.getString("address2"),
									rs.getString("address3"),
									rs.getString("phone"),
									rs.getString("email"),
									rs.getDate("joinDate"),
									rs.getDate("modifyDate"),
									rs.getString("groupNum"),
									rs.getString("status")
									);
				
			}
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
			close(rs);
		}
		
		return cuInfo;
	}
	
	
	public Seller selectSeller(Connection conn, int cid) {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		Seller seInfo = new Seller();
		String query = prop.getProperty("selectSeller");
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, cid);
			
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				seInfo = new Seller(rs.getInt("sid"),
									rs.getString("bStatus"),
									rs.getString("bName"),
									rs.getString("bNum"),
									rs.getString("cpNum"),
									rs.getString("acNum"),
									rs.getString("acName"),
									rs.getString("bankName"),
									rs.getDate("sJoinDate"),
									rs.getDate("sModifyDate"),
									rs.getInt("cid"),
									rs.getInt("fid"));
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
			close(rs);
		}
		
		return seInfo;
	}

	public Admin selectAdmin(Connection conn, int cid) {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		Admin adInfo = new Admin();
		String query = prop.getProperty("selectAdmin");
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, cid);
			
			rs = pstmt.executeQuery();
			if(rs.next()) {
				adInfo = new Admin(rs.getInt("aid"),
									rs.getInt("ADMIN_LEVEL"),
									rs.getInt("cid"));
				
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close(pstmt);
			close(rs);
		}
		
		
		
		
		
		return adInfo;
	}

	public int checkSignupId(Connection conn, String id) {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		int result = 0;
		String query = prop.getProperty("checkSignupId");
		
		try {
			pstmt =conn.prepareStatement(query);
			pstmt.setString(1, id);
			
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				result = rs.getInt(1);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close(pstmt);
			close(rs);
		}
		
		return result;
	}

	public int insertCustomer(Connection conn, Customer customer) {
		PreparedStatement pstmt= null;

		String query = prop.getProperty("insertCustomer");
		int result=0;
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, customer.getUserId());
			pstmt.setString(2, customer.getUserPwd());
			pstmt.setString(3, customer.getUserName());
			pstmt.setString(4, customer.getAddress());
			pstmt.setString(5, customer.getAddress2());
			pstmt.setString(6, customer.getAddress3());
			pstmt.setString(7, customer.getPhone());
			pstmt.setString(8, customer.getEmail());
			
			result = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		
		
		return result;
	}

	public ArrayList<MReview> mainReviewSelect(Connection conn) {
		Statement stmt = null;
		ResultSet rs = null;
		ArrayList<MReview> re = new ArrayList<MReview>();
		String query = prop.getProperty("randomReview");
		
		try {
			stmt = conn.createStatement();
			rs = stmt.executeQuery(query);
			
			while(rs.next()) {
				MReview m = new MReview(rs.getInt("reId"),
										rs.getString("recontent"),
										rs.getInt("gread"));
				re.add(m);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(stmt);
			close(rs);
		}
		
		return re;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
