package main.product.mapper;

import main.product.dto.request.TuDienCongTrinhRequest;
import main.product.entity.TuDienCongTrinh;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ITuDienCongTrinhMapper extends BaseMapper<TuDienCongTrinh, TuDienCongTrinhRequest> {
}