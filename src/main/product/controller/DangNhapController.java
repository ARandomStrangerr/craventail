package main.product.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import jakarta.servlet.http.HttpSession;
import main.product.dto.request.DangNhapReq;
import main.product.entity.NguoiDungEntity;
import main.product.service.NguoiDungService;

@RestController
@RequestMapping("/dang-nhap")
public class DangNhapController {

	@Autowired
	private NguoiDungService service;
	
	@PostMapping
	public ResponseEntity<?> dangNhap(@RequestBody DangNhapReq req, HttpSession session){
		Optional<NguoiDungEntity> entity = service.getByUsername(req.getTenNguoiDung());	
		if (entity.isEmpty() || !entity.get().getPassword().equals(req.getMatKhau()))
			return ResponseEntity.status(401).body("Tên đăng nhập hoặc mật khẩu không chính xác");
		session.setAttribute("username", req.getTenNguoiDung());
		return ResponseEntity.ok("Thành công");
	}
}
