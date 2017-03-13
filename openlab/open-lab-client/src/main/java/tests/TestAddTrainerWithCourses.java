package tests;

import java.util.ArrayList;
import java.util.List;

import delegate.SubscriptionServiceDelegate;
import tn.esprit.infob1.openlab.persistence.Course;
import tn.esprit.infob1.openlab.persistence.Teacher;

public class TestAddTrainerWithCourses {

	public static void main(String[] args) {
		Teacher teacher = new Teacher();
		teacher.setName("imed");

		Course course = new Course("J2ME");
		Course course2 = new Course("JAVA");

		List<Course> coursesTaught = new ArrayList<>();
		coursesTaught.add(course);
		coursesTaught.add(course2);

		teacher.linkCoursesToThisTrainer(coursesTaught);

		SubscriptionServiceDelegate.doAddUser(teacher);

	}

}
