package main.product.mapper;

import main.product.dto.request.TuDienChuongTrinhRequest;
import main.product.entity.TuDienChuongTrinh;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public interface ITuDienChuongTrinhMapper extends BaseMapper<TuDienChuongTrinh, TuDienChuongTrinhRequest> {
    @Override
    @Mapping(target = "maChuongTrinh", ignore = true)
    void updateEntity(@MappingTarget TuDienChuongTrinh entity, TuDienChuongTrinhRequest request);
}