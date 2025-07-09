package main.product.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import main.product.entity.TaiKhoanDungEntity;
import main.product.repository.TaiKhoanDungRepo;

@Service
public class TaiKhoanDungService extends BaseService <TaiKhoanDungEntity, Long> {

	@Autowired
	private TaiKhoanDungRepo repo;

	protected TaiKhoanDungRepo getRepo() {
		return repo;
	}	
}
