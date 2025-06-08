package main.product.service;

import jakarta.transaction.Transactional;
import main.product.dto.request.DonViRequest;
import main.product.entity.DonVi;
import main.product.mapper.BaseMapper;
import main.product.mapper.IDonViMapper;
import main.product.repository.BaseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import main.product.repository.DonViRepository;

@Service
@Transactional
public class DonViService extends BaseService <DonVi, DonViRequest> {
    @Autowired
    private DonViRepository donViRepository;

    @Autowired
    private IDonViMapper donViMapper;


    @Override
    protected BaseRepository<DonVi, Long> getRepository() {
        return donViRepository;
    }

    @Override
    protected BaseMapper<DonVi, DonViRequest> getMapper() {
        return donViMapper;
    }

    @Override
    protected String getNotFoundMessage() {
        return  "Không tìm thấy đơn vị";
    }

    @Override
    protected Specification<DonVi> buildSearchSpecification(DonViRequest request) {
        Specification<DonVi> spec = Specification.where(null);
        spec = and(spec, createLikeSpecification("maDonVi", request.getMaDonVi()));
        spec = and(spec, createLikeSpecification("tenDonVi", request.getTenDonVi()));

        return spec;
    }
}
