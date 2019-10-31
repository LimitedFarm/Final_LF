package LF.product.model.service;

import static LF.common.JDBCTemplate.close;
import static LF.common.JDBCTemplate.getConnection;

import java.sql.Connection;

import LF.product.model.dao.pAdao;
import LF.product.model.vo.pAttachment;

public class pAservice {

	public pAttachment pAselect(int pId) {
		
		Connection conn = getConnection();
		
		pAttachment pa = new pAdao().selectfid(conn, pId);
		
		
		close(conn);
		
		return pa;
	}

}
