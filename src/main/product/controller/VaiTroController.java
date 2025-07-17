package main.product.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import main.product.dto.request.TuDienChuongTrinhReq;
import main.product.dto.request.VaiTroReq;
import main.product.entity.VaiTroEntity;
import main.product.entity.VaiTroRouteEntity;
import main.product.service.VaiTroRouteService;
import main.product.service.VaiTroService;

@RestController
@RequestMapping(RouteDefinition.VAI_TRO)
public class VaiTroController {

	@Autowired
	private VaiTroRouteService vaiTroRouteService;
	@Autowired
	private VaiTroService vaiTroService;

	@PostMapping
	public ResponseEntity<?> them(@RequestBody VaiTroReq req){
		// tạo vai trò
		VaiTroEntity vaiTroEntity = vaiTroService.createOrModifyVaiTro(req.getTen());
		// tạo routes mà vai trò có thể đăng nhập
		List<VaiTroRouteEntity> vaiTroRouteEntities = vaiTroRouteService.createVaiTroRoute(vaiTroEntity.getId(), req.getRouteSignature());
		return ResponseEntity.ok("OK");
	}

	@PutMapping
	public ResponseEntity<?> capNhat(TuDienChuongTrinhReq req){
		return ResponseEntity.ok("OK");
	}
}
