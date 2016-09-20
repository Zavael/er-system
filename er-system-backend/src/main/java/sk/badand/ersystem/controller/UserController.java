package sk.badand.ersystem.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import sk.badand.ersystem.domain.User;
import sk.badand.ersystem.service.UserService;

import javax.servlet.ServletException;

/**
 * Created by abadinka on 20. 9. 2016.
 */
@RestController
@RequestMapping("/users")
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @RequestMapping(method = RequestMethod.POST)
    public User registerUser(User user) throws ServletException {
        try {
            return userService.create(user);
        } catch (ServletException e) {
            throw e;
        }
    }
}
