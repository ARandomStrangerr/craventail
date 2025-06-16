package main.product.mapper;

import main.product.dto.request.DangNhap;
import main.product.entity.NguoiDung;
import org.mapstruct.Mapper;

@Mapper(componentModel =  "spring")
public interface INguoiDung extends BaseMapper<NguoiDung, DangNhap> {
}

