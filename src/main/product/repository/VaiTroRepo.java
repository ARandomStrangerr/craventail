package main.product.repository;

import java.util.Optional;

import org.springframework.stereotype.Repository;

import main.product.entity.VaiTroEntity;

@Repository
public interface VaiTroRepo extends BaseRepo<VaiTroEntity, Long> {

	public Optional<VaiTroEntity> findByTen(String ten);
}
