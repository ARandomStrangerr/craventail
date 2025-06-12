package main.product.mapper;

import main.product.dto.request.MucLucNganSachRequest;
import main.product.entity.MucLucNganSach;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public interface IMucLucNganSachMapper extends BaseMapper<MucLucNganSach, MucLucNganSachRequest> {

    @Override
    @Mapping(target = "nhom", ignore = true)
    @Mapping(target = "tieuNhom", ignore = true)
    void updateEntity(@MappingTarget MucLucNganSach entity, MucLucNganSachRequest request);
}