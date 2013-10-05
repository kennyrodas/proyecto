package com.kenny.app.service;

import java.io.Serializable;
import java.util.List;

import com.kenny.app.domain.Resultado;

public interface ResultadoManager extends Serializable{
	public List<Resultado> getResultadosByProyecto(int proyecto_id);

}
