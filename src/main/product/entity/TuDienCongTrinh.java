package main.product.entity;

import jakarta.persistence.Column;

public class TuDienCongTrinh {

	@Column(name = "ma_cong_trinh", nullable = false)
	private String projectCode;

	@Column(name = "ten_cong_trinh", nullable = false)
	private String projectName;

	@Column(name = "ma_chuong")
	private String sectionCode;
}
