package tests;

import delegate.SubscriptionServiceDelegate;
import tn.esprit.infob1.openlab.persistence.Teacher;
import tn.esprit.infob1.openlab.persistence.User;

public class TestLogin {
	public static void main(String[] args) {
		User user = SubscriptionServiceDelegate.doLogin("a", "a");
		if (user != null) {

			if (user instanceof Teacher) {
				System.out.println("i am a teacher");

			} else {
				System.out.println("i am a student");
			}

		} else {
			System.out.println("not registred");
		}
	}
}
