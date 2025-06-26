package main.product.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table("tu_dien_chuong_trinh")
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
