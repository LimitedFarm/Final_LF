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

public class BasketDao {

	private Properties prop = new Properties();

	public BasketDao() {

		String fileName = BasketDao.class.getResource("/LF/sql/mypage/basket-query.properties").getPath();

		try {
			prop.load(new FileReader(fileName));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public int selectBasketListCount(Connection conn, int cId) {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		int listCount = 0;
		
		String query = prop.getProperty("selectBasketListCount");
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, cId);
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

	public ArrayList<BasketVo> selectBasketList(Connection conn,int cId) {
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		ArrayList<BasketVo> basketList = null;

		String query = prop.getProperty("selectBasketList");
		
		try {
			pstmt = conn.prepareStatement(query);
			
			pstmt.setInt(1, cId); 	
			
			rs=pstmt.executeQuery();
			
			basketList = new ArrayList<BasketVo>();	// 컬렉션(ArrayList)는 반드시 기본생성자로 초기화 해놓고 활용하자!!
			
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
	
	public int deleteBasket(Connection conn, String[] checkArr) {
		PreparedStatement pstmt = null;
		int result = 0;
		String query = "delete from basket where basketid in";
		
		try {
			StringBuilder sb = new StringBuilder();
	        sb.append(" (");
	        for (int i = 0; i < checkArr.length; i++) {
	            sb.append("?");
	            if (checkArr.length > i + 1) {
	                sb.append(",");
	            }
	        }
	        sb.append(")");

	        pstmt = conn.prepareStatement(query + sb);
	        for (int i = 1; i < checkArr.length+1; i++) {
	            pstmt.setInt(i, Integer.valueOf(checkArr[i - 1]));
	        }
			
			result = pstmt.executeUpdate();
		} catch(SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		
		return result;
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
			
			if(rs.next()) {
				imgPath = rs.getString(1);	// 쿼리에서의 resultSet 컬럼 값(count(*))을 뽑아내서 int listCount에 담음
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close(pstmt);
			close(rs);
		}
		return imgPath;
	}

}
