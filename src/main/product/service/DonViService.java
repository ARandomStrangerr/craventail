package main.product.service;

import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import main.product.dto.request.DonViRequest;
import main.product.entity.DonVi;
import main.product.mapper.IDonViMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import main.product.repository.DonViRepository;

@Service
@Transactional
public class DonViService {
    @Autowired
    private DonViRepository donViRepository;

    @Autowired
    private IDonViMapper donViMapper;

    public Page<DonVi> search(DonViRequest request, Pageable pageable) {
        Specification<DonVi> spec = Specification.where(null);

        String don_vi_chu_quan = request.getDon_vi_chu_quan();
        if (don_vi_chu_quan != null && !don_vi_chu_quan.isEmpty()) {
            spec = spec.and((root, query, cb) ->
                    cb.like(cb.lower(root.get("don_vi_chu_quan")), "%" + don_vi_chu_quan.toLowerCase() + "%"));
        }

        String ma_don_vi = request.getMa_don_vi();
        if (ma_don_vi != null && !ma_don_vi.isEmpty()) {
            spec = spec.and((root, query, cb) ->
                    cb.like(cb.lower(root.get("ma_don_vi")), "%" + ma_don_vi.toLowerCase() + "%"));
        }

        String ten_don_vi = request.getTen_don_vi();
        if (ten_don_vi != null && !ten_don_vi.isEmpty()) {
            spec = spec.and((root, query, cb) ->
                    cb.like(cb.lower(root.get("ten_don_vi")), "%" + ten_don_vi.toLowerCase() + "%"));
        }

        String ten_doi_ngoai = request.getTen_doi_ngoai();
        if (ten_doi_ngoai != null && !ten_doi_ngoai.isEmpty()) {
            spec = spec.and((root, query, cb) ->
                    cb.like(cb.lower(root.get("ten_doi_ngoai")), "%" + ten_doi_ngoai.toLowerCase() + "%"));
        }

        String dia_chi = request.getDia_chi();
        if (dia_chi != null && !dia_chi.isEmpty()) {
            spec = spec.and((root, query, cb) ->
                    cb.like(cb.lower(root.get("dia_chi")), "%" + dia_chi.toLowerCase() + "%"));
        }

        String ma_chuong = request.getMa_chuong();
        if (ma_chuong != null && !ma_chuong.isEmpty()) {
            spec = spec.and((root, query, cb) ->
                    cb.like(cb.lower(root.get("ma_chuong")), "%" + ma_chuong.toLowerCase() + "%"));
        }

        String ma_so_don_vi = request.getMa_so_don_vi();
        if (ma_so_don_vi != null && !ma_so_don_vi.isEmpty()) {
            spec = spec.and((root, query, cb) ->
                    cb.like(cb.lower(root.get("ma_so_don_vi")), "%" + ma_so_don_vi.toLowerCase() + "%"));
        }

        String ma_so_thue = request.getMa_so_thue();
        if (ma_so_thue != null && !ma_so_thue.isEmpty()) {
            spec = spec.and((root, query, cb) ->
                    cb.like(cb.lower(root.get("ma_so_thue")), "%" + ma_so_thue.toLowerCase() + "%"));
        }

        String cuc_thue = request.getCuc_thue();
        if (cuc_thue != null && !cuc_thue.isEmpty()) {
            spec = spec.and((root, query, cb) ->
                    cb.like(cb.lower(root.get("cuc_thue")), "%" + cuc_thue.toLowerCase() + "%"));
        }

        String ma_chuong_thu_thue = request.getMa_chuong_thu_thue();
        if (ma_chuong_thu_thue != null && !ma_chuong_thu_thue.isEmpty()) {
            spec = spec.and((root, query, cb) ->
                    cb.like(cb.lower(root.get("ma_chuong_thu_thue")), "%" + ma_chuong_thu_thue.toLowerCase() + "%"));
        }

        String ma_so_don_vi_thu_thue = request.getMa_so_don_vi_thu_thue();
        if (ma_so_don_vi_thu_thue != null && !ma_so_don_vi_thu_thue.isEmpty()) {
            spec = spec.and((root, query, cb) ->
                    cb.like(cb.lower(root.get("ma_so_don_vi_thu_thue")), "%" + ma_so_don_vi_thu_thue.toLowerCase() + "%"));
        }

        String kho_bac_chuyen_thue = request.getKho_bac_chuyen_thue();
        if (kho_bac_chuyen_thue != null && !kho_bac_chuyen_thue.isEmpty()) {
            spec = spec.and((root, query, cb) ->
                    cb.like(cb.lower(root.get("kho_bac_chuyen_thue")), "%" + kho_bac_chuyen_thue.toLowerCase() + "%"));
        }

        return donViRepository.findAll(spec, pageable);
    }

    public DonVi them(DonViRequest request) {
        DonVi donVi = donViMapper.themDonVi(request);
        return donViRepository.save(donVi);
    }

    public DonVi xem(Long id) {
        return donViRepository.findByIdActive(id)
                .orElseThrow(() -> new EntityNotFoundException("Không tìm thấy đơn vị"));
    }

    public DonVi chinhSua(Long id, DonViRequest request) {
        DonVi donVi = xem(id);
        donViMapper.chinhSuaDonVi(donVi, request);
        return donViRepository.save(donVi);
    }

    public void xoa(Long id) {
        if (!donViRepository.existsById(id)) {
            throw new EntityNotFoundException("Không tìm thấy đơn vị");
        }
        donViRepository.softDelete(id);
    }
}
