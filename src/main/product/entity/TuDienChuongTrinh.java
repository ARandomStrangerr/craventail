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
    @Column(name = "ma_chuong_trinh")
    private String maChuongTrinh;

    @Column(name = "ten_chuong_trinh")
    private String tenChuongTrinh;

    @Column(name = "ma_chuong")
    private String maChuong;

    @Column(name = "nguon_von")
    private String nguonVon;
} 