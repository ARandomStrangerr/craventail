package main.product.validation;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class CCCDValidator implements ConstraintValidator<ValidCCCD, String> {
    private static final Set<String> VALID_PROVINCE_CODES = new HashSet<>(Arrays.asList(
        "001", "002", "004", "006", "008", "010", "011", "012", "014", "015", "017", "019", "020", "022", "024", 
        "025", "026", "027", "030", "031", "033", "034", "035", "036", "037", "038", "040", "042", "044", "045", 
        "046", "048", "049", "051", "052", "054", "056", "058", "060", "062", "064", "066", "067", "068", "070", 
        "072", "074", "075", "077", "079", "080", "082", "083", "084", "086", "087", "089", "091", "092", "093", 
        "094", "095", "096"
    ));

    @Override
    public boolean isValid(String cccd, ConstraintValidatorContext context) {
        if (cccd == null || cccd.trim().isEmpty()) {
            return true;
        }

        if (cccd.length() != 12) {
            return false;
        }

        if (!cccd.matches("\\d+")) {
            return false;
        }

        String provinceCode = cccd.substring(0, 3);
        if (!VALID_PROVINCE_CODES.contains(provinceCode)) {
            return false;
        }

        int genderCentury = Integer.parseInt(cccd.substring(3, 4));
        if (genderCentury < 0 || genderCentury > 9) {
            return false;
        }

        int year = Integer.parseInt(cccd.substring(4, 6));
        if (year < 0 || year > 99) {
            return false;
        }

        return true;
    }
} 