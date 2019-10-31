package LF.mypage.model.service;

import static LF.common.JDBCTemplate.close;
import static LF.common.JDBCTemplate.getConnection;

import java.sql.Connection;

import LF.mypage.model.dao.CustomerDao;
import LF.mypage.model.vo.CustomerVo;

public class CustomerService {

	public CustomerService() {

	}
	
	public String getCustomerEmail(int cId) {
		Connection conn = getConnection();
		String email = "";
		
		email = new CustomerDao().getCustomerEmail(conn, cId);
		
		close(conn);
		
		return email;
	}

	public CustomerVo selectCustomer(int cId) {
		Connection conn = getConnection();

		CustomerVo customer = new CustomerDao().selectCustomer(conn, cId);

		close(conn);

		return customer;
	}

	public int modifyCustomer(CustomerVo vo) {
		Connection conn = getConnection();

		int flag = new CustomerDao().modifyCustomer(conn, vo);

		close(conn);

		return flag;
	}

}
