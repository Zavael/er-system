
package sk.badand.ersystem.service;

import org.springframework.stereotype.Service;
import sk.badand.ersystem.domain.User;
import sk.badand.ersystem.repository.UserRepository;

import java.util.Optional;

/**
 * Created by abadinka on 2. 9. 2016.
 */
@Service
public class UserService {
    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public Optional<User> findByUserName(String userName) {
        return userRepository.findByUserName(userName);
    }
}
