package main.product.validation;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class MaSoThueValidator implements ConstraintValidator<ValidMaSoThue, String> {

    @Override
    public boolean isValid(String maSoThue, ConstraintValidatorContext context) {
        if (maSoThue == null || maSoThue.trim().isEmpty()) {
            return true;
        }
        if (maSoThue.length() != 10 && maSoThue.length() != 13) {
            return false;
        }

        if (!maSoThue.matches("\\d+")) {
            return false;
        }

        if (maSoThue.length() == 13) {
            String branchNumber = maSoThue.substring(10);
            int branch;
            try {
                branch = Integer.parseInt(branchNumber);
                if (branch < 1 || branch > 999) {
                    return false;
                }
            } catch (NumberFormatException e) {
                return false;
            }
        }

        return true;
    }
} 