package tn.esprit.infob1.openlab.services;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;

/**
 * Session Bean implementation class Helper
 */
@Stateless
public class Helper implements HelperRemote, HelperLocal {
	@EJB
	private RaiseHand raiseHand;

	/**
	 * Default constructor.
	 */
	public Helper() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public void pleaseHelpMe(String id) {
		raiseHand.raise(id);
		System.out.println(id);
		System.out.println(raiseHand.getNbRequests());
		List<String> list = raiseHand.getIds();
		for (String s : list) {
			System.out.println(s);
		}
	}

}
