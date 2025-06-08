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
@Table(name = "tu_dien_cong_trinh")
public class TuDienCongTrinh extends BaseEntity {
    @Column(name = "ma_cong_trinh")
    private String maCongTrinh;

    @Column(name = "ten_cong_trinh")
    private String tenCongTrinh;

    @Column(name = "ma_chuong")
    private String maChuong;
} 