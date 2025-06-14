package main.product.dto.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import main.product.repository.NguoiDungRepository;
import main.product.validation.UniqueField;

public class DangNhap {

	@NotBlank(message = "Tên đăng nhập không được để trống")
	@Size(max = 128, message = "Tên đăng nhập quá dài")
	@UniqueField(message = "Tên người dùng đã tồn tại", fieldName = "username", repository = NguoiDungRepository.class)
	private String username;

	@NotBlank(message = "Mật khẩu không được để trống")
	@Size(max = 128, message = "Mật khẩu dài hơn mức cho phép")
	private String password;

	// Constructor mặc định
	public DangNhap() {}

	// Getter và Setter
	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
}

