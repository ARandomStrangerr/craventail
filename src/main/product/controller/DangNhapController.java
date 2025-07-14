package main.product.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import jakarta.servlet.http.HttpSession;
import main.product.dto.request.DangNhapReq;
import main.product.entity.NguoiDungEntity;
import main.product.service.NguoiDungService;

@RestController
@RequestMapping(value = RouteDefinition.XAC_THUC)
public class DangNhapController {

	@Autowired
	private NguoiDungService service;
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	@PostMapping
	public ResponseEntity<?> dangNhap(@RequestBody DangNhapReq req, HttpSession session){
		Optional<NguoiDungEntity> entity = service.getByUsername(req.getTenNguoiDung());
		if (entity.isEmpty() || !passwordEncoder.matches(req.getMatKhau(), entity.get().getPassword()))
			return ResponseEntity.status(401).body("Tên đăng nhập hoặc mật khẩu không chính xác");
		session.setAttribute("username", req.getTenNguoiDung());
		return ResponseEntity.ok("Thành công");
	}

	@DeleteMapping
	public ResponseEntity<?> dangXuat(HttpSession session){
		session.invalidate();
		return ResponseEntity.ok("Đăng xuất");
	}
}
