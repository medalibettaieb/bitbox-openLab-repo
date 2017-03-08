package tn.esprit.infob1.openlab.services;

import javax.ejb.Local;

import tn.esprit.infob1.openlab.persistence.User;

@Local
public interface SubscriptionServiceLocal {
	Boolean addUser(User user);
}
