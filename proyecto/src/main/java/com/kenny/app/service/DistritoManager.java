package com.kenny.app.service;

import java.io.Serializable;
import java.util.List;

import com.kenny.app.domain.Distrito;

public interface DistritoManager extends Serializable{

	public List<Distrito> getDistritosByProvincia(int provincia_id);
}
