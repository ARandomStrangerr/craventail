package main.product.controller;

import jakarta.validation.Valid;
import main.product.dto.request.DonViRequest;
import main.product.dto.response.ApiResponse;
import main.product.entity.DonVi;
import main.product.service.DonViService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/don-vi")
public class DonViController {

    @Autowired
    private DonViService donViService;

    @GetMapping
    public ResponseEntity<?> thongTinDonVi() {
        return ResponseEntity.ok(ApiResponse.success(donViService.thongTinDonVi(), ""));
    }

   @PostMapping
    public ResponseEntity<?> them(@RequestBody @Valid DonViRequest donViRequest) {
        DonVi donVi = donViService.them(donViRequest);
        return ResponseEntity.ok(ApiResponse.success(donVi, "Tạo mới thành công"));
    }

   @PutMapping
    public ResponseEntity<?> chinhSua(@RequestBody @Valid DonViRequest donViRequest) {
        DonVi donVi = donViService.chinhSua(donViRequest);
        return ResponseEntity.ok(ApiResponse.success(donVi, "Chỉnh sửa thành công"));
    }
}
