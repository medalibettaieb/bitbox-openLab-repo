package tn.esprit.infob1.openlab.services;

import javax.ejb.Stateless;

/**
 * Session Bean implementation class Fadda
 */
@Stateless
public class Fadda implements FaddaRemote, FaddaLocal {

    /**
     * Default constructor. 
     */
    public Fadda() {
        // TODO Auto-generated constructor stub
    }

	@Override
	public String raniFaddit(String name) {
		return "ahhhhhhh men 3and : "+name;
	}

}
