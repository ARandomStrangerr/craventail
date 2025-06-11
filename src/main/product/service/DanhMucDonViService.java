package main.product.service;

import jakarta.transaction.Transactional;
import main.product.dto.request.DanhMucDonViRequest;
import main.product.entity.DanhMucDonVi;
import main.product.mapper.BaseMapper;
import main.product.mapper.IDanhMucDonViMapper;
import main.product.repository.BaseRepository;
import main.product.repository.DanhMucDonViRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class DanhMucDonViService extends BaseService<DanhMucDonVi, DanhMucDonViRequest> {
    @Autowired
    private DanhMucDonViRepository danhMucDonViRepository;

    @Autowired
    private IDanhMucDonViMapper danhMucDonViMapper;

    @Override
    protected BaseRepository<DanhMucDonVi, Long> getRepository() {
        return danhMucDonViRepository;
    }

    @Override
    protected BaseMapper<DanhMucDonVi, DanhMucDonViRequest> getMapper() {
        return danhMucDonViMapper;
    }

    @Override
    protected String getNotFoundMessage() {
        return "Không tìm thấy danh mục đơn vị";
    }

    @Override
    protected Specification<DanhMucDonVi> buildSearchSpecification(DanhMucDonViRequest request) {
        Specification<DanhMucDonVi> spec = Specification.where(null);

        spec = and(spec, createLikeSpecification("maDonVi", request.getMaDonVi()));
        spec = and(spec, createLikeSpecification("tenDonVi", request.getTenDonVi()));
        spec = and(spec, createLikeSpecification("soTaiKhoanKhoBac", request.getSoTaiKhoanKhoBac()));
        spec = and(spec, createLikeSpecification("tenNganHangKhoBac", request.getTenNganHangKhoBac()));
        spec = and(spec, createLikeSpecification("maSoSuDungNganSach", request.getMaSoSuDungNganSach()));

        return spec;
    }
} 