package main.product.repository;

import main.product.entity.DoiTuongKinhTe;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface DoiTuongKinhTeRepository extends BaseRepository<DoiTuongKinhTe, Long>, JpaSpecificationExecutor<DoiTuongKinhTe> {
    @Query("SELECT COUNT(e) > 0 FROM DoiTuongKinhTe e WHERE e.ma_doi_tuong = :ma_doi_tuong AND e.deleted = false")
    boolean existsByMaDoiTuong(@Param("ma_doi_tuong") String ma_doi_tuong);

    @Query("SELECT COUNT(e) > 0 FROM DoiTuongKinhTe e WHERE e.ma_doi_tuong = :ma_doi_tuong AND e.id != :id AND e.deleted = false")
    boolean existsByMaDoiTuongAndIdNot(@Param("ma_doi_tuong") String ma_doi_tuong, @Param("id") Long id);
} 