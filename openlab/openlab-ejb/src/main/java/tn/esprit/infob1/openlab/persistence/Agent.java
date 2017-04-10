package tn.esprit.infob1.openlab.persistence;

import java.io.Serializable;
import java.lang.String;
import javax.persistence.*;
import tn.esprit.infob1.openlab.persistence.User;

/**
 * Entity implementation class for Entity: Agent
 *
 */
@Entity

public class Agent extends User implements Serializable {

	
	private String job;
	private static final long serialVersionUID = 1L;

	public Agent() {
		super();
	}  
	
	public Agent(String name, String login, String password, String job) {
		super(name, login, password);
		this.job = job;
	}

	public String getJob() {
		return this.job;
	}

	public void setJob(String job) {
		this.job = job;
	}
   
}
