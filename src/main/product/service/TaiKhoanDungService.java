package main.product.service;

import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import main.product.dto.request.TaiKhoanDungRequest;
import main.product.entity.TaiKhoanDung;
import main.product.mapper.BaseMapper;
import main.product.mapper.ITaiKhoanDungMapper;
import main.product.repository.BaseRepository;
import main.product.repository.SoDuChiTietRepository;
import main.product.repository.SoDuRepository;
import main.product.repository.TaiKhoanDungRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
@Transactional
public class TaiKhoanDungService extends BaseService<TaiKhoanDung, TaiKhoanDungRequest> {
    @Autowired
    private TaiKhoanDungRepository taiKhoanDungRepository;

    @Autowired
    private SoDuRepository soDuRepository;

    @Autowired
    private SoDuChiTietRepository soDuChiTietRepository;

    @Autowired
    private ITaiKhoanDungMapper taiKhoanDungMapper;


    @Override
    protected BaseRepository<TaiKhoanDung, Long> getRepository() {
        return taiKhoanDungRepository;
    }

    @Override
    protected BaseMapper<TaiKhoanDung, TaiKhoanDungRequest> getMapper() {
        return taiKhoanDungMapper;
    }

    @Override
    protected String getNotFoundMessage() {
        return  "Không tìm thấy tài khoản dùng";
    }

    @Override
    protected Specification<TaiKhoanDung> buildSearchSpecification(TaiKhoanDungRequest request) {
        Specification<TaiKhoanDung> spec = Specification.where(null);

        spec = and(spec, createLikeSpecification("tenTaiKhoan", request.getTenTaiKhoan()));
        spec = and(spec, createLikeSpecification("soHieuTaiKhoan", request.getSoHieuTaiKhoan()));
        spec = and(spec, createEqualSpecification("loaiRutSoDu", request.getLoaiRutSoDu()));

        return spec;
    }

    @Override
    protected TaiKhoanDung beforeUpdate(TaiKhoanDung entity, TaiKhoanDungRequest request) {
        if (!Objects.equals(entity.getSoHieuTaiKhoan(), request.getSoHieuTaiKhoan())) {
            soDuRepository.updateSoHieuTaiKhoan(entity.getSoHieuTaiKhoan(), request.getSoHieuTaiKhoan());
            soDuChiTietRepository.updateSoHieuTaiKhoan(entity.getSoHieuTaiKhoan(), request.getSoHieuTaiKhoan());
        }

        entity.setSoHieuTaiKhoan(request.getSoHieuTaiKhoan());
        return entity;
    }
}