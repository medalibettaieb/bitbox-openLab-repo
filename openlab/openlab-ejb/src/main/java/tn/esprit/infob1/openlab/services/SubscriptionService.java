package tn.esprit.infob1.openlab.services;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import tn.esprit.infob1.openlab.persistence.Course;
import tn.esprit.infob1.openlab.persistence.Teacher;
import tn.esprit.infob1.openlab.persistence.User;

/**
 * Session Bean implementation class SubscriptionService
 */
@Stateless
public class SubscriptionService implements SubscriptionServiceRemote, SubscriptionServiceLocal {
	@PersistenceContext
	private EntityManager entityManager;

	/**
	 * Default constructor.
	 */
	public SubscriptionService() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public Boolean saveOrUpdateUser(User user) {
		Boolean b = false;
		try {
			entityManager.merge(user);
			b = true;
		} catch (Exception e) {

			System.err.println("problem in subscription ...");
		}
		return b;
	}

	@Override
	public void saveOrUpdateCourse(Course course) {
		entityManager.merge(course);
	}

	@Override
	public User login(String login, String password) {
		User user = null;
		try {
			user = (User) entityManager.createQuery("select u from User u where u.login=:param1 and u.password=:param2")
					.setParameter("param1", login).setParameter("param2", password).getSingleResult();
		} catch (Exception e) {
		}

		return user;
	}

	@Override
	public void assignCourseToTeacher(Course course, User user) {
		course.setTrainer(user);

		entityManager.merge(course);

	}

	@Override
	public List<Course> findAllCourses() {
		return entityManager.createQuery("SELECT c FROM Course c", Course.class).getResultList();
	}

	@Override
	public User findUserById(Integer id) {
		return entityManager.find(User.class, id);
	}

	@Override
	public List<User> findAllUsers() {
		return entityManager.createQuery("SELECT c FROM User c", User.class).getResultList();
	}

	@Override
	public List<Teacher> findallTeachers() {
		return entityManager.createQuery("SELECT c FROM Teacher c", Teacher.class).getResultList();
	}

	@Override
	public Teacher findTrainerByName(String name) {
		return entityManager.createQuery("SELECT c FROM Teacher c WHERE c.name=:p", Teacher.class)
				.setParameter("p", name).getSingleResult();

	}

	@Override
	public List<Course> findAllCoursesByTrainer(User user) {
		return entityManager.createQuery("SELECT c FROM Course c  WHERE c.trainer=:p", Course.class)
				.setParameter("p", user).getResultList();
	}

	@Override
	public List<Course> findAllCoursesByStudent(User user) {
		return entityManager
				.createQuery("SELECT c FROM Course c  inner join c.attendeesList ats  WHERE ats.id=:p", Course.class)
				.setParameter("p", user.getId()).getResultList();
	}

	@Override
	public void assingStudentToCourse(User user, Course course) {
		List<Course> coursesOld = findAllCoursesByStudent(user);
		coursesOld.add(course);
		user.setCoursesAttended(coursesOld);
		entityManager.merge(user);
	}

}
