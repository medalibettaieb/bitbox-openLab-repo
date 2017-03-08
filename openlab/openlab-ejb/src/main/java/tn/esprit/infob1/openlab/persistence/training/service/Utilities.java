package tn.esprit.infob1.openlab.persistence.training.service;

import javax.annotation.PostConstruct;
import javax.ejb.LocalBean;
import javax.ejb.Singleton;
import javax.ejb.Startup;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import tn.esprit.infob1.openlab.persistence.training.Player;
import tn.esprit.infob1.openlab.persistence.training.Team;

/**
 * Session Bean implementation class Utilities
 */
@Singleton
@LocalBean
@Startup
public class Utilities {
	@PersistenceContext
	private EntityManager entityManager;

	/**
	 * Default constructor.
	 */
	public Utilities() {
	}

	@PostConstruct
	public void initDb() {
		Player player = new Player();
		player.setId(1);
		player.setName("mahmoud");

		Player player2 = new Player();
		player2.setId(2);
		player2.setName("chokri");

		Team team = new Team();
		team.setId(2);
		team.setColor("red");

		Team team2 = new Team();
		team2.setId(3);
		team2.setColor("yellow");

		entityManager.persist(team);
		entityManager.persist(team2);
		entityManager.persist(player);
		entityManager.persist(player2);
	}
}
