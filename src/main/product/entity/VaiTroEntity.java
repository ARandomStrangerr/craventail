package main.product.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(schema = "nguoi_dung_schema", name = "vai_tro")
public class VaiTroEntity extends BaseEntity {

	@Column(name = "ten")
	private String ten;
	
	public String getTen() {
			return ten;
	}
	public void setTen(String ten) {
			this.ten = ten;
	}
}
