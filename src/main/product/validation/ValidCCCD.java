package main.product.validation;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;
import java.lang.annotation.*;

@Documented
@Constraint(validatedBy = CCCDValidator.class)
@Target({ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
public @interface ValidCCCD {
    String message() default "Số CCCD không hợp lệ";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
} 