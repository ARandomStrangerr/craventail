package main.product.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import main.product.entity.NguoiDungEntity;
import main.product.entity.NguoiDungVaiTroEntity;
import main.product.entity.VaiTroEntity;
import main.product.repository.NguoiDungRepo;
import main.product.repository.NguoiDungVaiTroRepo;
import main.product.repository.VaiTroRepo;

@Service
public class NguoiDungService extends BaseService<NguoiDungEntity, Long>{

	@Autowired
	private NguoiDungRepo repo;
	@Autowired
	private VaiTroRepo vaiTroRepo;
	@Autowired
	private NguoiDungVaiTroRepo nguoiDungVaiTroRepo;
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
			VaiTroEntity vaiTroEntity = vaiTroRepo.findByTen(v).orElseThrow(() -> new RuntimeException("Không tìm thấy vai trò này"));

			NguoiDungVaiTroEntity nguoiDungVaiTroEntity = new NguoiDungVaiTroEntity();
			nguoiDungVaiTroEntity.setMaNguoiDung(nguoiDungEntity.getId());
			nguoiDungVaiTroEntity.setMaVaiTro(vaiTroEntity.getId());

			nguoiDungVaiTroRepo.save(nguoiDungVaiTroEntity);
		}
		return nguoiDungEntity;
	}

	/**
	 * @input
	 * String ~ username
	 * String ~ raw password
	 * 
	 * @output
	 * List<String> ~ list of API that this user can access to
	 *
	 * @throws
	 * UsernameNotFoundException ~ when there is no account found with the username
	 * BadCredentialsException ~ when the password is incorrect
	 **/
	public List<String> login(String username, String password) throws NullPointerException, BadCredentialsException {
		Optional<NguoiDungEntity> entity = this.repo.findByUsername(username);

		if (entity.isEmpty())
			throw new UsernameNotFoundException("Tài khoản người dùng hoặc mật khẩu không chính xác");
		
		if (!passwordEncoder.matches(password, entity.get().getPassword()))
			throw new BadCredentialsException("Tài khoản người dùng hoặc mật khẩu không chính xác");
		
		return repo.getRouteSignature(entity.get().getId());
	}
}
