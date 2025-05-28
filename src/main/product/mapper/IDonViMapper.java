package main.product.mapper;

import main.product.dto.request.DonViRequest;
import main.product.entity.DonVi;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public interface IDonViMapper {
    DonVi themDonVi(DonViRequest request);
    void chinhSuaDonVi(@MappingTarget DonVi donVi, DonViRequest request);
}
