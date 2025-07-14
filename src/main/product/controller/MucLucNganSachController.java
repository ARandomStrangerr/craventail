package main.product.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import main.product.dto.request.MucLucNganSachReq;
import main.product.entity.MucLucNganSachEntity;
import main.product.service.MucLucNganSachService;

@RestController
@RequestMapping(value = RouteDefinition.MUC_LUC_NGAN_SACH)
public class MucLucNganSachController extends BaseController<MucLucNganSachEntity, MucLucNganSachService, MucLucNganSachReq>{

	@Autowired
	private MucLucNganSachService service;

	@Override
	protected MucLucNganSachService getService() {
		return service;
	}

	@Override
	@PutMapping
	public ResponseEntity<?> capNhat(Long id, MucLucNganSachReq req) {
		MucLucNganSachEntity entity = service.getSingle(id);
		entity.setTen(req.getTen());
		entity.setNhom(req.getNhom());
		entity.setNoiDung(req.getNoiDung());
		entity.setTieuNhom(req.getTieuNhom());

		service.createOrUpdate(entity);

		return ResponseEntity.ok("OK");
	}
	
	@Override
	@PostMapping
	public ResponseEntity<?> them(MucLucNganSachReq req) {
		MucLucNganSachEntity entity = new MucLucNganSachEntity();
		entity.setTen(req.getTen());
		entity.setNhom(req.getNhom());
		entity.setNoiDung(req.getNoiDung());
		entity.setTieuNhom(req.getTieuNhom());
		service.createOrUpdate(entity);

		service.createOrUpdate(entity);

		return ResponseEntity.ok("OK");
	}
}
