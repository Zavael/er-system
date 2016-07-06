package sk.badand.ersystem;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
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
}
