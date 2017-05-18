package application.service;

import java.util.List;

import application.dao.PersonDao;
import application.domain.Person;

public class PersonService {
	PersonDao personDAO = new PersonDao();
	
	public List<Person> getPersons() {
		return personDAO.getAllPersons();
	}
}
