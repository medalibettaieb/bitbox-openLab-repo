package tests;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import tn.esprit.infob1.openlab.persistence.training.service.TeamServicesRemote;

public class TestDeletePlayerById {

	public static void main(String[] args) throws NamingException {
		Context context = new InitialContext();
		TeamServicesRemote teamServicesRemote = (TeamServicesRemote) context.lookup(
				"openlab-ear/openlab-ejb/TeamServices!tn.esprit.infob1.openlab.persistence.training.service.TeamServicesRemote");

		teamServicesRemote.deletePlayerById(2);
	}

}
