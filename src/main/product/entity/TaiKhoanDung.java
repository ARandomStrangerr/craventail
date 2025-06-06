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
    String ten_tai_khoan;
    String so_hieu_tai_khoan;
    String loai_rut_so_du;
    String ten_chu_quan;
    String tai_khoan_ngan_hang_kho_bac;
    String tam_ung;
    String ten_ngan_hang_kho_bac;
} 