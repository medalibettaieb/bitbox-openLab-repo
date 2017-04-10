package tests;

import delegate.SubscriptionServiceDelegate;
import tn.esprit.infob1.openlab.persistence.Course;
import tn.esprit.infob1.openlab.persistence.Teacher;

public class TestAddCourseWithUser {

	public static void main(String[] args) {
		Teacher trainer = new Teacher();
		trainer.setName("bessem");

		Teacher trainer2 = new Teacher();
		trainer2.setName("salma");

		Course course = new Course("SPRING AOP");
		Course course2 = new Course("Java EE 7", trainer2);
		Course course3 = new Course("IC", trainer2);

		SubscriptionServiceDelegate.doAddCourse(course);
		SubscriptionServiceDelegate.doAddCourse(course2);
		SubscriptionServiceDelegate.doAddCourse(course3);

	}

}
