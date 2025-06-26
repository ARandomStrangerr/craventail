package main.product.entity;

import jakarta.persistence.Column;

public class MucLucNganSach extends BaseEntity {

	@Column (name = "nhom")
	private String group;
	public String getGroup() {
			return group;
	}
	public void setGroup(String group) {
			this.group = group;
	}

	@Column (name = "tieu_nhom")
	private String subGroup;
	public String getSubGroup() {
			return subGroup;
	}
	public void setSubGroup(String subGroup) {
			this.subGroup = subGroup;
	}

	@Column (name = "ten")
	private String name;
	public String getName() {
			return name;
	}
	public void setName(String name) {
			this.name = name;
	}

	@Column (name = "nguoi_dung")
	private String desc;
	public String getDesc() {
			return desc;
	}
	public void setDesc(String desc) {
			this.desc = desc;
	}
}
