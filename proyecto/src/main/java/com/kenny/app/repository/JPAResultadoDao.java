package com.kenny.app.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.kenny.app.domain.Resultado;
@Repository (value = "ResultadoDao")

public class JPAResultadoDao implements ResultadoDao {
	private EntityManager em = null;
    @PersistenceContext
    public void setEntityManager(EntityManager em) {
        this.em = em;
    }
    @Transactional(readOnly = true)
    @SuppressWarnings("unchecked")
	public List<Resultado> getResultadosByProyecto(int proyectoId) {
		return em.createQuery("select p from Resultado p").getResultList();

	}

}
