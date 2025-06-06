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
@Table(name = "muc_luc_ngan_sach")
public class MucLucNganSach extends BaseEntity {
    String nhom;
    String tieu_nhom;
    String ten;
    String noi_dung;
} 