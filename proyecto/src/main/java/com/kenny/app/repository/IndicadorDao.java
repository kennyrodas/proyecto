package com.kenny.app.repository;
import java.util.List;

import com.kenny.app.domain.Indicador;
public interface IndicadorDao {
	public List<Indicador> getIndicadoresList(int objetivo_id);
	public Indicador saveIndicador(Indicador indicador);
	public int eliminar(int indicador_id);
}
