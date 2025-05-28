package main.product.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Map;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ApiResponse<T> {
    private int code;
    private T data;
    private String message;
    private Map<String, String> errors;

    public static <T> ApiResponse<T> success(T data, String message) {
        return new ApiResponse<>(200, data, message, null);
    }

    public static <T> ApiResponse<T> error(String message) {
        return new ApiResponse<>(400, null, message, null);
    }

    public static <T> ApiResponse<T> validationError(Map<String, String> errors) {
        return new ApiResponse<>(422, null, null, errors);
    }
}
