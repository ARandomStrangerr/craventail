package main.product.service;

import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import main.product.dto.request.SoDuRequest;
import main.product.entity.DanhMucDonVi;
import main.product.entity.MucLucNganSach;
import main.product.entity.SoDu;
import main.product.mapper.BaseMapper;
import main.product.mapper.ISoDuMapper;
import main.product.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@Service
@Transactional
public class SoDuService extends BaseService<SoDu, SoDuRequest> {
    @Autowired
    private SoDuRepository soDuRepository;

    @Autowired
    private ISoDuMapper soDuMapper;

    @Autowired
    private DanhMucDonViRepository danhMucDonViRepository;

    @Autowired
    private TaiKhoanDungRepository taiKhoanDungRepository;

    @Autowired
    private DoiTuongKinhTeRepository doiTuongKinhTeRepository;

    @Autowired
    private TuDienCongTrinhRepository tuDienCongTrinhRepository;

    @Autowired
    private TuDienChuongTrinhRepository tuDienChuongTrinhRepository;
    @Autowired
    private MucLucNganSachRepository mucLucNganSachRepository;

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

    public HashMap<String, Object> getFormData() {
        HashMap<String, Object> formData = new HashMap<>();
        formData.put("danhMucDonVi", danhMucDonViRepository.findAllActive());
        formData.put("taiKhoanDung", taiKhoanDungRepository.findAllActive());
        formData.put("chuongTrinh", tuDienChuongTrinhRepository.findAllActive());
        formData.put("congTrinh", tuDienCongTrinhRepository.findAllActive());
        formData.put("mucLucNganSach", mucLucNganSachRepository.findAllActive());

        return formData;
    }

    @Override
    protected SoDu beforeCreate(SoDu entity, SoDuRequest request) {
        return beforeSave(entity, request);
    }

    @Override
    protected SoDu beforeUpdate(SoDu entity, SoDuRequest request) {
        return beforeSave(entity, request);
    }

    protected SoDu beforeSave(SoDu entity, SoDuRequest request) {
        if (request.getMucTieuMuc() != null && !request.getMucTieuMuc().isBlank()) {
            MucLucNganSach mucLucNganSach = mucLucNganSachRepository.findByIdActive(Long.valueOf(request.getMucTieuMuc()))
                    .orElseThrow(() -> new EntityNotFoundException(getNotFoundMessage()));

            entity.setNhomMuc(mucLucNganSach.getNhom());
            entity.setMucTieuMuc(mucLucNganSach.getTieuNhom());
        } else {
            entity.setNhomMuc(null);
            entity.setMucTieuMuc(null);
        }

        return entity;
    }

    @Override
    public SoDu show(Long id) {
        SoDu entity = super.show(id);
        if (entity.getNhomMuc() != null && !entity.getNhomMuc().isBlank()) {
            Map<String, String> fieldConditions = new HashMap<>();
            fieldConditions.put("nhom", entity.getNhomMuc());
            fieldConditions.put("tieuNhom", entity.getMucTieuMuc());

            entity.setMucTieuMuc(null);

            Optional<MucLucNganSach> mucLucNganSachOpt = mucLucNganSachRepository.findFirstByFields(fieldConditions);
            mucLucNganSachOpt.ifPresent(mucLucNganSach -> entity.setMucTieuMuc(String.valueOf(mucLucNganSach.getId())));

        }
        return entity;
    }
}