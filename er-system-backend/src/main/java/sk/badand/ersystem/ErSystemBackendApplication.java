package sk.badand.ersystem;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import sk.badand.ersystem.filter.JwtFilter;
import sk.badand.ersystem.repository.*;
import sk.badand.ersystem.util.CmdLineRunner;

@SpringBootApplication
public class ErSystemBackendApplication {

    @Bean
    public FilterRegistrationBean jwtFilter() {
        final FilterRegistrationBean registrationBean = new FilterRegistrationBean();
        registrationBean.setFilter(new JwtFilter());
        registrationBean.addUrlPatterns("/api/*");

        return registrationBean;
    }

    CommandLineRunner runner(UserRepository er, ProjectRepository pr, AssignedStateRepository asr, ProjectReviewRepository prr, AssignmentsRepository ar) {
        return new CmdLineRunner(er, pr, asr, prr, ar);
    }

    public static void main(String[] args) {
        SpringApplication.run(ErSystemBackendApplication.class, args);
    }
}
