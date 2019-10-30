package LF.seller.model.service;

import static LF.common.JDBCTemplate.close;
import static LF.common.JDBCTemplate.getConnection;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.HashMap;

import org.json.simple.JSONObject;

import com.google.gson.Gson;

import LF.seller.model.dao.ProductDao;
import LF.seller.model.vo.pAttachment;
import LF.seller.model.vo.pList;

public class ProductService {

	public int getListCount(int sid) {
		Connection conn = getConnection();
		
		int listCount = new ProductDao().getListCount(conn, sid);
		
		close(conn);
		
		return listCount;
	}

	public ArrayList<pList> selectList(int currentPage, int limit, int sid) {
		Connection conn = getConnection();
		//1번
		ArrayList<pList> list = new ProductDao().selectList(conn, currentPage, limit, sid);
		
		close(conn);
		
		return list;
	}

	public pList selectpList(int pid) {
		Connection conn = getConnection();
		
		pList pl = new ProductDao().selectpList(conn, pid);
		close(conn);
		return pl;
	}

	public ArrayList<pAttachment> selectpAttachment(int pid) {
		Connection conn = getConnection();
		
		ArrayList<pAttachment> paList = new ProductDao().selectpAttachment(conn, pid);
		close(conn);
		return paList;
	}

	public ArrayList<pAttachment> selectImg(ArrayList<pList> list) {
		Connection conn = getConnection();
		//2번
		ArrayList<pAttachment> paList = new ProductDao().selectImg(conn, list);
		close(conn);
		return paList;
	}
	
	public String  GsonList(int currentPage, int limit, int sid) {
		JSONObject successJObj = new JSONObject();
		
		Connection conn = getConnection();
		//1번 - plist를 가져옴
		ArrayList<pList> list = new ProductDao().selectList(conn, currentPage, limit, sid);
		
		close(conn);
		
		
		//2 - palist를 가져옴
		Connection conn2 = getConnection();
		
		ArrayList<pAttachment> paList = new ProductDao().selectImg(conn2, list);
		
		close(conn2);
		
		//plist값
		HashMap<String, Object> hashList1 = new ProductDao().getpList(list);
		
		HashMap<String, Object> hashList2 = new ProductDao().getpaList(paList);
		
		
		HashMap<String, HashMap<String,Object>> hash1 = new HashMap<>();
//		ArrayList<HashMap<String,Object>> hash2 = new ArrayList<>();
		hash1.put("hash1",hashList1);
		hash1.put("hash2",hashList2);
		
//		System.out.println("Service hash2 = " + hash2);

//		successJObj.put("hash1", hashList1);
//		successJObj.put("hash2", hashList1);
		
//		hashArr.add(successJObj);
		
		Gson gson = new Gson();
		String json = gson.toJson(hash1);
		
//		System.out.println("Service return successJObj = " + successJObj);
		
//		return hashArr;
		return json;
	}

}
