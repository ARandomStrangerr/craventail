package main.product.mapper;

import main.product.dto.request.MucLucNganSachRequest;
import main.product.entity.MucLucNganSach;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public interface IMucLucNganSachMapper {
    MucLucNganSach themMucLucNganSach(MucLucNganSachRequest request);
    void chinhSuaMucLucNganSach(@MappingTarget MucLucNganSach mucLucNganSach, MucLucNganSachRequest request);
} 