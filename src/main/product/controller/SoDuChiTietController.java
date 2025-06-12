package main.product.controller;

import main.product.dto.request.SoDuChiTietRequest;
import main.product.dto.response.ApiResponse;
import main.product.entity.SoDuChiTiet;
import main.product.service.BaseService;
import main.product.service.SoDuChiTietService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/so-du-chi-tiet")
public class SoDuChiTietController extends BaseController<SoDuChiTiet, SoDuChiTietRequest> {
    @Autowired
    private SoDuChiTietService SoDuChiTietService;

    @Override
    protected BaseService<SoDuChiTiet, SoDuChiTietRequest> getService() {
        return SoDuChiTietService;
    }

    @GetMapping("/get-form-data")
    public ResponseEntity<?> getFormData() {
        return ResponseEntity.ok(ApiResponse.success(SoDuChiTietService.getFormData(), "Lấy danh sách thành công"));
    }
} 