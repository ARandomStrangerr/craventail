package main.product.repository;

import main.product.entity.TaiKhoanDung;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface TaiKhoanDungRepository extends BaseRepository<TaiKhoanDung, Long> {
    @Query("SELECT e FROM TaiKhoanDung e WHERE e.deleted = false")
    Page<TaiKhoanDung> findAll(Pageable pageable);
} 