package main.product.service;

import jakarta.transaction.Transactional;
import main.product.dto.request.TuDienChuongTrinhRequest;
import main.product.entity.TuDienChuongTrinh;
import main.product.mapper.BaseMapper;
import main.product.mapper.ITuDienChuongTrinhMapper;
import main.product.repository.BaseRepository;
import main.product.repository.SoDuChiTietRepository;
import main.product.repository.SoDuRepository;
import main.product.repository.TuDienChuongTrinhRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
@Transactional
public class TuDienChuongTrinhService extends BaseService<TuDienChuongTrinh, TuDienChuongTrinhRequest> {
    @Autowired
    private TuDienChuongTrinhRepository tuDienChuongTrinhRepository;

    @Autowired
    private SoDuRepository soDuRepository;

    @Autowired
    private SoDuChiTietRepository soDuChiTietRepository;

    @Autowired
    private ITuDienChuongTrinhMapper tuDienChuongTrinhMapper;

    @Override
    protected BaseRepository<TuDienChuongTrinh, Long> getRepository() {
        return tuDienChuongTrinhRepository;
    }

    @Override
    protected BaseMapper<TuDienChuongTrinh, TuDienChuongTrinhRequest> getMapper() {
        return tuDienChuongTrinhMapper;
    }

    @Override
    protected String getNotFoundMessage() {
        return  "Không tìm thấy từ điển chương trình";
    }

    @Override
    protected Specification<TuDienChuongTrinh> buildSearchSpecification(TuDienChuongTrinhRequest request) {
        Specification<TuDienChuongTrinh> spec = Specification.where(null);
        spec = and(spec, createLikeSpecification("maChuongTrinh", request.getMaChuongTrinh()));
        spec = and(spec, createLikeSpecification("tenChuongTrinh", request.getTenChuongTrinh()));
        spec = and(spec, createLikeSpecification("maChuong", request.getMaChuong()));

        return spec;
    }

    @Override
    protected TuDienChuongTrinh beforeUpdate(TuDienChuongTrinh entity, TuDienChuongTrinhRequest request) {
        if (!Objects.equals(entity.getMaChuongTrinh(), request.getMaChuongTrinh())) {
            soDuRepository.updateMaChuongTrinh(entity.getMaChuongTrinh(), request.getMaChuongTrinh());
            soDuChiTietRepository.updateMaChuongTrinh(entity.getMaChuongTrinh(), request.getMaChuongTrinh());
        }
        entity.setMaChuongTrinh(request.getMaChuongTrinh());
        return entity;
    }
}