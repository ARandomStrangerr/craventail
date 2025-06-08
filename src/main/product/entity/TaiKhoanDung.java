package main.product.entity;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

@Setter
@Getter
@FieldDefaults(level = AccessLevel.PRIVATE)
@Entity
@Table(name = "tai_khoan_dung")
public class TaiKhoanDung extends BaseEntity {
    @Column(name = "ten_tai_khoan")
    String tenTaiKhoan;

    @Column(name = "so_hieu_tai_khoan")
    String soHieuTaiKhoan;

    @Column(name = "loai_rut_so_du")
    String loaiRutSoDu;

    @Column(name = "ten_chu_quan")
    String tenChuQuan;

    @Column(name = "tai_khoan_ngan_hang_kho_bac")
    String taiKhoanNganHangKhoBac;

    @Column(name = "tam_ung")
    String tamUng;

    @Column(name = "ten_ngan_hang_kho_bac")
    String tenNganHangKhoBac;
} 