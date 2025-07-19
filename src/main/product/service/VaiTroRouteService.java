package main.product.service;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

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

			entity = repo.save(entity);
			
			list.add(entity);
		}
		return list;
	}

	public void modify(Long vaiTroId, List<String> routeSignature) {
		if (routeSignature == null) return;
		// find the set to add and remove
		List<VaiTroRouteEntity> currentRoutes = repo.getRouteSignature(vaiTroId);
		Map<String, Long> currentRoutesMap = currentRoutes.stream().collect(
				Collectors.toMap(
					row -> ((VaiTroRouteEntity) row).getRouteSignature(),
					row -> ((VaiTroRouteEntity) row).getId()
					)
				);
		Set<String> oldRoute = currentRoutesMap.keySet(),
			newRoute = new HashSet<>(routeSignature),
			toAdd = new HashSet<>(routeSignature),
			toRemove = new HashSet<>(oldRoute);
		toAdd.removeAll(oldRoute);
		toRemove.removeAll(newRoute);
		// add elements into db
		for (String route : toAdd){
			VaiTroRouteEntity vaiTroRouteEntity = new VaiTroRouteEntity();
			vaiTroRouteEntity.setMaVaiTro(vaiTroId);
			vaiTroRouteEntity.setRouteSignature(route);
			repo.save(vaiTroRouteEntity);
		}
		// remove elements from db
		for (String route : toRemove){
			repo.deleteById(currentRoutesMap.get(route));;
		}
	}
	
	public List<String> getRouteForUser(Long userId){
		return repo.getRouteSignatureForUser(userId);
	}

	public List<String> getRouteForRole(Long userId) {
		return repo.getRouteSignatureString(userId);
	}
}
