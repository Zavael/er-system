
package sk.badand.ersystem.service;

import org.springframework.stereotype.Service;
import sk.badand.ersystem.domain.Person;
import sk.badand.ersystem.repository.PersonRepository;

import javax.servlet.ServletException;
import java.util.List;

/**
 * Created by abadinka on 2. 9. 2016.
 */
@Service
public class PersonService {
    private final PersonRepository personRepository;

    public PersonService(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    public List<Person> findByUserName(String userName) {
        return personRepository.findByUserName(userName);
    }

    public Person create(Person person) throws ServletException {
        if (!personRepository.findByUserName(person.getUserName()).isEmpty()) {
            throw new ServletException("Person already present! " + person.getUserName());
        }
        return personRepository.save(person);
    }

    public Person findPerson(long id) {
        return personRepository.findOne(id);
    }
}
