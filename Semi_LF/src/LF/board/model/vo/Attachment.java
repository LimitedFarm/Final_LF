package LF.board.model.vo;

import java.io.Serializable;
import java.sql.Date;

public class Attachment implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -612802313412646530L;
	private int fId;
	private int pId;
	private String originName;
	private String changeName;
	private String filePath;
	private Date uploadDate;
	private Date modifydate;
	private int fileLevel;
	private String status;
	
	public Attachment() {
	}

	public Attachment(int fId, int pId, String originName, String changeName, String filePath, Date uploadDate,
			Date modifydate, int fileLevel, String status) {
		super();
		this.fId = fId;
		this.pId = pId;
		this.originName = originName;
		this.changeName = changeName;
		this.filePath = filePath;
		this.uploadDate = uploadDate;
		this.modifydate = modifydate;
		this.fileLevel = fileLevel;
		this.status = status;
	}

	public int getfId() {
		return fId;
	}

	public void setfId(int fId) {
		this.fId = fId;
	}

	public int getpId() {
		return pId;
	}

	public void setpId(int pId) {
		this.pId = pId;
	}

	public String getOriginName() {
		return originName;
	}

	public void setOriginName(String originName) {
		this.originName = originName;
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

	public Date getModifydate() {
		return modifydate;
	}

	public void setModifydate(Date modifydate) {
		this.modifydate = modifydate;
	}

	public int getFileLevel() {
		return fileLevel;
	}

	public void setFileLevel(int fileLevel) {
		this.fileLevel = fileLevel;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return "Attachment [fId=" + fId + ", pId=" + pId + ", originName=" + originName + ", changeName=" + changeName
				+ ", filePath=" + filePath + ", uploadDate=" + uploadDate + ", modifydate=" + modifydate
				+ ", fileLevel=" + fileLevel + ", status=" + status + "]";
	}

	
	
	
	
	
}
