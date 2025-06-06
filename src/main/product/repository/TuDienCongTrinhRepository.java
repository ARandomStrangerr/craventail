package main.product.repository;

import main.product.entity.TuDienCongTrinh;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface TuDienCongTrinhRepository extends BaseRepository<TuDienCongTrinh, Long>, JpaSpecificationExecutor<TuDienCongTrinh> {
    @Query("SELECT e FROM TuDienCongTrinh e WHERE e.deleted = false")
    Page<TuDienCongTrinh> findAll(Pageable pageable);
} 