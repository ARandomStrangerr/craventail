package main.product.service;

import jakarta.transaction.Transactional;
import main.product.dto.request.TuDienCongTrinhRequest;
import main.product.entity.TuDienCongTrinh;
import main.product.mapper.BaseMapper;
import main.product.mapper.ITuDienCongTrinhMapper;
import main.product.repository.BaseRepository;
import main.product.repository.TuDienCongTrinhRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class TuDienCongTrinhService extends BaseService<TuDienCongTrinh, TuDienCongTrinhRequest> {
    @Autowired
    private TuDienCongTrinhRepository tuDienCongTrinhRepository;

    @Autowired
    private ITuDienCongTrinhMapper tuDienCongTrinhMapper;

    @Override
    protected BaseRepository<TuDienCongTrinh, Long> getRepository() {
        return tuDienCongTrinhRepository;
    }

    @Override
    protected BaseMapper<TuDienCongTrinh, TuDienCongTrinhRequest> getMapper() {
        return tuDienCongTrinhMapper;
    }

    @Override
    protected String getNotFoundMessage() {
        return  "Không tìm thấy từ điển công trình";
    }

    @Override
    protected Specification<TuDienCongTrinh> buildSearchSpecification(TuDienCongTrinhRequest request) {
        Specification<TuDienCongTrinh> spec = Specification.where(null);
        spec = and(spec, createLikeSpecification("maCongTrinh", request.getMaCongTrinh()));
        spec = and(spec, createLikeSpecification("tenCongTrinh", request.getTenCongTrinh()));
        spec = and(spec, createLikeSpecification("maChuong", request.getMaChuong()));

        return spec;
    }
}