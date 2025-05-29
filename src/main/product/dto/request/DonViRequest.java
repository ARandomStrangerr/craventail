package main.product.dto.request;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
@JsonIgnoreProperties(ignoreUnknown = true)
public class DonViRequest {

    @Size(max = 256, message = "Đơn vị chủ quản tối đa 256 ký tự")
    String don_vi_chu_quan;

    @Size(max = 20, message = "Mã đơn vị tối đa 20 ký tự")
    String ma_don_vi;

    @NotBlank(message = "Tên đơn vị không được để trống")
    @Size(max = 256, message = "Tên đơn vị tối đa 256 ký tự")
    String ten_don_vi;

    @Size(max = 256, message = "Tên đối ngoại tối đa 256 ký tự")
    String ten_doi_ngoai;

    @NotBlank(message = "Địa chỉ không được để trống")
    @Size(max = 256, message = "Địa chỉ tối đa 256 ký tự")
    String dia_chi;

    @NotBlank(message = "Mã chương không được để trống")
    @Size(max = 6, message = "Mã chương tối đa 6 ký tự")
    String ma_chuong;

    @NotBlank(message = "Mã số đơn vị không được để trống")
    @Size(max = 20, message = "Mã số đơn vị tối đa 20 ký tự")
    String ma_so_don_vi;

    @NotBlank(message = "Mã số thuế không được để trống")
    @Size(max = 10, message = "Mã số thuế tối đa 10 ký tự")
    String ma_so_thue;

    @Size(max = 20, message = "Cục thuế tối đa 20 ký tự")
    String cuc_thue;

    @Size(max = 6, message = "Mã chương đơn vị thu thuế tối đa 6 ký tự")
    String ma_chuong_thu_thue;

    @Size(max = 10, message = "Mã số đơn vị thu thuế tối đa 10 ký tự")
    String ma_so_don_vi_thu_thue;

    @Size(max = 20, message = "Kho bạc chuyển thuế tối đa 20 ký tự")
    String kho_bac_chuyen_thue;
}
