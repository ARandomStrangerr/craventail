package main.product.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import main.product.entity.MucLucNganSachEntity;
import main.product.repository.MucLucNganSachRepo;

@Service
public class MucLucNganSachService extends BaseService<MucLucNganSachEntity, Long>{

	@Autowired
	private MucLucNganSachRepo repo;

	@Override
	protected MucLucNganSachRepo getRepo() {
		return repo;
	}
}
