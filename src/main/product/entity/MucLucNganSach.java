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
@Table(name = "muc_luc_ngan_sach")
public class MucLucNganSach extends BaseEntity {
    @Column(name = "nhom")
    String nhom;

    @Column(name = "tieu_nhom")
    String tieuNhom;

    @Column(name = "ten")
    String ten;

    @Column(name = "noi_dung")
    String noiDung;
} 