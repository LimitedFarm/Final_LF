package LF.seller.model.vo;

import java.io.Serializable;
import java.sql.Date;

public class Review implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 809684238238001941L;
	
	private int reId;
	private String reContent;
	private int grade;
	private Date reviewDate;
	private Date reviewModify;
	private String status;
	private int cid;
	private int saleId;
	
	
	public Review() {
		super();
	}


	public Review(int reId, String reContent, int grade, Date reviewDate, Date reviewModify, String status, int cid,
			int saleId) {
		super();
		this.reId = reId;
		this.reContent = reContent;
		this.grade = grade;
		this.reviewDate = reviewDate;
		this.reviewModify = reviewModify;
		this.status = status;
		this.cid = cid;
		this.saleId = saleId;
	}


	public int getReId() {
		return reId;
	}


	public void setReId(int reId) {
		this.reId = reId;
	}


	public String getReContent() {
		return reContent;
	}


	public void setReContent(String reContent) {
		this.reContent = reContent;
	}


	public int getGrade() {
		return grade;
	}


	public void setGrade(int grade) {
		this.grade = grade;
	}


	public Date getReviewDate() {
		return reviewDate;
	}


	public void setReviewDate(Date reviewDate) {
		this.reviewDate = reviewDate;
	}


	public Date getReviewModify() {
		return reviewModify;
	}


	public void setReviewModify(Date reviewModify) {
		this.reviewModify = reviewModify;
	}


	public String getStatus() {
		return status;
	}


	public void setStatus(String status) {
		this.status = status;
	}


	public int getCid() {
		return cid;
	}


	public void setCid(int cid) {
		this.cid = cid;
	}


	public int getSaleId() {
		return saleId;
	}


	public void setSaleId(int saleId) {
		this.saleId = saleId;
	}


	public static long getSerialversionuid() {
		return serialVersionUID;
	}


	@Override
	public String toString() {
		return "Review [reId=" + reId + ", reContent=" + reContent + ", grade=" + grade + ", reviewDate=" + reviewDate
				+ ", reviewModify=" + reviewModify + ", status=" + status + ", cid=" + cid + ", saleId=" + saleId + "]";
	}
	
	
}
