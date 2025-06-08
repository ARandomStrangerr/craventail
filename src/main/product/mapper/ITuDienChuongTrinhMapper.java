package main.product.mapper;

import main.product.dto.request.TuDienChuongTrinhRequest;
import main.product.entity.TuDienChuongTrinh;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ITuDienChuongTrinhMapper extends BaseMapper<TuDienChuongTrinh, TuDienChuongTrinhRequest> {
}