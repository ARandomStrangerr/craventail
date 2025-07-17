package main.product.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import main.product.entity.NguoiDungEntity;
import main.product.entity.NguoiDungVaiTroEntity;
import main.product.repository.NguoiDungRepo;

@Service
public class NguoiDungService extends BaseService<NguoiDungEntity, Long>{

	@Autowired
	private NguoiDungRepo repo;
	@Autowired
	private PasswordEncoder passwordEncoder;

	protected NguoiDungRepo getRepo() {
		return repo;
	}
	
	public NguoiDungEntity createUser(String ten, String tenNguoiDung, String matKhau, List<String> vaiTro) {
		NguoiDungEntity nguoiDungEntity = new NguoiDungEntity();
		nguoiDungEntity.setName(ten);
		nguoiDungEntity.setUsername(tenNguoiDung);
		nguoiDungEntity.setPassword(passwordEncoder.encode(matKhau));
		nguoiDungEntity = repo.save(nguoiDungEntity);
		
		for (String v : vaiTro) {
		}
		return nguoiDungEntity;
	}

	public Optional<NguoiDungEntity> getByUsername(String username) {
		return this.repo.findByUsername(username);
	}
}
