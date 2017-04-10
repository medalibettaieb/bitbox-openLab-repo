package tn.esprit.infob1.openlab.presentation.mbeans;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import tn.esprit.infob1.openlab.persistence.Student;
import tn.esprit.infob1.openlab.persistence.Teacher;
import tn.esprit.infob1.openlab.persistence.User;
import tn.esprit.infob1.openlab.services.SubscriptionServiceLocal;

@ManagedBean
@SessionScoped
public class Identity {
	@EJB
	private SubscriptionServiceLocal subscriptionServiceLocal;

	private User user = new User();

	public String doLogin() {
		String navigateTo = "";
		User userLoggedIn = subscriptionServiceLocal.login(user.getLogin(), user.getPassword());
		if (userLoggedIn != null) {
			user = userLoggedIn;
			if (userLoggedIn instanceof Teacher) {
				System.out.println("teacher");
			} else if (userLoggedIn instanceof Student) {
				System.out.println("student");
			} else {
				navigateTo = "/pages/agent/manageCourses?faces-redirect=true";
			}
		} else {
			System.err.println("not");
		}
		return navigateTo;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
}
