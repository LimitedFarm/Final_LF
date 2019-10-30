package LF.faq.model.service;

import static LF.common.JDBCTemplate.*;


import java.sql.Connection;
import java.util.ArrayList;

import LF.faq.model.dao.OboDao;
import LF.faq.model.vo.Pattachment;
import LF.faq.model.vo.Question;

public class OboService {

	public int insertObo(Question q, ArrayList<Pattachment> fileList) {
				Connection conn = getConnection();
				
				OboDao oDao = new OboDao();
				
				int result1 = oDao.insertObo(conn,q);
				int result2 = oDao.insertAttachment(conn,fileList);
				
				int result = 0;
				
				if(result1>0 && result2>0 || result1>0) {
					commit(conn);
					result = 1;
				}else {
					rollback(conn);
				}
				
				close(conn);
		return result;
	}

	

	
}
