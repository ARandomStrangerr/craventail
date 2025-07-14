package main.product.controller;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
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
	@Autowired
	private PasswordEncoder passwordEncoder;

	protected NguoiDungService getService(){
		return service;
	}

	@Override
	@PostMapping
	public ResponseEntity<?> them(@RequestBody NguoiDungReq req){
		NguoiDungEntity entity = new NguoiDungEntity();
		entity.setName(req.getTen());
		entity.setUsername(req.getTenNguoiDung());
		entity.setPassword(passwordEncoder.encode(req.getMatKhau()));
		entity.setCreateDate(LocalDateTime.now());
		entity.setSoftDelete(false);
		service.createOrUpdate(entity);
		return ResponseEntity.ok("Thành công tạo người dùng mới");
	}

	@Override
	@PutMapping("/{id}")
	public ResponseEntity<?> capNhat(@PathVariable Long id, @RequestBody NguoiDungReq req){
		NguoiDungEntity entity = service.getSingle(id);
		entity.setName(req.getTen());
		entity.setPassword(req.getMatKhau());
		entity.setUsername(req.getTenNguoiDung());
		entity.setSoftDelete(entity.getSoftDelete());
		return ResponseEntity.ok("OK");
	}
}
