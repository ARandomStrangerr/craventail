package main.product.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import main.product.dto.request.TaiKhoanDungReq;
import main.product.entity.TaiKhoanDungEntity;
import main.product.service.TaiKhoanDungService;

@RestController
@RequestMapping("/tai-khoan-dung")
public class TaiKhoanDungController extends BaseController<TaiKhoanDungEntity, TaiKhoanDungService, TaiKhoanDungReq> {

	@Autowired
	private TaiKhoanDungService service;

	@Override
	protected TaiKhoanDungService getService() {
		return service;
	}

	@PostMapping
	public ResponseEntity<?> them(@RequestBody TaiKhoanDungReq req) {
		TaiKhoanDungEntity entity = new TaiKhoanDungEntity();
		entity.setTamUng(req.getTamUng());
		entity.setTenChuQuan(req.getTenChuQuan());
		entity.setLoaiRutSoDu(req.getLoaiRutSoDu());
		entity.setTenTaiKhoan(req.getTenTaiKhoan());
		entity.setSoHieuTaiKhoan(req.getSoHieuTaiKhoan());
		entity.setTenNganHangKhoBac(req.getTenNganHangKhoBac());
		entity.setTaiKhoanNganHangKhoBac(req.getTaiKhoanNganHangKhoBac());
		
		service.createOrUpdate(entity);

		return ResponseEntity.ok("OK");
	}

	@PostMapping("/{id}")
	public ResponseEntity<?> capNhat(@PathVariable Long id, @RequestBody TaiKhoanDungReq req) {
		TaiKhoanDungEntity entity = service.getSingle(id);
		entity.setTamUng(req.getTamUng());
		entity.setTenChuQuan(req.getTenChuQuan());
		entity.setLoaiRutSoDu(req.getLoaiRutSoDu());
		entity.setTenTaiKhoan(req.getTenTaiKhoan());
		entity.setSoHieuTaiKhoan(req.getSoHieuTaiKhoan());
		entity.setTenNganHangKhoBac(req.getTenNganHangKhoBac());
		entity.setTaiKhoanNganHangKhoBac(req.getTaiKhoanNganHangKhoBac());
		
		service.createOrUpdate(entity);

		return ResponseEntity.ok("OK");
	}
}
