package com.kenny.app.repository;
import java.util.List;

import com.kenny.app.domain.MedioVerificacion;;
public interface MedioVerificacionDao {
	public MedioVerificacion save(MedioVerificacion medio);
	public List<MedioVerificacion> getMediosByIndicador(int indicador_id);

}
