package LF.seller.model.vo;

import java.io.Serializable;

public class pInfo implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 3274660199358798791L;
	private int infoNum;	//정보 순서
	private String pCountent;	//제품 정보
	private int fId;	//파일 번호
	private int pId;	//물품 번호
	private int sId;	//판매자 번호
	
	
	public pInfo() {
		super();
	}


	public pInfo(int infoNum, String pCountent, int fId, int pId, int sId) {
		super();
		this.infoNum = infoNum;
		this.pCountent = pCountent;
		this.fId = fId;
		this.pId = pId;
		this.sId = sId;
	}


	public int getInfoNum() {
		return infoNum;
	}


	public void setInfoNum(int infoNum) {
		this.infoNum = infoNum;
	}


	public String getpCountent() {
		return pCountent;
	}


	public void setpCountent(String pCountent) {
		this.pCountent = pCountent;
	}


	public int getfId() {
		return fId;
	}


	public void setfId(int fId) {
		this.fId = fId;
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


	@Override
	public String toString() {
		return "pInfo [infoNum=" + infoNum + ", pCountent=" + pCountent + ", fId=" + fId + ", pId=" + pId + ", sId="
				+ sId + "]";
	}
	
	
	
	

}
