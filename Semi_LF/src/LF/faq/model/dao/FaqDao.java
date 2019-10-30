package LF.faq.model.dao;

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

import LF.faq.model.vo.Faq;

public class FaqDao {
	private Properties prop = new Properties();
	
	public FaqDao() {

		
		String fileName = FaqDao.class.getResource("/LF/sql/faq/faq-query.properties").getPath();	
		try {
			prop.load(new FileReader(fileName));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	
	
	public ArrayList<Faq> selectfList(Connection conn) {
		PreparedStatement pstmt = null;
		
		ResultSet rs = null;
		
		ArrayList<Faq> flist = new ArrayList();
		
		String query = prop.getProperty("selectfList");
		
		try {
			pstmt = conn.prepareStatement(query);
		
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				Faq f = new Faq(rs.getInt("faqid"),
								rs.getString("faqtitle"),
								rs.getString("faqcontent"),
								rs.getString("status"),
								rs.getInt("aid"));
				flist.add(f);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close(pstmt);
			close(rs);
		}
	
		
		return flist;
	}






	public int insertFaq(Connection conn, Faq f) {
		PreparedStatement pstmt = null;
		int result = 0;
		
		String query = prop.getProperty("insertFaq");
		
		try {
			pstmt = conn.prepareStatement(query);
			
			pstmt.setString(1,f.getfTitle());
			pstmt.setString(2, f.getfContent());
			pstmt.setInt(3, f.getaId());
			
			result = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close(pstmt);
		}
		
		
		return result;
	}



	public int deletetFaq(Connection conn, int fId) {
		PreparedStatement pstmt = null;
		int result = 0;
		
		String query = prop.getProperty("deleteFaq");
		
		try {
			pstmt = conn.prepareStatement(query);

			pstmt.setInt(1, fId);

			result = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close(pstmt);
		}
		
		return result;
	}



	public Faq selectmodi(Connection conn, int f) {
		PreparedStatement pstmt = null;
		
		ResultSet rs = null;
		
		Faq modifaq = null;
		
		String query = prop.getProperty("selectModiFqa");
		
		
		try {
			pstmt = conn.prepareStatement(query);
			
			pstmt.setInt(1, f);
			
			rs = pstmt.executeQuery();
			while(rs.next()) {
				modifaq = new Faq(rs.getInt("faqid"),
						rs.getString("faqtitle"),
						rs.getString("faqcontent"),
						rs.getString("status"),
						rs.getInt("aid"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			close(rs);
			close(pstmt);
		}
		
		
		return modifaq;
	}



	public int insertmodifaq(Connection conn, Faq f) {
		PreparedStatement pstmt = null;
		int result = 0;
		
		String query = prop.getProperty("insertModiFaq");
		
		try {
			pstmt = conn.prepareStatement(query);
			
			pstmt.setString(1,f.getfTitle());
			pstmt.setString(2, f.getfContent());
			pstmt.setInt(3, f.getaId());
			pstmt.setInt(4, f.getfId());
			
			result = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close(pstmt);
		}
		
		
		return result;
	}


}
