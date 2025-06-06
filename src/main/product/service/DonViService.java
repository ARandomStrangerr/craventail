package main.product.service;

import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import main.product.dto.request.DonViRequest;
import main.product.entity.DonVi;
import main.product.mapper.IDonViMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import main.product.repository.DonViRepository;

@Service
@Transactional
public class DonViService {
    @Autowired
    private DonViRepository donViRepository;

    @Autowired
    private IDonViMapper donViMapper;

    public Page<DonVi> danhSach(Pageable pageable) {
        return donViRepository.findAll(pageable);
    }

    public DonVi them(DonViRequest request) {
        DonVi donVi = donViMapper.themDonVi(request);
        return donViRepository.save(donVi);
    }

    public DonVi xem(Long id) {
        return donViRepository.findByIdActive(id)
                .orElseThrow(() -> new EntityNotFoundException("Không tìm thấy đơn vị"));
    }

    public DonVi chinhSua(Long id, DonViRequest request) {
        DonVi donVi = xem(id);
        donViMapper.chinhSuaDonVi(donVi, request);

        return donViRepository.save(donVi);
    }

    public void xoa(Long id) {
        if (!donViRepository.existsById(id)) {
            throw new EntityNotFoundException("Không tìm thấy đơn vị");
        }
        donViRepository.softDelete(id);
    }
}
