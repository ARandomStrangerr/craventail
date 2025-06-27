package main.product.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;

import main.product.entity.BaseEntity;

@NoRepositoryBean
public interface BaseRepo<T extends BaseEntity, Long> extends JpaRepository<T, Long> {

	
}
