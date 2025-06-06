package main.product.controller;

import jakarta.validation.Valid;
import main.product.dto.request.DoiTuongKinhTeRequest;
import main.product.dto.response.ApiResponse;
import main.product.entity.DoiTuongKinhTe;
import main.product.service.DoiTuongKinhTeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/doi-tuong-kinh-te")
public class DoiTuongKinhTeController {
    @Autowired
    private DoiTuongKinhTeService doiTuongKinhTeService;

    @GetMapping
    public ResponseEntity<?> danhSach(
            @ModelAttribute DoiTuongKinhTeRequest request,
            @PageableDefault(size = 10, page = 0,sort = "id", direction = Sort.Direction.ASC) Pageable pageable
    ) {
        Page<DoiTuongKinhTe> result = doiTuongKinhTeService.search(request, pageable);

        return ResponseEntity.ok(ApiResponse.success(result, "Lấy danh sách thành công"));
    }

    @PostMapping
    public ResponseEntity<?> them(@RequestBody @Valid DoiTuongKinhTeRequest request) {
        DoiTuongKinhTe doiTuongKinhTe = doiTuongKinhTeService.them(request);
        return ResponseEntity.ok(ApiResponse.success(doiTuongKinhTe, "Tạo mới thành công"));
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> xem(@PathVariable Long id) {
        DoiTuongKinhTe doiTuongKinhTe = doiTuongKinhTeService.xem(id);
        return ResponseEntity.ok(ApiResponse.success(doiTuongKinhTe, "Lấy thông tin thành công"));
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> chinhSua(@PathVariable Long id, @RequestBody @Valid DoiTuongKinhTeRequest request) {
        DoiTuongKinhTe doiTuongKinhTe = doiTuongKinhTeService.chinhSua(id, request);
        return ResponseEntity.ok(ApiResponse.success(doiTuongKinhTe, "Cập nhật thành công"));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> xoa(@PathVariable Long id) {
        doiTuongKinhTeService.xoa(id);
        return ResponseEntity.ok(ApiResponse.success(null, "Xóa thành công"));
    }
} 