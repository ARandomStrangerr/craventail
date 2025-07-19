package main.product.repository;

import java.util.Optional;

import org.springframework.stereotype.Repository;

import main.product.entity.NguoiDungEntity;

@Repository
public interface NguoiDungRepo extends BaseRepo<NguoiDungEntity, Long>{

	public Optional<NguoiDungEntity> findByUsername(String username);

}
