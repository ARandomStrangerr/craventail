package main.product.mapper;

import main.product.dto.request.TuDienCongTrinhRequest;
import main.product.entity.TuDienCongTrinh;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public interface ITuDienCongTrinhMapper {
    TuDienCongTrinh themTuDienCongTrinh(TuDienCongTrinhRequest request);

    void chinhSuaTuDienCongTrinh(@MappingTarget TuDienCongTrinh tuDienCongTrinh, TuDienCongTrinhRequest request);
} 