package com.kenny.app.web;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.json.simple.JSONArray;
import org.json.simple.JSONValue;
import org.json.simple.JSONObject;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

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
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.kenny.app.domain.AreaProyecto;
import com.kenny.app.domain.Indicador;
import com.kenny.app.domain.Pais;
import com.kenny.app.domain.PerfilUsuario;
import com.kenny.app.domain.Proyecto;
import com.kenny.app.domain.ProyectoUsuario;
import com.kenny.app.domain.ProyectoUsuarioPK;
import com.kenny.app.domain.Supuesto;
import com.kenny.app.domain.Usuario;
import com.kenny.app.service.AreaProyectoManager;
import com.kenny.app.domain.Objetivo;
import com.kenny.app.service.IndicadorManager;
import com.kenny.app.service.MedioVerificacionManager;
import com.kenny.app.service.ObjetivoManager;
import com.kenny.app.service.PaisManager;
import com.kenny.app.service.PerfilUsuarioManager;
import com.kenny.app.service.ProyectoManager;
import com.kenny.app.service.ProyectoRegionManager;
import com.kenny.app.service.ProyectoUsuarioManager;
import com.kenny.app.service.SupuestoManager;
import com.kenny.app.service.UsuarioManager;
@Controller
public class ProyectoController {
	@Autowired
	private UsuarioManager usuarioManager;
	@Autowired
	private AreaProyectoManager areaProyectoManager;
	@Autowired
	private PaisManager paisManager;
	@Autowired
	private ProyectoManager proyectoManager;
	@Autowired
	private PerfilUsuarioManager perfilManager;
	@Autowired
	private ProyectoUsuarioManager proyectoUsuarioManager;
	@Autowired
	private ObjetivoManager objetivoController;
	@Autowired
	private IndicadorManager indicadorController;
	@Autowired
	private MedioVerificacionManager medioController;
	@Autowired
	private ProyectoRegionManager proyectoRegionManager;
	@Autowired
	private SupuestoManager supuestoManager;
	
