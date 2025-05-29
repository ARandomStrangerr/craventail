package main.product.repository;

import main.product.entity.TuDienCongTrinh;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface TuDienCongTrinhRepository extends JpaRepository<TuDienCongTrinh, Long> {
    Page<TuDienCongTrinh> findAll(Pageable pageable);
} 