package main.product.mapper;

import main.product.dto.request.DoiTuongKinhTeRequest;
import main.product.entity.DoiTuongKinhTe;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public interface IDoiTuongKinhTeMapper extends BaseMapper<DoiTuongKinhTe, DoiTuongKinhTeRequest>{
    @Override
    @Mapping(target = "maDoiTuong", ignore = true)
    @Mapping(target = "doiTuong", ignore = true)
    @Mapping(target = "diaChi", ignore = true)
    void updateEntity(@MappingTarget DoiTuongKinhTe entity, DoiTuongKinhTeRequest request);
} 