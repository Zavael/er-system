package sk.badand.ersystem.util;

import org.springframework.boot.CommandLineRunner;
import sk.badand.ersystem.domain.*;
import sk.badand.ersystem.repository.*;

import java.time.Duration;
import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.Arrays;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.stream.Stream;

/**
 * Created by abadinka on 29. 6. 2016.
 */
public class CmdLineRunner implements CommandLineRunner {
    final StringGenerator stringGenerator = new StringGenerator();
    private final PersonRepository ur;
    private final ProjectRepository pr;
    private final AssignedStateRepository asr;
    private final ProjectReviewRepository prr;
    private final AssignmentsRepository ar;
    private final PersonReviewRepository persrr;
    private final ProjectReviewOpinionRepository pror;
    private final PersonReviewOpinionRepository persror;

    public CmdLineRunner(PersonRepository ur, ProjectRepository pr, AssignedStateRepository asr, ProjectReviewRepository prr, AssignmentsRepository ar, PersonReviewRepository persrr, ProjectReviewOpinionRepository pror, PersonReviewOpinionRepository persror) {
        this.ur = ur;
        this.pr = pr;
        this.asr = asr;
        this.prr = prr;
        this.ar = ar;
        this.persrr = persrr;
        this.pror = pror;
        this.persror = persror;
    }

    @Override
    public void run(String... strings) throws Exception {

        persistStates();

        final List<Person> persons = persistPersons();

        final List<Project> projects = persistProjects();

        for (Project project : projects) {
            addAsignments(project, persons);
            addReviews(project, persons);
            addPersReviews(project, persons);
            pr.save(project);
        }
    }

    private List<Project> persistProjects() {
        Arrays.asList("DMS,MOSR,SK-CRIS,Orange Výhody,SOA-ORGA".split(","))
                .forEach(name -> {
                    Project project = new Project(
                            name,
                            stringGenerator.generateParagraph(30),
                            Date.from(Instant.now().minus(15, ChronoUnit.DAYS)),
                            Date.from(Instant.now().plus(Duration.ofDays(60))));
                    project = pr.save(project);
                });
        return pr.findAll();
    }

    private List<Person> persistPersons() {
        Arrays.asList("Peter,Matthew,Johny,Sergey,Dmitry,Kostya,Kabir,Priyansh,Sahil".split(","))
                .forEach(name -> ur.save(new Person(name, "Smith", name.toLowerCase() + "_s", name.toLowerCase() + "_s")));
        return ur.findAll();
    }

    private List<String> persistStates() {
        final List<String> states = Arrays.asList("ACTIVE,INACTIVE".split(","));
        states.forEach(name -> asr.save(new AssignmentState(name, name, "Description of " + name + " state.")));
        return states;
    }

    private void addAsignments(Project project, List<Person> persons) {

        int max = new Randomizer().nextRandomInt(2, 8);
        for (int i = 0; i < max; i++) {
            ar.save(new AssignedPerson(
                    persons.stream().findAny().get().getId(),
                    project.getId(),
                    asr.getOne(1L), true,
                    i < 1 ? "Manager" : i < 3 ? "Analist" : "Developer"));
        }
    }

    private void addReviews(Project project, List<Person> persons) {

        int max = new Randomizer().nextRandomInt(2, 8);
        for (int i = 0; i < max; i++) {
            Collections.shuffle(persons);
            final Long revieweeId = persons.get(0).getId();
            final ProjectReview projectReview = prr.save(new ProjectReview(project.getId(), revieweeId, stringGenerator.generateParagraph(30)));
            addOpinions(projectReview, persons, project.getId(), revieweeId);
        }
    }

    private void addPersReviews(Project project, List<Person> persons) {

        int max = new Randomizer().nextRandomInt(2, 8);
        for (int i = 0; i < max; i++) {
            Collections.shuffle(persons);
            final Long reviewerId = persons.get(0).getId();
            final Long revieweeId = persons.get(persons.size()-1).getId();
            final PersonReview personReview = persrr.save(new PersonReview(project.getId(), reviewerId, revieweeId, stringGenerator.generateParagraph(30)));
            addOpinions(personReview, persons, revieweeId, reviewerId, project.getId());
        }
    }

    private void addOpinions(ProjectReview projectReview, List<Person> persons, long projectId, long reviewerId) {

        int max = new Randomizer().nextRandomInt(2, 8);
        for (int i = 0; i < max; i++) {
            Collections.shuffle(persons);
            final Long personId = persons.get(0).getId();
            pror.save(new ProjectReviewOpinion(personId, i % 2 == 0, projectId, reviewerId));
        }
    }

    private void addOpinions(PersonReview personReview, List<Person> persons, long revieweeId, long reviewerId, long projectId) {

        int max = new Randomizer().nextRandomInt(2, 8);
        for (int i = 0; i < max; i++) {
            Collections.shuffle(persons);
            final Long personId = persons.get(0).getId();
            persror.save(new PersonReviewOpinion(projectId, reviewerId, revieweeId, personId, i % 2 == 0));
        }
    }
}
