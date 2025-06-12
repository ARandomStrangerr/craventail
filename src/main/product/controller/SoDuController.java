package main.product.controller;

import main.product.dto.request.SoDuRequest;
import main.product.dto.response.ApiResponse;
import main.product.entity.SoDu;
import main.product.service.BaseService;
import main.product.service.SoDuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/so-du")
public class SoDuController extends BaseController<SoDu, SoDuRequest> {
    @Autowired
    private SoDuService soDuService;

    @Override
    protected BaseService<SoDu, SoDuRequest> getService() {
        return soDuService;
    }

    @GetMapping("/get-form-data")
    public ResponseEntity<?> getFormData() {
        return ResponseEntity.ok(ApiResponse.success(soDuService.getFormData(), "Lấy danh sách thành công"));
    }
} 