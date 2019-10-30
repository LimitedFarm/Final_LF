package LF.board.model.vo;

import java.io.Serializable;
import java.sql.Date;

public class Board implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1821429884843565082L;
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
	private String pText5;
	private String pNotice;
	private String pDelivery;
	private Date cRearedate;
	private Date pModifydate;
	private String status;
	private int cAteid;
	
	
	public Board() {
	}


	public Board(int pId, int sId, String pName, int pPrice, int pCount, String pAddress, String pDay, String pPeriod,
			String pText1, String pText2, String pText3, String pText4, String pText5, String pNotice, String pDelivery,
			Date cRearedate, Date pModifydate, String status, int cAteid) {
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
		this.pText5 = pText5;
		this.pNotice = pNotice;
		this.pDelivery = pDelivery;
		this.cRearedate = cRearedate;
		this.pModifydate = pModifydate;
		this.status = status;
		this.cAteid = cAteid;
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


	public void setpPrice(int pPrice) {
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


	public String getpText5() {
		return pText5;
	}


	public void setpText5(String pText5) {
		this.pText5 = pText5;
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


	public Date getcRearedate() {
		return cRearedate;
	}


	public void setcRearedate(Date cRearedate) {
		this.cRearedate = cRearedate;
	}


	public Date getpModifydate() {
		return pModifydate;
	}


	public void setpModifydate(Date pModifydate) {
		this.pModifydate = pModifydate;
	}


	public String getStatus() {
		return status;
	}


	public void setStatus(String status) {
		this.status = status;
	}


	public int getcAteid() {
		return cAteid;
	}


	public void setcAteid(int cAteid) {
		this.cAteid = cAteid;
	}


	public static long getSerialversionuid() {
		return serialVersionUID;
	}


	@Override
	public String toString() {
		return "Board [pId=" + pId + ", sId=" + sId + ", pName=" + pName + ", pPrice=" + pPrice + ", pCount=" + pCount
				+ ", pAddress=" + pAddress + ", pDay=" + pDay + ", pPeriod=" + pPeriod + ", pText1=" + pText1
				+ ", pText2=" + pText2 + ", pText3=" + pText3 + ", pText4=" + pText4 + ", pText5=" + pText5
				+ ", pNotice=" + pNotice + ", pDelivery=" + pDelivery + ", cRearedate=" + cRearedate + ", pModifydate="
				+ pModifydate + ", status=" + status + ", cAteid=" + cAteid + "]";
	}


	
	
	
	

	
}
