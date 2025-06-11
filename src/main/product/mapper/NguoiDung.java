package main.product.mapper;

import main.product.dto.request.TuDienChuongTrinhRequest;
import main.product.entity.TuDienChuongTrinh;
import org.mapstruct.Mapper;

@Mapper(componentModel =  "spring")
public interface NguoiDung extends JpaRepository<User, Long> {
    Optional<User> findByUsername(String username);
}

