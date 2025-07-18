package main.product.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import main.product.entity.NguoiDungVaiTroEntity;

@Repository
public interface NguoiDungVaiTroRepo extends BaseRepo<NguoiDungVaiTroEntity, Long> {

	@Query(value = """
	SELECT *
	FROM nguoi_dung_schema.nguoi_dung_vai_tro lhs
	JOIN nguoi_dung_schema.vai_tro rhs
	ON lhs.ma_vai_tro = rhs.ma
	WHERE lhs.ma_nguoi_dung = :maNguoiDung
	""", nativeQuery = true)
	public List<Object[]> getUserRole(@Param("maNguoiDung") Long maNguoiDung);
}
