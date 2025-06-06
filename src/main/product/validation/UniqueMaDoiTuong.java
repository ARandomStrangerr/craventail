package main.product.validation;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;
import java.lang.annotation.*;

@Documented
@Constraint(validatedBy = UniqueMaDoiTuongValidator.class)
@Target({ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
public @interface UniqueMaDoiTuong {
    String message() default "Mã đối tượng đã tồn tại";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
} 