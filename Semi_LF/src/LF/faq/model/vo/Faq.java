package LF.faq.model.vo;

import java.io.Serializable;

public class Faq implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 6542111067731818259L;
	
	private int fId;
	private String fTitle;
	private String fContent;
	private String fStatus;
	private int aId;
	
	public Faq() {}

	public Faq(int fId, String fTitle, String fContent, String fStatus, int aId) {
		this.fId = fId;
		this.fTitle = fTitle;
		this.fContent = fContent;
		this.fStatus = fStatus;
		this.aId = aId;
	}
	
	

	public int getfId() {
		return fId;
	}

	public void setfId(int fId) {
		this.fId = fId;
	}

	public String getfTitle() {
		return fTitle;
	}

	public void setfTitle(String fTitle) {
		this.fTitle = fTitle;
	}

	public String getfContent() {
		return fContent;
	}

	public void setfContent(String fContent) {
		this.fContent = fContent;
	}

	public String getfStatus() {
		return fStatus;
	}

	public void setfStatus(String fStatus) {
		this.fStatus = fStatus;
	}

	public int getaId() {
		return aId;
	}

	public void setaId(int aId) {
		this.aId = aId;
	}

	@Override
	public String toString() {
		return "Fqa [fId=" + fId + ", fTitle=" + fTitle + ", fContent=" + fContent + ", fStatus=" + fStatus + ", aId="
				+ aId + "]";
	}
	
	
}
