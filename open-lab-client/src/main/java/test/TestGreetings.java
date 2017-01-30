package test;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import tn.esprit.infob1.openlab.services.GreetingsServicesRemote;

public class TestGreetings {

	public static void main(String[] args) throws NamingException {
		Context context = new InitialContext();

		GreetingsServicesRemote proxy = (GreetingsServicesRemote) context.lookup(
				"openlab-ear/openlab-ejb/GreetingsServices!tn.esprit.infob1.openlab.services.GreetingsServicesRemote");

		proxy.sallem("info b");
	}

}
