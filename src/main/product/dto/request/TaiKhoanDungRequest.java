package main.product.dto.request;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;
import main.product.repository.TaiKhoanDungRepository;
import main.product.validation.UniqueField;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
@JsonIgnoreProperties(ignoreUnknown = true)
public class TaiKhoanDungRequest {
    @NotBlank(message = "Tên tài khoản không được để trống")
    @Size(max = 55, message = "Tên tài khoản tối đa 55 ký tự")
    String tenTaiKhoan;

    @NotBlank(message = "Số hiệu tài khoản không được để trống")
    @Size(max = 10, message = "Số hiệu tài khoản tối đa 10 ký tự")
    @UniqueField(message = "Số hiệu tài khoản đã tồn tại", fieldName = "soHieuTaiKhoan", repository = TaiKhoanDungRepository.class)
    String soHieuTaiKhoan;

    @NotBlank(message = "Loại rút số dư không được để trống")
    @Pattern(regexp = "[0-5]", message = "Loại rút số dư phải là một trong các giá trị: 0,1,2,3,4,5")
    String loaiRutSoDu;

    @Size(max = 60, message = "Tên chủ quản tối đa 60 ký tự")
    String tenChuQuan;

    @Size(max = 15, message = "Tài khoản ngân hàng kho bạc tối đa 15 ký tự")
    String taiKhoanNganHangKhoBac;

    @Size(max = 60, message = "Tạm ứng tối đa 60 ký tự")
    String tamUng;

    @Size(max = 256, message = "Tên ngân hàng kho bạc tối đa 256 ký tự")
    String tenNganHangKhoBac;
} 