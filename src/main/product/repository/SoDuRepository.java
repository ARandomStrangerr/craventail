package main.product.repository;

import main.product.entity.SoDu;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface SoDuRepository extends BaseRepository<SoDu, Long> {

    @Modifying
    @Query("UPDATE SoDu u SET u.soHieuTaiKhoan = :newSoHieuTaiKhoan WHERE u.soHieuTaiKhoan = :soHieuTaiKhoan")
    void updateSoHieuTaiKhoan(@Param("soHieuTaiKhoan") String soHieuTaiKhoan, @Param("newSoHieuTaiKhoan") String newSoHieuTaiKhoan);

    @Modifying
    @Query("UPDATE SoDu u SET u.maChuongTrinh = :newMaChuongTrinh WHERE u.maChuongTrinh = :maChuongTrinh")
    void updateMaChuongTrinh(@Param("maChuongTrinh") String maChuongTrinh, @Param("newMaChuongTrinh") String newMaChuongTrinh);


    @Modifying
    @Query("UPDATE SoDu u SET u.maCongTrinh = :newMaCongTrinh WHERE u.maCongTrinh = :maCongTrinh")
    void updateMaCongTrinh(@Param("maCongTrinh") String maCongTrinh, @Param("newMaCongTrinh") String newMaCongTrinh);

    @Modifying
    @Query("UPDATE SoDu u SET u.maDonVi = :newMaDonVi WHERE u.maDonVi = :maDonVi")
    void updateMaDonVi(@Param("maDonVi") String maDonVi, @Param("newMaDonVi") String newMaDonVi);

    @Modifying
    @Query(""" 
            UPDATE SoDu u
            SET u.nhomMuc = :newNhomMuc, u.mucTieuMuc = :newMucTieuMuc
            WHERE u.nhomMuc = :nhomMuc
            AND ((:mucTieuMuc IS NULL AND u.mucTieuMuc IS NULL) OR (:mucTieuMuc IS NOT NULL AND u.mucTieuMuc = :mucTieuMuc))
            """)
    void updateNhomTieuNhom(@Param("nhomMuc") String nhomMuc, @Param("mucTieuMuc") String mucTieuMuc, @Param("newNhomMuc") String newNhomMuc, @Param("newMucTieuMuc") String newMucTieuMuc);

} 