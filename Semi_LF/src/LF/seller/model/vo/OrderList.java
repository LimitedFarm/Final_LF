package LF.seller.model.vo;

import java.io.Serializable;
import java.sql.Date;

public class OrderList implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 570920664598110862L;
	private int saleId;
	private String status;
	private String pName;
	private Date saleDate;
	private int sCount;
	private String daName;
	private String orPhone;
	private String daAddress;
	private String daMessage;
	private int pid;
	private int sid;
	private int cid;
	
	public OrderList() {
		super();
	}
	
	public OrderList(String pName, int sCount, String daName, String daMessage) {
		super();
		this.pName = pName;
		this.sCount = sCount;
		this.daName = daName;
		this.daMessage = daMessage;
	}
	
	
	public OrderList(int pid, String pName, int sCount, String daName, String daMessage, int saleId  ) {
		super();
		this.saleId = saleId;
		this.pName = pName;
		this.sCount = sCount;
		this.daName = daName;
		this.daMessage = daMessage;
		this.pid = pid;
	}



	public OrderList(int saleId, String status, String pName, Date saleDate, int sCount, String daName, String orPhone,
			String daAddress, String daMessage, int pid, int sid, int cid) {
		super();
		this.saleId = saleId;
		this.status = status;
		this.pName = pName;
		this.saleDate = saleDate;
		this.sCount = sCount;
		this.daName = daName;
		this.orPhone = orPhone;
		this.daAddress = daAddress;
		this.daMessage = daMessage;
		this.pid = pid;
		this.sid = sid;
		this.cid = cid;
	}

	public int getSaleId() {
		return saleId;
	}

	public void setSaleId(int saleId) {
		this.saleId = saleId;
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

	public Date getSaleDate() {
		return saleDate;
	}

	public void setSaleDate(Date saleDate) {
		this.saleDate = saleDate;
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

	@Override
	public String toString() {
		return "OrderList [saleId=" + saleId + ", status=" + status + ", pName=" + pName + ", saleDate=" + saleDate
				+ ", sCount=" + sCount + ", daName=" + daName + ", orPhone=" + orPhone + ", daAddress=" + daAddress
				+ ", daMessage=" + daMessage + ", pid=" + pid + ", sid=" + sid + ", cid=" + cid + "]";
	}
	
	
	
	
	

}
