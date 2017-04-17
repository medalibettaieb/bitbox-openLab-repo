package tn.esprit.infob1.openlab.presentation.mbeans;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import tn.esprit.infob1.openlab.persistence.Teacher;
import tn.esprit.infob1.openlab.services.SubscriptionServiceLocal;

@ManagedBean
@ViewScoped
public class TrainerBean {
	private List<Teacher> teachers = new ArrayList<>();
	@EJB
	private SubscriptionServiceLocal subscriptionServiceLocal;

	public Teacher doFindTeacherByName(String name) {
		return subscriptionServiceLocal.findTrainerByName(name);
	}

	public List<Teacher> getTeachers() {
		teachers = subscriptionServiceLocal.findallTeachers();
		return teachers;
	}

	public void setTeachers(List<Teacher> teachers) {
		this.teachers = teachers;
	}
}
