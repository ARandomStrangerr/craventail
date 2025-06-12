package main.product.entity;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldDefaults;
import main.product.config.LocalDateSerializer;

import java.time.LocalDate;

@Setter
@Getter
@FieldDefaults(level = AccessLevel.PRIVATE)
@Entity
@Table(name = "so_du")
public class SoDu extends BaseEntity {
    @Column(name = "ngay_thang", nullable = false)
    @JsonSerialize(using = LocalDateSerializer.class)
    LocalDate ngayThang;

    @Column(name = "so_hieu_tai_khoan", length = 8, nullable = false)
    String soHieuTaiKhoan;

    @Column(name = "ma_chuong", length = 5)
    String maChuong;

    @Column(name = "du_no")
    Integer duNo;

    @Column(name = "du_no_ngoai_te")
    Double duNoNgoaiTe;

    @Column(name = "du_co")
    Integer duCo;

    @Column(name = "du_co_ngoai_te")
    Double duCoNgoaiTe;

    @Column(name = "loai_tien", length = 5)
    String loaiTien;

    @Column(name = "muc_tieu_muc", length = 12)
    String mucTieuMuc;

    @Column(name = "nhom_muc", length = 4)
    String nhomMuc;

    @Column(name = "ma_chuong_trinh", length = 20)
    String maChuongTrinh;

    @Column(name = "ma_cong_trinh", length = 15)
    String maCongTrinh;

    @Column(name = "ma_nguon", length = 6)
    String maNguon;

    @Column(name = "ma_don_vi", length = 10)
    String maDonVi;

    @Column(name = "dong_dau", length = 10)
    String dongDau;
} 