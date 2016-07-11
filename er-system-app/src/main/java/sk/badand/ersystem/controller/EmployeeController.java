package sk.badand.ersystem.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import sk.badand.ersystem.domain.EmployeeRepository;

import javax.inject.Inject;
import java.security.Principal;

/**
 * Created by abadinka on 28. 6. 2016.
 */
@RestController
public final class EmployeeController {

    @RequestMapping("/user")
    public Principal user(Principal user){
        return user;
    }

    private final EmployeeRepository employeeRepository;

    @Inject
    public EmployeeController(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }
}
