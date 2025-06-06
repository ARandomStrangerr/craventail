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
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class TaiKhoanDungService {
    @Autowired
    private TaiKhoanDungRepository taiKhoanDungRepository;

    @Autowired
    private ITaiKhoanDungMapper taiKhoanDungMapper;

    public Page<TaiKhoanDung> search(TaiKhoanDungRequest request, Pageable pageable) {
        Specification<TaiKhoanDung> spec = Specification.where(null);

        String ten_tai_khoan = request.getTen_tai_khoan();
        if (ten_tai_khoan != null && !ten_tai_khoan.isEmpty()) {
            spec = spec.and((root, query, cb) ->
                    cb.like(cb.lower(root.get("ten_tai_khoan")), "%" + ten_tai_khoan.toLowerCase() + "%"));
        }

        String so_hieu_tai_khoan = request.getSo_hieu_tai_khoan();
        if (so_hieu_tai_khoan != null && !so_hieu_tai_khoan.isEmpty()) {
            spec = spec.and((root, query, cb) ->
                    cb.like(cb.lower(root.get("so_hieu_tai_khoan")), "%" + so_hieu_tai_khoan.toLowerCase() + "%"));
        }

        String loai_rut_so_du = request.getLoai_rut_so_du();
        if (loai_rut_so_du != null && !loai_rut_so_du.isEmpty()) {
            spec = spec.and((root, query, cb) ->
                    cb.equal(cb.lower(root.get("loai_rut_so_du")), loai_rut_so_du.toLowerCase()));
        }

        String ten_chu_quan = request.getTen_chu_quan();
        if (ten_chu_quan != null && !ten_chu_quan.isEmpty()) {
            spec = spec.and((root, query, cb) ->
                    cb.like(cb.lower(root.get("ten_chu_quan")), "%" + ten_chu_quan.toLowerCase() + "%"));
        }

        String tai_khoan_ngan_hang_kho_bac = request.getTai_khoan_ngan_hang_kho_bac();
        if (tai_khoan_ngan_hang_kho_bac != null && !tai_khoan_ngan_hang_kho_bac.isEmpty()) {
            spec = spec.and((root, query, cb) ->
                    cb.like(cb.lower(root.get("tai_khoan_ngan_hang_kho_bac")), "%" + tai_khoan_ngan_hang_kho_bac.toLowerCase() + "%"));
        }

        String tam_ung = request.getTam_ung();
        if (tam_ung != null && !tam_ung.isEmpty()) {
            spec = spec.and((root, query, cb) ->
                    cb.like(cb.lower(root.get("tam_ung")), "%" + tam_ung.toLowerCase() + "%"));
        }

        String ten_ngan_hang_kho_bac = request.getTen_ngan_hang_kho_bac();
        if (ten_ngan_hang_kho_bac != null && !ten_ngan_hang_kho_bac.isEmpty()) {
            spec = spec.and((root, query, cb) ->
                    cb.like(cb.lower(root.get("ten_ngan_hang_kho_bac")), "%" + ten_ngan_hang_kho_bac.toLowerCase() + "%"));
        }

        return taiKhoanDungRepository.findAll(spec, pageable);
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