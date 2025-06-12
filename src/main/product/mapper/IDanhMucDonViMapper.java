package main.product.mapper;

import main.product.dto.request.DanhMucDonViRequest;
import main.product.entity.DanhMucDonVi;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public interface IDanhMucDonViMapper extends BaseMapper<DanhMucDonVi, DanhMucDonViRequest> {

    @Override
    @Mapping(target = "maDonVi", ignore = true)
    void updateEntity(@MappingTarget DanhMucDonVi entity, DanhMucDonViRequest request);
} 