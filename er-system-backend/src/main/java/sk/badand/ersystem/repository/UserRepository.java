package sk.badand.ersystem.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import sk.badand.ersystem.domain.User;

import java.util.Optional;

/**
 * Created by abadinka on 2. 9. 2016.
 */
@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByUserName(String userName);

    //TODO: repositories are visible without auth!
}
