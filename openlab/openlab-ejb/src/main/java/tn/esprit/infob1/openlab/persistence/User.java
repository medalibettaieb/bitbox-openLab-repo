package tn.esprit.infob1.openlab.persistence;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
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
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String name;
	private String login;
	private String password;

	@ManyToMany
	private List<Course> coursesAttended;
	@OneToMany(mappedBy = "trainer", cascade = CascadeType.MERGE)
	private List<Course> coursesTaught;
	private static final long serialVersionUID = 1L;

	public User() {
		super();
	}

	public User(String name, String login, String password) {
		super();
		this.name = name;
		this.login = login;
		this.password = password;
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

	public void linkCoursesToThisTrainer(List<Course> courses) {
		this.coursesTaught = courses;
		for (Course c : courses) {
			c.setTrainer(this);
		}
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
}
