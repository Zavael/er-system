
package sk.badand.ersystem.service;

import org.springframework.stereotype.Service;
import sk.badand.ersystem.domain.User;
import sk.badand.ersystem.repository.UserRepository;

import javax.servlet.ServletException;
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

    public User create(User user) throws ServletException {
        if (userRepository.findByUserName(user.getUserName()).isPresent()) {
            throw new ServletException("User already present! " + user.getUserName());
        }
        return userRepository.save(user);
    }

    public User findUser(long userId) {
        return userRepository.findOne(userId);
    }
}
