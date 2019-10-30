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
import java.util.HashMap;
import java.util.Properties;

import LF.seller.model.vo.pAttachment;
import LF.seller.model.vo.pList;

public class ProductDao {
	Properties prop = new Properties();

	public ProductDao() {
		String fileName = ProductDao.class.getResource("/LF/sql/seller/product-query.properties").getPath();
		
		try {
			prop.load(new FileReader(fileName));
		} catch (FileNotFoundException e) {		
			e.printStackTrace();
		} catch (IOException e) {	
			e.printStackTrace();
		}
	}
	public int getListCount(Connection conn, int sid) {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		int listCount = 0;
		
		String query = prop.getProperty("getListCount");
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, sid);
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
	
	public ArrayList<pList> selectList(Connection conn, int currentPage, int limit, int sid) {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		ArrayList<pList>list = null;
		
		String query = prop.getProperty("selectList");
		
		// 쿼리문 실행시 조건절에 넣을 변수들(rownum에 대한 조건 시 필요)
		int startRow = (currentPage-1)*limit +1;	//(2-1) * 5 + 1
		// ex) 2page면 시작 번호가 11번일 것이다.
		int endRow = startRow + limit -1;		//(6+5) - 1
		
		try {
			pstmt = conn.prepareStatement(query);
			
			pstmt.setInt(1, sid);
			pstmt.setInt(2, startRow);
			pstmt.setInt(3, endRow); 	// 1은 게시판 타입을 의미함 -> 1=일반게시판, 2=사진게시판
			
			rs=pstmt.executeQuery();
			list = new ArrayList<pList>();	// 컬렉션(ArrayList)는 반드시 기본생성자로 초기화 해놓고 활용하자!!
			System.out.println("Product Dao select pList = " + list);
			
			while(rs.next()) {
				
				pList b = new pList(rs.getInt("pid"),
									rs.getInt("sid"),
									rs.getString("pname"),
									rs.getInt("pprice"),
									rs.getInt("pcount"),
									rs.getString("paddress"),
									rs.getString("pday"),
									rs.getString("pperiod"),
									rs.getString("ptext1"),
									rs.getString("ptext2"),
									rs.getString("ptext3"),
									rs.getString("ptext4"),
									rs.getString("ptext5"),
									rs.getString("pnotice"),
									rs.getString("pdelivery"),
									rs.getDate("crearedate"),
									rs.getDate("pmodifydate"),
									rs.getString("status"),
									rs.getInt("cateid")
						);
				System.out.println("ProductDao pList while = " + b);
				list.add(b);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rs);
			close(pstmt);
		}
 
		System.out.println("Dao pList return = " +list);
		return list;
	}
	
	public pList selectpList(Connection conn, int pid) {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		pList pl = null;
		
		String query = prop.getProperty("selectpList");
		
		
		try {
			pstmt = conn.prepareStatement(query);
			
			pstmt.setInt(1, pid);
			
			rs=pstmt.executeQuery();
			
			while(rs.next()) {
				
				pl = new pList(rs.getInt("pid"),
									rs.getInt("sid"),
									rs.getString("pname"),
									rs.getInt("pprice"),
									rs.getInt("pcount"),
									rs.getString("paddress"),
									rs.getString("pday"),
									rs.getString("pperiod"),
									rs.getString("ptext1"),
									rs.getString("ptext2"),
									rs.getString("ptext3"),
									rs.getString("ptext4"),
									rs.getString("ptext5"),
									rs.getString("pnotice"),
									rs.getString("pdelivery"),
									rs.getDate("crearedate"),
									rs.getDate("pmodifydate"),
									rs.getString("status"),
									rs.getInt("cateid")
						);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rs);
			close(pstmt);
		}

		return pl;
	}
	
