package LF.seller.model.service;

import static LF.common.JDBCTemplate.close;
import static LF.common.JDBCTemplate.commit;
import static LF.common.JDBCTemplate.getConnection;
import static LF.common.JDBCTemplate.rollback;

import java.io.File;
import java.sql.Connection;
import java.util.ArrayList;

import LF.member.model.vo.Seller;
import LF.seller.model.dao.SellerDao;
import LF.seller.model.vo.pAttachment;

public class SellerService {

	public int registSeller(Seller seller, ArrayList<pAttachment> fileList) {
		//seller 생성 -> db에만 sid 있음
		Connection conn = getConnection();
		SellerDao sDao = new SellerDao();
		int result1 = sDao.registSeller(conn, seller);
		
		if(result1>0) {
			commit(conn);
		}else {
			rollback(conn);
		}
		close(conn);
		
		//image 생성 -> db에만 fid 있음
		Connection conn2 = getConnection();
		int result2 = sDao.registImage(conn2, fileList, seller);
		if(result2>0) {
			commit(conn2);
		}else {
			rollback(conn2);
		}
		close(conn2);
		
		//fid 가져오기
		Connection conn3 = getConnection();
		int fid = sDao.selectFid(conn3, fileList);
		close(conn3);
		
		
		//sellerDB에 fid 등록
		Connection conn4 = getConnection();
		int result3 = sDao.updateFid(conn4, seller, fid);
		if(result3>0) {
			commit(conn4);
		}else {
			rollback(conn4);
		}
		close(conn4);
		
		return result3;
	}

	public int updateSeller(Seller seller) {
		Connection conn = getConnection();
		
		int result = new SellerDao().updateSeller(conn, seller);
		
		if(result > 0)
			commit(conn);
		else
			rollback(conn);
		
		close(conn);
		
		return result;
	}


	public Seller selectSeller(int sid) {
		Connection conn = getConnection();
		
		Seller seInfo = new SellerDao().selectSeller(conn, sid);
		
		close(conn);
		
		return seInfo;
	}

	public pAttachment selectImage(int fid) {
		
		Connection conn = getConnection();
		pAttachment image = new SellerDao().selectImage(conn, fid);
		close(conn);
		
		return image;
	}
	
	public void renameFile(String filename, String newFilename, String savePath) {
	    File file = new File( savePath + filename );
	    File fileNew = new File( savePath + newFilename );
	    if( file.exists() ) file.renameTo( fileNew );
	}

}
