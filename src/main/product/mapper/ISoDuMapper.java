package main.product.mapper;

import main.product.dto.request.SoDuRequest;
import main.product.entity.SoDu;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ISoDuMapper extends BaseMapper<SoDu, SoDuRequest> {
} 