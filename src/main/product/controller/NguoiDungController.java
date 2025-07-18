package main.product.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import main.product.dto.request.NguoiDungReq;
import main.product.entity.NguoiDungEntity;
import main.product.service.NguoiDungService;

@RestController
@RequestMapping(value = RouteDefinition.NGUOI_DUNG)
public class NguoiDungController extends BaseController<NguoiDungEntity, NguoiDungService, NguoiDungReq> {
	
	@Autowired
	private NguoiDungService service;
	
	protected NguoiDungService getService(){
		return service;
	}

	@Override
	@PostMapping
	public ResponseEntity<?> them(@RequestBody NguoiDungReq req){
		service.createUser(req.getTen(), req.getTenNguoiDung(), req.getMatKhau(), req.getVaiTro());
		return ResponseEntity.ok("Thành công tạo người dùng mới");
	}

	@Override
	@PutMapping("/{id}")
	public ResponseEntity<?> capNhat(@PathVariable Long id, @RequestBody NguoiDungReq req){
		service.updateUser(id, req.getTen(), req.getMatKhau(), req.getVaiTro());
		return ResponseEntity.ok("OK");
	}
}
