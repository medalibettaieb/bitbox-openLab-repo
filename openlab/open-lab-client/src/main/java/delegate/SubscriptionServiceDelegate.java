package delegate;

import serviceLocator.ServiceLocator;
import tn.esprit.infob1.openlab.persistence.User;
import tn.esprit.infob1.openlab.services.SubscriptionServiceRemote;

public class SubscriptionServiceDelegate {
	private static final String JNDI = "openlab-ear/openlab-ejb/TeamServices!tn.esprit.infob1.openlab.persistence.training.service.TeamServicesRemote";

	private static SubscriptionServiceRemote getProxy() {
		return (SubscriptionServiceRemote) ServiceLocator.getInstance().getProxy(JNDI);
	}

	public static Boolean doAddUser(User user) {
		return getProxy().addUser(user);
	}
}
