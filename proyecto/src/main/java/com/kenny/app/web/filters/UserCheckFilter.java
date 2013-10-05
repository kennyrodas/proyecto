package com.kenny.app.web.filters;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import com.kenny.app.domain.Usuario;

/**
* Servlet Filter implementation class UserCheckFilter
*/
public class UserCheckFilter implements Filter {
   private String LOGIN_ACTION_URI;
    
   /**
    * @see Filter#init(FilterConfig)
    */
   public void init(FilterConfig fConfig) throws ServletException {
       LOGIN_ACTION_URI = "/proyecto/login/autenticar.htm";
   }

   /**
    * @see Filter#destroy()
    */
   public void destroy() {
   }

   /**
    * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
    */
   public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
       HttpServletRequest req = (HttpServletRequest) request;
       HttpSession session = req.getSession();
       Usuario user = (Usuario) session.getAttribute("usuario");
       
       System.out.println(req.getRequestURI());
       
       if (user == null && !LOGIN_ACTION_URI.equals(req.getRequestURI())){
           RequestDispatcher rd = req.getRequestDispatcher("login.htm");
           rd.forward(request, response);
           return;
       }
        
       chain.doFilter(request, response);
   }
}