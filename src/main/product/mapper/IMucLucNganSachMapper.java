package main.product.mapper;

import main.product.dto.request.MucLucNganSachRequest;
import main.product.entity.MucLucNganSach;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface IMucLucNganSachMapper extends BaseMapper<MucLucNganSach, MucLucNganSachRequest> {
}