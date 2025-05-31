package main.product.dto.request;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
@JsonIgnoreProperties(ignoreUnknown = true)
public class TaiKhoanDungRequest {
    @NotBlank(message = "Tên tài khoản không được để trống")
    @Size(max = 55, message = "Tên tài khoản tối đa 55 ký tự")
    String ten_tai_khoan;

    @NotBlank(message = "Số hiệu tài khoản không được để trống")
    @Size(max = 10, message = "Số hiệu tài khoản tối đa 10 ký tự")
    String so_hieu_tai_khoan;

    @NotBlank(message = "Loại rút số dư không được để trống")
    @Pattern(regexp = "[0-5]", message = "Loại rút số dư phải là một trong các giá trị: 0,1,2,3,4,5")
    String loai_rut_so_du;

    @Size(max = 60, message = "Tên chủ quản tối đa 60 ký tự")
    String ten_chu_quan;

    @Size(max = 15, message = "Tài khoản ngân hàng kho bạc tối đa 15 ký tự")
    String tai_khoan_ngan_hang_kho_bac;

    @Size(max = 60, message = "Tạm ứng tối đa 60 ký tự")
    String tam_ung;

    @Size(max = 256, message = "Tên ngân hàng kho bạc tối đa 256 ký tự")
    String ten_ngan_hang_kho_bac;
} 