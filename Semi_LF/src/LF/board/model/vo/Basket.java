package LF.board.model.vo;

import java.io.Serializable;

public class Basket implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -4512981325430241916L;
	
	private int basketId;
	private int cId;
	private int count;
	private int pId;
	private int sId;
	public Basket() {
	}
	public Basket(int basketId, int cId, int count, int pId, int sId) {
		super();
		this.basketId = basketId;
		this.cId = cId;
		this.count = count;
		this.pId = pId;
		this.sId = sId;
	}
	public int getBasketId() {
		return basketId;
	}
	public void setBasketId(int basketId) {
		this.basketId = basketId;
	}
	public int getcId() {
		return cId;
	}
	public void setcId(int cId) {
		this.cId = cId;
	}
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
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
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	@Override
	public String toString() {
		return "Basket [basketId=" + basketId + ", cId=" + cId + ", count=" + count + ", pId=" + pId + ", sId=" + sId
				+ "]";
	}
	
	
	
	

}
