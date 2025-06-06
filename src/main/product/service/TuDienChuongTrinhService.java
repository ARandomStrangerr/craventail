package main.product.service;

import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import main.product.dto.request.TuDienChuongTrinhRequest;
import main.product.entity.TuDienChuongTrinh;
import main.product.mapper.ITuDienChuongTrinhMapper;
import main.product.repository.TuDienChuongTrinhRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class TuDienChuongTrinhService {
    @Autowired
    private TuDienChuongTrinhRepository tuDienChuongTrinhRepository;

    @Autowired
    private ITuDienChuongTrinhMapper tuDienChuongTrinhMapper;

    public Page<TuDienChuongTrinh> search(TuDienChuongTrinhRequest request, Pageable pageable) {
        Specification<TuDienChuongTrinh> spec = Specification.where(null);

        String ma_chuong_trinh = request.getMa_chuong_trinh();
        if (ma_chuong_trinh != null && !ma_chuong_trinh.isEmpty()) {
            spec = spec.and((root, query, cb) ->
                    cb.like(cb.lower(root.get("ma_chuong_trinh")), "%" + ma_chuong_trinh.toLowerCase() + "%"));
        }

        String ten_chuong_trinh = request.getTen_chuong_trinh();
        if (ten_chuong_trinh != null && !ten_chuong_trinh.isEmpty()) {
            spec = spec.and((root, query, cb) ->
                    cb.like(cb.lower(root.get("ten_chuong_trinh")), "%" + ten_chuong_trinh.toLowerCase() + "%"));
        }

        String ma_chuong = request.getMa_chuong();
        if (ma_chuong != null && !ma_chuong.isEmpty()) {
            spec = spec.and((root, query, cb) ->
                    cb.like(cb.lower(root.get("ma_chuong")), "%" + ma_chuong.toLowerCase() + "%"));
        }

        String nguon_von = request.getNguon_von();
        if (nguon_von != null && !nguon_von.isEmpty()) {
            spec = spec.and((root, query, cb) ->
                    cb.like(cb.lower(root.get("nguon_von")), "%" + nguon_von.toLowerCase() + "%"));
        }

        return tuDienChuongTrinhRepository.findAll(spec, pageable);
    }

    public TuDienChuongTrinh them(TuDienChuongTrinhRequest request) {
        TuDienChuongTrinh tuDienChuongTrinh = tuDienChuongTrinhMapper.themTuDienChuongTrinh(request);
        return tuDienChuongTrinhRepository.save(tuDienChuongTrinh);
    }

    public TuDienChuongTrinh xem(Long id) {
        return tuDienChuongTrinhRepository.findByIdActive(id)
                .orElseThrow(() -> new EntityNotFoundException("Không tìm thấy từ điển chương trình"));
    }

    public TuDienChuongTrinh chinhSua(Long id, TuDienChuongTrinhRequest request) {
        TuDienChuongTrinh tuDienChuongTrinh = xem(id);
        tuDienChuongTrinhMapper.chinhSuaTuDienChuongTrinh(tuDienChuongTrinh, request);
        return tuDienChuongTrinhRepository.save(tuDienChuongTrinh);
    }

    public void xoa(Long id) {
        if (!tuDienChuongTrinhRepository.existsById(id)) {
            throw new EntityNotFoundException("Không tìm thấy từ điển chương trình");
        }
        tuDienChuongTrinhRepository.softDelete(id);
    }
} 