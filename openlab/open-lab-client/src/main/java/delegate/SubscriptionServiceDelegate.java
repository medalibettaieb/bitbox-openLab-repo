package delegate;

import serviceLocator.ServiceLocator;
import tn.esprit.infob1.openlab.persistence.Course;
import tn.esprit.infob1.openlab.persistence.User;
import tn.esprit.infob1.openlab.services.SubscriptionServiceRemote;

public class SubscriptionServiceDelegate {
	private static final String JNDI = "openlab-ear/openlab-ejb/SubscriptionService!tn.esprit.infob1.openlab.services.SubscriptionServiceRemote";

	private static SubscriptionServiceRemote getProxy() {
		return (SubscriptionServiceRemote) ServiceLocator.getInstance().getProxy(JNDI);
	}

	public static Boolean doAddUser(User user) {
		return getProxy().saveOrUpdateUser(user);
	}

	public static void doAddCourse(Course course) {
		getProxy().saveOrUpdateCourse(course);
	}
}
