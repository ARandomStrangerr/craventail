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
import org.springframework.stereotype.Service;

@Service
@Transactional
public class TuDienCongTrinhService {
    @Autowired
    private TuDienCongTrinhRepository tuDienCongTrinhRepository;

    @Autowired
    private ITuDienCongTrinhMapper tuDienCongTrinhMapper;

    public Page<TuDienCongTrinh> danhSach(Pageable pageable) {
        return tuDienCongTrinhRepository.findAll(pageable);
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