package tn.esprit.infob1.openlab.services;

import java.util.HashMap;
import java.util.Map;

import javax.ejb.Stateful;

/**
 * Session Bean implementation class MyRequest
 */
@Stateful
public class MyRequest implements MyRequestRemote, MyRequestLocal {
	private Map<String, String> mapOfRequests = new HashMap<>();

	/**
	 * Default constructor.
	 */
	public MyRequest() {
	}

	@Override
	public void sendRequest(String request) {
		System.out.println("Request : " + request);
		mapOfRequests.put(request, "false");

	}

	@Override
	public void showHistory() {
		// TODO Auto-generated method stub

	}

	public Map<String, String> getMapOfRequests() {
		return mapOfRequests;
	}

	public void setMapOfRequests(Map<String, String> mapOfRequests) {
		this.mapOfRequests = mapOfRequests;
	}

}
