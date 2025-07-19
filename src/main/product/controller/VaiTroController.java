package main.product.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import main.product.dto.request.VaiTroReq;
import main.product.entity.VaiTroEntity;
import main.product.entity.VaiTroRouteEntity;
import main.product.service.VaiTroRouteService;
import main.product.service.VaiTroService;

@RestController
@RequestMapping(RouteDefinition.VAI_TRO)
public class VaiTroController extends BaseController<VaiTroEntity, VaiTroService, VaiTroReq> {

	@Autowired
	private VaiTroRouteService vaiTroRouteService;
	@Autowired
	private VaiTroService vaiTroService;

	@Override
	protected VaiTroService getService() {
			return vaiTroService;
	}

	@PostMapping
	public ResponseEntity<?> them(@RequestBody VaiTroReq req){
		// tạo vai trò
		VaiTroEntity vaiTroEntity = vaiTroService.create(req.getTen());
		// tạo routes mà vai trò có thể đăng nhập
		List<VaiTroRouteEntity> vaiTroRouteEntities = vaiTroRouteService.createVaiTroRoute(vaiTroEntity.getId(), req.getRouteSignature());
		return ResponseEntity.ok("OK");
	}

	@PutMapping("/{id}")
	public ResponseEntity<?> capNhat(@PathVariable Long id, @RequestBody VaiTroReq req){
		// update role
		VaiTroEntity vaiTroEntity = vaiTroService.modify(id, req.getTen());
		
		// update vai tro route
		vaiTroRouteService.modify(vaiTroEntity.getId(), req.getRouteSignature());

		return ResponseEntity.ok("OK");
	}

	@Override
	@GetMapping("/{id}")
	public ResponseEntity<?> layVeMot(@PathVariable Long id){ 
		// get general details
		VaiTroEntity vaiTroEntity = vaiTroService.getSingle(id);

		// get routes
		List<String> vaiTroRoute = vaiTroRouteService.getRouteForRole(id);

		Map<String, Object> returnVal = new HashMap<>();
		returnVal.put("ten", vaiTroEntity.getTen());
		returnVal.put("routeSignature", vaiTroRoute);
		
		return ResponseEntity.ok(returnVal);
	}
}
