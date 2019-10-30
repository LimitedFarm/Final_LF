package LF.faq.model.dao;

import static LF.common.JDBCTemplate.*;


import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Properties;

import LF.faq.model.vo.Pattachment;
import LF.faq.model.vo.Question;

public class OboDao {
	Properties prop = new Properties();
	
	
	public OboDao() {
	
	String fileName = OboDao.class.getResource("/LF/sql/faq/faq-query.properties").getPath();
	
	try {
		prop.load(new FileReader(fileName));
	} catch (FileNotFoundException e) {
		e.printStackTrace();
	} catch (IOException e) {
		e.printStackTrace();
	}
	}


	public int insertObo(Connection conn, Question q) {
		PreparedStatement pstmt = null;
		int result = 0;
		
		String query = prop.getProperty("insertObo");
		
		try {
			pstmt = conn.prepareStatement(query);
			
			pstmt.setInt(1, q.getcId());
			pstmt.setString(2, q.getqTitle());
			pstmt.setString(3, q.getqContent());
			pstmt.setInt(4, q.getInquirytype());
			pstmt.setString(5, q.getPhone());
			pstmt.setString(6, q.getEamil());
		
			result = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close(pstmt);
		}
		
		
		return result;
	}


	public int insertAttachment(Connection conn, ArrayList<Pattachment> fileList) {
		PreparedStatement pstmt = null;
		
		int result = 0;
		
		String query = prop.getProperty("insertAttachment");
		
		
		
		try {
		for(int i=0;i< fileList.size();i++) {
			Pattachment pat = fileList.get(i);
		
			pstmt = conn.prepareStatement(query);
			
			pstmt.setString(1, pat.getFileName());
			pstmt.setString(2, pat.getChangeName());
			pstmt.setString(3, pat.getFilePath());
			
			result += pstmt.executeUpdate();
			
			
		}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close(pstmt);
		}
		if(result == fileList.size())
			return result;
		else
			return 0;
	}

}
