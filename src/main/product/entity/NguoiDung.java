package main.product.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.persistence.Id;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

@Entity
@Table(name = "nguoi_dung")
@Setter
@Getter
@FieldDefaults(level = AccessLevel.PRIVATE)
public class NguoiDung extends BaseEntity{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long ma;
	@Column(name = "ten")
	private String username;
	@Column(name = "mat_khau")
	private String password; // Giả định là đã hash rồi
}

