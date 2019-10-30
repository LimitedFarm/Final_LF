package LF.adminPage.model.vo;

import java.io.Serializable;
import java.sql.Date;

public class SInfo implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 7850464964063821844L;
	private int cid;
	private int sid;
	private String userId;
	private String userName;
	private String address2;
	private String address3;
	private String phone;
	private String email;
	private String bName;
	private String bNum;
	private String AcNum;
	private String AcName;
	private String bankName;
	private Date sJoinDate;
	private int fid;
	private String bStatus;
	
	public SInfo() {
	}

	public SInfo(int cid, int sid, String userId, String userName, String address2, String address3, String phone,
			String email, String bName, String bNum, String acNum, String acName, String bankName, Date sJoinDate,
			int fid, String bStatus) {
		this.cid = cid;
		this.sid = sid;
		this.userId = userId;
		this.userName = userName;
		this.address2 = address2;
		this.address3 = address3;
		this.phone = phone;
		this.email = email;
		this.bName = bName;
		this.bNum = bNum;
		AcNum = acNum;
		AcName = acName;
		this.bankName = bankName;
		this.sJoinDate = sJoinDate;
		this.fid = fid;
		this.bStatus = bStatus;
	}
	
	public int getCid() {
		return cid;
	}

	public void setCid(int cid) {
		this.cid = cid;
	}

	public int getSid() {
		return sid;
	}

	public void setSid(int sid) {
		this.sid = sid;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
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

	public String getbName() {
		return bName;
	}

	public void setbName(String bName) {
		this.bName = bName;
	}

	public String getbNum() {
		return bNum;
	}

	public void setbNum(String bNum) {
		this.bNum = bNum;
	}

	public String getAcNum() {
		return AcNum;
	}

	public void setAcNum(String acNum) {
		AcNum = acNum;
	}

	public String getAcName() {
		return AcName;
	}

	public void setAcName(String acName) {
		AcName = acName;
	}

	public String getBankName() {
		return bankName;
	}

	public void setBankName(String bankName) {
		this.bankName = bankName;
	}

	public Date getsJoinDate() {
		return sJoinDate;
	}

	public void setsJoinDate(Date sJoinDate) {
		this.sJoinDate = sJoinDate;
	}

	public int getFid() {
		return fid;
	}

	public void setFid(int fid) {
		this.fid = fid;
	}

	public String getbStatus() {
		return bStatus;
	}

	public void setbStatus(String bStatus) {
		this.bStatus = bStatus;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public String toString() {
		return "SInfo [cid=" + cid + ", sid=" + sid + ", userId=" + userId + ", userName=" + userName + ", address2="
				+ address2 + ", address3=" + address3 + ", phone=" + phone + ", email=" + email + ", bName=" + bName
				+ ", bNum=" + bNum + ", AcNum=" + AcNum + ", AcName=" + AcName + ", bankName=" + bankName
				+ ", sJoinDate=" + sJoinDate + ", fid=" + fid + ", bStatus=" + bStatus + "]";
	}

	
	
	
}
