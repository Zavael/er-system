package sk.badand.ersystem.util;

import org.springframework.boot.CommandLineRunner;
import sk.badand.ersystem.domain.Project;
import sk.badand.ersystem.domain.User;
import sk.badand.ersystem.repository.ProjectRepository;
import sk.badand.ersystem.repository.UserRepository;

import java.util.Arrays;

/**
 * Created by abadinka on 29. 6. 2016.
 */
public class CmdLineRunner implements CommandLineRunner {
    private final UserRepository ur;
    private final ProjectRepository pr;

    public CmdLineRunner(UserRepository ur, ProjectRepository pr) {
        this.ur = ur;
        this.pr = pr;
    }

    @Override
    public void run(String... strings) throws Exception {
        Arrays.asList("Peter,Martin,John,Robert,George".split(","))
                .forEach(name -> ur.save(new User(name, "Smith", name.toLowerCase() + "_s", name.toLowerCase() + "_s")));

        Arrays.asList("DMS,MOSR,SK-CRIS,Orange Výhody,SOA-ORGA".split(","))
                .forEach(name -> pr.save(new Project(name)));
    }
}
