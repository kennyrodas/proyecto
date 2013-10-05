package com.kenny.app.service;

import java.io.Serializable;
import java.util.List;

import com.kenny.app.domain.Comunidad;

public interface ComunidadManager extends Serializable {

	public List<Comunidad> getComunidadesByDistrito(int distrito_id);
}
