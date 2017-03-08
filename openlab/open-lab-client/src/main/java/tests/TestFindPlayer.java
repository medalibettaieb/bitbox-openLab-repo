package tests;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import tn.esprit.infob1.openlab.persistence.training.Player;
import tn.esprit.infob1.openlab.persistence.training.service.TeamServicesRemote;

public class TestFindPlayer {

	public static void main(String[] args) throws NamingException {
		Context context = new InitialContext();
		TeamServicesRemote teamServicesRemote = (TeamServicesRemote) context.lookup(
				"openlab-ear/openlab-ejb/TeamServices!tn.esprit.infob1.openlab.persistence.training.service.TeamServicesRemote");

		Player playerFound = teamServicesRemote.findPlayerById(2);

		System.out.println(playerFound.getName());
	}

}
