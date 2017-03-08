package tn.esprit.infob1.openlab.persistence.training.service;

import java.util.List;

import javax.ejb.Remote;

import tn.esprit.infob1.openlab.persistence.training.Player;
import tn.esprit.infob1.openlab.persistence.training.Team;

@Remote
public interface TeamServicesRemote {
	void addContract(Team team, Player player, Integer duration, String position);

	void addPlayer(Player player);

	void addTeam(Team team);

	Player findPlayerById(Integer id);

	Team findTeamById(Integer id);

	void deletePlayerById(Integer id);

	void deletePlayer(Player player);

	void updateTeam(Team team);

	List<Team> findAllTeams();

}
