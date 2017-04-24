package tn.esprit.infob1.openlab.presentation.mbeans;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import tn.esprit.infob1.openlab.persistence.Student;
import tn.esprit.infob1.openlab.services.SubscriptionServiceLocal;

@ManagedBean
@ViewScoped
public class UserManagementBean {
	private Student student;
	@EJB
	private SubscriptionServiceLocal subscriptionServiceLocal;

	public String doAddStudent() {
		subscriptionServiceLocal.saveOrUpdateUser(student);
		return "/login?faces-redirect=true";
	}

	@PostConstruct
	private void init() {
		student = new Student();
	}

	public Student getStudent() {
		return student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}

}
