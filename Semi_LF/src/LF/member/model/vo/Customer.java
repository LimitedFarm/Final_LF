package LF.member.model.vo;

import java.io.Serializable;
import java.sql.Date;

public class Customer implements Serializable{
	/**
	 * 회원
	 */
	private static final long serialVersionUID = -7365148241102009207L;
	
	
	private int cid;
	private String userId;
	private String userPwd;
	private String userName;
	private String address;
	private String address2;
	private String address3;
	private String phone;
	private String email;
	private Date joinDate;
	private Date modifyDate;
	private String groupNum;
	private String status;
	
	public Customer() {}

	public Customer(int cid, String userId, String userPwd, String userName, String address, String address2,
			String address3, String phone, String email, Date joinDate, Date modifyDate, String groupNum,
			String status) {
		this.cid = cid;
		this.userId = userId;
		this.userPwd = userPwd;
		this.userName = userName;
		this.address = address;
		this.address2 = address2;
		this.address3 = address3;
		this.phone = phone;
		this.email = email;
		this.joinDate = joinDate;
		this.modifyDate = modifyDate;
		this.groupNum = groupNum;
		this.status = status;
	}
	
	

	public Customer(String userId, String userPwd, String userName, String address, String address2, String address3,
			String phone, String email) {
		this.userId = userId;
		this.userPwd = userPwd;
		this.userName = userName;
		this.address = address;
		this.address2 = address2;
		this.address3 = address3;
		this.phone = phone;
		this.email = email;
	}

	public int getCid() {
		return cid;
	}

	public void setCid(int cid) {
		this.cid = cid;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getUserPwd() {
		return userPwd;
	}

	public void setUserPwd(String userPwd) {
		this.userPwd = userPwd;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getAddress2() {
		return address2;
	}

	public void setAddress2(String address2) {
		this.address2 = address2;
	}

	public String getAddress3() {
		return address3;
	}

	public void setAddress3(String address3) {
		this.address3 = address3;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Date getJoinDate() {
		return joinDate;
	}

	public void setJoinDate(Date joinDate) {
		this.joinDate = joinDate;
	}

	public Date getModifyDate() {
		return modifyDate;
	}

	public void setModifyDate(Date modifyDate) {
		this.modifyDate = modifyDate;
	}

	public String getGroupNum() {
		return groupNum;
	}

	public void setGroupNum(String groupNum) {
		this.groupNum = groupNum;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public String toString() {
		return "Customer [cid=" + cid + ", userId=" + userId + ", userPwd=" + userPwd + ", userName=" + userName
				+ ", address=" + address + ", address2=" + address2 + ", address3=" + address3 + ", phone=" + phone
				+ ", email=" + email + ", joinDate=" + joinDate + ", modifyDate=" + modifyDate + ", groupNum="
				+ groupNum + ", status=" + status + "]";
	}

	
	
}
