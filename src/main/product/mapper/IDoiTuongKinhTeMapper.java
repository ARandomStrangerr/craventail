package main.product.mapper;

import main.product.dto.request.DoiTuongKinhTeRequest;
import main.product.entity.DoiTuongKinhTe;
import org.mapstruct.Mapper;
@Mapper(componentModel = "spring")
public interface IDoiTuongKinhTeMapper extends BaseMapper<DoiTuongKinhTe, DoiTuongKinhTeRequest>{

} 