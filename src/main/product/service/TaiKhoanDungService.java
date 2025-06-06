package main.product.service;

import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import main.product.dto.request.TaiKhoanDungRequest;
import main.product.entity.TaiKhoanDung;
import main.product.mapper.ITaiKhoanDungMapper;
import main.product.repository.TaiKhoanDungRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class TaiKhoanDungService {
    @Autowired
    private TaiKhoanDungRepository taiKhoanDungRepository;

    @Autowired
    private ITaiKhoanDungMapper taiKhoanDungMapper;

    public Page<TaiKhoanDung> danhSach(Pageable pageable) {
        return taiKhoanDungRepository.findAll(pageable);
    }

    public TaiKhoanDung them(TaiKhoanDungRequest request) {
        TaiKhoanDung taiKhoanDung = taiKhoanDungMapper.themTaiKhoanDung(request);
        return taiKhoanDungRepository.save(taiKhoanDung);
    }

    public TaiKhoanDung xem(Long id) {
        return taiKhoanDungRepository.findByIdActive(id)
                .orElseThrow(() -> new EntityNotFoundException("Không tìm thấy tài khoản dùng"));
    }

    public TaiKhoanDung chinhSua(Long id, TaiKhoanDungRequest request) {
        TaiKhoanDung taiKhoanDung = xem(id);
        taiKhoanDungMapper.chinhSuaTaiKhoanDung(taiKhoanDung, request);
        return taiKhoanDungRepository.save(taiKhoanDung);
    }

    public void xoa(Long id) {
        if (!taiKhoanDungRepository.existsById(id)) {
            throw new EntityNotFoundException("Không tìm thấy tài khoản dùng");
        }
        taiKhoanDungRepository.softDelete(id);
    }
} 