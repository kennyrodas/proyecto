package com.kenny.app.service;

import java.io.Serializable;
import java.util.List;

import com.kenny.app.domain.Objetivo;

public interface ObjetivoManager extends Serializable{
	public List<Objetivo> getObjetivosProyecto(int proyecto_id);
	public Objetivo save(Objetivo objetivo);
	public Objetivo getById(int objetivo_id);
	public void actualizarCodigos(int codigo,  int tipo);
	public int eliminar(int objetivo_id);
}
