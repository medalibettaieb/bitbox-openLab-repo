package tn.esprit.infob1.openlab.util;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Singleton;
import javax.ejb.Startup;

import tn.esprit.infob1.openlab.persistence.Agent;
import tn.esprit.infob1.openlab.persistence.Student;
import tn.esprit.infob1.openlab.persistence.Teacher;
import tn.esprit.infob1.openlab.services.SubscriptionServiceLocal;

/**
 * Session Bean implementation class Utilities
 */
@Singleton
@LocalBean
@Startup
public class Utilities {
	@EJB
	private SubscriptionServiceLocal subscriptionServiceLocal;

	/**
	 * Default constructor.
	 */
	public Utilities() {
		// TODO Auto-generated constructor stub
	}

	@PostConstruct
	public void initDB() {
		Student student = new Student("amal", "a", "a", "one");
		Student student2 = new Student("samir", "s", "s", "one");
		Student student3 = new Student("mouha", "mou", "mou", "two");

		Teacher teacher = new Teacher("karim", "k", "k", 1200F);
		Teacher teacher2 = new Teacher("maher", "m", "m", 1200F);

		Agent agent = new Agent("bechir", "b", "b", "moudir");
		Agent agent2 = new Agent("bouthayna", "bo", "bo", "moudira");

		subscriptionServiceLocal.saveOrUpdateUser(teacher);
		subscriptionServiceLocal.saveOrUpdateUser(teacher2);
		subscriptionServiceLocal.saveOrUpdateUser(student);
		subscriptionServiceLocal.saveOrUpdateUser(student2);
		subscriptionServiceLocal.saveOrUpdateUser(student3);
		subscriptionServiceLocal.saveOrUpdateUser(agent);
		subscriptionServiceLocal.saveOrUpdateUser(agent2);

	}
}
