package main.product.validation;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import main.product.repository.DoiTuongKinhTeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import jakarta.servlet.http.HttpServletRequest;

public class UniqueMaDoiTuongValidator implements ConstraintValidator<UniqueMaDoiTuong, String> {

    @Autowired
    private DoiTuongKinhTeRepository doiTuongKinhTeRepository;

    @Override
    public boolean isValid(String maDoiTuong, ConstraintValidatorContext context) {
        if (maDoiTuong == null) {
            return true;
        }

        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
        String method = request.getMethod();
        String pathInfo = request.getRequestURI();

        // Nếu là PUT request (update), kiểm tra trùng mã loại trừ bản thân
        if ("PUT".equalsIgnoreCase(method)) {
            String[] pathParts = pathInfo.split("/");
            String idStr = pathParts[pathParts.length - 1];
            try {
                Long id = Long.parseLong(idStr);
                return !doiTuongKinhTeRepository.existsByMaDoiTuongAndIdNot(maDoiTuong, id);
            } catch (NumberFormatException e) {
                return true;
            }
        }
        
        // Nếu là POST request (thêm mới), kiểm tra trùng mã
        return !doiTuongKinhTeRepository.existsByMaDoiTuong(maDoiTuong);
    }
} 