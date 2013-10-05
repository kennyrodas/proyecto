package com.kenny.app.service;

import java.io.Serializable;
import java.util.List;
import com.kenny.app.domain.Provincia;

public interface ProvinciaManager extends Serializable{
	public List<Provincia> getProvinciasByRegion(int region_id);
}
