package main.product.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.MappedSuperclass;
import jakarta.persistence.Table;

@Entity
@MappedSuperclass
@Table(name = "tu_dien_cong_trinh")
public class TuDienCongTrinhEntity {

	@Column(name = "ma_cong_trinh", nullable = false)
	private String projectCode;

	@Column(name = "ten_cong_trinh", nullable = false)
	private String projectName;

	@Column(name = "ma_chuong")
	private String sectionCode;
}
