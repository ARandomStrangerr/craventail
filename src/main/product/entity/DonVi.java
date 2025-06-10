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
@Table(name = "don_vi")
public class DonVi extends BaseEntity {
    @Column(name = "don_vi_chu_quan")
    String donViChuQuan;

    @Column(name = "ma_don_vi")
    String maDonVi;

    @Column(name = "ten_don_vi")
    String tenDonVi;

    @Column(name = "ten_doi_ngoai")
    String tenDoiNgoai;

    @Column(name = "dia_chi")
    String diaChi;

    @Column(name = "ma_chuong")
    String maChuong;

    @Column(name = "ma_so_don_vi")
    String maSoDonVi;

    @Column(name = "ma_so_thue")
    String maSoThue;

    @Column(name = "cuc_thue")
    String cucThue;

    @Column(name = "ma_chuong_thu_thue")
    String maChuongThuThue;

    @Column(name = "ma_so_don_vi_thu_thue")
    String maSoDonViThuThue;

    @Column(name = "kho_bac_chuyen_thue")
    String khoBacChuyenThue;
}
