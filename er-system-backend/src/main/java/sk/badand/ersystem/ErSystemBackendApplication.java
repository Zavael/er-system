package sk.badand.ersystem;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.core.annotation.Order;
import sk.badand.ersystem.filter.JwtFilter;
import sk.badand.ersystem.repository.*;
import sk.badand.ersystem.util.CmdLineRunner;

@SpringBootApplication
public class ErSystemBackendApplication {

    @Bean
    @Order(1)
    public FilterRegistrationBean jwtFilter() {
        final FilterRegistrationBean registrationBean = new FilterRegistrationBean();
        registrationBean.setFilter(new JwtFilter());
        registrationBean.addUrlPatterns("/api/*");
        return registrationBean;
    }

    @Bean
    CommandLineRunner runner(
            PersonRepository er,
            ProjectRepository pr,
            AssignedStateRepository asr,
            ProjectReviewRepository prr,
            AssignmentsRepository ar,
            PersonReviewRepository persrr,
            ProjectReviewOpinionRepository pror,
            PersonReviewOpinionRepository persror) {
        return new CmdLineRunner(er, pr, asr, prr, ar, persrr, pror, persror);
    }

    public static void main(String[] args) {
        SpringApplication.run(ErSystemBackendApplication.class, args);
    }
}
