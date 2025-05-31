package main.product.repository;

import main.product.entity.TuDienChuongTrinh;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TuDienChuongTrinhRepository extends JpaRepository<TuDienChuongTrinh, Long> {
} 