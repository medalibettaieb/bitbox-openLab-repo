package tn.esprit.infob1.openlab.persistence.training.service;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import tn.esprit.infob1.openlab.persistence.training.Contract;
import tn.esprit.infob1.openlab.persistence.training.Player;
import tn.esprit.infob1.openlab.persistence.training.Team;

/**
 * Session Bean implementation class TeamServices
 */
@Stateless
public class TeamServices implements TeamServicesRemote, TeamServicesLocal {

	@PersistenceContext
	private EntityManager entityManager;

	/**
	 * Default constructor.
	 */
	public TeamServices() {
	}

	@Override
	public void addContract(Team team, Player player, Integer duration, String position) {
		Contract contract = new Contract(duration, position, team, player);

		entityManager.persist(contract);
	}

	@Override
	public void addPlayer(Player player) {
		entityManager.persist(player);

	}

	@Override
	public void addTeam(Team team) {
		entityManager.persist(team);
	}

	@Override
	public Player findPlayerById(Integer id) {
		return entityManager.find(Player.class, id);
	}

	@Override
	public Team findTeamById(Integer id) {
		return entityManager.find(Team.class, id);
	}

	@Override
	public void deletePlayerById(Integer id) {
		entityManager.remove(findPlayerById(id));
	}

	@Override
	public void deletePlayer(Player player) {
		entityManager.remove(entityManager.merge(player));
	}

	@Override
	public void updateTeam(Team team) {
		entityManager.merge(team);

	}

	@Override
	public List<Team> findAllTeams() {
		return entityManager.createQuery("select t from Team t ").getResultList();
	}

}
