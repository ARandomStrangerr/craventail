package main.product.dto.request;

public class TuDienChuongTrinhReq {

	private String programCode;
	public String getProgramCode() {
			return programCode;
	}
	public void setProgramCode(String programCode) {
			this.programCode = programCode;
	}

	private String programName;
	public String getProgramName() {
			return programName;
	}
	public void setProgramName(String programName) {
			this.programName = programName;
	}

	private String sectionCode;
	public String getSectionCode() {
			return sectionCode;
	}
	public void setSectionCode(String sectionCode) {
			this.sectionCode = sectionCode;
	}

	private String fundSource;
	public String getFundSource() {
			return fundSource;
	}
	public void setFundSource(String fundSource) {
			this.fundSource = fundSource;
	}
}
