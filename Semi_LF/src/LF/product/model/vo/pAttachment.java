package LF.product.model.vo;

import java.io.Serializable;

public class pAttachment implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5764044677394117950L;
	
	private int fid;
	private int pid;
	private String FILEPATH;	
	private int FileLevle;
	
	public pAttachment() {
	}

	public pAttachment(int fid, int pid, String fILEPATH, int fileLevle) {
		this.fid = fid;
		this.pid = pid;
		FILEPATH = fILEPATH;
		FileLevle = fileLevle;
	}

	public int getFid() {
		return fid;
	}

	public void setFid(int fid) {
		this.fid = fid;
	}

	public int getPid() {
		return pid;
	}

	public void setPid(int pid) {
		this.pid = pid;
	}

	public String getFILEPATH() {
		return FILEPATH;
	}

	public void setFILEPATH(String fILEPATH) {
		FILEPATH = fILEPATH;
	}

	public int getFileLevle() {
		return FileLevle;
	}

	public void setFileLevle(int fileLevle) {
		FileLevle = fileLevle;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public String toString() {
		return "pAttachment [fid=" + fid + ", pid=" + pid + ", FILEPATH=" + FILEPATH + ", FileLevle=" + FileLevle + "]";
	}
	
	
}
