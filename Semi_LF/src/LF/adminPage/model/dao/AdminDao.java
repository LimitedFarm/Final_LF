package LF.adminPage.model.dao;

import static LF.common.JDBCTemplate.*;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Properties;

import LF.adminPage.model.vo.AdOrderList;
import LF.adminPage.model.vo.AdPList;
import LF.adminPage.model.vo.CReportList;
import LF.adminPage.model.vo.PList;
import LF.adminPage.model.vo.SInfo;
import LF.member.model.vo.Customer;
import LF.member.model.vo.Seller;

public class AdminDao {
	Properties prop = new Properties();

	public AdminDao() {
		String fileName = AdminDao.class.getResource("/LF/sql/admin/admin-query.properties").getPath();

		try {
			prop.load(new FileReader(fileName));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	public ArrayList<Customer> selectCustomer(Connection conn, int currentPage, int limit) {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		ArrayList<Customer> cuInfo = new ArrayList();
		String query = prop.getProperty("selectCustomer");
		
		int startRow = (currentPage-1)*limit +1;	
		int endRow = startRow + limit -1;
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, startRow);
			pstmt.setInt(2, endRow);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				Customer customer = new Customer(rs.getInt("cid"),
						rs.getString("userid"),
						rs.getString("userPwd"),
						rs.getString("userName"),
						rs.getString("address"),
						rs.getString("address2"),
						rs.getString("address3"),
						rs.getString("phone"),
						rs.getString("email"),
						rs.getDate("joinDate"),
						rs.getDate("modifyDate"),
						rs.getString("groupNum"),
						rs.getString("status")
						);
				
				cuInfo.add(customer);
				
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
			close(rs);
		}
		
		
		return cuInfo;
	}
	
