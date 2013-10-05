package com.kenny.app.web;

import java.io.IOException;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.kenny.app.domain.DocumentoIdentidad;
import com.kenny.app.domain.Pais;
import com.kenny.app.domain.Usuario;
import com.kenny.app.service.DocumentoIdentidadManager;
import com.kenny.app.service.PaisManager;
import com.kenny.app.service.UsuarioManager;

@Controller
public class UsuarioController {

    protected final Log logger = LogFactory.getLog(getClass());
    
    @Autowired
    private UsuarioManager usuarioManager;
	@Autowired
	private PaisManager paisManager;
	@Autowired
	private DocumentoIdentidadManager documentoIdentidadManager;

    @RequestMapping(value="/inicio.htm")
    public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response, HttpSession session)
            throws ServletException, IOException {
    	if(session.getAttribute("usuario") == null){
    		 return new ModelAndView("login");
    	}
    	String now = (new Date()).toString();
        logger.info("Returning hello view with " + now);
        Map<String, Object> myModel = new HashMap<String, Object>();
        Usuario u =this.usuarioManager.getUsuarioByUsername((Usuario)(session.getAttribute("usuario")));
        myModel.put("proyectosusuarios", u.getProyectoUsuarioSet());
        if(!u.equals((Usuario)(session.getAttribute("usuario")))){
        	session.setAttribute("usuario", u);
        }
        return new ModelAndView("inicio","model", myModel);
    }
    @RequestMapping(value="/menu.htm")
    public ModelAndView handleRequestMenu(HttpServletRequest request, HttpServletResponse response, HttpSession session)
            throws ServletException, IOException {
    	if(session.getAttribute("usuario") == null){
	   		 return new ModelAndView("login");
	   	}
        Map<String, Object> myModel = new HashMap<String, Object>();
        Usuario u =this.usuarioManager.getUsuarioByUsername((Usuario)(session.getAttribute("usuario")));
        myModel.put("proyectosusuarios", u.getProyectoUsuarioSet());
        if(!u.equals((Usuario)(session.getAttribute("usuario")))){
        	session.setAttribute("usuario", u);
        }
        return new ModelAndView("menu","model", myModel);
    }
    @RequestMapping(value = "/nuevousuario.htm", method = RequestMethod.POST)
	//public String saveUsuario(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	public ModelAndView saveUsuario(HttpServletRequest request,
			HttpServletResponse response, HttpSession session) throws ServletException, IOException {
    	if(session.getAttribute("usuario") == null){
	   		 return new ModelAndView("login");
	   	}
		Usuario usuario = new Usuario();
		// usuario.setId(request.getParameter("id"));
		usuario.setUsuario(request.getParameter("usuario"));
		usuario.setClave(request.getParameter("clave"));
		usuario.setUsuariotipo("IND");
		usuario.setNombre(request.getParameter("nombre"));
		usuario.setApellido(request.getParameter("apellido"));
		usuario.setRazonsoc("");
		usuario.setEmptipo("");
		usuario.setEmpsector("");
		usuario.setEmprepresent("");
		usuario.setDocumentoIdentidadId(new DocumentoIdentidad(Integer.parseInt(request.getParameter("doctipo"))));
		// usuario.setDoctipo(request.getParameter("doctipo"));
		usuario.setDocnum(request.getParameter("docnum"));
		usuario.setPaisId(new Pais(Integer.parseInt(request.getParameter("pais"))));
		usuario.setTelefono(request.getParameter("telefono"));
		usuario.setCorreo(request.getParameter("correo"));
		usuario.setTrabdir(request.getParameter("trabdir"));
		usuario.setTrabcargo(request.getParameter("trabcargo"));
		Usuario u = (Usuario)(session.getAttribute("usuario"));
		usuario.setPadreId(u.getId());
		// usuario.setRegister_user(request.getParameter("register_user"));
		// usuario.setRegister_date(request.getParameter("register_date"));
		// usuario.setModified_user(request.getParameter("modified_user"));
		// usuario.setModified_date(request.getParameter("modified_date"));

		usuarioManager.registraUsuario(usuario);
		Map<String, Object> myModel = new HashMap<String, Object>();
		myModel.put("paises", this.paisManager.getPaises());
		myModel.put("doctipos",
				this.documentoIdentidadManager.getDocumentoIdentidad());

		return new ModelAndView("nuevousuario", "model", myModel);
	}
    public void setUsuarioManager(UsuarioManager usuarioManager) {
        this.usuarioManager = usuarioManager;
    }
}