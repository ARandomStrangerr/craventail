package main.product.controller;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import main.product.dto.request.NguoiDungReq;
import main.product.entity.NguoiDungEntity;
import main.product.service.NguoiDungService;

@RestController
@RequestMapping("/nguoi-dung")
public class NguoiDungController {
	
	@Autowired
	private NguoiDungService service;

	@PostMapping
	public ResponseEntity<?> post(@RequestBody NguoiDungReq req){
		System.out.println("HELLO");
		NguoiDungEntity entity = new NguoiDungEntity();
		entity.setName(req.getTen());
		entity.setUsername(req.getTenNguoiDung());
		entity.setPassword(req.getMatKhau());
		entity.setCreateDate(LocalDateTime.now());
		entity.setSoftDelete(false);
		service.createOrUpdate(entity);
		return ResponseEntity.ok("Thành công tạo người dùng mới");
	}

	@GetMapping
	public ResponseEntity<?> getMultiple(@RequestParam(name = "pageSize", defaultValue = "10") int pageSize, @RequestParam(name = "pageNumber", defaultValue = "0") int pageNum) {	
		Pageable pageable = PageRequest.of(pageNum, pageSize);
		Page<NguoiDungEntity> filledPage = service.getByPage(pageable);
		return ResponseEntity.ok(filledPage);
	}

	@GetMapping("/{id}")
	public ResponseEntity<?> getSingle(@PathVariable Long id) {
		NguoiDungEntity entity = service.getSingle(id);
		return ResponseEntity.ok(entity);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<?> delete(@PathVariable Long id){
		NguoiDungEntity entity = service.softDelete(id);
		return ResponseEntity.ok("OK");
	}

	@PutMapping
	public ResponseEntity<?> put(@PathVariable Long id, @RequestBody NguoiDungReq req){
		NguoiDungEntity entity = service.getSingle(id);
		entity.setName(req.getTen());
		entity.setPassword(req.getMatKhau());
		entity.setUsername(req.getTenNguoiDung());
		entity.setSoftDelete(entity.getSoftDelete());
		return ResponseEntity.ok("OK");
	}
}
