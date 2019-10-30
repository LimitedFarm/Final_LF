package LF.adminPage.model.service;


import static LF.common.JDBCTemplate.*;

import java.sql.Connection;
import java.util.ArrayList;

import LF.adminPage.model.dao.AdminDao;
import LF.adminPage.model.vo.AdOrderList;
import LF.adminPage.model.vo.AdPList;
import LF.adminPage.model.vo.CReportList;
import LF.adminPage.model.vo.PList;
import LF.adminPage.model.vo.SInfo;
import LF.member.model.vo.Customer;
import LF.member.model.vo.Seller;
public class AdminService {
	
	public AdminService() {}
	// 일반 회원 갯수
	public int getCuListCount() {
		Connection conn = getConnection();
		
		int result = new AdminDao().getCuListCount(conn);
		
		close(conn);
		
		return result;
	}
	// 일반 회원 정보
	public ArrayList<Customer> selectCustomer(int currentPage, int limit) {
		Connection conn = getConnection();
		
		ArrayList<Customer> cuInfo = new AdminDao().selectCustomer(conn, currentPage, limit);
		
		close(conn);
		
		return cuInfo;
	}
	// 검색을 통한 회원 찾기
	public Customer searchCustomer(String searchId) {
		Connection conn = getConnection();
		
		Customer searchCu = new AdminDao().searchCustomer(conn, searchId);
		
		close(conn);
		
		return searchCu;
	}
	
	// 판매자 정보 찾기
	public ArrayList<Seller> selectSeller(int currentPage, int limit) {
		Connection conn = getConnection();
		
		ArrayList<Seller> seInfo = new AdminDao().selectSeller(conn, currentPage, limit);
		
		close(conn);
		
		return seInfo;
	}
	// 판매자 정보 페이징 카운트
	public int getSeListCount() {
		Connection conn = getConnection();
		
		int result = new AdminDao().getSeListCount(conn);
		
		close(conn);
		
		return result;
	}
	// 판매자 정보 검색
	public Seller searchSeller(String searchbName) {
		Connection conn = getConnection();
		
		Seller seInfo = new AdminDao().searchSeller(conn, searchbName);
		
		close(conn);
		
		return seInfo;
	}
	// 판매자 권한 업데이트
	public int updateSellerAuth(int sid, String bStatus) {
		Connection conn = getConnection();
		
		int result = new AdminDao().updateSellerAuth(conn, sid, bStatus);
		
		if(result > 0) {
			commit(conn);
		}else {
			rollback(conn);
		}
		
		close(conn);
		
		return result;
	}
	// 모르겠다
	public ArrayList<CReportList> selectcReport(int currentPage, int limit) {
		Connection conn = getConnection();
		
		ArrayList<CReportList> crInfo = new AdminDao().selectcReport(conn, currentPage, limit);
		
		close(conn);
		
		return crInfo;
	}
	// 모르겠다
	public int crCount() {
		Connection conn = getConnection();
		
		int result = new AdminDao().getCReportCount(conn);
		
		return result;
	}
	// 모르겠다
	public SInfo selectSInfo(int cid) {
		Connection conn = getConnection();
		
		SInfo sinfo = new AdminDao().selectSInfo(conn, cid);
		
		close(conn);
		
		return sinfo;
	}
	// 한 판매자 정보
	public ArrayList<PList> SinfoSelectCol(int sid, int currentPage, int limit) {
		Connection conn = getConnection();
		
		ArrayList<PList> pList = new AdminDao().SinfoSelectCol(conn, sid, currentPage, limit);
		
		close(conn);
		
		
		return pList;
	}
	// 판매자 물품 카운트
	public int getseColCount(int sid) {
		Connection conn = getConnection();
		
		int result = new AdminDao().seTableCount(conn, sid);
		
		close(conn);
		
		return result;
	}
	// 상품 리스트 페이징 카운트
	public int getProductListCount() {
		Connection conn = getConnection();
		
		int result = new AdminDao().getProductListCount(conn);
		
		close(conn);
		
		return result;
	}
	// 상품 리스트 정보
	public ArrayList<AdPList> selectProductList(int currentPage, int limit) {
		Connection conn = getConnection();
		
		ArrayList<AdPList> plist = new AdminDao().selectProductList(conn, currentPage, limit);
		
		close(conn);
		
		return plist;
	}
	// 물품 상태 변경
	public int updatePdStatus(int pid, String status) {
		Connection conn = getConnection();
		
		int result = new AdminDao().updatePdStatus(conn, pid, status);
		
		if(result>0) {
			commit(conn);
		}else {
			rollback(conn);
		}
		
		close(conn);
		
		return result;
	}
	// 주문 내역 페이징 카운트
	public int getOrderListCount() {
		Connection conn = getConnection();
		
		int result = new AdminDao().getOrderListCount(conn);
		
		close(conn);
		
		return result;
	}
	// 주문 내역 정보
	public ArrayList<AdOrderList> selectOrdertList(int currentPage, int limit) {
		Connection conn = getConnection();
		
		ArrayList<AdOrderList> oList = new AdminDao().selectOrdertList(conn, currentPage, limit);
		
		close(conn);
		
		return oList;
	}
	
	// 환불 신청 내역 변경
	public int UpdateRefund(int saleId) {
		Connection conn = getConnection();
		
		int result = new AdminDao().UpdateRefund(conn, saleId);
		
		if(result>0) {
			commit(conn);
		}else {
			rollback(conn);
		}
		
		close(conn);
		
		return result;
	}
	// 판매자 1명의 판매 물품 등록 갯수
	public int getsViewColCount(int sid) {
		Connection conn = getConnection();
		
		int result = new AdminDao().getsViewColCount(conn, sid);
		
		close(conn);
		
		return result;
	}
	// 판매자 등록 물품 정보
	public ArrayList<PList> sViewPTableCol(int sid, int currentPage, int limit) {
		Connection conn = getConnection();
		ArrayList<PList> pList = new AdminDao().sViewPTableCol(conn, sid, currentPage, limit);
		
		close(conn);
		
		return pList;
	}
	// 판매 수량
	public int pChartDate(int pid) {
		Connection conn = getConnection();
		
		int result = new AdminDao().pChartDate(conn, pid);
		
		close(conn);
		
		return result;
	}
	// 재고량
	public int pInventory(int pid) {
		Connection conn = getConnection();
		
		int result = new AdminDao().pInventory(conn, pid);
		
		close(conn);
		
		return result;
	}
	// 전체 판매 수량
	public int pChartAllDate(int sid) {
		Connection conn = getConnection();
		
		int result = new AdminDao().pChartAllDate(conn, sid);
		
		close(conn);
		
		return result;
	}
	public int pAllInventory(int sid) {
		Connection conn = getConnection();
		
		int result = new AdminDao().pAllInventory(conn, sid);
		
		close(conn);
		
		return result;
	}
	
	
	
}
