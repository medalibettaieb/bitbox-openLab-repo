package delegate;

import serviceLocator.ServiceLocator;
import tn.esprit.infob1.openlab.persistence.training.Player;
import tn.esprit.infob1.openlab.persistence.training.service.TeamServicesRemote;

public class TeamServicesDelegate {
	private static final String JNDI = "openlab-ear/openlab-ejb/TeamServices!tn.esprit.infob1.openlab.persistence.training.service.TeamServicesRemote";

	private static TeamServicesRemote getProxy() {
		return (TeamServicesRemote) ServiceLocator.getInstance().getProxy(JNDI);
	}

	public static void doAddPlayer(Player player) {
		getProxy().addPlayer(player);
	}
}
