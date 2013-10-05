package com.kenny.app.repository;
import java.util.List;

import com.kenny.app.domain.Provincia;
public interface ProvinciaDao {
	public List<Provincia> getProvinciaList();
	public List<Provincia> getProvinciaListByRegion(int region_id);
}
