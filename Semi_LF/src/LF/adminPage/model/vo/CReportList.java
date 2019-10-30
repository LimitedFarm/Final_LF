package LF.adminPage.model.vo;

import java.io.Serializable;
import java.sql.Date;

public class CReportList implements Serializable{
	/**
	 * 고객 신고 내역
	 */
	private static final long serialVersionUID = 5664415076191864592L;
	
	private int cRid;
	private int cId;
	private String noContent;
	private Date report_Date;
	private String status;
	private int sale_Id;
	private String userId;
	private String pName;
	
	
	public CReportList() {}


	public CReportList(int cRid, int cId, String noContent, Date report_Date, String status, int sale_Id, String userId,
			String pName) {
		this.cRid = cRid;
		this.cId = cId;
		this.noContent = noContent;
		this.report_Date = report_Date;
		this.status = status;
		this.sale_Id = sale_Id;
		this.userId = userId;
		this.pName = pName;
	}


	public int getcRid() {
		return cRid;
	}


	public void setcRid(int cRid) {
		this.cRid = cRid;
	}


	public int getcId() {
		return cId;
	}


	public void setcId(int cId) {
		this.cId = cId;
	}


	public String getNoContent() {
		return noContent;
	}


	public void setNoContent(String noContent) {
		this.noContent = noContent;
	}


	public Date getReport_Date() {
		return report_Date;
	}


	public void setReport_Date(Date report_Date) {
		this.report_Date = report_Date;
	}


	public String getStatus() {
		return status;
	}


	public void setStatus(String status) {
		this.status = status;
	}


	public int getSale_Id() {
		return sale_Id;
	}


	public void setSale_Id(int sale_Id) {
		this.sale_Id = sale_Id;
	}


	public String getUserId() {
		return userId;
	}


	public void setUserId(String userId) {
		this.userId = userId;
	}


	public String getpName() {
		return pName;
	}


	public void setpName(String pName) {
		this.pName = pName;
	}


	public static long getSerialversionuid() {
		return serialVersionUID;
	}


	@Override
	public String toString() {
		return "CReportList [cRid=" + cRid + ", cId=" + cId + ", noContent=" + noContent + ", report_Date="
				+ report_Date + ", status=" + status + ", sale_Id=" + sale_Id + ", userId=" + userId + ", pName="
				+ pName + "]";
	}
	
	
	
}
