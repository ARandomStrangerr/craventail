package main.product.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "tu_dien_cong_trinh")
public class TuDienCongTrinhEntity extends BaseEntity {

	@Column(name = "ma_cong_trinh", nullable = false)
	private String projectCode;
	public String getProjectCode() {
			return projectCode;
	}
	public void setProjectCode(String projectCode) {
			this.projectCode = projectCode;
	}

	@Column(name = "ten_cong_trinh", nullable = false)
	private String projectName;
	public String getProjectName() {
			return projectName;
	}
	public void setProjectName(String projectName) {
			this.projectName = projectName;
	}

	@Column(name = "ma_chuong")
	private String sectionCode;
	public String getSectionCode() {
			return sectionCode;
	}
	public void setSectionCode(String sectionCode) {
			this.sectionCode = sectionCode;
	}
}
