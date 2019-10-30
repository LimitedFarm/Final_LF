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
import java.util.Properties;

import LF.member.model.vo.Seller;
import LF.seller.model.vo.pAttachment;

public class SellerDao {
	
	private Properties prop = new Properties();
	
	public SellerDao() {
		//항상 seller=query.properties 값 불러오도록 초기셋팅하기
		String fileName = SellerDao.class.getResource("/LF/sql/seller/seller-query.properties").getPath();
		
		try {
			prop.load(new FileReader(fileName));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	
	

	public int registImage(Connection conn, ArrayList<pAttachment> fileList, Seller seller) {
		PreparedStatement pstmt = null;
		int result = 0;
		String cid = String.valueOf(seller.getCid());
		String query = prop.getProperty("insertpAttachment");
		try {
			for(int i=0; i<fileList.size();i++) {
				pAttachment at = fileList.get(i);
				
				pstmt=conn.prepareStatement(query);
				pstmt.setString(1, at.getFileName());
				pstmt.setString(2, at.getChangeName());
				pstmt.setString(3, at.getFilePath());
				
				
				result = pstmt.executeUpdate();
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





	
	
	public int registSeller(Connection conn, Seller seller) {
		PreparedStatement pstmt = null;
		int result = 0;
		String query = prop.getProperty("insertSeller");
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, seller.getbName());
			pstmt.setString(2, seller.getbNum());
			pstmt.setString(3, seller.getCpNum());
			pstmt.setString(4, seller.getAcNum());
			pstmt.setString(5, seller.getAcName());
			pstmt.setString(6, seller.getBankName());
			pstmt.setInt(7, seller.getCid());
			
			result = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close(pstmt);
		}
		return result;
	}




	public int updateSeller(Connection conn, Seller seller) {
		PreparedStatement pstmt = null;
		int result = 0;
		
		String query = prop.getProperty("updateSeller");
		
		try {
			pstmt = conn.prepareStatement(query);
			
			pstmt.setString(1, seller.getBankName() );
			pstmt.setString(2, seller.getAcNum());
			pstmt.setString(3, seller.getAcName());
			pstmt.setInt(4, seller.getSid());
			
			result = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close(pstmt);
		}
		
		return result;
	}




	public Seller selectSeller(Connection conn, int sid) {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		Seller seInfo = new Seller();
		String query = prop.getProperty("selectSeller");
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, sid);
			
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




	public pAttachment selectImage(Connection conn, int fid) {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		pAttachment image = new pAttachment();
		String query = prop.getProperty("selectImage");
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, fid);
			
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				image = new pAttachment(
									rs.getInt("fid"),
									rs.getString("change_name"),
									rs.getString("file_path"),
									rs.getDate("upload_date")
									);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
			close(rs);
		}
		
		return image;
	}




	public int selectFid(Connection conn, ArrayList<pAttachment> fileList) {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		ArrayList<pAttachment> list = new ArrayList<pAttachment>();
		int fid=0;
		
		String query = prop.getProperty("selectFid");
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, fileList.get(0).getChangeName());
			
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				
				fid = rs.getInt("fid");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
			close(rs);
		}
		
		return fid;
	}




	public int updateFid(Connection conn, Seller seller, int fid) {
		PreparedStatement pstmt = null;
		int result = 0;
		System.out.println("updateFid seller = " + seller);
		System.out.println("updateFid fid = " + fid);
		
		String query = prop.getProperty("updateFid");
		
		try {
			pstmt = conn.prepareStatement(query);
			
			pstmt.setInt(1, fid);
			pstmt.setInt(2, seller.getCid());
			
			result = pstmt.executeUpdate();
			System.out.println("updateFid result = " + result);
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close(pstmt);
		}
		
		return result;
	}

}
