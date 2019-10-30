package LF.seller.model.vo;

import java.io.Serializable;
import java.sql.Date;

public class pList implements Serializable {
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 3059051936629675815L;
	
	private int pId;
	private int sId;
	private String pName;
	private int pPrice;
	private int pCount;
	private String pAddress;
	private String pDay;
	private String pPeriod;
	private String pText1;
	private String pText2;
	private String pText3;
	private String pText4;
	private String ptext5;
	private String pNotice;
	private String pDelivery;
	private Date createDate;
	private Date pModifyDate;
	private String status;
	private int cateId;
	
	
	public pList() {
		super();
	}


	public pList(int pId, int sId, String pName, int pPrice, int pCount, String pAddress, String pDay, String pPeriod,
			String pText1, String pText2, String pText3, String pText4, String ptext5, String pNotice, String pDelivery,
			Date createDate, Date pModifyDate, String status, int cateId) {
		super();
		this.pId = pId;
		this.sId = sId;
		this.pName = pName;
		this.pPrice = pPrice;
		this.pCount = pCount;
		this.pAddress = pAddress;
		this.pDay = pDay;
		this.pPeriod = pPeriod;
		this.pText1 = pText1;
		this.pText2 = pText2;
		this.pText3 = pText3;
		this.pText4 = pText4;
		this.ptext5 = ptext5;
		this.pNotice = pNotice;
		this.pDelivery = pDelivery;
		this.createDate = createDate;
		this.pModifyDate = pModifyDate;
		this.status = status;
		this.cateId = cateId;
	}


	public int getpId() {
		return pId;
	}


	public void setpId(int pId) {
		this.pId = pId;
	}


	public int getsId() {
		return sId;
	}


	public void setsId(int sId) {
		this.sId = sId;
	}


	public String getpName() {
		return pName;
	}


	public void setpName(String pName) {
		this.pName = pName;
	}


	public int getpPrice() {
		return pPrice;
	}


	public void setnPrice(int pPrice) {
		this.pPrice = pPrice;
	}


	public int getpCount() {
		return pCount;
	}


	public void setpCount(int pCount) {
		this.pCount = pCount;
	}


	public String getpAddress() {
		return pAddress;
	}


	public void setpAddress(String pAddress) {
		this.pAddress = pAddress;
	}


	public String getpDay() {
		return pDay;
	}


	public void setpDay(String pDay) {
		this.pDay = pDay;
	}


	public String getpPeriod() {
		return pPeriod;
	}


	public void setpPeriod(String pPeriod) {
		this.pPeriod = pPeriod;
	}


	public String getpText1() {
		return pText1;
	}


	public void setpText1(String pText1) {
		this.pText1 = pText1;
	}


	public String getpText2() {
		return pText2;
	}


	public void setpText2(String pText2) {
		this.pText2 = pText2;
	}


	public String getpText3() {
		return pText3;
	}


	public void setpText3(String pText3) {
		this.pText3 = pText3;
	}


	public String getpText4() {
		return pText4;
	}


	public void setpText4(String pText4) {
		this.pText4 = pText4;
	}


	public String getPtext5() {
		return ptext5;
	}


	public void setPtext5(String ptext5) {
		this.ptext5 = ptext5;
	}


	public String getpNotice() {
		return pNotice;
	}


	public void setpNotice(String pNotice) {
		this.pNotice = pNotice;
	}


	public String getpDelivery() {
		return pDelivery;
	}


	public void setpDelivery(String pDelivery) {
		this.pDelivery = pDelivery;
	}


	public Date getCreateDate() {
		return createDate;
	}


	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}


	public Date getpModifyDate() {
		return pModifyDate;
	}


	public void setpModifyDate(Date pModifyDate) {
		this.pModifyDate = pModifyDate;
	}


	public String getStatus() {
		return status;
	}


	public void setStatus(String status) {
		this.status = status;
	}


	public int getCateId() {
		return cateId;
	}


	public void setCateId(int cateId) {
		this.cateId = cateId;
	}


	@Override
	public String toString() {
		return "pList [pId=" + pId + ", sId=" + sId + ", pName=" + pName + ", pPrice=" + pPrice + ", pCount=" + pCount
				+ ", pAddress=" + pAddress + ", pDay=" + pDay + ", pPeriod=" + pPeriod + ", pText1=" + pText1
				+ ", pText2=" + pText2 + ", pText3=" + pText3 + ", pText4=" + pText4 + ", ptext5=" + ptext5
				+ ", pNotice=" + pNotice + ", pDelivery=" + pDelivery + ", createDate=" + createDate + ", pModifyDate="
				+ pModifyDate + ", status=" + status + ", cateId=" + cateId + "]";
	}
	
	
	
	
	
	
	

}
