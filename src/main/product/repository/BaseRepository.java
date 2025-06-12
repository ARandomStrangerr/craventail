package main.product.repository;

import jakarta.transaction.Transactional;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.NoRepositoryBean;
import org.springframework.data.repository.query.Param;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@NoRepositoryBean
public interface BaseRepository<T, ID> extends JpaRepository<T, ID>, JpaSpecificationExecutor<T> {
    @Modifying
    @Transactional
    @Query("UPDATE #{#entityName} e SET e.deleted = true WHERE e.id = ?1")
    void softDelete(ID id);

    @Query("SELECT e FROM #{#entityName} e WHERE e.deleted = false")
    Iterable<T> findAllActive();

    @Query("SELECT e FROM #{#entityName} e WHERE e.id = ?1 AND e.deleted = false")
    Optional<T> findByIdActive(ID id);

    List<T> findAll(Specification<T> spec);

    Page<T> findAll(Specification<T> spec, Pageable pageable);

    default boolean existsByField(String value, String fieldName) {
        Specification<T> spec = (root, query, cb) -> {
            query.distinct(true);
            return cb.and(
                    cb.equal(root.get(fieldName), value),
                    cb.isFalse(root.get("deleted"))
            );
        };
        return count(spec) > 0;
    }

    default boolean existsByFieldAndIdNot(String value, String fieldName, ID id) {
        Specification<T> spec = (root, query, cb) -> {
            query.distinct(true);
            return cb.and(
                    cb.equal(root.get(fieldName), value),
                    cb.notEqual(root.get("id"), id),
                    cb.isFalse(root.get("deleted"))
            );
        };
        return count(spec) > 0;
    }

    default Optional<T> findFirstByField(String fieldName, Object value) {
        Specification<T> spec = (root, query, cb) -> {
            query.distinct(true);
            return cb.and(
                    cb.equal(root.get(fieldName), value),
                    cb.isFalse(root.get("deleted"))
            );
        };

        return findAll(spec).stream().findFirst();
    }

    default Optional<T> findFirstByFields(Map<String, String> fieldConditions) {
        Specification<T> spec = Specification.where(null);

        for (Map.Entry<String, String> entry : fieldConditions.entrySet()) {
            String fieldName = entry.getKey();
            String fieldValue = entry.getValue();

            spec = spec.and((root, query, cb) -> {
                if (fieldValue == null) {
                    return cb.isNull(root.get(fieldName));
                } else {
                    return cb.equal(root.get(fieldName), fieldValue);
                }
            });
        }

        spec = spec.and((root, query, cb) -> cb.isFalse(root.get("deleted")));

        return findAll(spec).stream().findFirst();
    }

}