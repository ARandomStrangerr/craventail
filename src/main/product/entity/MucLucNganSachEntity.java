package main.product.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(schema = "ke_toan_schema", name = "muc_luc_ngan_sach")
public class MucLucNganSachEntity extends BaseEntity {
	@Column(name = "nhom")
	private String nhom;

	@Column(name = "tieu_nhom")
	private String tieuNhom;

	@Column(name = "ten")
	private String ten;

	@Column(name = "noi_dung")
	private String noiDung;

	public String getNhom() {
			return nhom;
	}
	public void setNhom(String nhom) {
			this.nhom = nhom;
	}

	public String getTieuNhom() {
			return tieuNhom;
	}
	public void setTieuNhom(String tieuNhom) {
			this.tieuNhom = tieuNhom;
	}

	public String getTen(){
		return this.ten;
	}
	public void setTen(String ten){
		this.ten = ten;
	}

	public String getNoiDung() {
			return noiDung;
	}
	public void setNoiDung(String noiDung) {
			this.noiDung = noiDung;
	}
}
