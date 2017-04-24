package tests;

import java.util.List;

import delegate.SubscriptionServiceDelegate;
import tn.esprit.infob1.openlab.persistence.Course;
import tn.esprit.infob1.openlab.persistence.User;

public class TestFindCoursesbyStudent {

	public static void main(String[] args) {
		User user = SubscriptionServiceDelegate.doLogin("mou", "mou");
		List<Course> courses = SubscriptionServiceDelegate.doFindCoursesByStudent(user);
		
		System.out.println(courses.size());
	}

}
