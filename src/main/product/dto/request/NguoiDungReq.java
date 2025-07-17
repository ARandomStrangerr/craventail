package main.product.dto.request;

import java.time.LocalDateTime;
import java.util.List;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public class NguoiDungReq implements RequestInterface {

	@NotBlank(message = "Tên chủ tài khoản không được bỏ trống")
	@Size(min = 5, max = 128, message = "| Tên chủ tài khoản | ∈ [10, 128] ∩ ℕ")
	private String ten;
	@NotBlank(message = "Tên người dùng không được bỏ trống")
	@Size(min = 5, max = 128, message = "| Tên người dùng | ∈ [10, 128] ∩ ℕ")
	private String tenNguoiDung;
	@NotBlank(message = "Mật khẩu không được bỏ trống")
	@Size(min = 5, max = 128, message = "| mật khẩu | ∈ [10, 128] ∩ ℕ")
	private String matKhau;
	private LocalDateTime ngayTao;
	private List<String> vaiTro;
	private boolean deleted;	

	public String getTen() {
			return ten;
	}
	public void setTen(String ten) {
			this.ten = ten;
	}

	public String getTenNguoiDung() {
			return tenNguoiDung;
	}
	public void setTenNguoiDung(String tenNguoiDung) {
			this.tenNguoiDung = tenNguoiDung;
	}

	public String getMatKhau() {
			return matKhau;
	}
	public void setMatKhau(String matKhau) {
			this.matKhau = matKhau;
	}

	public List<String> getVaiTro() {
			return vaiTro;
	}
	public void setVaiTro(List<String> vaiTro) {
			this.vaiTro = vaiTro;
	}

	public LocalDateTime getNgayTao() {
			return ngayTao;
	}
	public void setNgayTao(LocalDateTime ngayTao) {
			this.ngayTao = ngayTao;
	}

	public boolean getDeleted(){
		return deleted;
	}
	public void setDeleted(boolean deleted){
		this.deleted = deleted;
	}
}
