package main.product.mapper;

import main.product.dto.request.TaiKhoanDungRequest;
import main.product.entity.TaiKhoanDung;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public interface ITaiKhoanDungMapper {
    TaiKhoanDung themTaiKhoanDung(TaiKhoanDungRequest request);
    void chinhSuaTaiKhoanDung(@MappingTarget TaiKhoanDung taiKhoanDung, TaiKhoanDungRequest request);
} 