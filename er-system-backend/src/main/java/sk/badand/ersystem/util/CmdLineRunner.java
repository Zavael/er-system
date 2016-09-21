package sk.badand.ersystem.util;

import org.springframework.boot.CommandLineRunner;
import sk.badand.ersystem.domain.*;
import sk.badand.ersystem.repository.*;

import java.util.Arrays;

/**
 * Created by abadinka on 29. 6. 2016.
 */
public class CmdLineRunner implements CommandLineRunner {
    private final UserRepository ur;
    private final ProjectRepository pr;
    private final AssignedStateRepository asr;
    private final ProjectReviewRepository prr;
    private final AssignmentsRepository ar;

    public CmdLineRunner(UserRepository ur, ProjectRepository pr, AssignedStateRepository asr, ProjectReviewRepository prr, AssignmentsRepository ar) {
        this.ur = ur;
        this.pr = pr;
        this.asr = asr;
        this.prr = prr;
        this.ar = ar;
    }

    @Override
    public void run(String... strings) throws Exception {
        Arrays.asList("ACTIVE,INACTIVE".split(","))
                .forEach(name -> asr.save(new AssignmentState(name, name, "Description of " + name + " state.")));

        Arrays.asList("Peter,Martin,John,Robert,George".split(","))
                .forEach(name -> ur.save(new User(name, "Smith", name.toLowerCase() + "_s", name.toLowerCase() + "_s")));

        Arrays.asList("DMS,MOSR,SK-CRIS,Orange Výhody,SOA-ORGA".split(","))
                .forEach(name -> {
                    Project project = new Project(name);
                    project = pr.save(project);

                    addReviews(project, prr);

                    addAsignments(project, ar);

                    pr.save(project);
                });
    }

    private void addAsignments(Project project, AssignmentsRepository ar) {
        project.getAssignedUsers().add(
                ar.save(new AssignedUser(1L, project.getId(), asr.getOne(1L), true, "Manager"))
        );
        project.getAssignedUsers().add(
                ar.save(new AssignedUser(2L, project.getId(), asr.getOne(2L), false, "Analyst"))
        );
        project.getAssignedUsers().add(
                ar.save(new AssignedUser(3L, project.getId(), asr.getOne(1L), false, "Developer"))
        );
    }

    private void addReviews(Project project, ProjectReviewRepository prr) {
        project.getProjectReviews().add(
                prr.save(new ProjectReview(project.getId(), 2L, "My super review!"))
        );
        project.getProjectReviews().add(
                prr.save(new ProjectReview(project.getId(), 3L, "Totally bad!"))
        );
    }
}
