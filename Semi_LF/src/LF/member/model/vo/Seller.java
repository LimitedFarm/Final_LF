package LF.member.model.vo;

import java.io.Serializable;
import java.sql.Date;

public class Seller implements Serializable{
	
	/**
	 * 판매자
	 */
	private static final long serialVersionUID = 3585484310834257559L;
	
	private int sid;
	private String bStatus;
	private String bName;
	private String bNum;
	private String cpNum;
	private String acNum;
	private String acName;
	private String bankName;
	private Date sJoinDate;
	private Date sModifyDate;
	private int cid;
	private int fid;
	
	public Seller() {}

	public Seller(int sid, String bStatus, String bName, String bNum, String cpNum, String acNum, String acName,
			String bankName, Date sJoinDate, Date sModifyDate, int cid, int fid) {
		this.sid = sid;
		this.bStatus = bStatus;
		this.bName = bName;
		this.bNum = bNum;
		this.cpNum = cpNum;
		this.acNum = acNum;
		this.acName = acName;
		this.bankName = bankName;
		this.sJoinDate = sJoinDate;
		this.sModifyDate = sModifyDate;
		this.cid = cid;
		this.fid = fid;
	}

	
	
	public Seller(String bName2, String bNum2, String cpNum2, String acNum2, String acName2, String bankName2,
			int cId2) {
		this.bName = bName2;
		this.bNum = bNum2;
		this.cpNum = cpNum2;
		this.acNum = acNum2;
		this.acName = acName2;
		this.bankName = bankName2;
		this.cid = cId2;
	}

	public int getSid() {
		return sid;
	}

	public void setSid(int sid) {
		this.sid = sid;
	}

	public String getbStatus() {
		return bStatus;
	}

	public void setbStatus(String bStatus) {
		this.bStatus = bStatus;
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

	public String getCpNum() {
		return cpNum;
	}

	public void setCpNum(String cpNum) {
		this.cpNum = cpNum;
	}

	public String getAcNum() {
		return acNum;
	}

	public void setAcNum(String acNum) {
		this.acNum = acNum;
	}

	public String getAcName() {
		return acName;
	}

	public void setAcName(String acName) {
		this.acName = acName;
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

	public Date getsModifyDate() {
		return sModifyDate;
	}

	public void setsModifyDate(Date sModifyDate) {
		this.sModifyDate = sModifyDate;
	}

	public int getCid() {
		return cid;
	}

	public void setCid(int cid) {
		this.cid = cid;
	}

	public int getFid() {
		return fid;
	}

	public void setFid(int fid) {
		this.fid = fid;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public String toString() {
		return "Seller [sid=" + sid + ", bStatus=" + bStatus + ", bName=" + bName + ", bNum=" + bNum + ", cpNum="
				+ cpNum + ", acNum=" + acNum + ", acName=" + acName + ", bankName=" + bankName + ", sJoinDate="
				+ sJoinDate + ", sModifyDate=" + sModifyDate + ", cid=" + cid + ", fid=" + fid + "]";
	}

	
	
}
