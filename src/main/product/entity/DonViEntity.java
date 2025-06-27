package main.product.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.MappedSuperclass;
import jakarta.persistence.Table;

@Entity
@MappedSuperclass
@Table(name = "don_vi")
public class DonViEntity extends BaseEntity {

	@Column(name = "don_vi_chu_quan")
	private String supervisingUnit;
	public String getSupervisingUnit() {
			return supervisingUnit;
	}
	public void setSupervisingUnit(String supervisingUnit) {
			this.supervisingUnit = supervisingUnit;
	}

	@Column(name = "ma_don_vi")
	private String unitCode;
	public String getUnitCode() {
			return unitCode;
	}
	public void setUnitCode(String unitCode) {
			this.unitCode = unitCode;
	}

	@Column(name = "ten_don_vi")
	private String unitName;
	public String getUnitName() {
			return unitName;
	}
	public void setUnitName(String unitName) {
			this.unitName = unitName;
	}

	@Column(name = "ten_doi_ngoai")
	private String foreignName;
	public String getForeignName() {
			return foreignName;
	}
	public void setForeignName(String foreignName) {
			this.foreignName = foreignName;
	}

	@Column(name = "dia_chi")
	private String address;
	public String getAddress() {
			return address;
	}
	public void setAddress(String address) {
			this.address = address;
	}

	@Column(name = "ma_chuong")
	private String sectionCode;
	public String getSectionCode() {
			return sectionCode;
	}
	public void setSectionCode(String sectionCode) {
			this.sectionCode = sectionCode;
	}

	@Column(name = "ma_so_thue")
	private String taxCode;
	public String getTaxCode() {
			return taxCode;
	}
	public void setTaxCode(String taxCode) {
			this.taxCode = taxCode;
	}

	@Column(name = "cuc_thue")
	private String taxDepartment;
	public String getTaxDepartment() {
			return taxDepartment;
	}
	public void setTaxDepartment(String taxDepartment) {
			this.taxDepartment = taxDepartment;
	}

	@Column(name = "ma_chuong_thu_thue")
	private String taxSectionCode;
	public String getTaxSectionCode() {
			return taxSectionCode;
	}
	public void setTaxSectionCode(String taxSectionCode) {
			this.taxSectionCode = taxSectionCode;
	}

	@Column(name = "ma_so_don_vi_thu_thue")
	private String taxCollectorUnitCode;
	public String getTaxCollectorUnitCode() {
			return taxCollectorUnitCode;
	}
	public void setTaxCollectorUnitCode(String taxCollectorUnitCode) {
			this.taxCollectorUnitCode = taxCollectorUnitCode;
	}

	@Column(name = "kho_bac_chuyen_thue")
	private String treasuryForTaxTransfer;
	public String getTreasuryForTaxTransfer() {
			return treasuryForTaxTransfer;
	}
	public void setTreasuryForTaxTransfer(String treasuryForTaxTransfer) {
			this.treasuryForTaxTransfer = treasuryForTaxTransfer;
	}

}
