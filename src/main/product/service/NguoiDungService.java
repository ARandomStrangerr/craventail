package main.product.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import main.product.entity.NguoiDungEntity;
import main.product.repository.NguoiDungRepo;

@Service
public class NguoiDungService extends BaseService<NguoiDungEntity, Long>{

	@Autowired
	NguoiDungRepo repo;

	protected NguoiDungRepo getRepo() {
		return repo;
	}	
}
