package LF.member.model.vo;

import java.io.Serializable;

public class Admin implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -7350271471614785810L;
	
	private int aid;
	private int admin_Level;
	private int cid;
	
	public Admin() {
	}

	public Admin(int aid, int admin_Level, int cid) {
		this.aid = aid;
		this.admin_Level = admin_Level;
		this.cid = cid;
	}

	public int getAid() {
		return aid;
	}

	public void setAid(int aid) {
		this.aid = aid;
	}

	public int getAdmin_Level() {
		return admin_Level;
	}

	public void setAdmin_Level(int admin_Level) {
		this.admin_Level = admin_Level;
	}

	public int getCid() {
		return cid;
	}

	public void setCid(int cid) {
		this.cid = cid;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public String toString() {
		return "AdminInfo [aid=" + aid + ", admin_Level=" + admin_Level + ", cid=" + cid + "]";
	}

}
