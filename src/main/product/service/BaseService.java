package main.product.service;

import org.springframework.data.jpa.repository.JpaRepository;

import main.product.entity.BaseEntity;

public abstract class BaseService <T1 extends BaseEntity, T2> {

	protected abstract JpaRepository<T1, T2> getRepo(); 

	public T1 softDelete(T2 id) {
		T1 entity = getRepo().findById(id).orElseThrow(() -> new NullPointerException("The provide ID does not match with any record"));
		entity.setSoftDelete(true);
		
		return getRepo().save(entity);
	}

	public BaseEntity create(T1 entity){
		return getRepo().save(entity);
	}
}
