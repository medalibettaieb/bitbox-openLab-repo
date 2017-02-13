package tn.esprit.infob1.openlab.services;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Singleton;

/**
 * Session Bean implementation class RaiseHand
 */
@Singleton
@LocalBean
public class RaiseHand {
	private int nbRequests = 0;
	private List<String> ids = new ArrayList<>();

	/**
	 * Default constructor.
	 */
	public RaiseHand() {
	}

	public void raise(String id) {
		nbRequests++;
		System.out.println("HELP ME ...");
		ids.add(id);
	}

	public int getNbRequests() {
		return nbRequests;
	}

	public void setNbRequests(int nbRequests) {
		this.nbRequests = nbRequests;
	}

	public List<String> getIds() {
		return ids;
	}

	public void setIds(List<String> ids) {
		this.ids = ids;
	}

}
