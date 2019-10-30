package LF.faq.model.vo;

import java.io.Serializable;
import java.sql.Date;

public class Pattachment implements Serializable{
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -4862995642010267645L;
	
	private int fid;
	private int pid;
	private String fileName;
	private String changeName;
	private String filePath;
	private Date uploadDate;
	private Date modifyDate;
	private String status;
	
	public Pattachment() {
	}

	public Pattachment(int fid, int pid, String fileName, String changeName, String filePath, Date uploadDate,
			Date modifyDate, String status) {
		this.fid = fid;
		this.pid = pid;
		this.fileName = fileName;
		this.changeName = changeName;
		this.filePath = filePath;
		this.uploadDate = uploadDate;
		this.modifyDate = modifyDate;
		this.status = status;
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

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public String getChangeName() {
		return changeName;
	}

	public void setChangeName(String changeName) {
		this.changeName = changeName;
	}

	public String getFilePath() {
		return filePath;
	}

	public void setFilePath(String filePath) {
		this.filePath = filePath;
	}

	public Date getUploadDate() {
		return uploadDate;
	}

	public void setUploadDate(Date uploadDate) {
		this.uploadDate = uploadDate;
	}

	public Date getModifyDate() {
		return modifyDate;
	}

	public void setModifyDate(Date modifyDate) {
		this.modifyDate = modifyDate;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public String toString() {
		return "Pattachment [fid=" + fid + ", pid=" + pid + ", fileName=" + fileName + ", changeName=" + changeName
				+ ", filePath=" + filePath + ", uploadDate=" + uploadDate + ", modifyDate=" + modifyDate + ", status="
				+ status + "]";
	}
	
	

}
