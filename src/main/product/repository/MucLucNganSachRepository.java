package main.product.repository;

import main.product.entity.MucLucNganSach;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface MucLucNganSachRepository extends BaseRepository<MucLucNganSach, Long> {
    @Query("SELECT e FROM MucLucNganSach e WHERE e.deleted = false")
    Page<MucLucNganSach> findAll(Pageable pageable);
} 