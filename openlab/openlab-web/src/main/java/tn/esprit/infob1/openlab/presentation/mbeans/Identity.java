package tn.esprit.infob1.openlab.presentation.mbeans;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;

import tn.esprit.infob1.openlab.persistence.Teacher;
import tn.esprit.infob1.openlab.persistence.User;
import tn.esprit.infob1.openlab.services.SubscriptionServiceLocal;

@ManagedBean
public class Identity {
	@EJB
	private SubscriptionServiceLocal subscriptionServiceLocal;

	private User user = new User();

	public void doLogin() {
		User userLoggedIn = subscriptionServiceLocal.login(user.getLogin(), user.getPassword());
		if (userLoggedIn != null) {
			if (user instanceof Teacher) {
				System.out.println("teacher");
			} else {
				System.out.println("student");
			}
		} else {
			System.err.println("not");
		}
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
}
