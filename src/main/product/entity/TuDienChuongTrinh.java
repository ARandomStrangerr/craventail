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
@Table(name = "tu_dien_chuong_trinh")
public class TuDienChuongTrinh extends BaseEntity {
    private String ma_chuong_trinh;
    private String ten_chuong_trinh;
    private String ma_chuong;
    private String nguon_von;
} 