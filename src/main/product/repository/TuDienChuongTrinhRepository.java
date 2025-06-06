package main.product.repository;

import main.product.entity.TuDienChuongTrinh;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface TuDienChuongTrinhRepository extends BaseRepository<TuDienChuongTrinh, Long>, JpaSpecificationExecutor<TuDienChuongTrinh> {
    @Query("SELECT e FROM TuDienChuongTrinh e WHERE e.deleted = false")
    Page<TuDienChuongTrinh> findAll(Pageable pageable);
} 