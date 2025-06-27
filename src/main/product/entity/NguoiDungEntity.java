package main.product.entity;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.MappedSuperclass;
import jakarta.persistence.Table;

@Entity
@MappedSuperclass
@Table(name = "nguoi_dung")
public class NguoiDungEntity extends BaseEntity {

	@Column(name = "ten_dang_nhap")
	private String username;
	public String getUsername() {
			return username;
	}
	public void setUsername(String username) {
			this.username = username;
	}

	@Column(name = "mat_khau")
	private String password;
	public String getPassword() {
			return password;
	}
	public void setPassword(String password) {
			this.password = password;
	}

	@Column(name = "ten")
	private String name;
	public String getName() {
			return name;
	}
	public void setName(String name) {
			this.name = name;
	}
	
	@Column(name = "ngay_lap")
	private LocalDateTime createDate = LocalDateTime.now();
	public LocalDateTime getCreateDate() {
		return createDate;
	}
}