	 protected final Log logger = LogFactory.getLog(getClass());
	public AreaProyectoManager getAreaProyectoManager() {
		return areaProyectoManager;
	}
	public void setAreaProyectoManager(AreaProyectoManager areaProyectoManager) {
		this.areaProyectoManager = areaProyectoManager;
	}
	@RequestMapping(value="/nuevo_proyecto.htm")
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response){
		
		String now = (new Date()).toString();

        Map<String, Object> myModel = new HashMap<String, Object>();
        myModel.put("now", now);
        myModel.put("areas",this.areaProyectoManager.getAreasProyecto());
        myModel.put("paises",this.paisManager.getPaises());
        myModel.put("perfiles",this.perfilManager.getPerfiles());
        myModel.put("usuarios", this.usuarioManager.getUsuariosByUsuario(1));
		return new ModelAndView("nuevo_proyecto", "model", myModel)	;
	}
	
	@RequestMapping(value="/nuevoproyecto.htm")
	public ModelAndView nuevoProyectoView(HttpServletRequest request, HttpServletResponse response, HttpSession session){
		if(session.getAttribute("usuario") == null){
	   		 return new ModelAndView("login");
	   	}
		String now = (new Date()).toString();

        Map<String, Object> myModel = new HashMap<String, Object>();
        myModel.put("now", now);
        myModel.put("areas",this.areaProyectoManager.getAreasProyecto());
        myModel.put("paises",this.paisManager.getPaises());
        myModel.put("perfiles",this.perfilManager.getPerfiles());
        myModel.put("usuarios", this.usuarioManager.getUsuariosByUsuario(1));
        Usuario u = (Usuario) session.getAttribute("usuario"); 
        myModel.put("miusuario", this.usuarioManager.getUsuarioByUsername(u));
		return new ModelAndView("nuevoproyecto", "model", myModel)	;
	}
	
	@RequestMapping(value="/nuevo_proyecto.htm",method = RequestMethod.POST)
	public String onSubmit(HttpServletRequest request, HttpServletResponse response , HttpSession session){
	Proyecto p = new Proyecto();
	p.setNombre(request.getParameter("nombrepro"));
	AreaProyecto area = new AreaProyecto();
	area.setAreaId(Integer.parseInt(request.getParameter("area")));
	p.setAreaId(area);
	p.setDescripcion(request.getParameter("descripcion"));
	p.setDuracionMeses((short) Integer.parseInt(request.getParameter("duracion")));
	Date fecha_inicio = new Date();
	Date fecha_fin = new Date();
	Date now = new Date();
	SimpleDateFormat formatoDelTexto = new SimpleDateFormat("dd/mm/yyyy");
	try {
		fecha_inicio = formatoDelTexto.parse(request.getParameter("fecha_inicio"));
		fecha_fin = formatoDelTexto.parse(request.getParameter("fecha_fin"));
	} catch (ParseException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	p.setFechaInicio(fecha_inicio);
	p.setFechaFin(fecha_fin);
	p.setFechaRegistro(now);
	p.setFechaModificado(now);
	p.setRegistradoPor(1);
	p.setModificadoPor(1);
	
	Pais pais = new Pais();
	pais.setPaisId(Integer.parseInt(request.getParameter("pais_id")));
	p.setPaisId(pais);
	//p.setPais_id(Integer.parseInt(request.getParameter("pais_id")));
	System.err.println(p.toString());
	p = this.proyectoManager.save(p);
	
	System.err.println("proyectoid"+p.getProyectoId());
	/*String s = request.getParameter("usuariosjson");
	JSONArray usuariosjson = (JSONArray) JSONValue.parse(s);
	   for (int i = 0; i < usuariosjson.size(); i++) {  // **line 2**
		     JSONObject usuariop = (JSONObject) usuariosjson.get(i);
		      String nombres = (String) usuariop.get("nombres");
		      String apellidos = (String) usuariop.get("apellidos");
		      String correo = (String) usuariop.get("correo");
		      String cargo = (String) usuariop.get("cargo");
		      String pais_id = (String) usuariop.get("pais");
		      String perfil_id = (String) usuariop.get("perfil");
		      String dni = (String) usuariop.get("dni");
		      ProyectoUsuario temp = new ProyectoUsuario();
		     // temp.setNombres(nombres);
		      //temp.setApellidos(apellidos);
		      //temp.setCorreo(correo);
		      //temp.setPais_id(Integer.parseInt(pais_id));
		      //temp.setPerfil_id(Integer.parseInt(perfil_id));
		      //temp.setValor_documento(dni);
		      //temp.setTipo_documento_id(1);
		      //temp.setCargo(cargo);
		      temp.setProyecto_id(p.getProyecto_id());
		      System.err.println("temp"+temp.toString());
		      this.proyectoUsuarioManager.save(temp);
		      
		}*/
	   
	   for(int i = 1 ; i<4;i++){
		   Objetivo o = new Objetivo();
		   o.setCodigo(1);
		   o.setDescripcion("");
		   o.setProyectoId(p);
		   o.setTipoObjetivoId((short)i);
		   o = this.objetivoController.save(o);
	   }
	        return "redirect:detalles_proyecto.htm?id="+p.getProyectoId();
	        //return new ModelAndView("nuevo_proyecto", "model", myModel)	;
	}
	@RequestMapping(value="/nuevoproyecto.htm",method = RequestMethod.POST)
	public String onSubmitNuevoProyecto(HttpServletRequest request, HttpServletResponse response , HttpSession session){
		if(session.getAttribute("usuario") == null){
	   		 return "login.htm";
	   	}
	Proyecto p = new Proyecto();
	p.setNombre(request.getParameter("nombre"));
	AreaProyecto area = new AreaProyecto();
	area.setAreaId(Integer.parseInt(request.getParameter("area")));
	p.setAreaId(area);
	p.setDescripcion(request.getParameter("descripcion"));
	p.setDuracionMeses((short) Integer.parseInt(request.getParameter("duracion")));
	Date fecha_inicio = new Date();
	Date fecha_fin = new Date();
	Date now = new Date();
	System.err.println(request.getParameter("fechainicio"));
	System.err.println(request.getParameter("fechafin"));
	SimpleDateFormat formatoDelTexto = new SimpleDateFormat("dd/mm/yyyy");
	try {
		fecha_inicio = formatoDelTexto.parse(request.getParameter("fechainicio"));
		fecha_fin = formatoDelTexto.parse(request.getParameter("fechafin"));
	} catch (ParseException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	p.setFechaInicio(fecha_inicio);
	p.setFechaFin(fecha_fin);
	p.setFechaRegistro(now);
	p.setFechaModificado(now);
	p.setRegistradoPor(((Usuario)(session.getAttribute("usuario"))).getId());
	p.setModificadoPor(((Usuario)(session.getAttribute("usuario"))).getId());
	
	Pais pais = new Pais();
	pais.setPaisId(Integer.parseInt(request.getParameter("pais_id")));
	p.setPaisId(pais);
	p = this.proyectoManager.save(p);
	
	System.err.println("proyectoid"+p.getProyectoId());
	System.err.println("proyectoid"+request.getParameter("usuarios"));

	
	String s = request.getParameter("usuariosjson");
	JSONArray usuariosjson = (JSONArray) JSONValue.parse(s);
	   for (int i = 0; i < usuariosjson.size(); i++) {  // **line 2**
		     JSONObject usuariop = (JSONObject) usuariosjson.get(i);
		     int  id = Integer.parseInt( (String) usuariop.get("id"));
		     Usuario u = new Usuario();
		     u.setId(id);
		     ProyectoUsuario pu = new ProyectoUsuario();
		     PerfilUsuario perfil = new PerfilUsuario();
		     String combo = "perfil"+id;
			 perfil.setPerfilId(Integer.parseInt(request.getParameter(combo)));
			 pu.setPerfilId(perfil);
			 pu.setUsuario(u);
			 pu.setProyecto(p);
			 ProyectoUsuarioPK pk = new ProyectoUsuarioPK();
			 pk.setProyectoId(p.getProyectoId());
			 pk.setUsuarioId(id);
			 pu.setProyectoUsuarioPK(pk);
			 this.proyectoUsuarioManager.save(pu);
		      
		}
	   
	   for(int i = 1 ; i<4;i++){
		   Objetivo o = new Objetivo();
		   o.setCodigo(1);
		   o.setDescripcion("");
		   o.setProyectoId(p);
		   o.setTipoObjetivoId((short)i);
		   o = this.objetivoController.save(o);
	   }
	        return "redirect:detalles_proyecto.htm?id="+p.getProyectoId();
	        //return new ModelAndView("nuevo_proyecto", "model", myModel)	;
	}
	@RequestMapping(value="/detalles_proyecto.htm",method = RequestMethod.GET)
	public ModelAndView handleRequestdetalle(HttpServletRequest request, HttpServletResponse response, HttpSession session){
		if(session.getAttribute("usuario") == null){
	   		 return new ModelAndView("login");
	   	}
		 System.err.println(request.getParameter("id"));
		 Proyecto p = this.proyectoManager.getById(Integer.parseInt(request.getParameter("id")));
		 
		Map<String, Object> myModel = new HashMap<String, Object>();
		myModel.put("proyecto", p);
		myModel.put("objetivos", this.objetivoController.getObjetivosProyecto(p.getProyectoId()));
		//myModel.put("usuarios", this.proyectoUsuarioManager.getUsuariosProyecto(p.getProyecto_id()));
		 System.err.println(p.toString());
		return new ModelAndView("detalles_proyecto", "model", myModel);

	}
	@RequestMapping(value = "participantes.htm")
	public ModelAndView viewParticipantes(HttpServletRequest request, HttpServletResponse response, HttpSession session){
		if(session.getAttribute("usuario") == null){
	   		 return new ModelAndView("login");
	   	}
		 System.err.println(request.getParameter("id"));
		 Proyecto p = this.proyectoManager.getById(Integer.parseInt(request.getParameter("id")));
		 
		Map<String, Object> myModel = new HashMap<String, Object>();
		myModel.put("proyecto", p);
		myModel.put("objetivos", this.objetivoController.getObjetivosProyecto(p.getProyectoId()));
		//myModel.put("usuarios", this.proyectoUsuarioManager.getUsuariosProyecto(p.getProyecto_id()));
		 System.err.println(p.toString());
		return new ModelAndView("participantes", "model", myModel);

	}
	@RequestMapping(value = "reportes.htm")
	public ModelAndView viewReportes(HttpServletRequest request, HttpServletResponse response, HttpSession session){
		if(session.getAttribute("usuario") == null){
	   		 return new ModelAndView("login");
	   	}
		 System.err.println(request.getParameter("id"));
		 Proyecto p = this.proyectoManager.getById(Integer.parseInt(request.getParameter("id")));
		 
		Map<String, Object> myModel = new HashMap<String, Object>();
		myModel.put("proyecto", p);
		myModel.put("objetivos", this.objetivoController.getObjetivosProyecto(p.getProyectoId()));
		//myModel.put("usuarios", this.proyectoUsuarioManager.getUsuariosProyecto(p.getProyecto_id()));
		 System.err.println(p.toString());
		return new ModelAndView("reportes", "model", myModel);

	}
	@RequestMapping(value = "ingresodirecto.htm")
	public ModelAndView viewIngresoDirecto(HttpServletRequest request, HttpServletResponse response, HttpSession session){
		if(session.getAttribute("usuario") == null){
	   		 return new ModelAndView("login");
	   	}
		 System.err.println(request.getParameter("id"));
		 Proyecto p = this.proyectoManager.getById(Integer.parseInt(request.getParameter("id")));
		 
		Map<String, Object> myModel = new HashMap<String, Object>();
		myModel.put("proyecto", p);
		myModel.put("objetivos", this.objetivoController.getObjetivosProyecto(p.getProyectoId()));
		//myModel.put("usuarios", this.proyectoUsuarioManager.getUsuariosProyecto(p.getProyecto_id()));
		 System.err.println(p.toString());
		return new ModelAndView("ingresodirecto", "model", myModel);

	}
	@RequestMapping(value="/detalles_proyecto.htm",method = RequestMethod.POST)
	public ModelAndView submitObjetivos(HttpServletRequest request, HttpServletResponse response, HttpSession session){
		if(session.getAttribute("usuario") == null){
	   		 return new ModelAndView("login");
	   	}
		
		//agregando indicador
		String nombre = request.getParameter("nombre");
		System.err.println("nombre"+nombre);
		String descripcion = request.getParameter("descripcion");
		System.err.println("descripcion"+descripcion);
		String formaCalculo = request.getParameter("calculo");
		System.err.println("calculo"+formaCalculo);
		int objetivoId = Integer.parseInt(request.getParameter("objetivoIdIndicador"));
		System.err.println("objetivoIdIndicador"+objetivoId);
		String medioVerificacion = request.getParameter("medio");
		System.err.println("medio"+medioVerificacion);
		int fuente = Integer.parseInt(request.getParameter("fuente"));
		System.err.println("fuente"+fuente);
		boolean fuente_id = (fuente==1)?true:false;
		int modoprecalculo = Integer.parseInt(request.getParameter("modo"));
		System.err.println("modo"+modoprecalculo);
		boolean modoPreCalculo = (modoprecalculo==1)?true:false;
		int periodicidadId = Integer.parseInt(request.getParameter("periodicidad"));
		System.err.println("n"+periodicidadId);
		String valor_inicial = request.getParameter("valorinicial");
		System.err.println("n"+valor_inicial);
		String valor_final = request.getParameter("valorfinal");
		System.err.println("n"+valor_final);
		String documentoReporte = request.getParameter("documentoreporte");
		System.err.println("n"+documentoReporte);
		int responsableId = Integer.parseInt(request.getParameter("responsable"));
		System.err.println("n"+responsableId);
		
		Indicador i = new Indicador();
		i.setObjetivoId(new Objetivo(objetivoId));
		i.setNombre(nombre);
		i.setDescripcion(descripcion);
		i.setFormaCalculo(formaCalculo);
		i.setMedioVerificacion(medioVerificacion);
		i.setFuente(fuente_id);
		i.setModoPreCalculo(modoPreCalculo);
		i.setPeriodicidadId(periodicidadId);
		i.setValorInicial(valor_inicial);
		i.setValorFinal(valor_final);
		i.setDocumentoReporte(documentoReporte);
		i.setResponsableId(responsableId);
		this.indicadorController.save(i);
		Proyecto p = this.proyectoManager.getById(Integer.parseInt(request.getParameter("proyectoId")));
		Map<String, Object> myModel = new HashMap<String, Object>();
		myModel.put("proyecto", p);

		myModel.put("objetivos", this.objetivoController.getObjetivosProyecto(p.getProyectoId()));
		 //System.err.println(p.toString());
		return new ModelAndView("detalles_proyecto", "model", myModel);

	}
	
	@RequestMapping(value="/agregarobjetivos.htm",method = RequestMethod.POST)
    public @ResponseBody String handleRequestObjetivos(HttpServletRequest request, HttpServletResponse response, HttpSession session)
            throws ServletException, IOException {
		
		 String action = request.getParameter("action");
    	 System.err.println("codigo"+action);
			System.err.println("codigo2"+action);
			String descripcion = request.getParameter("desc");
	    	 String supuesto = request.getParameter("sup");
	    	 int codigo = Integer.parseInt(request.getParameter("codigo"));
	    	 int proyecto_id = Integer.parseInt(request.getParameter("proyecto_id"));
	    	 String tipo = request.getParameter("tipo");
	    	 int tipo_id = Integer.parseInt(tipo);
	    	 this.objetivoController.actualizarCodigos(codigo,1);
	    	 System.err.println("codigo"+request.getParameter("codigo")+request.getParameter("proyecto_id"));
	    	 Objetivo o = new Objetivo();
	    	 o.setCodigo(codigo);
	    	 Proyecto p= new Proyecto();
	    	 p.setProyectoId(proyecto_id);
	    	 o.setProyectoId(p);
	    	 o.setDescripcion(descripcion);
	    	 Set<Supuesto> supuestoset = new HashSet<Supuesto>() ;
	    	 Supuesto oSupuesto = new Supuesto();
	    	 oSupuesto.setSupuesto(supuesto);	    	 
	    	 supuestoset.add(oSupuesto);
	    	 o.setSupuestoSet(supuestoset);
	    	 o.setTipoObjetivoId((short) tipo_id);
	    	 o = this.objetivoController.save(o); 
	    	 return ""+o.getObjetivoId();
    }
	@RequestMapping(value="/agregarsupuesto.htm",method = RequestMethod.POST)
    public @ResponseBody String handleRequestSupuesto(HttpServletRequest request, HttpServletResponse response, HttpSession session)
            throws ServletException, IOException {
		
	    	 int id = Integer.parseInt(request.getParameter("id"));
	    	 Supuesto s = new Supuesto();

	    	 Objetivo o = new Objetivo();
	    	 o.setObjetivoId(id);
	    	 s.setObjetivoId(o);
	    	 
	    	 s = this.supuestoManager.save(s); 
	    	 return ""+s.getSupuestoId();
    }
	@RequestMapping(value="/actualizarobjetivo.htm",method = RequestMethod.POST)
    public @ResponseBody String handleRequestActualizarObjetivos(HttpServletRequest request, HttpServletResponse response, HttpSession session)
            throws ServletException, IOException {
			String descripcion = request.getParameter("desc");
	        String supuesto = request.getParameter("sup");	    	
	    	 int id = Integer.parseInt(request.getParameter("id"));	    	 
	    	 Objetivo o = this.objetivoController.getById(id);
	    	 o.setObjetivoId(id);
	    	 o.setDescripcion(descripcion);
	    	 o = this.objetivoController.save(o); 
	    	
	    	 return ""+o.getObjetivoId();
    }
	@RequestMapping(value="/eliminarobjetivo.htm",method = RequestMethod.POST)
    public @ResponseBody String handleRequestDeleteObjetivos(HttpServletRequest request, HttpServletResponse response, HttpSession session)
            throws ServletException, IOException {
	    	 int objetivo_id = Integer.parseInt(request.getParameter("id"));
	    	 int codigo = Integer.parseInt(request.getParameter("codigo"));
	    	 this.objetivoController.actualizarCodigos(codigo,2);
	    	 this.objetivoController.eliminar(objetivo_id);
	    	 return ""+1;
    }
	@RequestMapping(value="/actividades.htm")
	public ModelAndView mostrarActividades(HttpServletRequest request, HttpServletResponse response, HttpSession session){
		if(session.getAttribute("usuario") == null){
	   		 return new ModelAndView("login");
	   	}
		return new ModelAndView("actividades");
	}
	
}
