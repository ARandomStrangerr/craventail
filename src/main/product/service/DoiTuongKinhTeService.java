package main.product.service;

import jakarta.transaction.Transactional;
import main.product.dto.request.DoiTuongKinhTeRequest;
import main.product.entity.DoiTuongKinhTe;
import main.product.mapper.BaseMapper;
import main.product.mapper.IDoiTuongKinhTeMapper;
import main.product.repository.BaseRepository;
import main.product.repository.DoiTuongKinhTeRepository;
import main.product.repository.SoDuChiTietRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
@Transactional
public class DoiTuongKinhTeService extends BaseService<DoiTuongKinhTe, DoiTuongKinhTeRequest> {
    @Autowired
    private DoiTuongKinhTeRepository doiTuongKinhTeRepository;

    @Autowired
    private SoDuChiTietRepository soDuChiTietRepository;

    @Autowired
    private IDoiTuongKinhTeMapper iDoiTuongKinhTeMapper;

    @Override
    protected BaseRepository<DoiTuongKinhTe, Long> getRepository() {
        return doiTuongKinhTeRepository;
    }

    @Override
    protected BaseMapper<DoiTuongKinhTe, DoiTuongKinhTeRequest> getMapper() {
        return iDoiTuongKinhTeMapper;
    }

    @Override
    protected String getNotFoundMessage() {
        return "Không tìm thấy đối tượng kinh tế";
    }

    @Override
    protected Specification<DoiTuongKinhTe> buildSearchSpecification(DoiTuongKinhTeRequest request) {
        Specification<DoiTuongKinhTe> spec = Specification.where(null);

        spec = and(spec, createLikeSpecification("maDoiTuong", request.getMaDoiTuong()));
        spec = and(spec, createLikeSpecification("doiTuong", request.getDoiTuong()));
        spec = and(spec, createLikeSpecification("diaChi", request.getDiaChi()));
        spec = and(spec, createLikeSpecification("maDonVi", request.getMaDonVi()));
        spec = and(spec, createLikeSpecification("maSoThue", request.getMaSoThue()));
        spec = and(spec, createLikeSpecification("soCanCuocCongDan", request.getSoCanCuocCongDan()));

        return spec;
    }

    @Override
    protected DoiTuongKinhTe beforeUpdate(DoiTuongKinhTe entity, DoiTuongKinhTeRequest request) {
        if (!Objects.equals(entity.getMaDoiTuong(), request.getMaDoiTuong())
                || !Objects.equals(entity.getDoiTuong(), request.getDoiTuong())
                || !Objects.equals(entity.getDiaChi(), request.getDiaChi())
        ) {
            soDuChiTietRepository.updateDoiTuong(entity.getMaDoiTuong(), entity.getDoiTuong(), entity.getDiaChi(), request.getMaDoiTuong(), request.getDoiTuong(), request.getDiaChi());
        }
        entity.setMaDoiTuong(request.getMaDoiTuong());
        entity.setDoiTuong(request.getDoiTuong());
        entity.setDiaChi(request.getDiaChi());
        return entity;
    }
} 