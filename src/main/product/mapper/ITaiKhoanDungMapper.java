package main.product.mapper;

import main.product.dto.request.TaiKhoanDungRequest;
import main.product.entity.TaiKhoanDung;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ITaiKhoanDungMapper extends BaseMapper<TaiKhoanDung, TaiKhoanDungRequest> {
}