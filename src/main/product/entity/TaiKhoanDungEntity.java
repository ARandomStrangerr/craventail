package main.product.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;

@Entity
@Table(schema = "ke_toan_schema", name = "tai_khoan_dung")
public class TaiKhoanDungEntity extends BaseEntity {

	@NotNull(message = "Tên tài khoản không được bỏ trống")
	@Column(name = "ten_tai_khoan")
	private String tenTaiKhoan;
	@NotNull(message = "Số hiệu tài khoản không được bỏ trống")
	@Column(name = "so_hieu_tai_khoan")
	private String soHieuTaiKhoan;
	@NotNull(message = "Loại rút số dư không được bỏ trống")
	@Column(name = "loai_rut_so_du")
	private String loaiRutSoDu;
	@Column(name = "ten_chu_quan")
	private String	tenChuQuan;
	@Column(name = "tai_khoan_ngan_hang_kho_bac")
	private String taiKhoanNganHangKhoBac;
	@Column(name = "tam_ung")
	private String tamUng;
	@Column(name = "ten_ngan_hang_kho_bac")
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
