package com.kenny.app.repository;
import java.util.List;

import com.kenny.app.domain.ProyectoUsuario;

public interface ProyectoUsuarioDao {
	public List<ProyectoUsuario> getProyectoUsuarioList(int proyecto_id);
	public ProyectoUsuario save (ProyectoUsuario proyectousuario);
}
