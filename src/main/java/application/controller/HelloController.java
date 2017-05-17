package application.controller;

import java.util.List;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;

import application.domain.Person;
import application.service.PersonService;

@RestController
public class HelloController {
	PersonService personService = new PersonService();

    @RequestMapping("/")
    public List<Person> index() {
    	return personService.getPersons();
    }

}