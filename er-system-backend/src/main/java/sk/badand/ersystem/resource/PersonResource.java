package sk.badand.ersystem.resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import sk.badand.ersystem.domain.Person;
import sk.badand.ersystem.service.PersonService;

import javax.servlet.ServletException;

/**
 * Created by abadinka on 22. 9. 2016.
 */
@RestController
@RequestMapping("/api/users")
public class PersonResource {

    private final PersonService personService;

    @Autowired
    public PersonResource(PersonService personService) {
        this.personService = personService;
    }

    @RequestMapping(path = "/{id}", method = RequestMethod.GET)
    public Person findPerson(@PathVariable Long id) throws ServletException {
        if (id == null){
            throw new ServletException("Wrong arguments provided");
        }
        return personService.findPerson(id);
    }
}
