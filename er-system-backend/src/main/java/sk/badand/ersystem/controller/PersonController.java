package sk.badand.ersystem.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import sk.badand.ersystem.domain.Person;
import sk.badand.ersystem.service.PersonService;

import javax.servlet.ServletException;

/**
 * Created by abadinka on 20. 9. 2016.
 */
@RestController
@RequestMapping("/users")
public class PersonController {

    private final PersonService personService;

    @Autowired
    public PersonController(PersonService personService) {
        this.personService = personService;
    }

    @RequestMapping(method = RequestMethod.POST)
    public Person registerPerson(@RequestBody Person person) throws ServletException {
        try {
            return personService.create(person);
        } catch (ServletException e) {
            throw e;
        }
    }
}
