package main.product.validation;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import main.product.repository.BaseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import jakarta.servlet.http.HttpServletRequest;

public class UniqueFieldValidator implements ConstraintValidator<UniqueField, String> {

    @Autowired
    private ApplicationContext applicationContext;

    private String fieldName;
    private Class<?> repositoryClass;

    @Override
    public void initialize(UniqueField constraintAnnotation) {
        fieldName = constraintAnnotation.fieldName();
        repositoryClass = constraintAnnotation.repository();
    }

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        if (value == null) {
            return true;
        }

        BaseRepository<?, Long> repository = (BaseRepository<?, Long>) applicationContext.getBean(repositoryClass);
        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
        String method = request.getMethod();
        String pathInfo = request.getRequestURI();

        // Nếu là PUT request (update), kiểm tra trùng mã loại trừ bản thân
        if ("PUT".equalsIgnoreCase(method)) {
            String[] pathParts = pathInfo.split("/");
            String idStr = pathParts[pathParts.length - 1];
            try {
                Long id = Long.parseLong(idStr);
                return !repository.existsByFieldAndIdNot(value, fieldName, id);
            } catch (NumberFormatException e) {
                return true;
            }
        }
        
        // Nếu là POST request (thêm mới), kiểm tra trùng mã
        return !repository.existsByField(value, fieldName);
    }
} 