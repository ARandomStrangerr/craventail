package main.product.service;

import jakarta.transaction.Transactional;
import main.product.dto.request.TaiKhoanDungRequest;
import main.product.entity.TaiKhoanDung;
import main.product.mapper.BaseMapper;
import main.product.mapper.ITaiKhoanDungMapper;
import main.product.repository.BaseRepository;
import main.product.repository.TaiKhoanDungRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class TaiKhoanDungService extends BaseService<TaiKhoanDung, TaiKhoanDungRequest> {
    @Autowired
    private TaiKhoanDungRepository taiKhoanDungRepository;

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
}