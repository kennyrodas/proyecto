package com.kenny.app.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.kenny.app.domain.MedioVerificacion;
@Repository(value="MedioVerificacionDao")
public class JPAMedioVerificacionDao implements MedioVerificacionDao {

	private EntityManager em = null;

    /*
     * Sets the entity manager.
     */
    @PersistenceContext
    public void setEntityManager(EntityManager em) {
        this.em = em;
    }

    @Transactional(readOnly = true)
    @SuppressWarnings("unchecked")
    public List<MedioVerificacion> getMediosByIndicador(int indicador_id) {
		return em.createQuery("select p from MedioVerificacion p WHERE indicador_id = '"+indicador_id+"'").getResultList();

	}
    @Transactional(readOnly = false)
	public MedioVerificacion save(MedioVerificacion medio) {
		return em.merge(medio);
	}

	
	
}
