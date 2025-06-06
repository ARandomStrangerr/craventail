package main.product.repository;

import main.product.entity.DonVi;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface DonViRepository extends BaseRepository<DonVi, Long>, JpaSpecificationExecutor<DonVi> {
    @Query("SELECT e FROM DonVi e WHERE e.deleted = false")
    Page<DonVi> findAll(Pageable pageable);
}
