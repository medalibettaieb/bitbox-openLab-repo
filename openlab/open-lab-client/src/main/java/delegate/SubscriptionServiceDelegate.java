package delegate;

import java.util.List;

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

	public static User doLogin(String login, String password) {
		return getProxy().login(login, password);
	}

	public static List<Course> doFindCoursesByStudent(User user) {
		return getProxy().findAllCoursesByStudent(user);
	}
}
