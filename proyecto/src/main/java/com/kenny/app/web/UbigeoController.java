package com.kenny.app.web;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.kenny.app.service.ComunidadManager;
import com.kenny.app.service.DistritoManager;
import com.kenny.app.service.ProvinciaManager;
import com.kenny.app.service.RegionManager;

@Controller
public class UbigeoController {
	protected final Log logger = LogFactory.getLog(getClass());
    
	@Autowired
	private RegionManager regionManager;
	@Autowired
	private ComunidadManager comunidadManager;
	@Autowired
	private DistritoManager distritoManager;
	@Autowired
	private ProvinciaManager provinciaManager;

    @RequestMapping(value="/ubigeo.htm",method = RequestMethod.POST)
    public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    	 Map<String, Object> myModel = new HashMap<String, Object>();
         myModel.put("regiones",this.regionManager.getRegiones());
         if(request.getParameter("region_id")!=null){
             myModel.put("provincias",this.provinciaManager.getProvinciasByRegion(Integer.parseInt(request.getParameter("region_id"))));
         }
         if(request.getParameter("distrito_id")!=null){
        	 myModel.put("comunidades",this.comunidadManager.getComunidadesByDistrito(Integer.parseInt(request.getParameter("distrito_id"))));
         }
         if(request.getParameter("provincia_id")!=null){
        	 myModel.put("distritos",this.distritoManager.getDistritosByProvincia(Integer.parseInt(request.getParameter("provincia_id"))));
         }
        return new ModelAndView("ubigeo","model",myModel);
    }
    /*
    @RequestMapping(value="/ubigeo.htm")
    public ModelAndView load(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    	 Map<String, Object> myModel = new HashMap<String, Object>();
         myModel.put("provincias",this.provinciaManager.getProvinciasByRegion(2));
         myModel.put("regiones",this.regionManager.getRegiones());
         myModel.put("comunidades",this.comunidadManager.getComunidadesByDistrito(1));
         myModel.put("distritos",this.distritoManager.getDistritosByProvincia(1));
        return new ModelAndView("ubigeo","model",myModel);
    }
	 */   
}
