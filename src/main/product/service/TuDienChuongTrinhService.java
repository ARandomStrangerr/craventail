package main.product.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import main.product.entity.TuDienChuongTrinhEntity;
import main.product.repository.TuDienChuongTrinhRepo;

@Service
public class TuDienChuongTrinhService extends BaseService<TuDienChuongTrinhEntity, Long> {

	@Autowired
	private TuDienChuongTrinhRepo repo;

	@Override
	protected TuDienChuongTrinhRepo getRepo() {
		return repo;
	}
}
