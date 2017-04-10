package tn.esprit.infob1.openlab.persistence;

import java.io.Serializable;

import javax.persistence.Entity;

/**
 * Entity implementation class for Entity: Student
 *
 */
@Entity

public class Student extends User implements Serializable {

	private String level;
	private static final long serialVersionUID = 1L;

	public Student() {
		super();
	}

	public Student(String name, String login, String password, String level) {
		super(name, login, password);
		this.level = level;
	}

	public String getLevel() {
		return level;
	}

	public void setLevel(String level) {
		this.level = level;
	}

}
