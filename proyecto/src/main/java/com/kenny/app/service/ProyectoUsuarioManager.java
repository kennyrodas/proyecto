package com.kenny.app.service;

import java.io.Serializable;
import java.util.List;

import com.kenny.app.domain.ProyectoUsuario;;

public interface ProyectoUsuarioManager extends Serializable {
	public List<ProyectoUsuario> getUsuariosProyecto(int proyecto_id);
	public ProyectoUsuario save(ProyectoUsuario pu);

}
