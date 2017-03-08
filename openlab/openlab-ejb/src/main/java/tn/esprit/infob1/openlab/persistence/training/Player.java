package tn.esprit.infob1.openlab.persistence.training;

import java.io.Serializable;
import java.lang.Integer;
import java.lang.String;
import java.util.List;

import javax.persistence.*;

/**
 * Entity implementation class for Entity: Player
 *
 */
@Entity

public class Player implements Serializable {

	   
	@Id
	private Integer id;
	private String name;
	
	@OneToMany(mappedBy="player")
	private List<Contract> contracts;
	private static final long serialVersionUID = 1L;

	public Player() {
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
	public List<Contract> getContracts() {
		return contracts;
	}
	public void setContracts(List<Contract> contracts) {
		this.contracts = contracts;
	}
   
}
