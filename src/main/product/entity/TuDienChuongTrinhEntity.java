package main.product.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "tu_dien_chuong_trinh")
public class TuDienChuongTrinhEntity extends BaseEntity {

	@Column(name = "Ma_chuong_trinh")
	private String programCode;
	public String getProgramCode() {
			return programCode;
	}
	public void setProgramCode(String programCode) {
			this.programCode = programCode;
	}

	@Column(name = "ten_chuong_trinh")
	private String programName;
	public String getProgramName() {
			return programName;
	}
	public void setProgramName(String programName) {
			this.programName = programName;
	}

	@Column(name = "ma_chuong")
	private String sectionCode;
	public String getSectionCode() {
			return sectionCode;
	}
	public void setSectionCode(String sectionCode) {
			this.sectionCode = sectionCode;
	}

	@Column(name = "nguon_von")
	private String fundSource;
	public String getFundSource() {
			return fundSource;
	}
	public void setFundSource(String fundSource) {
			this.fundSource = fundSource;
	}
}
