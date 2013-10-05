package com.kenny.app.web;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.json.simple.JSONArray;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.kenny.app.domain.DocumentoIdentidad;
import com.kenny.app.domain.Objetivo;
import com.kenny.app.domain.Proyecto;
import com.kenny.app.domain.Usuario;
import com.kenny.app.domain.Pais;
import com.kenny.app.service.UsuarioManager;
import com.kenny.app.service.PaisManager;
import com.kenny.app.service.DocumentoIdentidadManager;

@Controller
public class RegistroController {

	@Autowired
	private UsuarioManager usuarioManager;
	@Autowired
	private PaisManager paisManager;
	@Autowired
	private DocumentoIdentidadManager documentoIdentidadManager;

	public static final String MIME_JSON = "application/json";

	@RequestMapping(value = "/registrarse.htm")
	public ModelAndView registro(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		Map<String, Object> myModel = new HashMap<String, Object>();
		myModel.put("paises", this.paisManager.getPaises());
		myModel.put("doctipos",
				this.documentoIdentidadManager.getDocumentoIdentidad());
		return new ModelAndView("registrarse", "model", myModel);
	}

	@RequestMapping(value = "/registro/individual.htm")
	public ModelAndView registroIndividual(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		Map<String, Object> myModel = new HashMap<String, Object>();
		myModel.put("paises", this.paisManager.getPaises());
		myModel.put("doctipos",
				this.documentoIdentidadManager.getDocumentoIdentidad());

		return new ModelAndView("regindividual", "model", myModel);
	}

	@RequestMapping(value = "/registro/empresa.htm")
	public ModelAndView registroEmpresa(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		Map<String, Object> myModel = new HashMap<String, Object>();
		myModel.put("paises", this.paisManager.getPaises());
		// request.setAttribute("paises", this.paisManager.getPaises());

		return new ModelAndView("regempresa", "model", myModel);
	}

	@RequestMapping(value = "/ajaxValidateUsernamx", method = RequestMethod.GET)
	public @ResponseBody
	String checkUserName(String fieldId, String fieldValue) {
		String username = fieldValue;
		JSONArray json = new JSONArray();
		boolean flag = true;// userService.checkUserName(username);
		json.add(fieldId);
		json.add(flag);
		sleep(3000);
		return json.toString();
	}

	@RequestMapping(value = "/resgistrarusuario.htm", method = RequestMethod.POST)
	//public String saveUsuario(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	public ModelAndView saveUsuario(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		Usuario usuario = new Usuario();
		// usuario.setId(request.getParameter("id"));
		usuario.setUsuario(request.getParameter("usuario"));
		usuario.setClave(request.getParameter("clave"));
		usuario.setUsuariotipo(request.getParameter("usuariotipo"));
		usuario.setNombre(request.getParameter("nombre"));
		usuario.setApellido(request.getParameter("apellido"));
		usuario.setRazonsoc(request.getParameter("razonsoc"));
		usuario.setEmptipo(request.getParameter("emptipo"));
		usuario.setEmpsector(request.getParameter("empsector"));
		usuario.setEmprepresent(request.getParameter("emprepresent"));
		usuario.setDocumentoIdentidadId(new DocumentoIdentidad(Integer.parseInt(request.getParameter("doctipo"))));
		// usuario.setDoctipo(request.getParameter("doctipo"));
		usuario.setDocnum(request.getParameter("docnum"));
		usuario.setPaisId(new Pais(Integer.parseInt(request.getParameter("pais"))));
		usuario.setTelefono(request.getParameter("telefono"));
		usuario.setCorreo(request.getParameter("correo"));
		usuario.setTrabdir(request.getParameter("trabdir"));
		usuario.setTrabcargo(request.getParameter("trabcargo"));
		//usuario.setPadreId(1);
		// usuario.setRegister_user(request.getParameter("register_user"));
		// usuario.setRegister_date(request.getParameter("register_date"));
		// usuario.setModified_user(request.getParameter("modified_user"));
		// usuario.setModified_date(request.getParameter("modified_date"));

		usuarioManager.registraUsuario(usuario);

		//return "regusuario";
		Map<String, Object> myModel = new HashMap<String, Object>();
		myModel.put("usuario", usuario);
		return new ModelAndView("registrarse", "model", myModel);
	}

	// ajaxValidateUsername
	@RequestMapping(value = "/ajaxValidateUsername.htm", method = RequestMethod.GET)
	public @ResponseBody
	String handleValidateUsername(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		
		System.err.println("action: " + request.getParameter("action") + " | username: "+ request.getParameter("usuario"));
		
		Usuario usuario = new Usuario();
		usuario.setUsuario(request.getParameter("usuario"));
		usuario = usuarioManager.getUsuarioByUsername(usuario);
		
		if (usuario != null) {
			System.out.println("ajaxValidateUsername: Usuario encontrado - " + usuario.getNombre()+", "+usuario.getApellido());
			sleep(10);
			return "[\"usuario\", false]";
		}
		
		System.err.println("ajaxValidateUsername: NO ENCONTRADO.");
		return "[\"usuario\", true]";
	}
	
	// ajaxValidateUsername
	@RequestMapping(value = "/ajaxValidateDocnum.htm", method = RequestMethod.GET)
	public @ResponseBody
	String handleValidateDocnum(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		
		System.err.println("action: " + request.getParameter("action") + " | docnum: "+ request.getParameter("docnum"));
		
		Usuario usuario = new Usuario();
		usuario.setDocnum(request.getParameter("docnum"));
		usuario = usuarioManager.getUsuarioByDocnum(usuario);
		
		if (usuario != null) {
			System.out.println("ajaxValidateDocnum: Usuario encontrado - " + usuario.getNombre()+", "+usuario.getApellido());
			sleep(10);
			return "[\"docnum\", false]";
		}
		
		System.err.println("ajaxValidateDocnum: NO ENCONTRADO.");
		return "[\"docnum\", true]";
	}
		
	@RequestMapping(value="/nuevousuario.htm")
	public ModelAndView mostrarNuevoUsuario(HttpServletRequest request, HttpServletResponse response){
		Map<String, Object> myModel = new HashMap<String, Object>();
		myModel.put("paises", this.paisManager.getPaises());
		myModel.put("doctipos",
				this.documentoIdentidadManager.getDocumentoIdentidad());

		return new ModelAndView("nuevousuario", "model", myModel);
	}
	
	/**
	 * Sleeps the current thread for the given delay
	 * 
	 * @param duration
	 *            in milliseconds
	 * */
	private void sleep(long duration) {
		try {
			Thread.sleep(duration);
		} catch (InterruptedException e) {

			e.printStackTrace();
		}
	}

}
