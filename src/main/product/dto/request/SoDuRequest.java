package main.product.dto.request;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;
import main.product.config.LocalDateDeserializer;
import main.product.config.LocalDateSerializer;

import java.time.LocalDate;

@Data
public class SoDuRequest {
    @NotNull(message = "Ngày tháng không được để trống")
    @JsonDeserialize(using = LocalDateDeserializer.class)
    @JsonSerialize(using = LocalDateSerializer.class)
    private LocalDate ngayThang;

    @NotNull(message = "Số hiệu tài khoản không được để trống")
    @Size(max = 8, message = "Số hiệu tài khoản không được vượt quá 8 ký tự")
    private String soHieuTaiKhoan;

    @Size(max = 5, message = "Mã chương không được vượt quá 5 ký tự")
    private String maChuong;

    private Integer duNo;

    private Double duNoNgoaiTe;

    private Integer duCo;

    private Double duCoNgoaiTe;

    @Size(max = 5, message = "Loại tiền không được vượt quá 5 ký tự")
    private String loaiTien;

    @Size(max = 12, message = "Mục tiêu mục không được vượt quá 12 ký tự")
    private String mucTieuMuc;

    @Size(max = 4, message = "Nhóm mục không được vượt quá 4 ký tự")
    private String nhomMuc;

    @Size(max = 20, message = "Mã chương trình không được vượt quá 20 ký tự")
    private String maChuongTrinh;

    @Size(max = 15, message = "Mã công trình không được vượt quá 15 ký tự")
    private String maCongTrinh;

    @Size(max = 6, message = "Mã nguồn không được vượt quá 6 ký tự")
    private String maNguon;

    @Size(max = 10, message = "Mã đơn vị không được vượt quá 10 ký tự")
    private String maDonVi;

    @Size(max = 10, message = "Dòng dấu không được vượt quá 10 ký tự")
    private String dongDau;
} 