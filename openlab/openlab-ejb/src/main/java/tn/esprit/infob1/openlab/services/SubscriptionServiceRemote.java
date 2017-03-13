package tn.esprit.infob1.openlab.services;

import javax.ejb.Remote;

import tn.esprit.infob1.openlab.persistence.Course;
import tn.esprit.infob1.openlab.persistence.User;

@Remote
public interface SubscriptionServiceRemote {
	Boolean saveOrUpdateUser(User user);

	void saveOrUpdateCourse(Course course);

}
