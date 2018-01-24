package sk.badand.ersystem.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import sk.badand.ersystem.domain.Person;

import java.util.List;

/**
 * Created by abadinka on 2. 9. 2016.
 */
@Repository
public interface PersonRepository extends JpaRepository<Person, Long> {
    List<Person> findByUserName(String userName);

    //TODO: repositories are visible without auth!
}
