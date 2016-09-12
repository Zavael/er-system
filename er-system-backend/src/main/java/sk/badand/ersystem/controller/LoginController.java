package sk.badand.ersystem.controller;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import sk.badand.ersystem.service.UserService;

import javax.servlet.ServletException;
import java.time.Instant;
import java.util.Date;
import java.util.Map;

/**
 * Created by abadinka on 2. 9. 2016.
 */
@RestController
@RequestMapping("/login")
public class LoginController {

    private static final int SECONDS_TO_EXPIRE_TOKEN = 30 * 60;
    private final UserService userService;

    @Autowired
    public LoginController(UserService userService) {
        this.userService = userService;
    }

    @RequestMapping(method = RequestMethod.POST)
    public String loginUser(@RequestBody Map<String, String> credentials) throws ServletException {
        final String userName = credentials.get("userName");
        final String password = credentials.get("password");

        if (userName == null || password == null) {
            throw new ServletException("Missing credentials");
        }

        this.userService.findByUserName(userName)
                .filter(user -> password.equals(user.getPassword()))
                .orElseThrow(() -> new ServletException("Invalid login. Please check your userName and password."));


        final Instant issuedAt = Instant.now();
        return Jwts.builder()
                .setSubject(userName).claim("roles", "user")
                .setIssuedAt(Date.from(issuedAt))
                .setExpiration(Date.from(issuedAt.plusSeconds(SECONDS_TO_EXPIRE_TOKEN)))
                .signWith(SignatureAlgorithm.HS256, "secretKey")
                .compact();
    }
}
