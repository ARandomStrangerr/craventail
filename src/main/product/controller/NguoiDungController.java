package main.product.controller;

import java.util.Map;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/nguoi-dung")
class NguoiDungController {

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String danhSach() {
		return "Trang cá nhân";
	}

	@RequestMapping(value = "/", method = RequestMethod.POST)
	public ResponseEntity<?> them(@RequestBody Map<String, String> body) {
		
		String tenNguoiDung = body.get("tenNguoiDung");
		String matKhau = body.get("matKhau");
		String ten = body.get("ten");

		if (tenNguoiDung == null) return ResponseEntity.badRequest().body("Thiếu tên đăng nhập");
		if (matKhau == null) return ResponseEntity.badRequest().body("Thiếu mật khẩu");
		if (ten == null) return ResponseEntity.badRequest().body("Thiếu tên người dùng");
		
		// todo action to create user
		return ResponseEntity.ok().body("Đã thêm người dùng");
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public void xem(@PathVariable String id) {

	}

	@RequestMapping(value = "/{id}", method = RequestMethod.PUT)
	public void chinhSua(@PathVariable String id) {

	}

	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<?> xoaNguoiDung(@RequestBody String id) {
		return ResponseEntity.ok("Đã xoá");
	}
}
