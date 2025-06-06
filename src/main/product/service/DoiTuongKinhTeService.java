package main.product.service;

import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import main.product.dto.request.DoiTuongKinhTeRequest;
import main.product.entity.DoiTuongKinhTe;
import main.product.mapper.IDoiTuongKinhTeMapper;
import main.product.repository.DoiTuongKinhTeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class DoiTuongKinhTeService {
    @Autowired
    private DoiTuongKinhTeRepository doiTuongKinhTeRepository;

    @Autowired
    private IDoiTuongKinhTeMapper doiTuongKinhTeMapper;

    public Page<DoiTuongKinhTe> search(DoiTuongKinhTeRequest request, Pageable pageable) {
        Specification<DoiTuongKinhTe> spec = Specification.where(null);

        String ma_doi_tuong = request.getMa_doi_tuong();
        if (ma_doi_tuong != null && !ma_doi_tuong.isEmpty()) {
            spec = spec.and((root, query, cb) ->
                    cb.like(cb.lower(root.get("ma_doi_tuong")), "%" + ma_doi_tuong.toLowerCase() + "%"));
        }

        String doi_tuong = request.getDoi_tuong();
        if (doi_tuong != null && !doi_tuong.isEmpty()) {
            spec = spec.and((root, query, cb) ->
                    cb.like(cb.lower(root.get("doi_tuong")), "%" + doi_tuong.toLowerCase() + "%"));
        }

        String ma_don_vi = request.getMa_don_vi();
        if (ma_don_vi != null && !ma_don_vi.isEmpty()) {
            spec = spec.and((root, query, cb) ->
                    cb.like(cb.lower(root.get("ma_don_vi")), "%" + ma_don_vi.toLowerCase() + "%"));
        }

        String ma_so_thue = request.getMa_so_thue();
        if (ma_so_thue != null && !ma_so_thue.isEmpty()) {
            spec = spec.and((root, query, cb) ->
                    cb.like(cb.lower(root.get("ma_so_thue")), "%" + ma_so_thue.toLowerCase() + "%"));
        }

        String so_can_cuoc_cong_dan = request.getSo_can_cuoc_cong_dan();
        if (so_can_cuoc_cong_dan != null && !so_can_cuoc_cong_dan.isEmpty()) {
            spec = spec.and((root, query, cb) ->
                    cb.like(cb.lower(root.get("so_can_cuoc_cong_dan")), "%" + so_can_cuoc_cong_dan.toLowerCase() + "%"));
        }

        return doiTuongKinhTeRepository.findAll(spec, pageable);
    }


    public DoiTuongKinhTe them(DoiTuongKinhTeRequest request) {
        DoiTuongKinhTe doiTuongKinhTe = doiTuongKinhTeMapper.themDoiTuongKinhTe(request);
        return doiTuongKinhTeRepository.save(doiTuongKinhTe);
    }

    public DoiTuongKinhTe xem(Long id) {
        return doiTuongKinhTeRepository.findByIdActive(id)
                .orElseThrow(() -> new EntityNotFoundException("Không tìm thấy đối tượng kinh tế"));
    }

    public DoiTuongKinhTe chinhSua(Long id, DoiTuongKinhTeRequest request) {
        DoiTuongKinhTe doiTuongKinhTe = xem(id);
        doiTuongKinhTeMapper.chinhSuaDoiTuongKinhTe(doiTuongKinhTe, request);
        return doiTuongKinhTeRepository.save(doiTuongKinhTe);
    }

    public void xoa(Long id) {
        if (!doiTuongKinhTeRepository.existsById(id)) {
            throw new EntityNotFoundException("Không tìm thấy đối tượng kinh tế");
        }
        doiTuongKinhTeRepository.softDelete(id);
    }
} 