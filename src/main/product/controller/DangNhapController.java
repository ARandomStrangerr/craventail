package main.product.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import jakarta.servlet.http.HttpSession;
import main.product.dto.request.DangNhapReq;
import main.product.entity.NguoiDungEntity;
import main.product.service.NguoiDungService;
import main.product.service.VaiTroRouteService;

@RestController
@RequestMapping(value = RouteDefinition.XAC_THUC)
public class DangNhapController {

	@Autowired
	private NguoiDungService service;
	@Autowired
	private VaiTroRouteService vaiTroRouteService;
	
	@PostMapping
	public ResponseEntity<?> dangNhap(@RequestBody DangNhapReq req, HttpSession session){
		// login action
		NguoiDungEntity entity;
		try {	
			entity = service.login(req.getTenNguoiDung(), req.getMatKhau());
		} catch (UsernameNotFoundException | BadCredentialsException e) {
			return ResponseEntity.status(401).body(e.getMessage());
		} 
		session.setAttribute("username", req.getTenNguoiDung());

		// get the viable routes
		List<String> viableRouteSignatures = vaiTroRouteService.getRouteForUser(entity.getId());
		session.setAttribute("route", viableRouteSignatures);

		return ResponseEntity.ok(viableRouteSignatures);
	}

	@DeleteMapping
	public ResponseEntity<?> dangXuat(HttpSession session){
		session.invalidate();
		return ResponseEntity.ok("Đăng xuất");
	}
}
