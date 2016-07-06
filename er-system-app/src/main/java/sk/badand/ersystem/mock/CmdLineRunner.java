package sk.badand.ersystem.mock;

import org.springframework.boot.CommandLineRunner;
import sk.badand.ersystem.domain.Employee;
import sk.badand.ersystem.domain.EmployeeRepository;
import sk.badand.ersystem.domain.Project;
import sk.badand.ersystem.domain.ProjectRepository;

import java.util.Arrays;

/**
 * Created by abadinka on 29. 6. 2016.
 */
public class CmdLineRunner implements CommandLineRunner {
    private final EmployeeRepository er;
    private final ProjectRepository pr;

    public CmdLineRunner(EmployeeRepository er, ProjectRepository pr) {
        this.er = er;
        this.pr = pr;
    }

    @Override
    public void run(String... strings) throws Exception {
        Arrays.asList("Peter,Martin,John,Robert,Will".split(","))
                .forEach(name -> er.save(new Employee(name, name)));

        Arrays.asList("DMS,MOSR,SK-CRIS".split(","))
                .forEach(name -> pr.save(new Project(name)));
    }
}
