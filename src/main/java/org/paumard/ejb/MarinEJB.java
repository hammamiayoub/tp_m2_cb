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
 	
 	//Ajout d'une méthode de listing des marin
	public List<Marin> selectAll() {
		List<Marin> marins = getEntityManager().createQuery(
				"select marin from Marin marin").getResultList();
		return marin;
	}
 	//Ajout d'une méthode de suppression de marin
 	public void delete(Marin m) {
	getEntityManager().getTransaction().begin();
	m = getEntityManager().merge(m);
	getEntityManager().remove(m);
	getEntityManager().getTransaction().commit();
	}
	
}
