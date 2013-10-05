package com.kenny.app.repository;
import java.util.List;

import com.kenny.app.domain.Comunidad;
public interface ComunidadDao {
	public List<Comunidad> getComunidadList();
	public List<Comunidad> getComunidadListByDistrito(int distrito_id);
}
