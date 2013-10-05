package com.kenny.app.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.kenny.app.domain.Provincia;
@Repository (value = "ProvinciaDao")
public class JPAProvinciaDao implements ProvinciaDao {

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
	public List<Provincia> getProvinciaList() {
    	return em.createQuery("select p from Provincia p").getResultList();
	}


    @Transactional(readOnly = true)
    @SuppressWarnings("unchecked")
	public List<Provincia> getProvinciaListByRegion(int region_id) {

    	return em.createQuery("select p from Provincia p WHERE p.regionId = '"+region_id+"'").getResultList();
	}

}
