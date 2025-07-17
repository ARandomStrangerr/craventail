package main.product.dto.request;

import java.util.List;

public class VaiTroReq implements RequestInterface {

	private String ten;
	private List<String> routeSignature;


	public String getTen() {
			return ten;
	}
	public void setName(String ten) {
			this.ten = ten;
	}

	public List<String> getRouteSignature() {
			return routeSignature;
	}
	public void setRouteSignature(List<String> routeSignature) {
			this.routeSignature = routeSignature;
	}
}
