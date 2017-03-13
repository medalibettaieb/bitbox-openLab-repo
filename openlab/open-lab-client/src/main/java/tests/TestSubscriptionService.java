package tests;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import tn.esprit.infob1.openlab.persistence.Student;
import tn.esprit.infob1.openlab.services.SubscriptionServiceRemote;

public class TestSubscriptionService {

	public static void main(String[] args) throws NamingException {
		Context context = new InitialContext();
		SubscriptionServiceRemote subscriptionServiceRemote = (SubscriptionServiceRemote) context.lookup(
				"openlab-ear/openlab-ejb/SubscriptionService!tn.esprit.infob1.openlab.services.SubscriptionServiceRemote");

		Student student = new Student();
		student.setId(1);
		student.setName("Ali");
		student.setLevel("infoB1");

		subscriptionServiceRemote.saveOrUpdateUser(student);

	}

}
