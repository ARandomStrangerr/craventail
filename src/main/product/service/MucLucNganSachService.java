package main.product.service;

import jakarta.transaction.Transactional;
import main.product.dto.request.MucLucNganSachRequest;
import main.product.entity.MucLucNganSach;
import main.product.mapper.BaseMapper;
import main.product.mapper.IMucLucNganSachMapper;
import main.product.repository.BaseRepository;
import main.product.repository.MucLucNganSachRepository;
import main.product.repository.SoDuChiTietRepository;
import main.product.repository.SoDuRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
@Transactional
public class MucLucNganSachService extends BaseService<MucLucNganSach, MucLucNganSachRequest> {
    @Autowired
    private MucLucNganSachRepository mucLucNganSachRepository;

    @Autowired
    private SoDuRepository soDuRepository;

    @Autowired
    private SoDuChiTietRepository soDuChiTietRepository;

    @Autowired
    private IMucLucNganSachMapper mucLucNganSachMapper;

    @Override
    protected BaseRepository<MucLucNganSach, Long> getRepository() {
        return mucLucNganSachRepository;
    }

    @Override
    protected BaseMapper<MucLucNganSach, MucLucNganSachRequest> getMapper() {
        return mucLucNganSachMapper;
    }

    @Override
    protected String getNotFoundMessage() {
        return "Không tìm thấy mục lục ngân sách";
    }

    @Override
    protected Specification<MucLucNganSach> buildSearchSpecification(MucLucNganSachRequest request) {
        Specification<MucLucNganSach> spec = Specification.where(null);
        spec = and(spec, createLikeSpecification("nhom", request.getNhom()));
        spec = and(spec, createLikeSpecification("tieuNhom", request.getTieuNhom()));
        spec = and(spec, createLikeSpecification("ten", request.getTen()));

        return spec;
    }


    @Override
    protected MucLucNganSach beforeUpdate(MucLucNganSach entity, MucLucNganSachRequest request) {
        String nhom = request.getNhom();
        String tieuNhom = request.getTieuNhom();
        if (!Objects.equals(entity.getNhom(), nhom)
                || !Objects.equals(entity.getTieuNhom(), tieuNhom)
        ) {
            soDuRepository.updateNhomTieuNhom(entity.getNhom(), entity.getTieuNhom(), nhom, tieuNhom);
            soDuChiTietRepository.updateNhomTieuNhom(entity.getNhom(), entity.getTieuNhom(), nhom, tieuNhom);
        }
        entity.setNhom(nhom);
        entity.setTieuNhom(tieuNhom);
        return entity;
    }
} 