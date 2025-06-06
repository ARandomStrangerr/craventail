package main.product.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

@Getter
@Setter
@FieldDefaults(level = AccessLevel.PRIVATE)
@Entity
@Table(name = "doi_tuong_kinh_te")
public class DoiTuongKinhTe extends BaseEntity {
    String ma_doi_tuong;
    String doi_tuong;
    String dia_chi;
    String ma_don_vi;
    String ma_so_thue;
    String so_can_cuoc_cong_dan;
} 