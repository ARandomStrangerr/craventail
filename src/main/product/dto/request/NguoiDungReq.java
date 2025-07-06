package main.product.dto.request;

import java.time.LocalDateTime;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public class NguoiDungReq {

	@NotBlank(message = "Tên chủ tài khoản không được bỏ trống")
	@Size(min = 5, max = 128, message = "| Tên chủ tài khoản | ∈ [10, 128] ∩ ℕ")
	private String ten;
	public String getTen() {
			return ten;
	}
	public void setTen(String ten) {
			this.ten = ten;
	}

	@NotBlank(message = "Tên người dùng không được bỏ trống")
	@Size(min = 5, max = 128, message = "| Tên người dùng | ∈ [10, 128] ∩ ℕ")
	private String tenNguoiDung;
	public String getTenNguoiDung() {
			return tenNguoiDung;
	}
	public void setTenNguoiDung(String tenNguoiDung) {
			this.tenNguoiDung = tenNguoiDung;
	}

	@NotBlank(message = "Mật khẩu không được bỏ trống")
	@Size(min = 5, max = 128, message = "| mật khẩu | ∈ [10, 128] ∩ ℕ")
	private String matKhau;
	public String getMatKhau() {
			return matKhau;
	}
	public void setMatKhau(String matKhau) {
			this.matKhau = matKhau;
	}

	private LocalDateTime ngayTao;
	public LocalDateTime getNgayTao() {
			return ngayTao;
	}
	public void setNgayTao(LocalDateTime ngayTao) {
			this.ngayTao = ngayTao;
	}

	private boolean deleted;
	public boolean getDeleted(){
		return deleted;
	}
	public void setDeleted(boolean deleted){
		this.deleted = deleted;
	}
}
