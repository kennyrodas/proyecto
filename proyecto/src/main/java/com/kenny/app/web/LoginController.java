package com.kenny.app.web;

import java.io.IOException;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import com.kenny.app.domain.Usuario;
import com.kenny.app.service.ProyectoManager;
import com.kenny.app.service.UsuarioManager;

@Controller
@SessionAttributes("eee")
public class LoginController {
	
	@Autowired
    private UsuarioManager usuarioManager;
	@Autowired
	private ProyectoManager proyectoManager;
	
	@RequestMapping(value="/inicio.htm", method = RequestMethod.POST)
	public ModelAndView autenticar(HttpServletRequest request, HttpServletResponse response)
	{
		String username = request.getParameter("usuario");
		String clave = request.getParameter("clave");
		
		Usuario usuario = new Usuario();
		usuario.setUsuario(username);
		usuario.setClave(clave);
		usuario = usuarioManager.getUsuarioAuthentication(usuario);
		
		if (usuario != null) {
			HttpSession session = request.getSession(true);
			session.setAttribute("usuario", usuario);
			System.out.println(usuario); 
			Map<String, Object> myModel = new HashMap<String, Object>();
	        myModel.put("proyectosusuarios", usuario.getProyectoUsuarioSet());
			return new ModelAndView("inicio","model", myModel);
		}else{
			request.setAttribute("error", "Fallo al intentar ingresar");
			String contextPath = request.getContextPath();
			return new ModelAndView("login","error", "Verifique sus datos de acceso.");
		}
		
        
		
	}
	
	@RequestMapping(value="/login.htm")
    public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        return new ModelAndView("login");
    }
	
	@RequestMapping(value="/salir.htm", method = RequestMethod.GET)
	public void salir(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		HttpSession session = request.getSession();
		session.setAttribute("usuario", null);
		
		String contextPath = request.getContextPath();
		response.sendRedirect(contextPath+"/index.jsp");
		//RequestDispatcher rd = request.getRequestDispatcher("/index.htm");
        //rd.forward(request, response);
		return;
	}
	
	@RequestMapping(value="/email.htm", method = RequestMethod.GET)
	public void email(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		Usuario usuario = new Usuario();
		usuario.setUsuario("kenny");
		usuario = usuarioManager.getUsuarioByUsername(usuario);

		// Datos del dominio
		String pageURL = "";
		String SERVER_NAME = request.getServerName();
		String PORT = String.valueOf(request.getServerPort());
		if (PORT != "80") {
			pageURL = SERVER_NAME + ":" + PORT;
		} else {
			pageURL = SERVER_NAME;
		}
		
		usuarioManager.sendEmailConfirmation(usuario, pageURL);
	}
	
	@RequestMapping(value="/proy/{user}", method = RequestMethod.GET)
	public String getCustomLogin(Model model, @PathVariable String user)
	{
		Usuario usuario = new Usuario();
		usuario.setUsuario(user);
		usuario = usuarioManager.getUsuarioByUsername(usuario);
		
		model.addAttribute("usuario", usuario);
		return "logincustom"; //viewname
	}
}