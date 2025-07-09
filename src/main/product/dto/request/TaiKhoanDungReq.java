package main.product.dto.request;

public class TaiKhoanDungReq implements RequestInterface {

	private String tenTaiKhoan;
	private String soHieuTaiKhoan;
	private String loaiRutSoDu;
	private String tenChuQuan;
	private String taiKhoanNganHangKhoBac;
	private String tamUng;
	private String tenNganHangKhoBac;

	public String getTenTaiKhoan() {
			return tenTaiKhoan;
	}
	public void setTenTaiKhoan(String tenTaiKhoan) {
			this.tenTaiKhoan = tenTaiKhoan;
	}

	public String getSoHieuTaiKhoan() {
			return soHieuTaiKhoan;
	}
	public void setSoHieuTaiKhoan(String soHieuTaiKhoan) {
			this.soHieuTaiKhoan = soHieuTaiKhoan;
	}

	public String getLoaiRutSoDu() {
			return loaiRutSoDu;
	}
	public void setLoaiRutSoDu(String loaiRutSoDu) {
			this.loaiRutSoDu = loaiRutSoDu;
	}

	public String getTenChuQuan() {
			return tenChuQuan;
	}
	public void setTenChuQuan(String tenChuQuan) {
			this.tenChuQuan = tenChuQuan;
	}

	public String getTaiKhoanNganHangKhoBac() {
			return taiKhoanNganHangKhoBac;
	}
	public void setTaiKhoanNganHangKhoBac(String taiKhoanNganHangKhoBac) {
			this.taiKhoanNganHangKhoBac = taiKhoanNganHangKhoBac;
	}
	
	public String getTamUng() {
			return tamUng;
	}
	public void setTamUng(String tamUng) {
			this.tamUng = tamUng;
	}

	public String getTenNganHangKhoBac() {
			return tenNganHangKhoBac;
	}
	public void setTenNganHangKhoBac(String tenNganHangKhoBac) {
			this.tenNganHangKhoBac = tenNganHangKhoBac;
	}
}
