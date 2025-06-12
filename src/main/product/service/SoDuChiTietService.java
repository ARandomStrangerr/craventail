package main.product.service;

import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import main.product.dto.request.SoDuChiTietRequest;
import main.product.entity.DoiTuongKinhTe;
import main.product.entity.MucLucNganSach;
import main.product.entity.SoDuChiTiet;
import main.product.mapper.BaseMapper;
import main.product.mapper.ISoDuChiTietMapper;
import main.product.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@Service
@Transactional
public class SoDuChiTietService extends BaseService<SoDuChiTiet, SoDuChiTietRequest> {
    @Autowired
    private SoDuChiTietRepository soDuRepository;

    @Autowired
    private ISoDuChiTietMapper soDuMapper;

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
    protected BaseRepository<SoDuChiTiet, Long> getRepository() {
        return soDuRepository;
    }

    @Override
    protected BaseMapper<SoDuChiTiet, SoDuChiTietRequest> getMapper() {
        return soDuMapper;
    }

    @Override
    protected String getNotFoundMessage() {
        return "Không tìm thấy số dư";
    }

    @Override
    protected Specification<SoDuChiTiet> buildSearchSpecification(SoDuChiTietRequest request) {
        Specification<SoDuChiTiet> spec = Specification.where(null);

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
        formData.put("doiTuongKinhTe", doiTuongKinhTeRepository.findAllActive());

        return formData;
    }

    @Override
    protected SoDuChiTiet beforeCreate(SoDuChiTiet entity, SoDuChiTietRequest request) {
        return beforeSave(entity, request);
    }

    @Override
    protected SoDuChiTiet beforeUpdate(SoDuChiTiet entity, SoDuChiTietRequest request) {
        return beforeSave(entity, request);
    }

    protected SoDuChiTiet beforeSave(SoDuChiTiet entity, SoDuChiTietRequest request) {
        if (request.getMucTieuMuc() != null && !request.getMucTieuMuc().isBlank()) {
            MucLucNganSach mucLucNganSach = mucLucNganSachRepository.findByIdActive(Long.valueOf(request.getMucTieuMuc()))
                    .orElseThrow(() -> new EntityNotFoundException(getNotFoundMessage()));

            entity.setNhomMuc(mucLucNganSach.getNhom());
            entity.setMucTieuMuc(mucLucNganSach.getTieuNhom());
        } else {
            entity.setNhomMuc(null);
            entity.setMucTieuMuc(null);
        }


        if (!request.getMaDoiTuong().isEmpty()) {
            Optional<DoiTuongKinhTe> doiTuongKinhTeOpt = doiTuongKinhTeRepository.findFirstByField("maDoiTuong", request.getMaDoiTuong());
            if (doiTuongKinhTeOpt.isEmpty()) {
                throw new EntityNotFoundException(getNotFoundMessage());
            } else {
                DoiTuongKinhTe doiTuongKinhTe = doiTuongKinhTeOpt.get();
                entity.setDoiTuong(doiTuongKinhTe.getDoiTuong());
                entity.setDiaChi(doiTuongKinhTe.getDiaChi());
            }
        } else {
            entity.setMaDoiTuong(null);
            entity.setDoiTuong(null);
            entity.setDiaChi(null);
        }

        return entity;
    }

    @Override
    public SoDuChiTiet show(Long id) {
        SoDuChiTiet entity = super.show(id);
        if (entity.getNhomMuc() != null && !entity.getNhomMuc().isBlank()) {
            Map<String, String> fieldConditions = new HashMap<>();
            fieldConditions.put("nhom", entity.getNhomMuc());
            fieldConditions.put("tieuNhom", entity.getMucTieuMuc());

            entity.setMucTieuMuc(null);

            Optional<MucLucNganSach> mucLucNganSach = mucLucNganSachRepository.findFirstByFields(fieldConditions);
            mucLucNganSach.ifPresent(lucNganSach -> entity.setMucTieuMuc(String.valueOf(lucNganSach.getId())));

        }
        return entity;
    }
}