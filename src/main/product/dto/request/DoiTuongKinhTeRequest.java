package main.product.dto.request;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;
import main.product.repository.DoiTuongKinhTeRepository;
import main.product.validation.UniqueField;
import main.product.validation.ValidMaSoThue;
import main.product.validation.ValidCCCD;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class DoiTuongKinhTeRequest {
    @NotBlank(message = "Mã đối tượng không được để trống")
    @Size(max = 15, message = "Mã đối tượng tối đa 15 ký tự")
    @UniqueField(message = "Mã đối tượng đã tồn tại", fieldName = "maDoiTuong", repository = DoiTuongKinhTeRepository.class)
    private String maDoiTuong;

    @NotBlank(message = "Tên đối tượng không được để trống")
    @Size(max = 256, message = "Tên đối tượng tối đa 256 ký tự")
    private String doiTuong;

    @Size(max = 256, message = "Địa chỉ tối đa 256 ký tự")
    private String diaChi;

    @Size(max = 20, message = "Mã đơn vị tối đa 20 ký tự")
    private String maDonVi;

    @ValidMaSoThue
    @Size(max = 20, message = "Mã số thuế tối đa 20 ký tự")
    private String maSoThue;

    @ValidCCCD
    @Size(max = 20, message = "Số căn cước công dân tối đa 20 ký tự")
    private String soCanCuocCongDan;
} 