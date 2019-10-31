package LF.adminPage.model.vo;

import java.io.Serializable;

public class AdPList implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 187443236811325223L;
	private int pId;
	private String uesrName;
	private String userId;
	private String bName;
	private String pName;
	private String pAddress;
	private int pCount;
	private int pPrice;
	private String pDay;
	private int cateId;
	private String status;

	public AdPList() {
	}

	public AdPList(int pId, String uesrName, String userId, String bName, String pName, String pAddress, int pCount,
			int pPrice, String pDay, int cateId, String status) {
		this.pId = pId;
		this.uesrName = uesrName;
		this.userId = userId;
		this.bName = bName;
		this.pName = pName;
		this.pAddress = pAddress;
		this.pCount = pCount;
		this.pPrice = pPrice;
		this.pDay = pDay;
		this.cateId = cateId;
		this.status = status;
	}

	public int getpId() {
		return pId;
	}

	public void setpId(int pId) {
		this.pId = pId;
	}

	public String getUesrName() {
		return uesrName;
	}

	public void setUesrName(String uesrName) {
		this.uesrName = uesrName;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getbName() {
		return bName;
	}

	public void setbName(String bName) {
		this.bName = bName;
	}

	public String getpName() {
		return pName;
	}

	public void setpName(String pName) {
		this.pName = pName;
	}

	public String getpAddress() {
		return pAddress;
	}

	public void setpAddress(String pAddress) {
		this.pAddress = pAddress;
	}

	public int getpCount() {
		return pCount;
	}

	public void setpCount(int pCount) {
		this.pCount = pCount;
	}

	public int getpPrice() {
		return pPrice;
	}

	public void setpPrice(int pPrice) {
		this.pPrice = pPrice;
	}

	public String getpDay() {
		return pDay;
	}

	public void setpDay(String pDay) {
		this.pDay = pDay;
	}

	public int getCateId() {
		return cateId;
	}

	public void setCateId(int cateId) {
		this.cateId = cateId;
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
		return "AdPList [pId=" + pId + ", uesrName=" + uesrName + ", userId=" + userId + ", bName=" + bName + ", pName="
				+ pName + ", pAddress=" + pAddress + ", pCount=" + pCount + ", pPrice=" + pPrice + ", pDay=" + pDay
				+ ", cateId=" + cateId + ", status=" + status + "]";
	}

}
