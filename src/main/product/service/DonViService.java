package main.product.service;

import main.product.dto.request.DonViRequest;
import main.product.entity.DonVi;
import main.product.mapper.IDonViMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import main.product.repository.DonViRepository;

@Service
public class DonViService {
    @Autowired
    private DonViRepository donViRepository;

    @Autowired
    private IDonViMapper donViMapper;

    public DonVi thongTinDonVi() {
        return donViRepository.findFirstByOrderByIdAsc().orElse(null);
    }

    public DonVi them(DonViRequest request) {
        DonVi donVi = donViMapper.themDonVi(request);

        return donViRepository.save(donVi);
    }

    public DonVi chinhSua(DonViRequest request) {
        DonVi donVi = thongTinDonVi();

        donViMapper.chinhSuaDonVi(donVi, request);

        return donViRepository.save(donVi);
    }
}
