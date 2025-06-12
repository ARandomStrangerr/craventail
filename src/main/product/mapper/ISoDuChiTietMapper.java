package main.product.mapper;

import main.product.dto.request.SoDuChiTietRequest;
import main.product.entity.SoDuChiTiet;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ISoDuChiTietMapper extends BaseMapper<SoDuChiTiet, SoDuChiTietRequest> {
} 