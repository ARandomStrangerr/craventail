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
public class MucLucNganSachRequest {
    @NotBlank(message = "Nhóm không được để trống")
    @Size(max = 4, message = "Nhóm tối đa 4 ký tự")
    String nhom;

    @Size(max = 5, message = "Tiểu nhóm tối đa 5 ký tự")
    String tieuNhom;

    @NotBlank(message = "Tên không được để trống")
    @Size(max = 12, message = "Tên tối đa 12 ký tự")
    String ten;

    @NotBlank(message = "Nội dung không được để trống")
    @Size(max = 256, message = "Nội dung tối đa 256 ký tự")
    String noiDung;
} 