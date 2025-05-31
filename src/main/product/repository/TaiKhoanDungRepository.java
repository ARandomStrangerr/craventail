package main.product.repository;

import main.product.entity.TaiKhoanDung;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TaiKhoanDungRepository extends JpaRepository<TaiKhoanDung, Long> {
} 