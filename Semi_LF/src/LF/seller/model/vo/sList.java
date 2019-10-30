package LF.seller.model.vo;

import java.io.Serializable;
import java.sql.Date;

public class sList implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 4072647155971166147L;
	private int sale_Id;	//판매번호. 나는 주문번호로 인식하고 사용할것임
	private char status;	//주문 상태, Y 디폴트 : 주문상태, N은 주문 취소. 또는 환불
	private Date sale_date;	//판매 날짜, 또는 주문일시
	private int sCount;	//판매 수량, 또는 주문 수량
	private int pId;	//물품번호. 판매물품 테이블에 대한 외래키 식별자 (물품 정보)
	private int sId;	//판매자 번호. 판매자 테이블에 대한 외래키 식별자 (판매자 정보)
	private int cId;	//회원번호. 일반 회원 테이블에 대한 외래키 식별자 (구매자 정보)
	
	
	public sList() {
		super();
	}


	public sList(int sale_Id, char status, Date sale_date, int sCount, int pId, int sId, int cId) {
		super();
		this.sale_Id = sale_Id;
		this.status = status;
		this.sale_date = sale_date;
		this.sCount = sCount;
		this.pId = pId;
		this.sId = sId;
		this.cId = cId;
	}


	public int getSale_Id() {
		return sale_Id;
	}


	public void setSale_Id(int sale_Id) {
		this.sale_Id = sale_Id;
	}


	public char getStatus() {
		return status;
	}


	public void setStatus(char status) {
		this.status = status;
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


	public int getcId() {
		return cId;
	}


	public void setcId(int cId) {
		this.cId = cId;
	}


	@Override
	public String toString() {
		return "sList [sale_Id=" + sale_Id + ", status=" + status + ", sale_date=" + sale_date + ", sCount=" + sCount
				+ ", pId=" + pId + ", sId=" + sId + ", cId=" + cId + "]";
	}

	
	
	
	
}
