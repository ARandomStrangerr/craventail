package main.product.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import main.product.entity.DonVi;

import java.util.Optional;

@Repository
public interface DonViRepository extends JpaRepository<DonVi, Integer> {
    Optional<DonVi> findFirstByOrderByIdAsc();
}
