package main.product.dto.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;
import main.product.repository.DanhMucDonViRepository;
import main.product.validation.UniqueField;

@Data
public class DanhMucDonViRequest {
    @NotBlank(message = "Mã đơn vị không được để trống")
    @Size(max = 20, message = "Mã đơn vị không được vượt quá 20 ký tự")
    @UniqueField(fieldName = "maDonVi", repository = DanhMucDonViRepository.class, message = "Mã đơn vị đã tồn tại")
    private String maDonVi;

    @NotBlank(message = "Tên đơn vị không được để trống")
    @Size(max = 256, message = "Tên đơn vị không được vượt quá 256 ký tự")
    private String tenDonVi;

    @Size(max = 15, message = "Số tài khoản kho bạc không được vượt quá 15 ký tự")
    private String soTaiKhoanKhoBac;

    @Size(max = 256, message = "Tên ngân hàng kho bạc không được vượt quá 256 ký tự")
    private String tenNganHangKhoBac;

    @Size(max = 10, message = "Mã số sử dụng ngân sách không được vượt quá 10 ký tự")
    private String maSoSuDungNganSach;
} 