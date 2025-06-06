package main.product.controller;

import jakarta.validation.Valid;
import main.product.dto.request.TaiKhoanDungRequest;
import main.product.dto.response.ApiResponse;
import main.product.entity.TaiKhoanDung;
import main.product.service.TaiKhoanDungService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/tai-khoan-dung")
public class TaiKhoanDungController {

	@Autowired
	private TaiKhoanDungService taiKhoanDungService;

	@GetMapping
	public ResponseEntity<?> danhSach(
			@ModelAttribute TaiKhoanDungRequest request,
			@PageableDefault(size = 10, page = 0, sort = "id", direction = Sort.Direction.ASC) Pageable pageable
	) {
		Page<TaiKhoanDung> result = taiKhoanDungService.search(request, pageable);
		return ResponseEntity.ok(ApiResponse.success(result, "Lấy danh sách thành công"));
	}

	@PostMapping
	public ResponseEntity<?> them(@RequestBody @Valid TaiKhoanDungRequest request) {
		TaiKhoanDung taiKhoanDung = taiKhoanDungService.them(request);
		return ResponseEntity.ok(ApiResponse.success(taiKhoanDung, "Tạo mới thành công"));
	}

	@GetMapping("/{id}")
	public ResponseEntity<?> xem(@PathVariable Long id) {
		TaiKhoanDung taiKhoanDung = taiKhoanDungService.xem(id);
		return ResponseEntity.ok(ApiResponse.success(taiKhoanDung, "Lấy thông tin thành công"));
	}

	@PutMapping("/{id}")
	public ResponseEntity<?> chinhSua(@PathVariable Long id, @RequestBody @Valid TaiKhoanDungRequest request) {
		TaiKhoanDung taiKhoanDung = taiKhoanDungService.chinhSua(id, request);
		return ResponseEntity.ok(ApiResponse.success(taiKhoanDung, "Cập nhật thành công"));
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<?> xoa(@PathVariable Long id) {
		taiKhoanDungService.xoa(id);
		return ResponseEntity.ok(ApiResponse.success(null, "Xóa thành công"));
	}
}
