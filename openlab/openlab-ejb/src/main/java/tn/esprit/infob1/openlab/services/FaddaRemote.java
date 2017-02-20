package tn.esprit.infob1.openlab.services;

import javax.ejb.Remote;

@Remote
public interface FaddaRemote {
	String raniFaddit(String name);
}
