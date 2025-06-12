package main.product.dto.request;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;
import main.product.repository.DonViRepository;
import main.product.validation.UniqueField;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
@JsonIgnoreProperties(ignoreUnknown = true)
public class DonViRequest {

    @Size(max = 256, message = "Đơn vị chủ quản tối đa 256 ký tự")
    String donViChuQuan;

    @Size(max = 20, message = "Mã đơn vị tối đa 20 ký tự")
    String maDonVi;

    @NotBlank(message = "Tên đơn vị không được để trống")
    @Size(max = 256, message = "Tên đơn vị tối đa 256 ký tự")
    String tenDonVi;

    @Size(max = 256, message = "Tên đối ngoại tối đa 256 ký tự")
    String tenDoiNgoai;

    @NotBlank(message = "Địa chỉ không được để trống")
    @Size(max = 256, message = "Địa chỉ tối đa 256 ký tự")
    String diaChi;

    @Size(max = 6, message = "Mã chương tối đa 6 ký tự")
    String maChuong;

    @NotBlank(message = "Mã số đơn vị không được để trống")
    @Size(max = 20, message = "Mã số đơn vị tối đa 20 ký tự")
    @UniqueField(fieldName = "maSoDonVi", repository = DonViRepository.class, message = "Mã đơn vị đã tồn tại")
    String maSoDonVi;

    @NotBlank(message = "Mã số thuế không được để trống")
    @Size(max = 10, message = "Mã số thuế tối đa 10 ký tự")
    String maSoThue;

    @Size(max = 256, message = "Cục thuế tối đa 256 ký tự")
    String cucThue;

    @Size(max = 6, message = "Mã chương đơn vị thu thuế tối đa 6 ký tự")
    String maChuongThuThue;

    @Size(max = 10, message = "Mã số đơn vị thu thuế tối đa 10 ký tự")
    String maSoDonViThuThue;

    @Size(max = 20, message = "Kho bạc chuyển thuế tối đa 20 ký tự")
    String khoBacChuyenThue;
}
