package main.product.mapper;

import main.product.dto.request.TuDienChuongTrinhRequest;
import main.product.entity.TuDienChuongTrinh;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public interface ITuDienChuongTrinhMapper {
    TuDienChuongTrinh themTuDienChuongTrinh(TuDienChuongTrinhRequest request);
    void chinhSuaTuDienChuongTrinh(@MappingTarget TuDienChuongTrinh tuDienChuongTrinh, TuDienChuongTrinhRequest request);
} 