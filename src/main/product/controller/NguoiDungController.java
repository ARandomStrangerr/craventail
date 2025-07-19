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

import main.product.dto.request.NguoiDungReq;
import main.product.entity.NguoiDungEntity;
import main.product.service.NguoiDungService;
import main.product.service.VaiTroRouteService;

@RestController
@RequestMapping(value = RouteDefinition.NGUOI_DUNG)
public class NguoiDungController extends BaseController<NguoiDungEntity, NguoiDungService, NguoiDungReq> {
	
	@Autowired
	private NguoiDungService service;
	@Autowired
	private VaiTroRouteService vaiTroRouteService;
	
	protected NguoiDungService getService(){
		return service;
	}

	@Override
	@PostMapping
	public ResponseEntity<?> them(@RequestBody NguoiDungReq req){
		// create the new user
		service.createUser(req.getTen(), req.getTenNguoiDung(), req.getMatKhau(), req.getVaiTro());
		// add user to the role table
		return ResponseEntity.ok("Thành công tạo người dùng mới");
	}

	@Override
	@PutMapping("/{id}")
	public ResponseEntity<?> capNhat(@PathVariable Long id, @RequestBody NguoiDungReq req){
		service.updateUser(id, req.getTen(), req.getMatKhau(), req.getVaiTro());
		return ResponseEntity.ok("OK");
	}

	@Override
	@GetMapping("/{id}")
	public ResponseEntity<?> layVeMot(@PathVariable Long id) {
		// get the user general information
		NguoiDungEntity nguoiDungEntity = service.getSingle(id);

		// get the user role
		List<String> routeList = vaiTroRouteService.getRouteForUser(id);

		Map<String, Object> returnValue = new HashMap<>();
		returnValue.put("tenNguoiDung", nguoiDungEntity.getUsername());
		returnValue.put("ten", nguoiDungEntity.getUsername());
		returnValue.put("ngayTao", nguoiDungEntity.getCreateDate());
		returnValue.put("routeSignature", routeList);
		
		return ResponseEntity.ok(returnValue);
	}
}
