package LF.product.model.dao;

import static LF.common.JDBCTemplate.close;

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

import LF.product.model.vo.ProductList;


public class ProductDao {
	private Properties prop = new Properties();
	
	
	
	public ProductDao() {
	
		String fileName = ProductDao.class.getResource("/LF/sql/productlist/productlist-query.properties").getPath();
	
			try {
				prop.load(new FileReader(fileName));
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
		
	}



	public ArrayList<ProductList> selectList(Connection conn) {
		
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		String query = prop.getProperty("selectpList");
	
		ArrayList<ProductList> plist = new ArrayList();
		
		
		try {
			pstmt = conn.prepareStatement(query);
	
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				ProductList p = new ProductList(rs.getInt("pId"),
												rs.getString("pName"),
												rs.getInt("pPrice"),
												rs.getString("PADDRESS"),
												rs.getString("status"),
												rs.getInt("CateId"));
				System.out.println("Dao:"+p.getpId());
				plist.add(p);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close(pstmt);
			close(rs);
		}
		
		
		
		
		return plist;
	}



	public ArrayList<ProductList> scpselelctList(Connection conn, int cateNum) {
		
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		String query = prop.getProperty("catePlist");
		
		ArrayList<ProductList> scpList = new ArrayList();
		
		try {
			pstmt = conn.prepareStatement(query);
			
			pstmt.setInt(1, cateNum);
			
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				ProductList p = new ProductList(rs.getInt("pId"),
											rs.getString("pName"),
											rs.getInt("pPrice"),
											rs.getString("PADDRESS"),
											rs.getString("status"),
											rs.getInt("CateId"));
				
				scpList.add(p);
			}	
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close(pstmt);
			close(rs);
		}
		
		return scpList;
	}



	public int getListCount(Connection conn) {
		Statement stmt = null;
		
		ResultSet rs = null;
		
		int listCount = 0;
		
		String query = prop.getProperty("countList");
		
		try {
			stmt = conn.createStatement();
			rs = stmt.executeQuery(query);
			
			if(rs.next()) {
				listCount = rs.getInt(1);
				//쿼리에서의 resultSet 컬럼 값 count(*)을 뽑아서 int listCount에 담음
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close(stmt);
			close(rs);
		}
		
		
		return listCount;
	}

}
