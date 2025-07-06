package main.product.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import main.product.entity.NguoiDungEntity;
import main.product.repository.NguoiDungRepo;

@Service
public class NguoiDungService extends BaseService<NguoiDungEntity, Long>{

	@Autowired
	private NguoiDungRepo repo;

	protected NguoiDungRepo getRepo() {
		return repo;
	}
	
	public Optional<NguoiDungEntity> getByUsername(String username) {
		return this.repo.findByUsername(username);
	}
}
