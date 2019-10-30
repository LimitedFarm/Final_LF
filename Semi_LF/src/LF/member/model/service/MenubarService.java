package LF.member.model.service;

import static LF.common.JDBCTemplate.*;

import java.sql.Connection;
import java.util.ArrayList;

import LF.member.model.dao.MenubarDao;
import LF.member.model.vo.Admin;
import LF.member.model.vo.Customer;
import LF.member.model.vo.MReview;
import LF.member.model.vo.Seller;

public class MenubarService {
	
	public MenubarService() {}
	// 로그인 정보 확인
	public Customer selectLoginDate(String userId, String userPwd) {
		Connection conn = getConnection();
		
		Customer cuInfo = new MenubarDao().selectCustomer(conn, userId, userPwd);
		
		close(conn);
		
		return cuInfo;
	}
	// 관리자 정보 찾기
	public Seller selectSeller(int cid) {
		Connection conn = getConnection();
		
		Seller seInfo = new MenubarDao().selectSeller(conn, cid);
		
		close(conn);
		
		return seInfo;
	}

	public Admin selectAdmin(int cid) {
		Connection conn = getConnection();
		
		Admin adInfo = new MenubarDao().selectAdmin(conn, cid);
		
		close(conn);
		
		return adInfo;
	}

	public int checkSignupId(String id) {
		Connection conn = getConnection();
		
		int result = new MenubarDao().checkSignupId(conn, id);
		
		close(conn);
		
		return result;
	}

	public int insertCustomer(Customer customer) {
		Connection conn = getConnection();
		
		int result = new MenubarDao().insertCustomer(conn, customer);
		
		if(result >0) {
			commit(conn);
		}else {
			rollback(conn);
		}
		
		close(conn);
		
		return result;
	}
	// 랜덤한 5개의 리뷰 가져오기
	public ArrayList<MReview> mainReviewSelect() {
		Connection conn = getConnection();
		
		ArrayList<MReview> re = new MenubarDao().mainReviewSelect(conn);
		
		close(conn);
		
		return re;
	}
	
	
}
