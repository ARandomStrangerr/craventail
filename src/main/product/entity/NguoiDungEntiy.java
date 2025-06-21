package main.product.entity;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class NguoiDungEntiy extends BaseEntity{
	@Column(name = "ten", nullable = false)
	String ten;
	@Column(name = "hoat_dong", nullable = false)
	boolean heatDong = false;
	@Column(name = "thoi_diem_tao", nullable = false)
	LocalDateTime thoiDiemTao;
}
