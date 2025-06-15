package main.product.entity;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

@Entity
@Table(name = "nguoi_dung")
@Setter
@Getter
@FieldDefaults(level = AccessLevel.PRIVATE)
public class NguoiDung {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column(name = "ten_dang_nhap")
	private String username;
	@Column(name = "mat_khau")
	private String password; // Giả định là đã hash rồi
}

