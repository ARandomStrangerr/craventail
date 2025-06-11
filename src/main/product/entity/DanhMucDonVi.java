package main.product.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

@Setter
@Getter
@FieldDefaults(level = AccessLevel.PRIVATE)
@Entity
@Table(name = "danh_muc_don_vi")
public class DanhMucDonVi extends BaseEntity {
    @Column(name = "ma_don_vi", length = 20, unique = true, nullable = false)
    String maDonVi;

    @Column(name = "ten_don_vi", length = 256, nullable = false)
    String tenDonVi;

    @Column(name = "so_tai_khoan_kho_bac", length = 15)
    String soTaiKhoanKhoBac;

    @Column(name = "ten_ngan_hang_kho_bac", length = 256)
    String tenNganHangKhoBac;

    @Column(name = "ma_so_su_dung_ngan_sach", length = 10)
    String maSoSuDungNganSach;
} 