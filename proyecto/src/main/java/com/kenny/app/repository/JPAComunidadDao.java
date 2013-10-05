package com.kenny.app.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.kenny.app.domain.Comunidad;
@Repository(value = "ComunidadDao")
public class JPAComunidadDao implements ComunidadDao {
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
	public List<Comunidad> getComunidadList() {
    	return em.createQuery("select p from Comunidad p").getResultList();
	}

    @Transactional(readOnly = true)
    @SuppressWarnings("unchecked")
	public List<Comunidad> getComunidadListByDistrito(int distrito_id) {
    	return em.createQuery("select p from Comunidad p WHERE distritoId = '"+distrito_id+"'").getResultList();

	}

}
