package tn.esprit.infob1.openlab.services;

import javax.ejb.Local;

@Local
public interface GreetingsServicesLocal {
	void sallem(String esm);
}
