package LF.seller.model.vo;

import java.io.Serializable;
import java.sql.Date;

public class pAttachment implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 7140281091469282225L;
	private int fId;	//파일 번호
	private int pId;	//물품 번호
	private String fileName;	//파일 이름
	private String changeName;	//수정된 파일 이름
	private String filePath;	//파일 경로
	private Date uploadDate;	//업로드 날짜
	private Date modifyDate;	//파일 수정일자
	private String status;	//파일 상태 여부
	private int fileLevel;
	
	public pAttachment() {
		super();
	}

	public pAttachment(int fId, int pId, String fileName, String changeName, String filePath, Date uploadDate, Date modifyDate, String status, int fileLevel) {
		super();
		this.fId = fId;
		this.pId = pId;
		this.fileName = fileName;
		this.changeName = changeName;
		this.filePath = filePath;
		this.uploadDate = uploadDate;
		this.modifyDate = modifyDate;
		this.status = status;
	}

	public pAttachment(int fId, String changeName, String filePath, Date uploadDate) {
		this.fId = fId;
		this.changeName = changeName;
		this.filePath = filePath;
		this.uploadDate = uploadDate;
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
	
	

	public int getFileLevel() {
		return fileLevel;
	}

	public void setFileLevel(int fileLevel) {
		this.fileLevel = fileLevel;
	}

	@Override
	public String toString() {
		return "pAttachment [fId=" + fId + ", pId=" + pId + ", fileName=" + fileName + ", changeName=" + changeName
				+ ", filePath=" + filePath + ", uploadDate=" + uploadDate + ", modifyDate=" + modifyDate + ", status="
				+ status + ", fileLevel=" + fileLevel + "]";
	}

	

	
	
	
	
	
}
