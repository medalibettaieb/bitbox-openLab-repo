package tests;

import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import tn.esprit.infob1.openlab.persistence.training.Team;
import tn.esprit.infob1.openlab.persistence.training.service.TeamServicesRemote;

public class TestFindAllTeams {

	public static void main(String[] args) throws NamingException {
		Context context = new InitialContext();
		TeamServicesRemote teamServicesRemote = (TeamServicesRemote) context.lookup(
				"openlab-ear/openlab-ejb/TeamServices!tn.esprit.infob1.openlab.persistence.training.service.TeamServicesRemote");

		List<Team> teams = teamServicesRemote.findAllTeams();

		for (Team t : teams) {
			System.out.println(t.getColor());
		}

	}

}
