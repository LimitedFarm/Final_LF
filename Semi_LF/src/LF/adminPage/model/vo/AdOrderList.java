package LF.adminPage.model.vo;

import java.io.Serializable;
import java.sql.Date;

public class AdOrderList implements Serializable{
	/**
	 * 주문 내역
	 */
	private static final long serialVersionUID = -4663036651816140709L;
	private int sale_Id;
	private String status;
	private Date sale_Date;
	private String userId;
	private String pName;
	private int sCount;
	private String daName;
	private String orPhone;
	private String daAddress;
	private int pid;
	private int cid;
	public AdOrderList() {
	}
	public AdOrderList(int sale_Id, String status, Date sale_Date, String userId, String pName, int sCount,
			String daName, String orPhone, String daAddress, int pid, int cid) {
		this.sale_Id = sale_Id;
		this.status = status;
		this.sale_Date = sale_Date;
		this.userId = userId;
		this.pName = pName;
		this.sCount = sCount;
		this.daName = daName;
		this.orPhone = orPhone;
		this.daAddress = daAddress;
		this.pid = pid;
		this.cid = cid;
	}
	public int getSale_Id() {
		return sale_Id;
	}
	public void setSale_Id(int sale_Id) {
		this.sale_Id = sale_Id;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public Date getSale_Date() {
		return sale_Date;
	}
	public void setSale_Date(Date sale_Date) {
		this.sale_Date = sale_Date;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getpName() {
		return pName;
	}
	public void setpName(String pName) {
		this.pName = pName;
	}
	public int getsCount() {
		return sCount;
	}
	public void setsCount(int sCount) {
		this.sCount = sCount;
	}
	public String getDaName() {
		return daName;
	}
	public void setDaName(String daName) {
		this.daName = daName;
	}
	public String getOrPhone() {
		return orPhone;
	}
	public void setOrPhone(String orPhone) {
		this.orPhone = orPhone;
	}
	public String getDaAddress() {
		return daAddress;
	}
	public void setDaAddress(String daAddress) {
		this.daAddress = daAddress;
	}
	public int getPid() {
		return pid;
	}
	public void setPid(int pid) {
		this.pid = pid;
	}
	public int getCid() {
		return cid;
	}
	public void setCid(int cid) {
		this.cid = cid;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	@Override
	public String toString() {
		return "AdOrderList [sale_Id=" + sale_Id + ", status=" + status + ", sale_Date=" + sale_Date + ", userId="
				+ userId + ", pName=" + pName + ", sCount=" + sCount + ", daName=" + daName + ", orPhone=" + orPhone
				+ ", daAddress=" + daAddress + ", pid=" + pid + ", cid=" + cid + "]";
	}
	
}
