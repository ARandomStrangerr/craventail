package main.product.controller;

import jakarta.validation.Valid;
import main.product.dto.request.MucLucNganSachRequest;
import main.product.dto.response.ApiResponse;
import main.product.entity.MucLucNganSach;
import main.product.service.MucLucNganSachService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/muc-luc-ngan-sach")
public class MucLucNganSachController {

	@Autowired
	private MucLucNganSachService mucLucNganSachService;

	@GetMapping
	public ResponseEntity<?> danhSach(
			@RequestParam(defaultValue = "1") int page,
			@RequestParam(defaultValue = "10") int size,
			@RequestParam(defaultValue = "id") String sortBy,
			@RequestParam(defaultValue = "desc") String sortDir) {
		
		Sort.Direction direction = Sort.Direction.fromString(sortDir);
		PageRequest pageRequest = PageRequest.of(page - 1, size, Sort.by(direction, sortBy));
		Page<MucLucNganSach> result = mucLucNganSachService.danhSach(pageRequest);
		
		return ResponseEntity.ok(ApiResponse.success(result, "Lấy danh sách thành công"));
	}

	@PostMapping
	public ResponseEntity<?> them(@RequestBody @Valid MucLucNganSachRequest request) {
		MucLucNganSach mucLucNganSach = mucLucNganSachService.them(request);
		return ResponseEntity.ok(ApiResponse.success(mucLucNganSach, "Tạo mới thành công"));
	}

	@GetMapping("/{id}")
	public ResponseEntity<?> xem(@PathVariable Long id) {
		MucLucNganSach mucLucNganSach = mucLucNganSachService.xem(id);
		return ResponseEntity.ok(ApiResponse.success(mucLucNganSach, "Lấy thông tin thành công"));
	}

	@PutMapping("/{id}")
	public ResponseEntity<?> chinhSua(@PathVariable Long id, @RequestBody @Valid MucLucNganSachRequest request) {
		MucLucNganSach mucLucNganSach = mucLucNganSachService.chinhSua(id, request);
		return ResponseEntity.ok(ApiResponse.success(mucLucNganSach, "Cập nhật thành công"));
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<?> xoa(@PathVariable Long id) {
		mucLucNganSachService.xoa(id);
		return ResponseEntity.ok(ApiResponse.success(null, "Xóa thành công"));
	}
}
