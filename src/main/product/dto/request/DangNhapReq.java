package main.product.dto.request;

import jakarta.validation.constraints.NotBlank;

public class DangNhapReq {

	@NotBlank(message = "Tên đăng nhập không được bỏ trống")
	private String tenNguoiDung;
	public String getTenNguoiDung() {
			return tenNguoiDung;
	}
	public void setTenNguoiDung(String tenNguoiDung) {
			this.tenNguoiDung = tenNguoiDung;
	}

	@NotBlank(message = "Mật khẩu không được bỏ trống")
	private String matKhau;
	public String getMatKhau() {
			return matKhau;
	}
	public void setMatKhau(String matKhau) {
			this.matKhau = matKhau;
	}
}
