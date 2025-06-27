package main.product.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.MappedSuperclass;
import jakarta.persistence.Table;

@Entity
@MappedSuperclass
@Table(name = "tu_dien_chuong_trinh")
public class TuDienChuongTrinhEntity extends BaseEntity {

	@Column(name = "Ma_chuong_trinh")
	private String programCode;
	@Column(name = "ten_chuong_trinh")
	private String programName;
	@Column(name = "ma_chuong")
	private String sectionCode;
	@Column(name = "nguon_von")
	private String fundSource;
}
