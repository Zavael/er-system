package sk.badand.ersystem;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.SecurityProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import sk.badand.ersystem.domain.EmployeeRepository;
import sk.badand.ersystem.domain.ProjectRepository;
import sk.badand.ersystem.mock.CmdLineRunner;

@SpringBootApplication
public class ErSystemApplication {

    public static void main(String[] args) {
        SpringApplication.run(ErSystemApplication.class, args);
    }

    @Bean
    CommandLineRunner runner(EmployeeRepository er, ProjectRepository pr) {
        return new CmdLineRunner(er, pr);
    }

    @Configuration
    @Order(SecurityProperties.ACCESS_OVERRIDE_ORDER)
    protected static class SecurityConfiguration extends WebSecurityConfigurerAdapter {

        @Override
        protected void configure(HttpSecurity http) throws Exception {
/*
            http.httpBasic()
                    .and().authorizeRequests()
                    .antMatchers("/index.html", "/home.html", "/login.html", "/")
                    .permitAll()
                    .anyRequest().authenticated();
*/
        }
    }
}
