package main.product.service;

import jakarta.transaction.Transactional;
import main.product.dto.request.SoDuRequest;
import main.product.entity.SoDu;
import main.product.mapper.BaseMapper;
import main.product.mapper.ISoDuMapper;
import main.product.repository.BaseRepository;
import main.product.repository.SoDuRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class SoDuService extends BaseService<SoDu, SoDuRequest> {
    @Autowired
    private SoDuRepository soDuRepository;

    @Autowired
    private ISoDuMapper soDuMapper;

    @Override
    protected BaseRepository<SoDu, Long> getRepository() {
        return soDuRepository;
    }

    @Override
    protected BaseMapper<SoDu, SoDuRequest> getMapper() {
        return soDuMapper;
    }

    @Override
    protected String getNotFoundMessage() {
        return "Không tìm thấy số dư";
    }

    @Override
    protected Specification<SoDu> buildSearchSpecification(SoDuRequest request) {
        Specification<SoDu> spec = Specification.where(null);

        if (request.getNgayThang() != null) {
            spec = and(spec, (root, query, cb) -> cb.equal(root.get("ngayThang"), request.getNgayThang()));
        }

        spec = and(spec, createLikeSpecification("soHieuTaiKhoan", request.getSoHieuTaiKhoan()));
        spec = and(spec, createLikeSpecification("maChuong", request.getMaChuong()));
        spec = and(spec, createLikeSpecification("loaiTien", request.getLoaiTien()));
        spec = and(spec, createLikeSpecification("mucTieuMuc", request.getMucTieuMuc()));
        spec = and(spec, createLikeSpecification("nhomMuc", request.getNhomMuc()));
        spec = and(spec, createLikeSpecification("maChuongTrinh", request.getMaChuongTrinh()));
        spec = and(spec, createLikeSpecification("maCongTrinh", request.getMaCongTrinh()));
        spec = and(spec, createLikeSpecification("maNguon", request.getMaNguon()));
        spec = and(spec, createLikeSpecification("maDonVi", request.getMaDonVi()));
        spec = and(spec, createLikeSpecification("dongDau", request.getDongDau()));

        return spec;
    }
} 