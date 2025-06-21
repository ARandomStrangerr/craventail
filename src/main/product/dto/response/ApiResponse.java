package main.product.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Map;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ApiResponse<T> {
	private int status;
	private T data;
	private String msg;
	private Map<String, String> err;

	public static <T> ApiResponse<T> success(T data, String msg) {
		ApiResponse<T> res = new ApiResponse<>();
		res.status = 200;
		res.data = data;
		res.msg = "success";
		return res;
	}

	public static <T> ApiResponse<T> error(String msg) {
		ApiResponse<T> res = new ApiResponse<>();
		res.status = 400;
		res.msg = msg;
		return res;
	}

	public static <T> ApiResponse<T> validationError(Map<String, String> err) {
		ApiResponse<T>  res = new ApiResponse<>();
		res.err = err;
		return res;
	}
}
