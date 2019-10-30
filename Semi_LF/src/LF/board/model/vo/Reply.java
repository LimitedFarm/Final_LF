package LF.board.model.vo;

import java.io.Serializable;
import java.sql.Date;

public class Reply implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -1509329356743407904L;

	private int Saleid;
	private	String Recontent;
	private int Grade;
	private Date Reviewmodify;
	private int Cid;
	private int Pid;

	public Reply() {
	}

	public Reply(int saleid, String recontent, int grade, Date reviewmodify, int cid, int pid) {
		super();
		Saleid = saleid;
		Recontent = recontent;
		Grade = grade;
		Reviewmodify = reviewmodify;
		Cid = cid;
		Pid = pid;
	}

	public int getSaleid() {
		return Saleid;
	}

	public void setSaleid(int saleid) {
		Saleid = saleid;
	}

	public String getRecontent() {
		return Recontent;
	}

	public void setRecontent(String recontent) {
		Recontent = recontent;
	}

	public int getGrade() {
		return Grade;
	}

	public void setGrade(int grade) {
		Grade = grade;
	}

	public Date getReviewmodify() {
		return Reviewmodify;
	}

	public void setReviewmodify(Date reviewmodify) {
		Reviewmodify = reviewmodify;
	}

	public int getCid() {
		return Cid;
	}

	public void setCid(int cid) {
		Cid = cid;
	}

	public int getPid() {
		return Pid;
	}

	public void setPid(int pid) {
		Pid = pid;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public String toString() {
		return "Reply [Saleid=" + Saleid + ", Recontent=" + Recontent + ", Grade=" + Grade + ", Reviewmodify="
				+ Reviewmodify + ", Cid=" + Cid + ", Pid=" + Pid + ", getSaleid()=" + getSaleid() + ", getRecontent()="
				+ getRecontent() + ", getGrade()=" + getGrade() + ", getReviewmodify()=" + getReviewmodify()
				+ ", getCid()=" + getCid() + ", getPid()=" + getPid() + ", getClass()=" + getClass() + ", hashCode()="
				+ hashCode() + ", toString()=" + super.toString() + "]";
	}

	
	

	
	
	
	
}
