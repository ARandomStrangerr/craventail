package main.product.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import main.product.dto.request.TuDienChuongTrinhReq;
import main.product.entity.TuDienChuongTrinhEntity;
import main.product.service.TuDienChuongTrinhService;

@RestController
@RequestMapping(RouteDefinition.TU_DIEN_CHUONG_TRINH)
public class TuDienChuongTrinhController extends BaseController<TuDienChuongTrinhEntity, TuDienChuongTrinhService, TuDienChuongTrinhReq> {

	@Autowired
	private TuDienChuongTrinhService service;

	@Override
	protected TuDienChuongTrinhService getService() {
		return service;
	}

	@Override
	@PutMapping
	public ResponseEntity<?> capNhat(Long id, TuDienChuongTrinhReq req) {
		TuDienChuongTrinhEntity entity = service.getSingle(id);
		entity.setMaChuong(req.getMaChuong());
		entity.setNguonVon(req.getNguonVon());
		entity.setMaChuongTrinh(req.getMaChuongTrinh());
		entity.setTenChuongTrinh(req.getTenChuongTrinh());
		return ResponseEntity.ok("OK");	
	}

	@Override
	@PostMapping
	public ResponseEntity<?> them(TuDienChuongTrinhReq req) {
		TuDienChuongTrinhEntity entity = new TuDienChuongTrinhEntity();
		entity.setMaChuong(req.getMaChuong());
		entity.setNguonVon(req.getNguonVon());
		entity.setMaChuongTrinh(req.getMaChuongTrinh());
		entity.setTenChuongTrinh(req.getTenChuongTrinh());
		return ResponseEntity.ok("OK");
	}
}
