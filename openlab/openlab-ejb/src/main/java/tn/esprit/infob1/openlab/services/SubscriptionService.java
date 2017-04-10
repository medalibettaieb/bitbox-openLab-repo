package tn.esprit.infob1.openlab.services;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import tn.esprit.infob1.openlab.persistence.Course;
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

}
