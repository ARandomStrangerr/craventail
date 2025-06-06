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
import org.springframework.stereotype.Service;

@Service
@Transactional
public class TuDienChuongTrinhService {
    @Autowired
    private TuDienChuongTrinhRepository tuDienChuongTrinhRepository;

    @Autowired
    private ITuDienChuongTrinhMapper tuDienChuongTrinhMapper;

    public Page<TuDienChuongTrinh> danhSach(Pageable pageable) {
        return tuDienChuongTrinhRepository.findAll(pageable);
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