	public ArrayList<pAttachment> selectpAttachment(Connection conn, int pid) {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		String query = prop.getProperty("selectpList");
		
		ArrayList<pAttachment> list = null;
		
		try {
			pstmt = conn.prepareStatement(query);
			
			pstmt.setInt(1, pid);
			
			rs=pstmt.executeQuery();
			
			list = new ArrayList<pAttachment>();
			
			while(rs.next()) {
				pAttachment at = new pAttachment();
				at.setfId(rs.getInt("fid"));
				at.setpId(rs.getInt("pid"));
				at.setFileName(rs.getString("File_name"));
				at.setChangeName(rs.getString("change_name"));
				at.setFilePath(rs.getString("file_path"));
				at.setUploadDate(rs.getDate("upload_date"));
				at.setModifyDate(rs.getDate("modify_date"));
				at.setStatus(rs.getString("status"));
				
				list.add(at);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rs);
			close(pstmt);
		}
		
		return list;
	}
	public ArrayList<pAttachment> selectImg(Connection conn, ArrayList<pList> plist) {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		String query = prop.getProperty("selectpList");
		
		ArrayList<pAttachment> list = null;
		try {
			list = new ArrayList<pAttachment>();
			for(int i=0; i<plist.size(); i++) {
				System.out.println("Dao pList.get(i).getpId = " + plist.get(i).getpId());
				pstmt = conn.prepareStatement(query);
				pstmt.setInt(1, plist.get(i).getpId());
				rs=pstmt.executeQuery();
				System.out.println("Dao pList rs = "+ rs);
				while(rs.next()) {
					pAttachment at = new pAttachment();
					at.setfId(rs.getInt("fid"));
					at.setpId(rs.getInt("pid"));
					at.setFileName(rs.getString("File_name"));
					at.setChangeName(rs.getString("change_name"));
					at.setFilePath(rs.getString("file_path"));
					at.setUploadDate(rs.getDate("upload_date"));
					at.setModifyDate(rs.getDate("modify_date"));
					at.setStatus(rs.getString("status"));
					at.setFileLevel(rs.getInt("filelevel"));
					
					System.out.println("Dao pList while at = " + at);
					list.add(at);
				}
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rs);
			close(pstmt);
		}
		
		System.out.println("Dao pList return = " + list);
		return list;

	}
	public HashMap<String, Object> getpList(ArrayList<pList> list) {
		System.out.println("Dao getpList list = " + list);
		//리스트 객체를 맵으로 바꿔서 내보내기
//		String[] listK = {"pId", "sId", "pName", "pPrice", "pCount", "pAddress", "pDay", "pPeriod", "pText1", "pText2", "pText3", "pText4", "pText5", "pNotice",
//				"pDelivery", "createDate", "pModifyDate", "status", "cateId"};
		
//		String[][] keyN= new String[list.size()][listK.length];
		String [] keyN = new String[list.size()];
//		System.out.println("Dao getpList keyN Size = " + list.size() + "," +listK.length);
		System.out.println("Dao getplist keyN Size = " + keyN.length +", " + list.size());
		//키 값 만들기
//		for(int i=0; i<list.size();i++) {
//			for(int j=0; j<listK.length;j++) {
//				keyN[i][j] = listK[j];
//				System.out.println("Dao getpList keyN[i] = " + keyN[i]);
//			}
//		}
		for(int i=0; i<list.size();i++) {
			keyN[i] = "pList" + Integer.valueOf(i);
			System.out.println("Dao getpList keyN[i] = " +keyN[i]);
		}
		
		HashMap< String, Object > arrMap = new HashMap<>();
		//value 입력
			for(int i=0; i<list.size(); i++) {
				
				System.out.println("ProductDao JSON 부분 list.get(i) =" +list.get(i) );
					arrMap.put(keyN[i], list.get(i));
			}

			System.out.println("Dao getpList arrMap = " + arrMap);
			
		return arrMap;
	}
	
	public HashMap<String, Object> getpaList(ArrayList<pAttachment> paList) {
		//리스트 객체를 맵으로 바꿔서 내보내기
		
//		String[] listK = {"fId", "pId", "fileName","changeName", "filePath", "uploadDate", "modifyDate", "status", "fileLevel"};
		String[] keyN = new String[paList.size()];
		 System.out.println("Dao getpaList keyN size = " + keyN.length + ", " + paList.size());
		
		for(int i=0; i<paList.size();i++) {
			keyN[i] = "pAttachment" + Integer.valueOf(i);
			System.out.println("Dao getpaList keyN[i] = " +keyN[i]);
		}
		
				HashMap< String, Object > arrMap = new HashMap<>();
				
					for(int i=0; i<paList.size(); i++) {
						System.out.println("Dao getpalist for paList.get(i) = " + paList.get(i));
							arrMap.put(keyN[i], paList.get(i));
					}

					System.out.println("Dao getpalist return arrMap = " + arrMap);
					
				return arrMap;
	}
	

}
