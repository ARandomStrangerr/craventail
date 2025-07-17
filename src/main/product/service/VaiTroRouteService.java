package main.product.service;

import java.util.LinkedList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import main.product.entity.VaiTroRouteEntity;
import main.product.repository.VaiTroRouteRepo;

@Service
public class VaiTroRouteService extends BaseService<VaiTroRouteEntity, Long> {

	@Autowired
	private VaiTroRouteRepo repo;

	@Override
	protected VaiTroRouteRepo getRepo() {
			return repo;
	}
	
	public List<VaiTroRouteEntity> createVaiTroRoute(Long vaiTroId, List<String> routeSignature) {
		List<VaiTroRouteEntity> list = new LinkedList<>();
		for (String signature : routeSignature){
			VaiTroRouteEntity entity = new VaiTroRouteEntity();
			entity.setMaVaiTro(vaiTroId);
			entity.setRouteSignature(signature);
			list.add(entity);
		}
		return list;
	}
}
