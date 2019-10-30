package LF.board.model.service;

import static LF.common.JDBCTemplate.close;
import static LF.common.JDBCTemplate.commit;
import static LF.common.JDBCTemplate.getConnection;
import static LF.common.JDBCTemplate.rollback;

import java.sql.Connection;
import java.util.ArrayList;

import LF.board.model.dao.BoardDao;
import LF.board.model.vo.Attachment;
import LF.board.model.vo.Basket;
import LF.board.model.vo.Board;
import LF.board.model.vo.PaymentInfo;
import LF.board.model.vo.Reply;

public class BoardService {
	
	public int insertThumbnail(Board b, ArrayList<Attachment> fileList) {
		Connection conn = getConnection();
		
		// BoardDao 메소드 두개를 호출하자
		BoardDao bDao = new BoardDao();
		
		int result1 = bDao.insertThBoard(conn,b);
		int result2 = bDao.insertAttachment(conn,fileList);
		
		int result = 0;
		
		if(result1>0 && result2>0) {
			commit(conn);
			result =1;
		}else {
			rollback(conn);
		}
		
		close(conn);
		
		return result;
	}
	
	public Board selectBoard(int pId) {
		Connection conn = getConnection();
		
		Board b = new Board();
		BoardDao bDao = new BoardDao();
		
		b=bDao.selectBoard(conn,pId);
	
		close(conn);
		
		return b;
	}
	
	public ArrayList<Attachment> selectThumbnail(int pId) {
		Connection conn = getConnection();
		
		ArrayList<Attachment> list = new BoardDao().selectThumbnail(conn,pId);
		
		close(conn);
		
		return list;
	}

	public int insertPayInfo(PaymentInfo p) {
		Connection conn = getConnection();
		
		int result = new BoardDao().insertBoard(conn, p);
		
		if(result>0) {
			commit(conn);
		}else {
			rollback(conn);
		}
		close(conn);
		
		return result;
	}
	/*
	 * public int updateCount(int count, int pid, ) { Connection conn =
	 * getConnection();
	 * 
	 * int result = new BoardDao().updateCount(conn, pid);
	 * 
	 * if(result>0) { commit(conn); }else { rollback(conn); } close(conn);
	 * 
	 * return result; }
	 */

	public int updatePListInfo(int pid, int count) {
		Connection conn = getConnection();
		int result = new BoardDao().updatePListInfo(conn, pid, count);
		
		if(result >0) {
			commit(conn);
		}else {
			rollback(conn);
		}
		
		close(conn);
		
		return result;
	}

	public int insertBasket(Basket b) {
		Connection conn = getConnection();
		
		int result = new BoardDao().insertBasket(conn, b);
		
		if(result>0) {
			commit(conn);
		}else {
			rollback(conn);
		}
		close(conn);
		
		return result;
	}

	public ArrayList<Reply> selectReply(int pId) {
		Connection conn = getConnection();
		
		ArrayList<Reply> r = new BoardDao().selectReply(conn, pId);
		
		close(conn);
		
		return r;
	}
	
	

}
