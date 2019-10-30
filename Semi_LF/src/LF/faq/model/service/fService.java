package LF.faq.model.service;

import static LF.common.JDBCTemplate.*;




import java.sql.Connection;
import java.util.ArrayList;

import LF.faq.model.dao.FaqDao;
import LF.faq.model.vo.Faq;

public class fService {

	public static ArrayList<Faq> selectfList() {
			Connection conn = getConnection();
			
			ArrayList<Faq> flist = new FaqDao().selectfList(conn);
			
			
			
			close(conn);
			
		return flist;
	}

	public int insertFaq(Faq f) {
		Connection conn = getConnection();
		
		int result = new FaqDao().insertFaq(conn, f);
		
		if(result > 0) {
			commit(conn);
		}else {
			rollback(conn);
		}
		
		close(conn);
		
		
		return result;
	}

	public int Faqdelete(int fId) {
		Connection conn = getConnection();
		
		int result = new FaqDao().deletetFaq(conn, fId);
		
		if(result > 0) {
			commit(conn);
		}else {
			rollback(conn);
		}
	
		close(conn);
		
		return result;
	}

	public Faq selectmodifaq(int f) {
		Connection conn = getConnection();
		
		Faq modifyFaq = new FaqDao().selectmodi(conn, f);
		
		close(conn);
		
		return modifyFaq;
	}

	public int insertmodiFaq(Faq f) {
		Connection conn = getConnection();
		
		int result = new FaqDao().insertmodifaq(conn, f);
		
		if(result > 0) {
			commit(conn);
		}else {
			rollback(conn);
		}
	
		
		close(conn);
		return result;
	}


}
