package net.edupoll.kr.intercepter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

public class RequestInterceptor extends HandlerInterceptorAdapter {

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		HttpSession session = request.getSession();
		String uri = request.getRequestURI();
		StringBuffer url = request.getRequestURL();
		System.out.println("session + log ->"+session +":" + uri);
		System.out.println(url);

		if(session.getAttribute("authValue") ==null) {
			response.sendRedirect("/");
			return false;
		}
		
		return true;
	}

}
