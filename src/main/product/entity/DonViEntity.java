package main.product.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(schema = "ke_toan_schema", name = "don_vi")
public class DonViEntity extends BaseEntity {

	@Column(name = "don_vi_chu_quan")
	private String DonViChuQuan;
	@Column(name = "ma_don_vi")
	private String maDonVi;
	@Column(name = "ten_don_vi")
	private String tenDonVi;
	@Column(name = "ten_doi_ngoai")
	private String tenDoiNgoai;
	@Column(name = "dia_chi")
	private String diaChi;
	@Column(name = "ma_chuong")
	private String maChuong;
	@Column(name = "ma_so_thue")
	private String maSoThue;
	@Column(name = "cuc_thue")
	private String cucThue;
	@Column(name = "ma_chuong_thu_thue")
	private String maChuongThuThue;
	@Column(name = "ma_so_don_vi_thu_thue")
	private String maSoDonViThuThue;
	@Column(name = "kho_bac_chuyen_thue")
	private String khoBacChuyenThue;
}
