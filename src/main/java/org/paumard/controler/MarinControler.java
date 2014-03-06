package org.paumard.controler;

import java.io.Serializable;

import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;

import org.paumard.ejb.MarinEJB;
import org.paumard.model.Marin;

@SuppressWarnings("serial")
@Named("marinControler")
@SessionScoped
public class MarinControler implements Serializable {
	
	@Inject
	private transient MarinEJB marinEJB ;
	
	private Marin marin = new Marin() ;

	public void create() {
		Long id = marinEJB.createMarin(marin) ;
		System.out.println("Marin persisté : " + id) ;
	}
	
	//Ajout d'une méthode de listing des marin
	private MarinEJB mEJB = new MarinEJB();
	private List<Marin> marins;
	}
	//Ajout d'une méthode Delete marin dans le controleur
	public String deleteMarin() {
	Marin m = (Marin) marins.getRowData();
	mEJB.delete(m);
	marins.setWrappedData(mEJB.selectAll());
	return null;
}
}
	
	public Marin getMarin() {
		return marin;
	}

	public void setMarin(Marin marin) {
		this.marin = marin;
	}
}
