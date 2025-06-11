package main.product.mapper;

import main.product.dto.request.DanhMucDonViRequest;
import main.product.entity.DanhMucDonVi;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface IDanhMucDonViMapper extends BaseMapper<DanhMucDonVi, DanhMucDonViRequest> {
} 