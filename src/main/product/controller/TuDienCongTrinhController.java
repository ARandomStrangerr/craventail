package main.product.controller;

import jakarta.validation.Valid;
import main.product.dto.request.TuDienCongTrinhRequest;
import main.product.dto.response.ApiResponse;
import main.product.entity.TuDienCongTrinh;
import main.product.service.TuDienCongTrinhService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/tu-dien-cong-trinh")
public class TuDienCongTrinhController {

	@Autowired
	private TuDienCongTrinhService tuDienCongTrinhService;

	@GetMapping
	public ResponseEntity<?> danhSach(
			@ModelAttribute TuDienCongTrinhRequest request,
			@PageableDefault(size = 10, page = 0, sort = "id", direction = Sort.Direction.ASC) Pageable pageable
	) {
		Page<TuDienCongTrinh> result = tuDienCongTrinhService.search(request, pageable);
		return ResponseEntity.ok(ApiResponse.success(result, "Lấy danh sách thành công"));
	}

	@PostMapping
	public ResponseEntity<?> them(@RequestBody @Valid TuDienCongTrinhRequest request) {
		TuDienCongTrinh tuDienCongTrinh = tuDienCongTrinhService.them(request);
		return ResponseEntity.ok(ApiResponse.success(tuDienCongTrinh, "Tạo mới thành công"));
	}

	@GetMapping("/{id}")
	public ResponseEntity<?> xem(@PathVariable Long id) {
		TuDienCongTrinh tuDienCongTrinh = tuDienCongTrinhService.xem(id);
		return ResponseEntity.ok(ApiResponse.success(tuDienCongTrinh, "Lấy thông tin thành công"));
	}

	@PutMapping("/{id}")
	public ResponseEntity<?> chinhSua(@PathVariable Long id, @RequestBody @Valid TuDienCongTrinhRequest request) {
		TuDienCongTrinh tuDienCongTrinh = tuDienCongTrinhService.chinhSua(id, request);
		return ResponseEntity.ok(ApiResponse.success(tuDienCongTrinh, "Cập nhật thành công"));
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<?> xoa(@PathVariable Long id) {
		tuDienCongTrinhService.xoa(id);
		return ResponseEntity.ok(ApiResponse.success(null, "Xóa thành công"));
	}
}
