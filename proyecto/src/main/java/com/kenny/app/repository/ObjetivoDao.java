package com.kenny.app.repository;
import java.util.List;

import com.kenny.app.domain.Objetivo;
public interface ObjetivoDao {
	public List<Objetivo> getObjetivoList(int proyecto_id);
	public Objetivo save(Objetivo objetivo);
	public Objetivo getById(int objetivo_id);
	public int actualizarCodigos(int codigo_id, int tipo);
	public int eliminar(int objetivo_id) ;

}
