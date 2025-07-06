package main.product.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import main.product.entity.BaseEntity;

public abstract class BaseService <T1 extends BaseEntity, T2> {

	protected abstract JpaRepository<T1, T2> getRepo(); 

	public T1 softDelete(T2 id) {
		T1 entity = getRepo().findById(id).orElseThrow(() -> new NullPointerException("The provide ID does not match with any record"));
		entity.setSoftDelete(true);
	
		return getRepo().save(entity);
	}

	public T1 createOrUpdate(T1 entity){
		return getRepo().save(entity);
	}

	public T1 getSingle(T2 id){
		return getRepo().findById(id).orElseThrow(() -> new NullPointerException("Không tìm thấy bản ghi với ID"));
	}

	public Page<T1> getByPage(Pageable page){
		return getRepo().findAll(page);
	}
}
