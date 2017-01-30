package tn.esprit.infob1.openlab.services;

import javax.ejb.Stateless;

@Stateless
public class GreetingsServices implements GreetingsServicesLocal, GreetingsServicesRemote {

	@Override
	public void sallem(String esm) {
		System.out.println("ahla w sahla ya :" + esm);

	}

}
