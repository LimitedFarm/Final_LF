package LF.adminPage.model.vo;

import java.io.Serializable;

public class Admin implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1800155281901462347L;
	
	private String aUserId;
	private int aId;
	private int admin_Level;
	private int cId;
	
	
	public Admin() {
	}


	public Admin(String aUserId, int aId, int admin_Level, int cId) {
		this.aUserId = aUserId;
		this.aId = aId;
		this.admin_Level = admin_Level;
		this.cId = cId;
	}


	public String getaUserId() {
		return aUserId;
	}


	public void setaUserId(String aUserId) {
		this.aUserId = aUserId;
	}


	public int getaId() {
		return aId;
	}


	public void setaId(int aId) {
		this.aId = aId;
	}


	public int getAdmin_Level() {
		return admin_Level;
	}


	public void setAdmin_Level(int admin_Level) {
		this.admin_Level = admin_Level;
	}


	public int getcId() {
		return cId;
	}


	public void setcId(int cId) {
		this.cId = cId;
	}


	public static long getSerialversionuid() {
		return serialVersionUID;
	}


	@Override
	public String toString() {
		return "Admin [aUserId=" + aUserId + ", aId=" + aId + ", admin_Level=" + admin_Level + ", cId=" + cId + "]";
	}
	
	
	
}
