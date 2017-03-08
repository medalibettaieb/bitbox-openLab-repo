package tn.esprit.infob1.openlab.persistence.training;

import java.io.Serializable;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

/**
 * Entity implementation class for Entity: Contract
 *
 */
@Entity

public class Contract implements Serializable {
	@EmbeddedId
	private ContractId contractId;
	private int duration;
	private String position;

	@ManyToOne
	@JoinColumn(name = "idTeam", referencedColumnName = "id", updatable = false, insertable = false)
	private Team team;

	@ManyToOne
	@JoinColumn(name = "idPlayer", referencedColumnName = "id", updatable = false, insertable = false)
	private Player player;
	private static final long serialVersionUID = 1L;

	public Contract() {
		super();
	}

	public Contract(int duration, String position, Team team, Player player) {
		super();
		this.contractId = new ContractId(team.getId(), player.getId());
		this.duration = duration;
		this.position = position;
		this.team = team;
		this.player = player;
	}

	public int getDuration() {
		return this.duration;
	}

	public void setDuration(int duration) {
		this.duration = duration;
	}

	public String getPosition() {
		return this.position;
	}

	public void setPosition(String position) {
		this.position = position;
	}

	public Team getTeam() {
		return team;
	}

	public void setTeam(Team team) {
		this.team = team;
	}

	public Player getPlayer() {
		return player;
	}

	public void setPlayer(Player player) {
		this.player = player;
	}

}
