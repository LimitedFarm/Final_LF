package LF.seller.model.vo;

import java.io.Serializable;

public class ListObj implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = -793313742151342288L;
	private int currentPage;
	private int limit;
	private int sid;
	public ListObj() {
		super();
	}
	public ListObj(int currentPage, int limit, int sid) {
		super();
		this.currentPage = currentPage;
		this.limit = limit;
		this.sid = sid;
	}
	public int getCurrentPage() {
		return currentPage;
	}
	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}
	@Override
	public String toString() {
		return "ListObj [currentPage=" + currentPage + ", limit=" + limit + ", sid=" + sid + "]";
	}
	public int getLimit() {
		return limit;
	}
	public void setLimit(int limit) {
		this.limit = limit;
	}
	public int getSid() {
		return sid;
	}
	public void setSid(int sid) {
		this.sid = sid;
	}
	
	
	

}
