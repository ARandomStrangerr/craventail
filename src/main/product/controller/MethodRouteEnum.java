package main.product.controller;

public enum MethodRouteEnum {

	DANG_NHAP("POST", RouteDefinition.XAC_THUC),
	DANG_XUAT("DELETE", RouteDefinition.XAC_THUC),

	NGUOI_DUNG_THEM("POST", RouteDefinition.NGUOI_DUNG),
	NGUOI_DUNG_XEM("GET", RouteDefinition.NGUOI_DUNG),
	NGUOI_DUNG_SUA("PUT", RouteDefinition.NGUOI_DUNG),
	NGUOI_DUNG_XOA("DELETE", RouteDefinition.NGUOI_DUNG),

	MUC_LUC_NGAN_SACH_THEM("POST", RouteDefinition.MUC_LUC_NGAN_SACH),
	MUC_LUC_NGAN_SACH_XEM("GET", RouteDefinition.MUC_LUC_NGAN_SACH),
	MUC_LUC_NGAN_SACH_SUA("PUT", RouteDefinition.MUC_LUC_NGAN_SACH),
	MUC_LUC_NGAN_SACH_XOA("DELETE", RouteDefinition.MUC_LUC_NGAN_SACH),

	TAI_KHOAN_DUNG_THEM("POST", RouteDefinition.TAI_KHOAN_DUNG),
	TAI_KHOAN_DUNG_XEM("GET", RouteDefinition.TAI_KHOAN_DUNG),
	TAI_KHOAN_DUNG_SUA("PUT", RouteDefinition.TAI_KHOAN_DUNG),
	TAI_KHOAN_DUNG_XOA("DELETE", RouteDefinition.TAI_KHOAN_DUNG),

	TU_DIEN_CHUONG_TRINH_THEM("POST", RouteDefinition.TU_DIEN_CHUONG_TRINH),
	TU_DIEN_CHUONG_TRINH_XEM("GET", RouteDefinition.TU_DIEN_CHUONG_TRINH),
	TU_DIEN_CHUONG_TRINH_SUA("PUT", RouteDefinition.TU_DIEN_CHUONG_TRINH),
	TU_DIEN_CHUONG_TRINH_XOA("DELETE", RouteDefinition.TU_DIEN_CHUONG_TRINH);

	public final String method, route;

	private MethodRouteEnum(String method, String route){
		this.method = method;
		this.route = route;
	}	
}
