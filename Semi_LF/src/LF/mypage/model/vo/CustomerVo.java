package LF.mypage.model.vo;

import java.io.Serializable;
import java.sql.Date;

public class CustomerVo implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -3452414934006290261L;
	
	private int cId;		// 시퀀스 회원 번호
	private String userId;	//회원아이디
	private String userPwd;	//회원비밀번호
	private String address;	//회원주소
	private String address2;//상세주소
	private String address3;//회원주소
	private String phone;	//회원 번호
	private String email;	//회원 이메일
	private Date joinDate;	//회원 가입일자
	private Date modifyDate;//정보 수정일자
	private String status;	//회원 상태정보(탈퇴시 N)
	
	public CustomerVo() {
		
	}

	public CustomerVo(int cId, String userId, String userPwd, String address, String address2, String address3,
			String phone, String email, Date joinDate, Date modifyDate, String status) {
		super();
		this.cId = cId;
		this.userId = userId;
		this.userPwd = userPwd;
		this.address = address;
		this.address2 = address2;
		this.address3 = address3;
		this.phone = phone;
		this.email = email;
		this.joinDate = joinDate;
		this.modifyDate = modifyDate;
		this.status = status;
	}

	public int getcId() {
		return cId;
	}

	public void setcId(int cId) {
		this.cId = cId;
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
		return "CustomerVo [cId=" + cId + ", userId=" + userId + ", userPwd=" + userPwd + ", address=" + address
				+ ", address2=" + address2 + ", address3=" + address3 + ", phone=" + phone + ", email=" + email
				+ ", joinDate=" + joinDate + ", modifyDate=" + modifyDate + ", status=" + status + "]";
	}
}

	