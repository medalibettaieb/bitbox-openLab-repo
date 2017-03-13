package tn.esprit.infob1.openlab.services;

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

}
