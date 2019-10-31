package LF.mypage.model.service;

import static LF.common.JDBCTemplate.close;
import static LF.common.JDBCTemplate.getConnection;

import java.sql.Connection;
import java.util.ArrayList;

import LF.mypage.model.dao.BasketDao;
import LF.mypage.model.vo.BasketVo;
import LF.product.model.vo.pAttachment;

public class BasketService {

	public BasketService() {

	}

	public int selectBasketListCount(int cId) {
		Connection conn = getConnection();

		int listCount = new BasketDao().selectBasketListCount(conn, cId);

		close(conn);

		return listCount;

	}

	public ArrayList<BasketVo> selectBasketList(int cId) {
		Connection conn = getConnection();

		ArrayList<BasketVo> orderList = new BasketDao().selectBasketList(conn, cId);

		close(conn);

		return orderList;
	}
	
	public int deleteBasket(String[] checkArr) {
		Connection conn = getConnection();
		
		int result = new BasketDao().deleteBasket(conn, checkArr);
		
		close(conn);
		
		return result;
	}
	
	public String selectImgPath(int pId) {
		Connection conn = getConnection();

		String imgPath = new BasketDao().selectImgPath(conn, pId);

		close(conn);

		return imgPath;

	}

}
