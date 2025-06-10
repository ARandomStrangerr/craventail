package main.product.service;

import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import main.product.entity.BaseEntity;
import main.product.mapper.BaseMapper;
import main.product.repository.BaseRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.validation.annotation.Validated;

@Validated
@Transactional
public abstract class BaseService<T extends BaseEntity, R> {

    protected abstract BaseRepository<T, Long> getRepository();
    protected abstract BaseMapper<T, R> getMapper();
    protected abstract String getNotFoundMessage();

    public Page<T> search(R request, Pageable pageable) {
        Specification<T> spec = buildSearchSpecification(request);
        spec = spec.and((root, query, cb) -> cb.equal(root.get("deleted"), false));

        return getRepository().findAll(spec, pageable);
    }

    public T create(R request) {
        T entity = getMapper().toEntity(request);
        return getRepository().save(entity);
    }

    public T show(Long id) {
        return getRepository().findByIdActive(id)
                .orElseThrow(() -> new EntityNotFoundException(getNotFoundMessage()));
    }

    public T update(Long id, R request) {
        T entity = show(id);
        getMapper().updateEntity(entity, request);
        return getRepository().save(entity);
    }

    public void delete(Long id) {
        getRepository().softDelete(id);
    }

    protected Specification<T> createLikeSpecification(String fieldName, String value) {
        if (value == null || value.trim().isEmpty()) {
            return null;
        }
        return (root, query, cb) -> cb.like(
            cb.lower(root.get(fieldName)),
            "%" + value.toLowerCase().trim() + "%"
        );
    }

    protected Specification<T> createEqualSpecification(String fieldName, Object value) {
        if (value == null) {
            return null;
        }
        return (root, query, cb) -> cb.equal(root.get(fieldName), value);
    }

    protected Specification<T> and(Specification<T> spec1, Specification<T> spec2) {
        if (spec1 == null) {
            return spec2;
        }
        if (spec2 == null) {
            return spec1;
        }
        return spec1.and(spec2);
    }


    protected Specification<T> buildSearchSpecification(R request) {
        return Specification.where(null);
    }
} 