package main.product.controller;

import jakarta.validation.Valid;
import main.product.dto.request.DonViRequest;
import main.product.dto.response.ApiResponse;
import main.product.entity.DonVi;
import main.product.service.DonViService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/don-vi")
public class DonViController {

    @Autowired
    private DonViService donViService;

    @GetMapping
    public ResponseEntity<?> danhSach(
            @ModelAttribute DonViRequest request,
            @PageableDefault(size = 10, page = 0, sort = "id", direction = Sort.Direction.ASC) Pageable pageable
    ) {
        Page<DonVi> result = donViService.search(request, pageable);
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
