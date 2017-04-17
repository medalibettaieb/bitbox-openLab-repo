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
	private Boolean loggedInAsAgent = false;
	private User user = new User();

	public String doLogin() {
		String navigateTo = "";
		User userLoggedIn = subscriptionServiceLocal.login(user.getLogin(), user.getPassword());
		if (userLoggedIn != null) {
			user = userLoggedIn;
			if (userLoggedIn instanceof Teacher) {
				navigateTo = "/pages/trainer/myCourses?faces-redirect=true";
			} else if (userLoggedIn instanceof Student) {
				navigateTo = "/pages/student/subscriptionToCourses?faces-redirect=true";
			} else {
				loggedInAsAgent = true;
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

	public Boolean getLoggedInAsAgent() {
		return loggedInAsAgent;
	}

	public void setLoggedInAsAgent(Boolean loggedInAsAgent) {
		this.loggedInAsAgent = loggedInAsAgent;
	}
}
