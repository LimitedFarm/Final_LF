package LF.mypage.model.vo;

import java.io.Serializable;
import java.sql.Date;

public class OrderVo implements Serializable {

	private static final long serialVersionUID = -758311744047627062L;

	private int sale_id; // 주문 번호
	private int cId; // 주문자 회원 번호
	private int sId; // 판매자 회원 번호
	private int pId; // 상품 번호
	private String pName; // 상품명
	private int scount; // 주문한 상품 수량
	private Date sale_date; // 주문 일자
	private String status;
	private String userId; // 판매자 아이디
	private String totalPrice; // 주문 총금액
	private int reviewCount;	// 구매후기 등록 상태 확인용 카운트
	private String imgPath; // 대표이미지 경로
	
	public OrderVo() {

	}

	public OrderVo(int sale_id, int cId, int sId, int pId, String pName, int scount, Date sale_date, String status,
			String userId, String totalPrice) {
		super();
		this.sale_id = sale_id;
		this.cId = cId;
		this.sId = sId;
		this.pId = pId;
		this.pName = pName;
		this.scount = scount;
		this.sale_date = sale_date;
		this.status = status;
		this.userId = userId;
		this.totalPrice = totalPrice;
	}

	public int getSale_id() {
		return sale_id;
	}

	public void setSale_id(int sale_id) {
		this.sale_id = sale_id;
	}

	public int getcId() {
		return cId;
	}

	public void setcId(int cId) {
		this.cId = cId;
	}

	public int getsId() {
		return sId;
	}

	public void setsId(int sId) {
		this.sId = sId;
	}

	public int getpId() {
		return pId;
	}

	public void setpId(int pId) {
		this.pId = pId;
	}

	public String getpName() {
		return pName;
	}

	public void setpName(String pName) {
		this.pName = pName;
	}

	public int getScount() {
		return scount;
	}

	public void setScount(int scount) {
		this.scount = scount;
	}

	public Date getSale_date() {
		return sale_date;
	}

	public void setSale_date(Date sale_date) {
		this.sale_date = sale_date;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(String totalPrice) {
		this.totalPrice = totalPrice;
	}
	
	
	public int getReviewCount() {
		return reviewCount;
	}

	public void setReviewCount(int reviewCount) {
		this.reviewCount = reviewCount;
	}

	public String getImgPath() {
		return imgPath;
	}

	public void setImgPath(String imgPath) {
		this.imgPath = imgPath;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public String toString() {
		return "OrderVo [sale_id=" + sale_id + ", cId=" + cId + ", sId=" + sId + ", pId=" + pId + ", pName=" + pName
				+ ", scount=" + scount + ", sale_date=" + sale_date + ", status=" + status + ", userId=" + userId
				+ ", totalPrice=" + totalPrice + "]";
	}

}