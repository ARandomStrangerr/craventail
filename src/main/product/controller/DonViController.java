package main.product.controller;

import jakarta.validation.Valid;
import main.product.dto.request.DonViRequest;
import main.product.dto.request.DonViRequest;
import main.product.dto.response.ApiResponse;
import main.product.entity.DonVi;
import main.product.entity.DonVi;
import main.product.service.DonViService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/don-vi")
public class DonViController {

    @Autowired
    private DonViService donViService;

    @GetMapping
    public ResponseEntity<?> danhSach(
            @RequestParam(defaultValue = "1") int page,
            @RequestParam(defaultValue = "10") int size,
            @RequestParam(defaultValue = "id") String sortBy,
            @RequestParam(defaultValue = "desc") String sortDir) {

        Sort.Direction direction = Sort.Direction.fromString(sortDir);
        PageRequest pageRequest = PageRequest.of(page - 1, size, Sort.by(direction, sortBy));
        Page<DonVi> result = donViService.danhSach(pageRequest);

        return ResponseEntity.ok(ApiResponse.success(result, "Lấy danh sách thành công"));
    }

    @PostMapping
    public ResponseEntity<?> them(@RequestBody @Valid DonViRequest request) {
        DonVi donVi = donViService.them(request);
        return ResponseEntity.ok(ApiResponse.success(donVi, "Tạo mới thành công"));
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> xem(@PathVariable Long id) {
        DonVi donVi = donViService.xem(id);
        return ResponseEntity.ok(ApiResponse.success(donVi, "Lấy thông tin thành công"));
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> chinhSua(@PathVariable Long id, @RequestBody @Valid DonViRequest request) {
        DonVi donVi = donViService.chinhSua(id, request);
        return ResponseEntity.ok(ApiResponse.success(donVi, "Cập nhật thành công"));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> xoa(@PathVariable Long id) {
        donViService.xoa(id);
        return ResponseEntity.ok(ApiResponse.success(null, "Xóa thành công"));
    }
}
