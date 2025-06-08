package main.product.mapper;

import main.product.dto.request.DonViRequest;
import main.product.entity.DonVi;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface IDonViMapper extends BaseMapper<DonVi, DonViRequest> { }
