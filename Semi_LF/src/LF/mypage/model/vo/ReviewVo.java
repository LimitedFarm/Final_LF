package LF.mypage.model.vo;

import java.io.Serializable;
import java.sql.Date;

public class ReviewVo implements  Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -6787963670847629042L;
	
	private int reId;	// 리뷰번호
	private String reContent;	//리뷰내용
	private int grade;			//상품 평점
	private Date review_date;	//리뷰 날짜
	private Date review_modify;	//리뷰 수정날짜
	private String status;		//리뷰상태
	private int cId;			//회원번호	
	private int sale_id;		//판매 번호
	private String pName;		//상품명

	public ReviewVo() {
		
	}


	public ReviewVo(int reId, String reContent, int grade, Date review_date, Date review_modify, String status, int cId,
			int sale_id) {
		super();
		this.reId = reId;
		this.reContent = reContent;
		this.grade = grade;
		this.review_date = review_date;
		this.review_modify = review_modify;
		this.status = status;
		this.cId = cId;
		this.sale_id = sale_id;
	}

	
	public ReviewVo(int reId, String reContent, int grade, Date review_date, Date review_modify, String status, int cId,
			int sale_id, String pName) {
		super();
		this.reId = reId;
		this.reContent = reContent;
		this.grade = grade;
		this.review_date = review_date;
		this.review_modify = review_modify;
		this.status = status;
		this.cId = cId;
		this.sale_id = sale_id;
		this.pName = pName;
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


	public Date getReview_date() {
		return review_date;
	}


	public void setReview_date(Date review_date) {
		this.review_date = review_date;
	}


	public Date getReview_modify() {
		return review_modify;
	}


	public void setReview_modify(Date review_modify) {
		this.review_modify = review_modify;
	}


	public String getStatus() {
		return status;
	}


	public void setStatus(String status) {
		this.status = status;
	}


	public int getcId() {
		return cId;
	}


	public void setcId(int cId) {
		this.cId = cId;
	}


	public int getSale_id() {
		return sale_id;
	}


	public void setSale_id(int sale_id) {
		this.sale_id = sale_id;
	}


	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	
	public String getpName() {
		return pName;
	}


	public void setpName(String pName) {
		this.pName = pName;
	}


	@Override
	public String toString() {
		return "ReviewVo [reId=" + reId + ", reContent=" + reContent + ", grade=" + grade + ", review_date="
				+ review_date + ", review_modify=" + review_modify + ", status=" + status + ", cId=" + cId
				+ ", sale_id=" + sale_id + ", pName=" + pName + "]";
	}

}
	