	// 일반 회원의 리스트 도출
	public int getCuListCount(Connection conn) {
		Statement stmt = null;
		ResultSet rs = null;
		int result =0;
		
		String query = prop.getProperty("getCuListCount");
		
		try {
			stmt = conn.createStatement();
			rs = stmt.executeQuery(query);
			
			if(rs.next()) {
				result = rs.getInt(1);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(stmt);
			close(rs);
		}
		
		
		return result;
	}

	public Customer searchCustomer(Connection conn, String searchId) {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		Customer searchCu = null;
		String query = prop.getProperty("searchCustomer");
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, searchId);
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				searchCu = new Customer(rs.getInt("cid"),
										rs.getString("userid"),
										rs.getString("userPwd"),
										rs.getString("userName"),
										rs.getString("address"),
										rs.getString("address2"),
										rs.getString("address3"),
										rs.getString("phone"),
										rs.getString("email"),
										rs.getDate("joinDate"),
										rs.getDate("modifyDate"),
										rs.getString("groupNum"),
										rs.getString("status")
										);
			}
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
			close(rs);
		}
		
		
		return searchCu;
	}

	public ArrayList<Seller> selectSeller(Connection conn, int currentPage, int limit) {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		ArrayList<Seller> seInfo = new ArrayList();
		String query = prop.getProperty("selectSeller");
		
		int startRow = (currentPage-1)*limit +1;	
		int endRow = startRow + limit -1;
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, startRow);
			pstmt.setInt(2, endRow);
			rs = pstmt.executeQuery();
			
			
			while(rs.next()) {
				Seller s = new Seller(rs.getInt("sid"),
									rs.getString("bstatus"),
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
				
				seInfo.add(s);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close(pstmt);
			close(rs);
		}
		
		return seInfo;
	}

	public int getSeListCount(Connection conn) {
		Statement stmt = null;
		ResultSet rs = null;
		int result =0;
		
		String query = prop.getProperty("getSeListCount");
		
		try {
			stmt = conn.createStatement();
			rs = stmt.executeQuery(query);
			
			if(rs.next()) {
				result = rs.getInt(1);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(stmt);
			close(rs);
		}
		
		
		return result;
	}

	public Seller searchSeller(Connection conn, String searchbName) {
		PreparedStatement pstmt = null;
		ResultSet rs= null;
		Seller seInfo = null;
		String query = prop.getProperty("searchSeller");
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, searchbName);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				seInfo = new Seller(rs.getInt("sid"),
						rs.getString("bstatus"),
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

	public int updateSellerAuth(Connection conn, int sid, String bStatus) {
		PreparedStatement pstmt = null;
		int result = 0;
		String query = prop.getProperty("updateSellerAuth");
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, bStatus);
			pstmt.setInt(2, sid);
			
			result = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		
		return result;
	}

	public ArrayList<CReportList> selectcReport(Connection conn, int currentPage, int limit) {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		ArrayList<CReportList> crInfo = new ArrayList();
		String query = prop.getProperty("selectcReport");
		
		int startRow = (currentPage-1)*limit +1;	
		int endRow = startRow + limit -1;
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, startRow);
			pstmt.setInt(2, endRow);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				CReportList sr = new CReportList(rs.getInt("crid"),
												rs.getInt("cid"),
												rs.getString("noContent"),
												rs.getDate("report_date"),
												rs.getString("status"),
												rs.getInt("sale_id"),
												rs.getString("userid"),
												rs.getString("pname"));
				crInfo.add(sr);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
			close(rs);			
		}

		return crInfo;
	}

	public int getCReportCount(Connection conn) {
		Statement stmt = null;
		ResultSet rs = null;
		int result = 0;
		String query = prop.getProperty("getCReportCount");
		
		try {
			stmt = conn.createStatement();
			rs = stmt.executeQuery(query);
			
			if(rs.next()) {
				result = rs.getInt(1);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(stmt);
			close(rs);
		}
		
		return result;
	}

	public SInfo selectSInfo(Connection conn, int cid) {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		SInfo sinfo = null;
		String query = prop.getProperty("selectSInfo");
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, cid);
			
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				sinfo = new SInfo(rs.getInt("cid"),
								rs.getInt("sid"),
								rs.getString("userId"),
								rs.getString("userName"),
								rs.getString("address2"),
								rs.getString("address3"),
								rs.getString("phone"),
								rs.getString("email"),
								rs.getString("bname"),
								rs.getString("bnum"),
								rs.getString("acnum"),
								rs.getString("acname"),
								rs.getString("bankname"),
								rs.getDate("sJoinDate"),
								rs.getInt("fid"),
								rs.getString("bstatus"));
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
			close(rs);
		}
		
		return sinfo;
	}
	
	public ArrayList<PList> SinfoSelectCol(Connection conn, int sid, int currentPage, int limit) {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		int startRow = (currentPage-1)*limit +1;	
		int endRow = startRow + limit -1;
		
		ArrayList<PList> pList = new ArrayList();
		String query = prop.getProperty("SinfoSelectCol");
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, sid);
			pstmt.setInt(2, startRow);
			pstmt.setInt(3, endRow);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				PList p = new PList(rs.getInt("PID"),
									rs.getInt("sid"),
									rs.getString("pName"),
									rs.getInt("pPrice"),
									rs.getInt("pCount"),
									rs.getString("pAddress"),
									rs.getString("pDay"),
									rs.getString("pperiod"),
									rs.getString("ptext1"),
									rs.getString("ptext2"),
									rs.getString("ptext3"),
									rs.getString("ptext4"),
									rs.getString("ptext5"),
									rs.getString("pNotice"),
									rs.getString("pDelivery"),
									rs.getDate("createDate"),
									rs.getDate("pmodifyDate"),
									rs.getString("status"),
									rs.getInt("cateId")
									);
				pList.add(p);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
			close(rs);
		}
		return pList;
	}
	// 테이블에 들어갈 row 갯수
	public int seTableCount(Connection conn, int sid) {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		int result = 0;
		String query = prop.getProperty("seTableCount");
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, sid);
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				result = rs.getInt(1);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
			close(rs);
		}
		
		return result;
	}
	// 물품 리스트 갯수
	public int getProductListCount(Connection conn) {
		Statement stmt = null;
		ResultSet rs = null;
		int result = 0;
		String query = prop.getProperty("ProductListCount");
		
		try {
			stmt = conn.createStatement();
			rs = stmt.executeQuery(query);
			
			if(rs.next()) {
				result = rs.getInt(1);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(stmt);
			close(rs);
		}
		
		
		return result;
	}
	// 물품 리스트
	public ArrayList<AdPList> selectProductList(Connection conn, int currentPage, int limit) {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		ArrayList<AdPList> plist = new ArrayList();
		String query = prop.getProperty("selectProductList");
		
		int startRow = (currentPage-1)*limit +1;	
		int endRow = startRow + limit -1;
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, startRow);
			pstmt.setInt(2, endRow);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				AdPList sinfo = new AdPList(rs.getInt("pid"),
						rs.getString("userName"),
						rs.getString("userId"),
						rs.getString("bName"),
						rs.getString("pName"),
						rs.getString("pAddress"),
						rs.getInt("PCount"),
						rs.getInt("pPrice"),
						rs.getString("pDay"),
						rs.getInt("cateId"),
						rs.getString("status"));
				
				plist.add(sinfo);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally{
			close(pstmt);
			close(rs);
		}
		
		return plist;
	}
	// 판매물품 상태 변경
	public int updatePdStatus(Connection conn, int pid, String status) {
		PreparedStatement pstmt = null;

		int result = 0;
		String query = prop.getProperty("updatePdStatus");
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, status);
			pstmt.setInt(2, pid);
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		
		
		return result;
	}
	// 주문 내역 갯수
	public int getOrderListCount(Connection conn) {
		Statement stmt = null;
		ResultSet rs = null;
		int result = 0;
		String query = prop.getProperty("OrderListCount");
		
		try {
			stmt = conn.createStatement();
			rs = stmt.executeQuery(query);
			if(rs.next()) {
				result = rs.getInt(1);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(stmt);
			close(rs);
		}
		
		return result;
	}

	public ArrayList<AdOrderList> selectOrdertList(Connection conn, int currentPage, int limit) {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		ArrayList<AdOrderList> oList = new ArrayList();
		String query = prop.getProperty("selectOrdertList");
		int startRow = (currentPage-1)*limit +1;	
		int endRow = startRow + limit -1;
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, startRow);
			pstmt.setInt(2, endRow);
			
			rs = pstmt.executeQuery();
			while(rs.next()) {
				AdOrderList ad = new AdOrderList(rs.getInt("sale_id"),
												rs.getString("status"),
												rs.getDate("sale_Date"),
												rs.getString("pName"),
												rs.getString("userId"),
												rs.getInt("sCount"),
												rs.getString("daName"),
												rs.getString("orPhone"),
												rs.getString("daAddress"),
												rs.getInt("pid"),
												rs.getInt("cid"));
				
				oList.add(ad);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
			close(rs);
		}
		
		return oList;
	}

	public int UpdateRefund(Connection conn, int saleId) {
		PreparedStatement pstmt = null;

		int result = 0;
		String query = prop.getProperty("UpdateRefund");
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, saleId);
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		
		
		return result;
	}

	public int getsViewColCount(Connection conn, int sid) {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		int result = 0;
		String query = prop.getProperty("getsViewColCount");
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, sid);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				result = rs.getInt(1);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
			close(rs);
		}
		
		return result;
	}
	// 한명의 판매자 등록 물품 정보
	public ArrayList<PList> sViewPTableCol(Connection conn, int sid, int currentPage, int limit) {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		ArrayList<PList> pList = new ArrayList<PList>();
		String query = prop.getProperty("sViewPTableCol");
		
		int startRow = (currentPage-1)*limit +1;	
		int endRow = startRow + limit -1;
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, sid);
			pstmt.setInt(2, startRow);
			pstmt.setInt(3, endRow);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				PList p = new PList(rs.getInt("pid"),
									rs.getString("pName"),
									rs.getInt("pPrice"),
									rs.getString("pday"),
									rs.getString("PPERIOD"),
									rs.getDate("CREAREDATE"),
									rs.getString("status"));
				
				pList.add(p);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
			close(rs);
		}
		
		return pList;
	}

	public int pChartDate(Connection conn, int pid) {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		int result = 0;
		String query = prop.getProperty("pChartDate");
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, pid);
			
			rs = pstmt.executeQuery();
			if(rs.next()) {
				result = rs.getInt(1);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
			close(rs);
		}
		
		
		
		return result;
	}

	public int pInventory(Connection conn, int pid) {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		int result = 0;
		String query = prop.getProperty("pInventory");
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, pid);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				result =rs.getInt(1);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
			close(rs);
		}
		
		return result;
	}

	public int pChartAllDate(Connection conn, int sid) {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		int result = 0;
		String query = prop.getProperty("pChartAllDate");
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, sid);
			
			rs = pstmt.executeQuery();
			while(rs.next()) {
				result += rs.getInt(1);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
			close(rs);
		}
		
		
		
		return result;
	}

	public int pAllInventory(Connection conn, int sid) {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		int result = 0;
		String query = prop.getProperty("pAllInventory");
		System.out.println(sid);
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, sid);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				result +=rs.getInt(1);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
			close(rs);
		}
		
		return result;
	}
	
}
