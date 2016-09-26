package sk.badand.ersystem.domain;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by abadinka on 27. 6. 2016.
 */
@Entity
public class Project {
    @Id
    @GeneratedValue
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = true, length = 2048)
    private String description;

    @Column(nullable = true)
    private Date started;

    @Column(nullable = true)
    private Date finished;

    @OneToMany(mappedBy = "project", fetch = FetchType.LAZY)
    private List<ProjectReview> projectReviews = new ArrayList<>();

    @OneToMany(mappedBy = "project", fetch = FetchType.LAZY)
    private List<AssignedPerson> assignedPersons = new ArrayList<>();

    @OneToMany(mappedBy = "project", fetch = FetchType.LAZY)
    private List<PersonReview> personReviews = new ArrayList<>();

    public Project(String name, String description, Date started, Date finished) {
        this.name = name;
        this.description = description;
        this.started = started;
        this.finished = finished;
    }

    public Project() {
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public Date getStarted() {
        return started;
    }

    public Date getFinished() {
        return finished;
    }

    public List<ProjectReview> getProjectReviews() {
        return projectReviews;
    }

    public List<AssignedPerson> getAssignedPersons() {
        assignedPersons.sort((o1, o2) -> {
            return -o1.getPosition().compareTo(o2.getPosition());
        });
        return assignedPersons;
    }
}
