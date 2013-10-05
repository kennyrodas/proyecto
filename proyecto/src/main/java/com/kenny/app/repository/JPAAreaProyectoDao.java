package com.kenny.app.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.kenny.app.domain.AreaProyecto;
@Repository (value = "AreaProyectoDao")
public class JPAAreaProyectoDao implements AreaProyectoDao {
    private EntityManager em = null;

    @PersistenceContext
    public void setEntityManager(EntityManager em) {
        this.em = em;
    }
    @Transactional(readOnly = true)
    @SuppressWarnings("unchecked")
	public List<AreaProyecto> getAreaProyectoList() {
		// TODO Auto-generated method stub
		//return null;
		return em.createQuery("select p from AreaProyecto p").getResultList();
	}
	
	

}
