package main.product.entity;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

@Entity
@Table(name = "tu_dien_chuong_trinh")
@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class TuDienChuongTrinh {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    
    @Column(name = "ma_chuong_trinh", nullable = false, length = 20)
    String ma_chuong_trinh;
    
    @Column(name = "ten_chuong_trinh", nullable = false, length = 256)
    String ten_chuong_trinh;
    
    @Column(name = "ma_chuong", nullable = false, length = 6)
    String ma_chuong;
    
    @Column(name = "nguon_von", nullable = false, length = 2)
    String nguon_von;
} 