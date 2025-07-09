package main.product.controller;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import main.product.dto.request.RequestInterface;
import main.product.entity.BaseEntity;
import main.product.service.BaseService;

public abstract class BaseController<EntityType extends BaseEntity, ServiceType extends BaseService<EntityType, Long>, RequestType extends RequestInterface> implements ControllerInterface<RequestType> {

	protected abstract ServiceType getService();

	@Override
	@GetMapping
	public ResponseEntity<?> layVeNhieu(@RequestParam (name = "pageSize", defaultValue = "10") int pageSize, @RequestParam (name = "pageNumber", defaultValue = "0") int pageNum) {
		Pageable pageable = PageRequest.of(pageNum, pageSize);
		Page<EntityType> filledPage = getService().getByPage(pageable);
		return ResponseEntity.ok(filledPage);
	}

	@Override
	@GetMapping("/{id}")
	public ResponseEntity<?> layVeMot(@PathVariable Long id){
		return ResponseEntity.ok(getService().getSingle(id));
	}

	@Override
	@DeleteMapping("/{id}")
	public ResponseEntity<?> xoa(@PathVariable Long id){
		EntityType entity = getService().softDelete(id);
		return ResponseEntity.ok("OK");
	}
}
