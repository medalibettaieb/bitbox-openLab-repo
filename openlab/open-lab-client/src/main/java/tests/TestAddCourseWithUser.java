package tests;

import delegate.SubscriptionServiceDelegate;
import tn.esprit.infob1.openlab.persistence.Course;
import tn.esprit.infob1.openlab.persistence.Teacher;

public class TestAddCourseWithUser {

	public static void main(String[] args) {
		Teacher trainer = new Teacher();
		trainer.setName("bessem");
		
		Course course = new Course("SPRING AOP", trainer);
		
		SubscriptionServiceDelegate.doAddCourse(course);
		
		

	}

}
