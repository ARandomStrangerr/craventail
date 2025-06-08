package main.product.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

@Getter
@Setter
@FieldDefaults(level = AccessLevel.PRIVATE)
@Entity
@Table(name = "doi_tuong_kinh_te")
public class DoiTuongKinhTe extends BaseEntity {
    @Column(name = "ma_doi_tuong")
    String maDoiTuong;

    @Column(name = "doi_tuong")
    String doiTuong;

    @Column(name = "dia_chi")
    String diaChi;

    @Column(name = "ma_don_vi")
    String maDonVi;

    @Column(name = "ma_so_thue")
    String maSoThue;

    @Column(name = "so_can_cuoc_cong_dan")
    String soCanCuocCongDan;
} 