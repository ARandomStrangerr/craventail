package main.product.repository;

import main.product.entity.SoDuChiTiet;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface SoDuChiTietRepository extends BaseRepository<SoDuChiTiet, Long> {

    @Modifying
    @Query("UPDATE SoDuChiTiet u SET u.soHieuTaiKhoan = :newSoHieuTaiKhoan WHERE u.soHieuTaiKhoan = :soHieuTaiKhoan")
    void updateSoHieuTaiKhoan(@Param("soHieuTaiKhoan") String soHieuTaiKhoan, @Param("newSoHieuTaiKhoan") String newSoHieuTaiKhoan);

    @Modifying
    @Query("UPDATE SoDuChiTiet u SET u.maChuongTrinh = :newMaChuongTrinh WHERE u.maChuongTrinh = :maChuongTrinh")
    void updateMaChuongTrinh(@Param("maChuongTrinh") String maChuongTrinh, @Param("newMaChuongTrinh") String newMaChuongTrinh);

    @Modifying
    @Query("UPDATE SoDuChiTiet u SET u.maCongTrinh = :newMaCongTrinh WHERE u.maCongTrinh = :maCongTrinh")
    void updateMaCongTrinh(@Param("maCongTrinh") String maCongTrinh, @Param("newMaCongTrinh") String newMaCongTrinh);

    @Modifying
    @Query("UPDATE SoDuChiTiet u SET u.maDonVi = :newMaDonVi WHERE u.maDonVi = :maDonVi")
    void updateMaDonVi(@Param("maDonVi") String maDonVi, @Param("newMaDonVi") String newMaDonVi);

    @Modifying
    @Query("""
            UPDATE SoDuChiTiet u
            SET u.maDoiTuong = :newMaDoiTuong, u.doiTuong = :newDoiTuong, u.diaChi = :newDiaChi
            WHERE u.maDoiTuong = :maDoiTuong
            and u.doiTuong = :doiTuong
            AND ((:diaChi IS NULL AND u.diaChi IS NULL) OR (:diaChi IS NOT NULL AND u.diaChi = :diaChi))
            """)
    void updateDoiTuong(@Param("maDoiTuong") String maDoiTuong, @Param("doiTuong") String doiTuong, @Param("diaChi") String diaChi, @Param("newMaDoiTuong") String newMaDoiTuong, @Param("newDoiTuong") String newDoiTuong, @Param("newDiaChi") String newDiaChi);

    @Modifying
    @Query(""" 
            UPDATE SoDuChiTiet u
            SET u.nhomMuc = :newNhomMuc, u.mucTieuMuc = :newMucTieuMuc
            WHERE u.nhomMuc = :nhomMuc
            AND ((:mucTieuMuc IS NULL AND u.mucTieuMuc IS NULL) OR (:mucTieuMuc IS NOT NULL AND u.mucTieuMuc = :mucTieuMuc))
            """)
    void updateNhomTieuNhom(@Param("nhomMuc") String nhomMuc, @Param("mucTieuMuc") String mucTieuMuc, @Param("newNhomMuc") String newNhomMuc, @Param("newMucTieuMuc") String newMucTieuMuc);

}