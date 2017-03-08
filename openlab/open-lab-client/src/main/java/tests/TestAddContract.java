package tests;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import tn.esprit.infob1.openlab.persistence.training.Player;
import tn.esprit.infob1.openlab.persistence.training.Team;
import tn.esprit.infob1.openlab.persistence.training.service.TeamServicesRemote;

public class TestAddContract {

	public static void main(String[] args) throws NamingException {
		Context context = new InitialContext();
		TeamServicesRemote teamServicesRemote = (TeamServicesRemote) context.lookup(
				"openlab-ear/openlab-ejb/TeamServices!tn.esprit.infob1.openlab.persistence.training.service.TeamServicesRemote");

		Team team = teamServicesRemote.findTeamById(2);
		Player player = teamServicesRemote.findPlayerById(2);
		Integer duration = 2;
		String position = "striker";
		teamServicesRemote.addContract(team, player, duration, position);
	}

}
