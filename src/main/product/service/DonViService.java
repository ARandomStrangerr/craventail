package main.product.service;

import org.springframework.beans.factory.annotation.Autowired;

import main.product.entity.DonViEntity;
import main.product.repository.DonViRepo;

public class DonViService extends BaseService<DonViEntity, Long> {
	@Autowired
	private DonViRepo repo;

	protected DonViRepo getRepo() {
		return repo;
	}
}
