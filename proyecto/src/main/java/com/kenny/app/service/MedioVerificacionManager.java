package com.kenny.app.service;

import java.io.Serializable;
import java.util.List;

import com.kenny.app.domain.MedioVerificacion;

public interface MedioVerificacionManager extends Serializable{
	public List<MedioVerificacion> getMedioByIndicador(int indicador_id);
	public MedioVerificacion save(MedioVerificacion verificacion);
}
