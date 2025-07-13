package main.product.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(schema = "ke_toan_schema", name = "tu_dien_chuong_trinh")
public class TuDienChuongTrinhEntity extends BaseEntity {

	@Column(name = "ma_chuong_trinh")
	private String maChuongTrinh;
	@Column(name = "ten_chuong_trinh")
	private String tenChuongTrinh;
	@Column(name = "ma_chuong")
	private String maChuong;
	@Column(name = "nguon_von")
	private String nguonVon;
	
	public String getMaChuong() {
			return maChuong;
	}
	public void setMaChuong(String maChuong) {
			this.maChuong = maChuong;
	}

	public String getTenChuongTrinh() {
			return tenChuongTrinh;
	}
	public void setTenChuongTrinh(String tenChuongTrinh) {
			this.tenChuongTrinh = tenChuongTrinh;
	}
	
	public String getMaChuongTrinh() {
			return maChuongTrinh;
	}
	public void setMaChuongTrinh(String maChuongTrinh) {
			this.maChuongTrinh = maChuongTrinh;
	}

	public String getNguonVon() {
			return nguonVon;
	}
	public void setNguonVon(String nguonVon) {
			this.nguonVon = nguonVon;
	}

}
