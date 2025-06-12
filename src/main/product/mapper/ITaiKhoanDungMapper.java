package main.product.mapper;

import main.product.dto.request.TaiKhoanDungRequest;
import main.product.entity.TaiKhoanDung;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public interface ITaiKhoanDungMapper extends BaseMapper<TaiKhoanDung, TaiKhoanDungRequest> {

    @Override
    @Mapping(target = "soHieuTaiKhoan", ignore = true)
    void updateEntity(@MappingTarget TaiKhoanDung entity, TaiKhoanDungRequest request);
}