package main.product.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import main.product.entity.VaiTroRouteEntity;

@Repository
public interface VaiTroRouteRepo extends BaseRepo<VaiTroRouteEntity, Long>{
	
	/**
	 * get all routes associated to a role ID.
	 * this is for modification of roles associated with a role ID.
	 *
	 * @param
	 * Long ~ ID of the role
	 *
	 * @return
	 * List<VaiTroEntity> ~ the list of routes are associated with the role ID
	 **/
	@Query(value = """
	SELECT *
	FROM nguoi_dung_schema.vai_tro_route
	WHERE nguoi_dung_schema.vai_tro_route.ma_vai_tro = :maVaiTro
	""", nativeQuery = true)
	public List<VaiTroRouteEntity> getRouteSignature(@Param("maVaiTro") Long maVaiTro);

	@Query(value = """
	SELECT nguoi_dung_schema.vai_tro_route.route_signature
	FROM nguoi_dung_schema.vai_tro_route
	WHERE nguoi_dung_schema.vai_tro_route.ma_vai_tro = :maVaiTro
	""", nativeQuery = true)
	public List<String> getRouteSignatureString(@Param("maVaiTro") Long maVaiTro);

	/**
	 * get all routes associated to an user ID.
	 * this is for getting route a person can access to
	 * 
	 * @param
	 * Long ~ ID of the user
	 *
	 * @return
	 * List<String> ~ the list of sinagure associated with the user ID
	 **/
	@Query(value = """
	SELECT rhs.route_signature
	FROM nguoi_dung_schema.nguoi_dung_vai_tro lhs
	JOIN nguoi_dung_schema.vai_tro_route rhs
	ON lhs.ma_vai_tro = rhs.ma_vai_tro
	WHERE lhs.ma_nguoi_dung = :userId
	""", nativeQuery = true)
	public List<String> getRouteSignatureForUser(@Param("userId") Long userId);

}
