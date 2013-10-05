package com.kenny.app.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.kenny.app.domain.Indicador;
@Repository(value="IndicadorDao")
public class JPAIndicadorDao implements IndicadorDao {
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
	public List<Indicador> getIndicadoresList(int objetivo_id) {
		return em.createQuery("select p from Indicador p WHERE p.objetivo_id = '"+objetivo_id+"'").getResultList();

	}

    @Transactional(readOnly = false)
	public Indicador saveIndicador(Indicador indicador) {
		return em.merge(indicador);

	}
    @Transactional(readOnly = false)
	public int eliminar(int indicador_id){
		return em.createQuery("delete Indicador where indicadorId = '"+indicador_id+"'").executeUpdate();
	}

}
