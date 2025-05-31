package main.product.entity;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

@Entity
@Table(name = "tai_khoan_dung")
@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class TaiKhoanDung {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    
    @Column(name = "ten_tai_khoan", nullable = false, length = 55)
    String ten_tai_khoan;
    
    @Column(name = "so_hieu_tai_khoan", nullable = false, length = 10)
    String so_hieu_tai_khoan;
    
    @Column(name = "loai_rut_so_du", nullable = false, length = 1)
    String loai_rut_so_du;
    
    @Column(name = "ten_chu_quan", length = 60)
    String ten_chu_quan;
    
    @Column(name = "tai_khoan_ngan_hang_kho_bac", length = 15)
    String tai_khoan_ngan_hang_kho_bac;
    
    @Column(name = "tam_ung", length = 60)
    String tam_ung;
    
    @Column(name = "ten_ngan_hang_kho_bac", length = 256)
    String ten_ngan_hang_kho_bac;
} 