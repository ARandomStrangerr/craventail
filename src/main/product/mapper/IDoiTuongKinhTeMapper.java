package main.product.mapper;

import main.product.dto.request.DoiTuongKinhTeRequest;
import main.product.entity.DoiTuongKinhTe;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public interface IDoiTuongKinhTeMapper {
    DoiTuongKinhTe themDoiTuongKinhTe(DoiTuongKinhTeRequest request);
    void chinhSuaDoiTuongKinhTe(@MappingTarget DoiTuongKinhTe doiTuongKinhTe, DoiTuongKinhTeRequest request);
} 