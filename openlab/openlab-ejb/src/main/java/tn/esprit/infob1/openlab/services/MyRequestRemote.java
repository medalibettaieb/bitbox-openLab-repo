package tn.esprit.infob1.openlab.services;

import javax.ejb.Remote;

@Remote
public interface MyRequestRemote {
	void sendRequest(String request);

	void showHistory();
}
