package main.product.entity;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

@Entity
@Table(name = "tu_dien_cong_trinh")
@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class TuDienCongTrinh {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    
    @Column(name = "ma_cong_trinh", nullable = false, length = 20)
    String ma_cong_trinh;
    
    @Column(name = "ten_cong_trinh", nullable = false, length = 256)
    String ten_cong_trinh;
    
    @Column(name = "ma_chuong", nullable = false, length = 6)
    String ma_chuong;
} 