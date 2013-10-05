package com.kenny.app.repository;
import java.util.List;

import com.kenny.app.domain.ProyectoRegion;

public interface ProyectoRegionDao {
	public List<ProyectoRegion> getProyectoRegionList(int proyecto_id);
	public ProyectoRegion save (ProyectoRegion proyectoregion);
}
