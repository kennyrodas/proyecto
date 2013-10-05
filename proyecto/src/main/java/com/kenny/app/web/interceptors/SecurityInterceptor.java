package com.kenny.app.web.interceptors;

import javax.servlet.Filter;
import javax.servlet.FilterConfig;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.kenny.app.domain.Usuario;

@Component
public class SecurityInterceptor extends HandlerInterceptorAdapter {

	private String LOGIN_ACTION_URI = "/proyecto/login/autenticar.htm";

	public boolean preHandle(HttpServletRequest request,
			HttpServletResponse response, Object handler) throws Exception {

		// if ((null == request.getSession(false))
		// || (null == request.getSession(false).getAttribute("usuario"))) {
		// System.out.println("user logged out...");
		// RequestDispatcher rd = request.getRequestDispatcher("login.htm");
		// rd.forward(request, response);
		// return false;
		// }

		HttpServletRequest req = (HttpServletRequest) request;
		HttpSession session = req.getSession();
		Usuario user = (Usuario) session.getAttribute("usuario");

		System.out.println(req.getRequestURI());

		if (user == null && !LOGIN_ACTION_URI.equals(req.getRequestURI())) {
			RequestDispatcher rd = req.getRequestDispatcher("login.htm");
			rd.forward(request, response);
			return false;
		}

		return super.preHandle(request, response, handler);
	}
}
