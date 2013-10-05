package com.kenny.app.service;

import java.io.Serializable;
import java.util.List;

import com.kenny.app.domain.Indicador;

public interface IndicadorManager extends Serializable{
	public List<Indicador> getIndicadoresObjetivo(int objetivo_id);
	public Indicador save(Indicador indicador);
	
}
