package main.product.entity;

import jakarta.persistence.Column;

public class TuDienChuongTrinh extends BaseEntity {

	@Column(name = "Ma_chuong_trinh")
	private String programCode;
	@Column(name = "ten_chuong_trinh")
	private String programName;
	@Column(name = "ma_chuong")
	private String sectionCode;
	@Column(name = "nguon_von")
	private String fundSource;
}
