package com.kenny.app.repository;

import java.util.List;

import com.kenny.app.domain.Resultado;

public interface ResultadoDao {
public List<Resultado> getResultadosByProyecto(int proyectoId);
}
