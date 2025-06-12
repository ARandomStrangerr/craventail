package main.product.mapper;

import main.product.dto.request.TuDienCongTrinhRequest;
import main.product.entity.TuDienCongTrinh;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public interface ITuDienCongTrinhMapper extends BaseMapper<TuDienCongTrinh, TuDienCongTrinhRequest> {

    @Override
    @Mapping(target = "maCongTrinh", ignore = true)
    void updateEntity(@MappingTarget TuDienCongTrinh entity, TuDienCongTrinhRequest request);
}