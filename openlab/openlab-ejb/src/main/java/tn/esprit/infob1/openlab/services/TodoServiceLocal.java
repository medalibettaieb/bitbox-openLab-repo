package tn.esprit.infob1.openlab.services;

import java.util.List;

import javax.ejb.Local;

import tn.esprit.infob1.openlab.persistence.Todo;

@Local
public interface TodoServiceLocal {
	
	void create(Todo todo);
	List<Todo> findAll();

}
