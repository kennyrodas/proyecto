package com.kenny.app.service;
import java.io.Serializable;
import java.util.List;
import com.kenny.app.domain.AreaProyecto;
public interface AreaProyectoManager extends Serializable{
	public List<AreaProyecto> getAreasProyecto();
}
