package main.product.entity;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

@Entity
@Table(name = "don_vi")
@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class DonVi {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    String don_vi_chu_quan;
    String ma_don_vi;
    String ten_don_vi;
    String ten_doi_ngoai;
    String dia_chi;
    String ma_chuong;
    String ma_so_don_vi;
    String ma_so_thue;
    String cuc_thue;
    String ma_chuong_thu_thue;
    String ma_so_don_vi_thu_thue;
    String kho_bac_chuyen_thue;
}
