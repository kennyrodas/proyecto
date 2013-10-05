package com.kenny.app.web;

import java.io.IOException;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

//import sun.security.krb5.internal.PAEncTSEnc;

import com.kenny.app.domain.Objetivo;
import com.kenny.app.domain.Proyecto;
import com.kenny.app.domain.Resultado;
import com.kenny.app.domain.Supuesto;
import com.kenny.app.service.AreaProyectoManager;
import com.kenny.app.service.ResultadoManager;

@Controller
public class ActividadesController {
	@Autowired
	private ResultadoManager resultadoManager;
	@RequestMapping(value="/arbol.htm")
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response){
		 Map<String, Object> myModel = new HashMap<String, Object>();
		return new ModelAndView("arbol", "model", myModel)	;
	}
	@RequestMapping(value="/metas.htm")
	public ModelAndView handleRequestMetas(HttpServletRequest request, HttpServletResponse response, HttpSession session){
		if(session.getAttribute("usuario") == null){
	   		 return new ModelAndView("login");
	   	}
		Map<String, Object> myModel = new HashMap<String, Object>();
		return new ModelAndView("metas", "model", myModel)	;
	}
	@RequestMapping(value="/getNodes.htm",method= RequestMethod.POST)
	  public @ResponseBody String handleRequestObjetivos(HttpServletRequest request, HttpServletResponse response)
	            throws ServletException, IOException {
			JSONArray o = new JSONArray();
			JSONObject j = new JSONObject();
			j.put("title", "1.Actividad 1 <a href='#'>metas</a>");
			o.add(j);
			//j.put("children","["+j.toString()+"]");
			j.put("children", o.toJSONString());
			//j.put("children", "");
			o.add(j);
			System.err.println(o.toJSONString());
			List<Resultado> resultados = this.resultadoManager.getResultadosByProyecto(1);
			System.err.println(resultados.get(0).getActividadesJson().toJSONString());

			return resultados.get(0).getActividadesJson().toJSONString();
		   	/// return "[ {'title': '1. Actividad1','children':'[]{'title': '1.1 Actividad1.1','children':'[{'title': '1.1.1 Actividad1.1.1'}]'}'},{'title': 'Actividad 2' } ]";
			//return o;€
	    }
}
