package application.service;

import java.util.List;

import application.dao.PersonDAO;
import application.domain.Person;

public class PersonService {
	PersonDAO personDAO = new PersonDAO();
	
	public List<Person> getPersons() {
		return personDAO.getAllPersons();
	}
}
