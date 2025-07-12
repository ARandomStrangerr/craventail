package main.product.dto.request;

public class MucLucNganSachReq implements RequestInterface {
	private String nhom;
	private String tieuNhom;
	private String ten;
	private String noiDung;

	public String getNhom() {
			return nhom;
	}
	public void setNhom(String nhom) {
			this.nhom = nhom;
	}

	public String getTieuNhom() {
			return tieuNhom;
	}
	public void setTieuNhom(String tieuNhom) {
			this.tieuNhom = tieuNhom;
	}

	public String getTen(){
		return this.ten;
	}
	public void setTen(String ten){
		this.ten = ten;
	}

	public String getNoiDung() {
			return noiDung;
	}
	public void setNoiDung(String noiDung) {
			this.noiDung = noiDung;
	}

}
