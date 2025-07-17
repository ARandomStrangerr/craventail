package main.product.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(schema = "nguoi_dung_schema", name = "vai_tro_route")
public class VaiTroRouteEntity extends BaseEntity {
	
	@Column(name = "ma_vai_tro")
	private Long maVaiTro;
	@Column(name = "route_signature")
	private String routeSignature;

	public Long getMaVaiTro() {
			return maVaiTro;
	}
	public void setMaVaiTro(Long maVaiTro) {
			this.maVaiTro = maVaiTro;
	}
	
	public String getRouteSignature() {
			return routeSignature;
	}
	public void setRouteSignature(String routeSignature) {
			this.routeSignature = routeSignature;
	}
}
