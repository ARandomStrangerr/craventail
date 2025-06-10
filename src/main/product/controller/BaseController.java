package main.product.controller;

import jakarta.validation.Valid;
import main.product.dto.response.ApiResponse;
import main.product.entity.BaseEntity;
import main.product.service.BaseService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

public abstract class BaseController<T extends BaseEntity, R> {

    protected abstract BaseService<T, R> getService();


    @GetMapping
    public ResponseEntity<?> index(
            @ModelAttribute R request,
            @PageableDefault(size = 10, page = 0,sort = "id", direction = Sort.Direction.DESC) Pageable pageable
    ) {
        Page<T> result = getService().search(request, pageable);

        return ResponseEntity.ok(ApiResponse.success(result, "Lấy danh sách thành công"));
    }

    @PostMapping
    public ResponseEntity<?> create(@RequestBody @Valid R request) {
        T entity = getService().create(request);
        return ResponseEntity.ok(ApiResponse.success(entity, "Tạo mới thành công"));
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> show(@PathVariable Long id) {
        T entity = getService().show(id);
        return ResponseEntity.ok(ApiResponse.success(entity, "Lấy thông tin thành công"));
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> update(@PathVariable Long id, @RequestBody @Valid R request) {
        T entity = getService().update(id, request);
        return ResponseEntity.ok(ApiResponse.success(entity, "Cập nhật thành công"));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id) {
        getService().delete(id);
        return ResponseEntity.ok(ApiResponse.success(null, "Xóa thành công"));
    }
}
