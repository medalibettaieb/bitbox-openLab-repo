package tests;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import tn.esprit.infob1.openlab.persistence.training.Team;
import tn.esprit.infob1.openlab.persistence.training.service.TeamServicesRemote;

public class TestUpdateTeam {

	public static void main(String[] args) throws NamingException {
		Context context = new InitialContext();
		TeamServicesRemote teamServicesRemote = (TeamServicesRemote) context.lookup(
				"openlab-ear/openlab-ejb/TeamServices!tn.esprit.infob1.openlab.persistence.training.service.TeamServicesRemote");

		Team teamFound = teamServicesRemote.findTeamById(2);
		teamFound.setColor("blue");

		teamServicesRemote.updateTeam(teamFound);

	}

}
