package main.product.service;

import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import main.product.dto.request.MucLucNganSachRequest;
import main.product.entity.MucLucNganSach;
import main.product.mapper.IMucLucNganSachMapper;
import main.product.repository.MucLucNganSachRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class MucLucNganSachService {
    @Autowired
    private MucLucNganSachRepository mucLucNganSachRepository;

    @Autowired
    private IMucLucNganSachMapper mucLucNganSachMapper;

    public Page<MucLucNganSach> search(MucLucNganSachRequest request, Pageable pageable) {
        Specification<MucLucNganSach> spec = Specification.where(null);

        String nhom = request.getNhom();
        if (nhom != null && !nhom.isEmpty()) {
            spec = spec.and((root, query, cb) ->
                    cb.like(cb.lower(root.get("nhom")), "%" + nhom.toLowerCase() + "%"));
        }

        String tieu_nhom = request.getTieu_nhom();
        if (tieu_nhom != null && !tieu_nhom.isEmpty()) {
            spec = spec.and((root, query, cb) ->
                    cb.like(cb.lower(root.get("tieu_nhom")), "%" + tieu_nhom.toLowerCase() + "%"));
        }

        String ten = request.getTen();
        if (ten != null && !ten.isEmpty()) {
            spec = spec.and((root, query, cb) ->
                    cb.like(cb.lower(root.get("ten")), "%" + ten.toLowerCase() + "%"));
        }

        String noi_dung = request.getNoi_dung();
        if (noi_dung != null && !noi_dung.isEmpty()) {
            spec = spec.and((root, query, cb) ->
                    cb.like(cb.lower(root.get("noi_dung")), "%" + noi_dung.toLowerCase() + "%"));
        }

        return mucLucNganSachRepository.findAll(spec, pageable);
    }

    public MucLucNganSach them(MucLucNganSachRequest request) {
        MucLucNganSach mucLucNganSach = mucLucNganSachMapper.themMucLucNganSach(request);
        return mucLucNganSachRepository.save(mucLucNganSach);
    }

    public MucLucNganSach xem(Long id) {
        return mucLucNganSachRepository.findByIdActive(id)
                .orElseThrow(() -> new EntityNotFoundException("Không tìm thấy mục lục ngân sách"));
    }

    public MucLucNganSach chinhSua(Long id, MucLucNganSachRequest request) {
        MucLucNganSach mucLucNganSach = xem(id);
        mucLucNganSachMapper.chinhSuaMucLucNganSach(mucLucNganSach, request);
        return mucLucNganSachRepository.save(mucLucNganSach);
    }

    public void xoa(Long id) {
        if (!mucLucNganSachRepository.existsById(id)) {
            throw new EntityNotFoundException("Không tìm thấy mục lục ngân sách");
        }
        mucLucNganSachRepository.softDelete(id);
    }
} 