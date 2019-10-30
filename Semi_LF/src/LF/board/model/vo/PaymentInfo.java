package LF.board.model.vo;

import java.io.Serializable;
import java.sql.Date;

public class PaymentInfo implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 8437084856378298338L;
	private int sale_id;
	private String status;
	private String pName;
	private Date sale_date;
	private int sCount;
	private String daName;
	private String orPhone; 
	private String daAddress;
	private String daMessage;
	private int pid;
	private int sid;
	private int cid;
	public PaymentInfo() {
		super();
	}
	public PaymentInfo(int sale_id, String status, String pName, Date sale_date, int sCount, String daName,
			String orPhone, String daAddress, String daMessage, int pid, int sid, int cid) {
		super();
		this.sale_id = sale_id;
		this.status = status;
		this.pName = pName;
		this.sale_date = sale_date;
		this.sCount = sCount;
		this.daName = daName;
		this.orPhone = orPhone;
		this.daAddress = daAddress;
		this.daMessage = daMessage;
		this.pid = pid;
		this.sid = sid;
		this.cid = cid;
	}
	public int getSale_id() {
		return sale_id;
	}
	public void setSale_id(int sale_id) {
		this.sale_id = sale_id;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getpName() {
		return pName;
	}
	public void setpName(String pName) {
		this.pName = pName;
	}
	public Date getSale_date() {
		return sale_date;
	}
	public void setSale_date(Date sale_date) {
		this.sale_date = sale_date;
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
	public String getDaMessage() {
		return daMessage;
	}
	public void setDaMessage(String daMessage) {
		this.daMessage = daMessage;
	}
	public int getPid() {
		return pid;
	}
	public void setPid(int pid) {
		this.pid = pid;
	}
	public int getSid() {
		return sid;
	}
	public void setSid(int sid) {
		this.sid = sid;
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
		return "PaymentInfo [sale_id=" + sale_id + ", status=" + status + ", pName=" + pName + ", sale_date="
				+ sale_date + ", sCount=" + sCount + ", daName=" + daName + ", orPhone=" + orPhone + ", daAddress="
				+ daAddress + ", daMessage=" + daMessage + ", pid=" + pid + ", sid=" + sid + ", cid=" + cid + "]";
	}
	
	
	
	
	
	
}
