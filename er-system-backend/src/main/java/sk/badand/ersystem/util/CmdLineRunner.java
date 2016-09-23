package sk.badand.ersystem.util;

import org.springframework.boot.CommandLineRunner;
import sk.badand.ersystem.domain.*;
import sk.badand.ersystem.repository.*;

import java.time.Duration;
import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.Arrays;
import java.util.Date;

/**
 * Created by abadinka on 29. 6. 2016.
 */
public class CmdLineRunner implements CommandLineRunner {
    private final PersonRepository ur;
    private final ProjectRepository pr;
    private final AssignedStateRepository asr;
    private final ProjectReviewRepository prr;
    private final AssignmentsRepository ar;

    public CmdLineRunner(PersonRepository ur, ProjectRepository pr, AssignedStateRepository asr, ProjectReviewRepository prr, AssignmentsRepository ar) {
        this.ur = ur;
        this.pr = pr;
        this.asr = asr;
        this.prr = prr;
        this.ar = ar;
    }

    @Override
    public void run(String... strings) throws Exception {
        final StringGenerator stringGenerator = new StringGenerator();

        Arrays.asList("ACTIVE,INACTIVE".split(","))
                .forEach(name -> asr.save(new AssignmentState(name, name, "Description of " + name + " state.")));

        Arrays.asList("Peter,Martin,John,Robert,George".split(","))
                .forEach(name -> ur.save(new Person(name, "Smith", name.toLowerCase() + "_s", name.toLowerCase() + "_s")));

        Arrays.asList("DMS,MOSR,SK-CRIS,Orange Výhody,SOA-ORGA".split(","))
                .forEach(name -> {
                    Project project = new Project(
                            name,
                            stringGenerator.generateParagraph(30),
                            Date.from(Instant.now().minus(15, ChronoUnit.DAYS)),
                            Date.from(Instant.now().plus(Duration.ofDays(60))));
                    project = pr.save(project);

                    addReviews(project, prr, stringGenerator);

                    addAsignments(project, ar);

                    pr.save(project);
                });
    }

    private void addAsignments(Project project, AssignmentsRepository ar) {
        project.getAssignedPersons().add(
                ar.save(new AssignedPerson(1L, project.getId(), asr.getOne(1L), true, "Manager"))
        );
        project.getAssignedPersons().add(
                ar.save(new AssignedPerson(2L, project.getId(), asr.getOne(2L), false, "Analyst"))
        );
        project.getAssignedPersons().add(
                ar.save(new AssignedPerson(3L, project.getId(), asr.getOne(1L), false, "Developer"))
        );
    }

    private void addReviews(Project project, ProjectReviewRepository prr, StringGenerator stringGenerator) {
        project.getProjectReviews().add(
                prr.save(new ProjectReview(project.getId(), 2L, stringGenerator.generateParagraph(30)))
        );
        project.getProjectReviews().add(
                prr.save(new ProjectReview(project.getId(), 3L, stringGenerator.generateParagraph(30)))
        );
    }
}
