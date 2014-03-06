package org.paumard.ejb;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.paumard.model.Marin;

@Stateless
public class MarinEJB {

	@PersistenceContext(unitName="cloudbees-project")
	private EntityManager em ;
	
	public Long createMarin(Marin marin) {
		
		em.persist(marin) ;
		return marin.getId() ;
 	}
 	
 	public void delete(Marin m) {
	getEntityManager().getTransaction().begin();
	m = getEntityManager().merge(m);
	getEntityManager().remove(m);
	getEntityManager().getTransaction().commit();
	}
	
}
