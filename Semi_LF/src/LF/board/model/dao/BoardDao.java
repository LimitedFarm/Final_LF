package LF.board.model.dao;
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

import LF.board.model.vo.Attachment;
import LF.board.model.vo.Basket;
import LF.board.model.vo.Board;
import LF.board.model.vo.PaymentInfo;
import LF.board.model.vo.Reply;

public class BoardDao {
	Properties prop = new Properties();

	public BoardDao() {
		String fileName = BoardDao.class.getResource("/LF/sql/board/board-query.properties").getPath();
		
		try {
			prop.load(new FileReader(fileName));
		} catch (FileNotFoundException e) {		
			e.printStackTrace();
		} catch (IOException e) {	
			e.printStackTrace();
		}
	}


	public int insertThBoard(Connection conn, Board b) {
		PreparedStatement pstmt = null;
		int result = 0;
		
		String query = prop.getProperty("insertBoard");
		
		try {
			pstmt= conn.prepareStatement(query);
			pstmt.setInt(1, b.getsId());
			pstmt.setString(2, b.getpName());
			pstmt.setInt(3, b.getpPrice());
			pstmt.setInt(4, b.getpCount());
			pstmt.setString(5, b.getpAddress());
			pstmt.setString(6, b.getpDay()); 
			pstmt.setString(7, b.getpPeriod());
			pstmt.setString(8, b.getpText1());
			pstmt.setString(9, b.getpText2());
			pstmt.setString(10, b.getpText3());
			pstmt.setString(11, b.getpText4());
			pstmt.setString(12, b.getpText5());
			pstmt.setString(13, b.getpNotice());
			pstmt.setString(14, b.getpDelivery());
			pstmt.setInt(15, b.getcAteid());
			
			result = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close(pstmt);
		}
		
		return result;
	}
	
	public int insertAttachment(Connection conn, ArrayList<Attachment> fileList) {
		PreparedStatement pstmt = null;
		int result = 0;
		
		String query = prop.getProperty("insertAttachment");
		
		try {
			for(int i=0; i<fileList.size();i++) {
				Attachment at = fileList.get(i);
				
				pstmt=conn.prepareStatement(query);
				pstmt.setString(1, at.getOriginName());
				pstmt.setString(2, at.getChangeName());
				pstmt.setString(3, at.getFilePath());
				pstmt.setInt(4, at.getFileLevel());
				
				result += pstmt.executeUpdate();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close(pstmt);
		}
		
		// fileList가 가진 파일 갯수만큼의 행이 모두 insert가 되었다면
		if(result == fileList.size())
			return result;
		else
			return 0;

	}


	public int updateCount(Connection conn, int pId) {
			PreparedStatement pstmt = null;
			int result = 0;
			
			String query = prop.getProperty("updateCount");
			
			try {
				pstmt = conn.prepareStatement(query);
				pstmt.setInt(1, pId);
				
				result = pstmt.executeUpdate();
	 
			} catch (SQLException e) {
				e.printStackTrace();
			}finally {
				close(pstmt);
			}

			return result;
	}
	
	public Board selectBoard(Connection conn, int pId) {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		Board b = null;
		
		String query = prop.getProperty("selectBoard");
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, pId);
			
		
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				b = new Board(rs.getInt("pId"),
						rs.getInt("sId"),
						rs.getString("pName"),
						rs.getInt("pPrice"),
						rs.getInt("pCount"),
						rs.getString("pAddress"),
						rs.getString("pDay"),
						rs.getString("pPeriod"),
						rs.getString("pText1"),
						rs.getString("pText2"),
						rs.getString("pText3"),
						rs.getString("pText4"),
						rs.getString("pText5"),
						rs.getString("pNotice"),
						rs.getString("pDelivery"),
						rs.getDate("CREAREDATE"),
						rs.getDate("pModifydate"),
						rs.getString("status"),
						rs.getInt("cAteid"));
				
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close(pstmt);
			close(rs);
		}
		
		return b;
	}
	
	public ArrayList<Attachment> selectThumbnail(Connection conn, int pId) {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		ArrayList<Attachment> list = null;
		
		String query = prop.getProperty("selectThumbnail");
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, pId);
			
			rs = pstmt.executeQuery();
			
			list = new ArrayList<Attachment>();
			
			while(rs.next()) {
				Attachment at = new Attachment();
				at.setfId(rs.getInt("fId"));
				at.setpId(rs.getInt("pId"));
				at.setOriginName(rs.getString("file_Name"));
				at.setChangeName(rs.getString("change_Name"));
				at.setFilePath(rs.getString("file_Path"));
				at.setUploadDate(rs.getDate("upload_Date"));
			
				list.add(at);
				
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close(pstmt);
			close(rs);
		}
		
		return list;
	}


	public int insertBoard(Connection conn, PaymentInfo p) {
		PreparedStatement pstmt = null;
		int result = 0;
		
		String query = prop.getProperty("insertPayinfo");
		
		try {
			pstmt= conn.prepareStatement(query);
			pstmt.setString(1, p.getpName());
			pstmt.setInt(2, p.getsCount());
			pstmt.setString(3, p.getDaName());
			pstmt.setString(4, p.getOrPhone());
			pstmt.setString(5, p.getDaAddress());
			pstmt.setString(6, p.getDaMessage());
			pstmt.setInt(7, p.getPid());
			pstmt.setInt(8, p.getSid());
			pstmt.setInt(9, p.getCid());
			
			result = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close(pstmt);
		}
		
		return result;
	}


	public int updatePListInfo(Connection conn, int pid, int count) {
		PreparedStatement pstmt = null;
		int result = 0;
		String query = prop.getProperty("updatePListInfo");
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, count);
			pstmt.setInt(2, pid);
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		
		return result;
	}


	public int insertBasket(Connection conn, Basket b) {
		PreparedStatement pstmt = null;
		int result = 0;
		
		String query = prop.getProperty("insertBasket");
		
		try {
			pstmt= conn.prepareStatement(query);
			pstmt.setInt(1, b.getcId());
			pstmt.setInt(2, b.getpId());
			pstmt.setInt(3, b.getsId());
			pstmt.setInt(4, b.getCount());
			
			result = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close(pstmt);
		}
		
		return result;
	}


	public ArrayList<Reply> selectReply(Connection conn, int pId) {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		ArrayList<Reply> rList = new ArrayList();
		
		String query = prop.getProperty("selectReply");
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, pId);
		
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				Reply r = new Reply(rs.getInt("sale_id"),
						rs.getString("recontent"),
						rs.getInt("grade"),
						rs.getDate("review_modify"),
						rs.getInt("cid"),
						rs.getInt("pid"));
				
				rList.add(r);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close(pstmt);
			close(rs);
		}
		
		return rList;
	}
}
