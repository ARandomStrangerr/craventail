package main.product.validation;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;
import java.lang.annotation.*;

@Documented
@Constraint(validatedBy = MaSoThueValidator.class)
@Target({ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
public @interface ValidMaSoThue {
    String message() default "Mã số thuế không hợp lệ";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
} 