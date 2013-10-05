package com.kenny.app.service;

import java.io.Serializable;
import java.util.List;

import com.kenny.app.domain.ProyectoRegion;

public interface ProyectoRegionManager extends Serializable {
	public List<ProyectoRegion> getRegionesProyecto(int proyecto_id);
	public ProyectoRegion save(ProyectoRegion pr);

}
