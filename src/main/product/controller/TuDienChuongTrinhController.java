package main.product.controller;

import jakarta.validation.Valid;
import main.product.dto.request.TuDienChuongTrinhRequest;
import main.product.dto.response.ApiResponse;
import main.product.entity.TuDienChuongTrinh;
import main.product.service.TuDienChuongTrinhService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/tu-dien-chuong-trinh")
public class TuDienChuongTrinhController {

	@Autowired
	private TuDienChuongTrinhService tuDienChuongTrinhService;

	@GetMapping
	public ResponseEntity<?> danhSach(
			@RequestParam(defaultValue = "1") int page,
			@RequestParam(defaultValue = "10") int size,
			@RequestParam(defaultValue = "id") String sortBy,
			@RequestParam(defaultValue = "desc") String sortDir) {
		
		Sort.Direction direction = Sort.Direction.fromString(sortDir);
		PageRequest pageRequest = PageRequest.of(page - 1, size, Sort.by(direction, sortBy));
		Page<TuDienChuongTrinh> result = tuDienChuongTrinhService.danhSach(pageRequest);
		
		return ResponseEntity.ok(ApiResponse.success(result, "Lấy danh sách thành công"));
	}

	@PostMapping
	public ResponseEntity<?> them(@RequestBody @Valid TuDienChuongTrinhRequest request) {
		TuDienChuongTrinh tuDienChuongTrinh = tuDienChuongTrinhService.them(request);
		return ResponseEntity.ok(ApiResponse.success(tuDienChuongTrinh, "Tạo mới thành công"));
	}

	@GetMapping("/{id}")
	public ResponseEntity<?> xem(@PathVariable Long id) {
		TuDienChuongTrinh tuDienChuongTrinh = tuDienChuongTrinhService.xem(id);
		return ResponseEntity.ok(ApiResponse.success(tuDienChuongTrinh, "Lấy thông tin thành công"));
	}

	@PutMapping("/{id}")
	public ResponseEntity<?> chinhSua(@PathVariable Long id, @RequestBody @Valid TuDienChuongTrinhRequest request) {
		TuDienChuongTrinh tuDienChuongTrinh = tuDienChuongTrinhService.chinhSua(id, request);
		return ResponseEntity.ok(ApiResponse.success(tuDienChuongTrinh, "Cập nhật thành công"));
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<?> xoa(@PathVariable Long id) {
		tuDienChuongTrinhService.xoa(id);
		return ResponseEntity.ok(ApiResponse.success(null, "Xóa thành công"));
	}
}
