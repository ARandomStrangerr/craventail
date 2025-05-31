package main.product.entity;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

@Entity
@Table(name = "muc_luc_ngan_sach")
@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class MucLucNganSach {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    
    @Column(name = "nhom", nullable = false, length = 4)
    String nhom;
    
    @Column(name = "tieu_nhom", nullable = false, length = 5)
    String tieu_nhom;
    
    @Column(name = "ten", nullable = false, length = 12)
    String ten;
    
    @Column(name = "noi_dung", nullable = false, length = 256)
    String noi_dung;
} 