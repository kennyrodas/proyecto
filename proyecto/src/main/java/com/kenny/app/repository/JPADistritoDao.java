package com.kenny.app.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.kenny.app.domain.Distrito;
@Repository(value="DistritoDao")
public class JPADistritoDao implements DistritoDao {

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
	public List<Distrito> getDistritoList() {
    	return em.createQuery("select p from Distrito p").getResultList();

	}

    @Transactional(readOnly = true)
    @SuppressWarnings("unchecked")
	public List<Distrito> getDistritoListByProvincia(int provincia_id) {
    	return em.createQuery("select p from Distrito p WHERE provinciaId = '"+provincia_id+"'").getResultList();
	}

}
