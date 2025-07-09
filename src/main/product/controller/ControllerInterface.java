package main.product.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import main.product.dto.request.RequestInterface;

public interface ControllerInterface<RequestType extends RequestInterface> {

	@PostMapping
	public ResponseEntity<?> them(@RequestBody RequestType req); // create

	@GetMapping
	public ResponseEntity<?> layVeNhieu(@RequestParam (name = "pageSize", defaultValue = "10") int pageSize, @RequestParam (name = "pageNumber", defaultValue = "0") int pageNum); // get multiple records
																																																							
	@GetMapping("/{id}")
	public ResponseEntity<?> layVeMot(@PathVariable Long id); // get single record with details

	@DeleteMapping("/{id}")
	public ResponseEntity<?> xoa(@PathVariable Long id); // soft delete

	@PutMapping("/{id}")
	public ResponseEntity<?> capNhat(@PathVariable Long id, @RequestBody RequestType req); // update
}
