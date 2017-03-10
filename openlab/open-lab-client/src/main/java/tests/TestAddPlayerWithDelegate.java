package tests;

import delegate.TeamServicesDelegate;
import tn.esprit.infob1.openlab.persistence.training.Player;

public class TestAddPlayerWithDelegate {

	public static void main(String[] args) {
		Player player = new Player();
		player.setId(12);
		player.setName("daly");

		TeamServicesDelegate.doAddPlayer(player);

	}

}
