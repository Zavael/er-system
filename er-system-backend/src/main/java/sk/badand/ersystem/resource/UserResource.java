package sk.badand.ersystem.resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import sk.badand.ersystem.domain.User;
import sk.badand.ersystem.service.UserService;

import javax.servlet.ServletException;

/**
 * Created by abadinka on 22. 9. 2016.
 */
@RestController
@RequestMapping("/api/users")
public class UserResource {

    private final UserService userService;

    @Autowired
    public UserResource(UserService userService) {
        this.userService = userService;
    }

    @RequestMapping(path = "/{userId}", method = RequestMethod.GET)
    public User findUser(@PathVariable Long userId) throws ServletException {
        if (userId == null){
            throw new ServletException("Wrong arguments provided");
        }
        return userService.findUser(userId);
    }
}
