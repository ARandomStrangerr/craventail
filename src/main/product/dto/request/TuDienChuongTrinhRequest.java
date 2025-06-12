package main.product.dto.request;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;
import main.product.repository.TuDienChuongTrinhRepository;
import main.product.validation.UniqueField;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
@JsonIgnoreProperties(ignoreUnknown = true)
public class TuDienChuongTrinhRequest {
    @NotBlank(message = "Mã chương trình không được để trống")
    @Size(max = 20, message = "Mã chương trình tối đa 20 ký tự")
    @UniqueField(fieldName = "maChuongTrinh", repository = TuDienChuongTrinhRepository.class, message = "Mã chương trình đã tồn tại")
    String maChuongTrinh;

    @NotBlank(message = "Tên chương trình không được để trống")
    @Size(max = 256, message = "Tên chương trình tối đa 256 ký tự")
    String tenChuongTrinh;

    @NotBlank(message = "Mã chương không được để trống")
    @Size(max = 6, message = "Mã chương tối đa 6 ký tự")
    String maChuong;

    @NotBlank(message = "Nguồn vốn không được để trống")
    @Size(min = 2, max = 2, message = "Nguồn vốn phải có đúng 2 ký tự")
    String nguonVon;
} 