package main.product.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(schema = "nguoi_dung_schema", name = "nguoi_dung_vai_tro")
public class NguoiDungVaiTroEntity extends BaseEntity {

	@Column(name = "ma_nguoi_dung")
	private Long maNguoiDung;
	@Column(name = "ma_vai_tro")
	private Long maVaiTro;

	public Long getMaNguoiDung() {
			return maNguoiDung;
	}
	public void setMaNguoiDung(Long maNguoiDung) {
			this.maNguoiDung = maNguoiDung;
	}

	public Long getMaVaiTro() {
			return maVaiTro;
	}
	public void setMaVaiTro(Long maVaiTro) {
			this.maVaiTro = maVaiTro;
	}
}
