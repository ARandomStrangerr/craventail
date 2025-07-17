package main.product.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import main.product.entity.NguoiDungEntity;

@Repository
public interface NguoiDungRepo extends BaseRepo<NguoiDungEntity, Long>{

	public Optional<NguoiDungEntity> findByUsername(String username);

	@Query(value = """
	SELECT rhs.route_signature
	FROM nguoi_dung_schema.nguoi_dung_vai_tro lhs
	JOIN nguoi_dung_schema.vai_tro_route rhs
	ON lhs.ma_vai_tro = rhs.ma_vai_tro
	WHERE lhs.ma_nguoi_dung = :userId
	""", nativeQuery = true)
	public List<String> getRouteSignature(@Param("userId") Long userId);
}
