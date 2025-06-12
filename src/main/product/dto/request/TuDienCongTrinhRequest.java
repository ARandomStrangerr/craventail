package main.product.dto.request;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;
import main.product.repository.TuDienCongTrinhRepository;
import main.product.validation.UniqueField;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
@JsonIgnoreProperties(ignoreUnknown = true)
public class TuDienCongTrinhRequest {
    @NotBlank(message = "Mã công trình không được để trống")
    @Size(max = 20, message = "Mã công trình tối đa 20 ký tự")
    @UniqueField(fieldName = "maCongTrinh", repository = TuDienCongTrinhRepository.class, message = "Mã công trình đã tồn tại")
    String maCongTrinh;

    @NotBlank(message = "Tên công trình không được để trống")
    @Size(max = 256, message = "Tên công trình tối đa 256 ký tự")
    String tenCongTrinh;

    @NotBlank(message = "Mã chương không được để trống")
    @Size(max = 6, message = "Mã chương tối đa 6 ký tự")
    String maChuong;
} 