package main.product.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import main.product.entity.VaiTroEntity;
import main.product.repository.VaiTroRepo;

@Service
public class VaiTroService extends BaseService <VaiTroEntity, Long> {

	@Autowired
	private VaiTroRepo repo;

	@Override
	protected VaiTroRepo getRepo() {
			return repo;
	}
	
	public VaiTroEntity createOrModifyVaiTro(String ten){
		VaiTroEntity entity = new VaiTroEntity();
		entity.setTen(ten);
		return repo.save(entity);
	}
}
