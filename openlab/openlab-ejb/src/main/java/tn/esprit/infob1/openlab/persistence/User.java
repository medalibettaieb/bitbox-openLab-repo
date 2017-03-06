package tn.esprit.infob1.openlab.persistence;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

/**
 * Entity implementation class for Entity: User
 *
 */
@Entity

public class User implements Serializable {

	@Id
	private Integer id;
	private String name;

	@ManyToMany
	private List<Course> coursesAttended;
	@OneToMany(mappedBy = "trainer")
	private List<Course> coursesTaught;
	private static final long serialVersionUID = 1L;

	public User() {
		super();
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Course> getCoursesAttended() {
		return coursesAttended;
	}

	public void setCoursesAttended(List<Course> coursesAttended) {
		this.coursesAttended = coursesAttended;
	}

	public List<Course> getCoursesTaught() {
		return coursesTaught;
	}

	public void setCoursesTaught(List<Course> coursesTaught) {
		this.coursesTaught = coursesTaught;
	}

}
