package LF.seller.model.vo;

import java.io.Serializable;

public class aChart implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -7088366015755387978L;
	private int aChart;
	private String pName;
	public aChart() {
		super();
	}
	public aChart(int aChart, String pName) {
		super();
		this.aChart = aChart;
		this.pName = pName;
	}
	public int getaChart() {
		return aChart;
	}
	public void setaChart(int aChart) {
		this.aChart = aChart;
	}
	public String getpName() {
		return pName;
	}
	public void setpName(String pName) {
		this.pName = pName;
	}
	@Override
	public String toString() {
		return "aChart [aChart=" + aChart + ", pName=" + pName + "]";
	}
	
	

}
