package main.product.service;

import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import main.product.dto.request.TuDienCongTrinhRequest;
import main.product.entity.TuDienCongTrinh;
import main.product.mapper.ITuDienCongTrinhMapper;
import main.product.repository.TuDienCongTrinhRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class TuDienCongTrinhService {
    @Autowired
    private TuDienCongTrinhRepository tuDienCongTrinhRepository;

    @Autowired
    private ITuDienCongTrinhMapper tuDienCongTrinhMapper;

    public Page<TuDienCongTrinh> search(TuDienCongTrinhRequest request, Pageable pageable) {
        Specification<TuDienCongTrinh> spec = Specification.where(null);

        String ma_cong_trinh = request.getMa_cong_trinh();
        if (ma_cong_trinh != null && !ma_cong_trinh.isEmpty()) {
            spec = spec.and((root, query, cb) ->
                    cb.like(cb.lower(root.get("ma_cong_trinh")), "%" + ma_cong_trinh.toLowerCase() + "%"));
        }

        String ten_cong_trinh = request.getTen_cong_trinh();
        if (ten_cong_trinh != null && !ten_cong_trinh.isEmpty()) {
            spec = spec.and((root, query, cb) ->
                    cb.like(cb.lower(root.get("ten_cong_trinh")), "%" + ten_cong_trinh.toLowerCase() + "%"));
        }

        String ma_chuong = request.getMa_chuong();
        if (ma_chuong != null && !ma_chuong.isEmpty()) {
            spec = spec.and((root, query, cb) ->
                    cb.like(cb.lower(root.get("ma_chuong")), "%" + ma_chuong.toLowerCase() + "%"));
        }

        return tuDienCongTrinhRepository.findAll(spec, pageable);
    }

    public TuDienCongTrinh them(TuDienCongTrinhRequest request) {
        TuDienCongTrinh tuDienCongTrinh = tuDienCongTrinhMapper.themTuDienCongTrinh(request);
        return tuDienCongTrinhRepository.save(tuDienCongTrinh);
    }

    public TuDienCongTrinh xem(Long id) {
        return tuDienCongTrinhRepository.findByIdActive(id)
                .orElseThrow(() -> new EntityNotFoundException("Không tìm thấy từ điển công trình"));
    }

    public TuDienCongTrinh chinhSua(Long id, TuDienCongTrinhRequest request) {
        TuDienCongTrinh tuDienCongTrinh = xem(id);
        tuDienCongTrinhMapper.chinhSuaTuDienCongTrinh(tuDienCongTrinh, request);
        return tuDienCongTrinhRepository.save(tuDienCongTrinh);
    }

    public void xoa(Long id) {
        if (!tuDienCongTrinhRepository.existsById(id)) {
            throw new EntityNotFoundException("Không tìm thấy từ điển công trình");
        }
        tuDienCongTrinhRepository.softDelete(id);
    }
} 