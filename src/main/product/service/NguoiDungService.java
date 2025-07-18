package main.product.service;

import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

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
	
	/**
	 * @param
	 * String ~ name of the account owner
	 * String ~ username
	 * String ~ raw password
	 * List<String> ~ name of the roles
	 *
	 * @return
	 * NguoiDungEntity ~ created enetity
	 *
	 * @throws
	 * NullPointerException ~ when there is no role is found according to the account
	 **/
	public NguoiDungEntity createUser(String ten, String tenNguoiDung, String matKhau, List<String> vaiTro) throws NullPointerException {
		NguoiDungEntity nguoiDungEntity = new NguoiDungEntity();
		nguoiDungEntity.setName(ten);
		nguoiDungEntity.setUsername(tenNguoiDung);
		nguoiDungEntity.setPassword(passwordEncoder.encode(matKhau));
		
		for (String v : vaiTro) {
			Optional<VaiTroEntity> vaiTroEntity = vaiTroRepo.findByTen(v);
			
			if (vaiTroEntity.isEmpty())
				throw new NullPointerException("Không tìm thấy vai trò");

			NguoiDungVaiTroEntity nguoiDungVaiTroEntity = new NguoiDungVaiTroEntity();
			nguoiDungVaiTroEntity.setMaNguoiDung(nguoiDungEntity.getId());
			nguoiDungVaiTroEntity.setMaVaiTro(vaiTroEntity.get().getId());

			nguoiDungVaiTroRepo.save(nguoiDungVaiTroEntity);
		}

		nguoiDungEntity = repo.save(nguoiDungEntity);
		
		return nguoiDungEntity;
	}

	public NguoiDungEntity updateUser(Long userId, String ten, String matKhau, List<String> vaiTro) {
		Optional<NguoiDungEntity> nguoiDungEntity = repo.findById(userId);

		if (nguoiDungEntity.isEmpty())
			throw new UsernameNotFoundException("Không tìm thấy người dùng");
		
		boolean isChanged = false;
		if (ten != null) {
			nguoiDungEntity.get().setName(ten);
			isChanged = true;
		}
		if (matKhau != null) {
			nguoiDungEntity.get().setPassword(passwordEncoder.encode(matKhau));
			isChanged = true;
		}
		if (isChanged) repo.save(nguoiDungEntity.get());

		// remove the duplicates on the db and the update
		// left over on the db side is the one that not listed in the update = remove
		// left over on the update side is the one listed in the update but not in db = add
		if (vaiTro != null){
			List<Object[]> currentUserRole = nguoiDungVaiTroRepo.getUserRole(userId);
			Map<String, Long> currentUserRoleMap = currentUserRole.stream().collect(
					Collectors.toMap(
						row -> (String) row[4], 
						row -> (Long) row[0]
						)
					);
			Set<String> oldRole = currentUserRoleMap.keySet();
			Set<String> newRole = new HashSet<>(vaiTro);
			Set<String> toRemove = new HashSet<>(oldRole);
			Set<String> toAdd = new HashSet<>(newRole);
			toRemove.removeAll(newRole);
			toAdd.removeAll(oldRole);
			// remove from database
			for (String role : toRemove) {
				nguoiDungVaiTroRepo.deleteById(currentUserRoleMap.get(role));
			}
			// add into database
			for (String role : toAdd) {
				Optional<VaiTroEntity> vaiTroEntity = vaiTroRepo.findByTen(role);
				if (vaiTroEntity.isEmpty()) throw new NullPointerException("Vai trò người dùng không tồn tại");
				NguoiDungVaiTroEntity nguoiDungVaiTroEntity = new NguoiDungVaiTroEntity();
				nguoiDungVaiTroEntity.setMaNguoiDung(userId);
				nguoiDungVaiTroEntity.setMaVaiTro(vaiTroEntity.get().getId());
				nguoiDungVaiTroRepo.save(nguoiDungVaiTroEntity);
			}
		}
		return nguoiDungEntity.get();
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
