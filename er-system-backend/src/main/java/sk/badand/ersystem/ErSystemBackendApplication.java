package sk.badand.ersystem;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import sk.badand.ersystem.filter.JwtFilter;
import sk.badand.ersystem.repository.ProjectRepository;
import sk.badand.ersystem.repository.UserRepository;
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

    @Bean
    CommandLineRunner runner(UserRepository er, ProjectRepository pr) {
        return new CmdLineRunner(er, pr);
    }

    public static void main(String[] args) {
        SpringApplication.run(ErSystemBackendApplication.class, args);
    }
}
