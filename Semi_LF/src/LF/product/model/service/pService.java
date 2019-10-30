package LF.product.model.service;

import static LF.common.JDBCTemplate.*;


import java.sql.Connection;
import java.util.ArrayList;

import LF.product.model.dao.ProductDao;
import LF.product.model.vo.ProductList;

public class pService {

	public ArrayList<ProductList> selectList() {
			Connection conn = getConnection();
		
			ArrayList<ProductList> plist = new ProductDao().selectList(conn);
			
			close(conn);
	
			return plist;
	}

	public ArrayList<ProductList> SelectCate(int cateNum) {
		Connection conn = getConnection();
		
		ArrayList<ProductList> scplist = new ProductDao().scpselelctList(conn, cateNum);
		System.out.println("service : " + scplist);
		close(conn);
		return scplist;
	}

	public int getListCount() {
		Connection conn = getConnection();
		
		int listCount = new ProductDao().getListCount(conn);
		
		close(conn);
		
		return listCount;
	}

}
