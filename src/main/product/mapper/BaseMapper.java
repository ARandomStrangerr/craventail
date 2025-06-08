package main.product.mapper;

import main.product.entity.BaseEntity;
import org.mapstruct.MappingTarget;

public interface BaseMapper<T extends BaseEntity, R> {

    T toEntity(R request);

    void updateEntity(@MappingTarget T entity, R request);
}
