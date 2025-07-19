package main.product.component;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@Component
public class AuthRouteInceptor implements HandlerInterceptor{

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
					throws Exception {
			HttpSession session = request.getSession(false);
			if (session == null){
				response.setStatus(401);
				return false;
			}
			return HandlerInterceptor.super.preHandle(request, response, handler);
	}
}
