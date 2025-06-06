package main.product.entity;

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
@Table(name = "tu_dien_cong_trinh")
public class TuDienCongTrinh extends BaseEntity {
    private String ma_cong_trinh;
    private String ten_cong_trinh;
    private String ma_chuong;
} 