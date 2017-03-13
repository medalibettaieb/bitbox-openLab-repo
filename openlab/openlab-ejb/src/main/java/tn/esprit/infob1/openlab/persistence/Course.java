package tn.esprit.infob1.openlab.persistence;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

/**
 * Entity implementation class for Entity: Course
 *
 */
@Entity

public class Course implements Serializable {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	private String name;
	
	@ManyToMany(mappedBy = "coursesAttended")
	private List<User> attendeesList;
	@ManyToOne(cascade=CascadeType.MERGE)
	private User trainer;
	private static final long serialVersionUID = 1L;

	public Course() {
		super();
	}

	public Course(String name, User trainer) {
		super();
		this.name = name;
		this.trainer = trainer;
	}
	

	public Course(String name) {
		super();
		this.name = name;
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

	public List<User> getAttendeesList() {
		return attendeesList;
	}

	public void setAttendeesList(List<User> attendeesList) {
		this.attendeesList = attendeesList;
	}

	public User getTrainer() {
		return trainer;
	}

	public void setTrainer(User trainer) {
		this.trainer = trainer;
	}

}
