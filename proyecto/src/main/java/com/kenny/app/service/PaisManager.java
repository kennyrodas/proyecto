package com.kenny.app.service;

import java.io.Serializable;
import java.util.List;

import com.kenny.app.domain.Pais;

public interface PaisManager extends Serializable{
	public List<Pais> getPaises();
}
