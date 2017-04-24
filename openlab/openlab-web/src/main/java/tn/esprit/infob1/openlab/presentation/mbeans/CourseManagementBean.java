package tn.esprit.infob1.openlab.presentation.mbeans;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;

import tn.esprit.infob1.openlab.persistence.Course;
import tn.esprit.infob1.openlab.persistence.Teacher;
import tn.esprit.infob1.openlab.services.SubscriptionServiceLocal;

@ManagedBean
@ViewScoped
public class CourseManagementBean {
	
	private List<Course> coursesFiltred=new ArrayList<>();
	@EJB
	private SubscriptionServiceLocal subscriptionServiceLocal;
	private List<Course> coursesByTrainer = new ArrayList<>();
	private List<Course> coursesByStudent = new ArrayList<>();
	private Teacher trainerSelected = new Teacher();
	private List<Course> allCourses = new ArrayList<>();
	private Boolean formVisibility = false;
	private Boolean buttonStatus = false;
	private Course courseSelected = new Course();
	@ManagedProperty(value = "#{identity}")
	private Identity identity;

	public void doSaveOrUpdateCourse() {
		subscriptionServiceLocal.saveOrUpdateCourse(courseSelected);
		formVisibility = false;
	}

	public void doSubscribeTocourse(Course course) {
		List<Course> coursesByStrudent = subscriptionServiceLocal.findAllCoursesByStudent(identity.getUser());
		if (coursesByStrudent.contains(course)) {
			subscriptionServiceLocal.unsubscribeStudentFromCourse(identity.getUser(), course);
			buttonStatus = false;
		} else {
			subscriptionServiceLocal.assingStudentToCourse(identity.getUser(), course);
			formVisibility = false;
			buttonStatus = true;
		}

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

	public List<Course> getCoursesByTrainer() {
		coursesByTrainer = subscriptionServiceLocal.findAllCoursesByTrainer(identity.getUser());
		return coursesByTrainer;
	}

	public void setCoursesByTrainer(List<Course> coursesByTrainer) {
		this.coursesByTrainer = coursesByTrainer;
	}

	public Identity getIdentity() {
		return identity;
	}

	public void setIdentity(Identity identity) {
		this.identity = identity;
	}

	public List<Course> getCoursesByStudent() {
		coursesByStudent = subscriptionServiceLocal.findAllCoursesByStudent(identity.getUser());
		return coursesByStudent;
	}

	public void setCoursesByStudent(List<Course> coursesByStudent) {
		this.coursesByStudent = coursesByStudent;
	}

	public Boolean getButtonStatus() {
		List<Course> coursesByStudent = subscriptionServiceLocal.findAllCoursesByStudent(identity.getUser());

		return buttonStatus;
	}

	public void setButtonStatus(Boolean buttonStatus) {
		this.buttonStatus = buttonStatus;
	}

	public List<Course> getCoursesFiltred() {
		return coursesFiltred;
	}

	public void setCoursesFiltred(List<Course> coursesFiltred) {
		this.coursesFiltred = coursesFiltred;
	}

}
