package LF.member.model.vo;

import java.io.Serializable;

public class MReview implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = -2512085246803068521L;
	private int reId;
	private String reContent;
	private int grade;
	public MReview() {
	}
	public MReview(int reId, String reContent, int grade) {
		this.reId = reId;
		this.reContent = reContent;
		this.grade = grade;
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
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	@Override
	public String toString() {
		return "MReview [reId=" + reId + ", reContent=" + reContent + ", grade=" + grade + "]";
	}
	
	

}
