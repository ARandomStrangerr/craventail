package main.product.controller;

import main.product.dto.request.DangNhap;
import main.product.entity.NguoiDung;
import main.product.repository.NguoiDungRepository;
import main.product.dto.response.ApiResponse;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    private NguoiDungRepository nguoiDungRepository;

    @PostMapping("/login")
    public ResponseEntity<ApiResponse<?>> login(@RequestBody @Valid DangNhap request) {
        Optional<NguoiDung> nguoiDungOpt = nguoiDungRepository.findByUsername(request.getUsername());

        if (nguoiDungOpt.isEmpty()) {
            return ResponseEntity.status(401)
                    .body(ApiResponse.error("Sai tài khoản hoặc mật khẩu"));
        }

        NguoiDung nguoiDung = nguoiDungOpt.get();

        if (!nguoiDung.getPassword().equals(request.getPassword())) {
            return ResponseEntity.status(401)
                    .body(ApiResponse.error("Sai tài khoản hoặc mật khẩu"));
        }

        return ResponseEntity.ok(ApiResponse.success(nguoiDung.getUsername(), "Đăng nhập thành công"));
    }
}

