package LF.product.model.dao;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;

import LF.product.model.vo.pAttachment;

import static LF.common.JDBCTemplate.*;

public class pAdao {
	private Properties prop = new Properties();

	
	public pAdao() {
	
		String fileName = pAdao.class.getResource("/LF/sql/productlist/productlist-query.properties").getPath();
	
			try {
				prop.load(new FileReader(fileName));
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
		
	}
	
	public pAttachment selectfid(Connection conn, int pId) {
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		pAttachment pa = null;
	
		String query = prop.getProperty("selectimg");
		
		try {
			pstmt = conn.prepareStatement(query);
			
			pstmt.setInt(1, pId);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				 pa = new pAttachment(rs.getInt("FID"),
						 			  rs.getInt("pId"),
						 			  rs.getString("FILE_PATH"),
						 			  rs.getInt("FILELEVEL")
						 
						 );
						 
				
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close(pstmt);
			close(rs);
		}
		
		
		
		
		
		
		return pa;
	}
	
	
}
