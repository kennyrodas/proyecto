package com.kenny.app.repository;

import java.util.List;

import com.kenny.app.domain.Region;



import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
@Repository (value = "RegionDao")
public class JPARegionDao implements RegionDao {
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
	public List<Region> getRegionList() {
        return em.createQuery("select p from Region p").getResultList();	}

    @Transactional(readOnly = true)
    @SuppressWarnings("unchecked")
	public List<Region> getRegionListByPais(int pais_id) {
		return em.createQuery("select p from Region p WHERE p.paisId ='"+pais_id+"'").getResultList();	
	}

}
