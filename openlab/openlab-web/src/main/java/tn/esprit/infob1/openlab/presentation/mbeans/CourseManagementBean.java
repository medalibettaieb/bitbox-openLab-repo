package tn.esprit.infob1.openlab.presentation.mbeans;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import tn.esprit.infob1.openlab.persistence.Course;
import tn.esprit.infob1.openlab.persistence.Teacher;
import tn.esprit.infob1.openlab.services.SubscriptionServiceLocal;

@ManagedBean
@ViewScoped
public class CourseManagementBean {
	@EJB
	private SubscriptionServiceLocal subscriptionServiceLocal;
	private Teacher trainerSelected = new Teacher();
	private List<Course> allCourses = new ArrayList<>();
	private Boolean formVisibility = false;
	private Course courseSelected = new Course();

	public void doSaveOrUpdateCourse() {
		subscriptionServiceLocal.saveOrUpdateCourse(courseSelected);
		formVisibility = false;
	}

	public void doAssignCourseToTrainer() {
		subscriptionServiceLocal.assignCourseToTeacher(courseSelected, trainerSelected);
		formVisibility = false;
		courseSelected = new Course();
	}

	public List<Course> getAllCourses() {
		allCourses = subscriptionServiceLocal.findAllCourses();
		return allCourses;
	}

	public void changeVisibility() {
		formVisibility = true;
	}

	public void setAllCourses(List<Course> allCourses) {
		this.allCourses = allCourses;
	}

	public Boolean getFormVisibility() {
		return formVisibility;
	}

	public void setFormVisibility(Boolean formVisibility) {
		this.formVisibility = formVisibility;
	}

	public Course getCourseSelected() {
		return courseSelected;
	}

	public void setCourseSelected(Course courseSelected) {
		this.courseSelected = courseSelected;
	}

	public Teacher getTrainerSelected() {
		return trainerSelected;
	}

	public void setTrainerSelected(Teacher trainerSelected) {
		this.trainerSelected = trainerSelected;
	}

}
