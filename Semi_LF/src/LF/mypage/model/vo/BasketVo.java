package LF.mypage.model.vo;

public class BasketVo {
	
	private int basketId;
	private int cId;
	private int pId;
	private int sId;
	private int count;
	private String pName;
	private String userId;
	private int price;
	private String imgPath;
	
	public BasketVo() {
		
	}

	public BasketVo(int basketId, int cId, int pId, int sId, int count, String pName, String userId, int price) {
		super();
		this.basketId = basketId;
		this.cId = cId;
		this.pId = pId;
		this.sId = sId;
		this.count = count;
		this.pName = pName;
		this.userId = userId;
		this.price = price;
	}

	public int getBasketId() {
		return basketId;
	}

	public void setBasketId(int basketId) {
		this.basketId = basketId;
	}

	public int getcId() {
		return cId;
	}

	public void setcId(int cId) {
		this.cId = cId;
	}

	public int getpId() {
		return pId;
	}

	public void setpId(int pId) {
		this.pId = pId;
	}

	public int getsId() {
		return sId;
	}

	public void setsId(int sId) {
		this.sId = sId;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	public String getpName() {
		return pName;
	}

	public void setpName(String pName) {
		this.pName = pName;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}
	
	public String getImgPath() {
		return imgPath;
	}

	public void setImgPath(String imgPath) {
		this.imgPath = imgPath;
	}

	@Override
	public String toString() {
		return "BasketVo [basketId=" + basketId + ", cId=" + cId + ", pId=" + pId + ", sId=" + sId + ", count=" + count
				+ ", pName=" + pName + ", userId=" + userId + ", price=" + price + "]";
	}
}
