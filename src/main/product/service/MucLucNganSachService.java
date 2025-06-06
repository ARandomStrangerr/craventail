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
import org.springframework.stereotype.Service;

@Service
@Transactional
public class MucLucNganSachService {
    @Autowired
    private MucLucNganSachRepository mucLucNganSachRepository;

    @Autowired
    private IMucLucNganSachMapper mucLucNganSachMapper;

    public Page<MucLucNganSach> danhSach(Pageable pageable) {
        return mucLucNganSachRepository.findAll(pageable);
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