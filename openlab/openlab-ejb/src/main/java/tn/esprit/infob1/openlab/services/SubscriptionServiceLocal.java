package tn.esprit.infob1.openlab.services;

import java.util.List;

import javax.ejb.Local;

import tn.esprit.infob1.openlab.persistence.Course;
import tn.esprit.infob1.openlab.persistence.Teacher;
import tn.esprit.infob1.openlab.persistence.User;

@Local
public interface SubscriptionServiceLocal {
	Boolean saveOrUpdateUser(User user);

	void saveOrUpdateCourse(Course course);

	User login(String login, String password);

	void assignCourseToTeacher(Course course, User user);

	List<Course> findAllCourses();

	User findUserById(Integer id);

	List<User> findAllUsers();

	List<Teacher> findallTeachers();

	Teacher findTrainerByName(String name);

	List<Course> findAllCoursesByTrainer(User user);

	List<Course> findAllCoursesByStudent(User user);

	void assingStudentToCourse(User user, Course courseSelected);
	
	void unsubscribeStudentFromCourse(User user, Course courseSelected);

}
