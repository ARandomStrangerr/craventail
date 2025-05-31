package main.product.repository;

import main.product.entity.MucLucNganSach;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MucLucNganSachRepository extends JpaRepository<MucLucNganSach, Long> {
} 