package LF.adminPage.model.vo;

import java.io.Serializable;

public class ChartPData implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 8828995596098773547L;
	private int sale;
	private int pCount;
	public ChartPData() {
	}
	public ChartPData(int sale, int pCount) {
		this.sale = sale;
		this.pCount = pCount;
	}
	public int getSale() {
		return sale;
	}
	public void setSale(int sale) {
		this.sale = sale;
	}
	public int getpCount() {
		return pCount;
	}
	public void setpCount(int pCount) {
		this.pCount = pCount;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	@Override
	public String toString() {
		return "ChartPData [sale=" + sale + ", pCount=" + pCount + "]";
	}
	
	
	
}
