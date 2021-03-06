package tn.esprit.infob1.openlab.persistence;

import java.io.Serializable;
import java.lang.Float;
import javax.persistence.*;
import tn.esprit.infob1.openlab.persistence.User;

/**
 * Entity implementation class for Entity: Teacher
 *
 */
@Entity

public class Teacher extends User implements Serializable {

	
	private Float salary;
	private static final long serialVersionUID = 1L;

	public Teacher() {
		super();
	} 
	
	public Teacher(String name, String login, String password, Float salary) {
		super(name, login, password);
		this.salary = salary;
	}

	public Float getSalary() {
		return this.salary;
	}

	public void setSalary(Float salary) {
		this.salary = salary;
	}
   
}
