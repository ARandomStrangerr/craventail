package main.product.dto.request;


public class TuDienChuongTrinhReq implements RequestInterface{

	private String maChuongTrinh;
	private String tenChuongTrinh;
	private String maChuong;
	private String nguonVon;

	public String getMaChuong() {
			return maChuong;
	}
	public void setMaChuong(String maChuong) {
			this.maChuong = maChuong;
	}

	public String getTenChuongTrinh() {
			return tenChuongTrinh;
	}
	public void setTenChuongTrinh(String tenChuongTrinh) {
			this.tenChuongTrinh = tenChuongTrinh;
	}
	
	public String getMaChuongTrinh() {
			return maChuongTrinh;
	}
	public void setMaChuongTrinh(String maChuongTrinh) {
			this.maChuongTrinh = maChuongTrinh;
	}

	public String getNguonVon() {
			return nguonVon;
	}
	public void setNguonVon(String nguonVon) {
			this.nguonVon = nguonVon;
	}
}
