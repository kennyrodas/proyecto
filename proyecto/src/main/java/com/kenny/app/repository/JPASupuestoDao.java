package com.kenny.app.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.kenny.app.domain.Supuesto;
@Repository(value="SupuestoDao")
public class JPASupuestoDao implements SupuestoDao {
	private EntityManager em = null;

    /*
     * Sets the entity manager.
     */
    @PersistenceContext
    public void setEntityManager(EntityManager em) {
        this.em = em;
    }
	@Override
	public List<Supuesto> getSupuestosByObjetivo(int objetivo_id) {
		// TODO Auto-generated method stub
		return null;
	}

    @Transactional(readOnly = false)
	public Supuesto save(Supuesto supuesto) {
		// TODO Auto-generated method stub
    	return em.merge(supuesto);
	}

	@Override
	public int eliminar(int supuesto_id) {
		// TODO Auto-generated method stub
		return 0;
	}

}
