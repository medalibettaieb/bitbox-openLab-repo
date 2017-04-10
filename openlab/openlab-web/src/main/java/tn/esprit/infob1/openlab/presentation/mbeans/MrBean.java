package tn.esprit.infob1.openlab.presentation.mbeans;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;

import tn.esprit.infob1.openlab.persistence.User;
import tn.esprit.infob1.openlab.services.SubscriptionServiceLocal;

@ManagedBean
public class MrBean {
	@EJB
	private SubscriptionServiceLocal subscriptionServiceLocal;
	private String name;
	private User user=new User();

	public void display() {
		System.out.println(name);
	}

	public void doSaveOrUpdateUser() {
		subscriptionServiceLocal.saveOrUpdateUser(user);
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

}
