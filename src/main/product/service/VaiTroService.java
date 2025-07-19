package main.product.service;

import java.util.Optional;

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
	
	public VaiTroEntity create(String ten){
		VaiTroEntity entity = new VaiTroEntity();
		entity.setTen(ten);
		return repo.save(entity);
	}

	public VaiTroEntity modify(Long id, String ten) throws NullPointerException {
		Optional<VaiTroEntity> optionalEntity = repo.findById(id);
		VaiTroEntity entity;
		if (optionalEntity.isEmpty())
			throw new NullPointerException();
		else
			entity = optionalEntity.get();
		
		boolean changed = false;
		
		if (ten != null && !ten.equals(entity.getTen())){
			entity.setTen(ten);
			changed = true;
		}

		if (changed)
			entity = repo.save(entity);

		return entity;
	}
}
