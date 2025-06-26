package main.product.entity;

import jakarta.persistence.Column;

public class BaseEntity {
	
	@Column (name = "ma")
	private Long id;
	public Long getId() {
			return id;
	}
	public void setId(Long id) {
			this.id = id;
	}

	@Column (name = "softDelete")
	private boolean softDelete;
	public boolean getSoftDelete() {
		return softDelete;
	}
	public void setSoftDelete(boolean softDelete) {
		this.softDelete = softDelete;
	}
}
