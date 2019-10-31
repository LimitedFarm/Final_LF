package LF.mypage.model.vo;

public class MainCountVo {
	
	private int o_count;	// 주문 카운트
	private int b_count;	// 장바구니 카운트
	private int r_count;	// 리뷰 카운트
	private int q_count;	// 문의내역 카운트
	
	public MainCountVo() {
		
	}

	public MainCountVo(int o_count, int b_count, int r_count, int q_count) {
		super();
		this.o_count = o_count;
		this.b_count = b_count;
		this.r_count = r_count;
		this.q_count = q_count;
	}

	public int getO_count() {
		return o_count;
	}

	public void setO_count(int o_count) {
		this.o_count = o_count;
	}

	public int getB_count() {
		return b_count;
	}

	public void setB_count(int b_count) {
		this.b_count = b_count;
	}

	public int getR_count() {
		return r_count;
	}

	public void setR_count(int r_count) {
		this.r_count = r_count;
	}

	public int getQ_count() {
		return q_count;
	}

	public void setQ_count(int q_count) {
		this.q_count = q_count;
	}

	@Override
	public String toString() {
		return "MainCountVo [o_count=" + o_count + ", b_count=" + b_count + ", r_count=" + r_count + ", q_count="
				+ q_count + "]";
	}
	
	
	
	

}
