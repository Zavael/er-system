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

    @Column(nullable = true)
    private String description;

    @Column(nullable = true)
    private Date started;

    @Column(nullable = true)
    private Date finished;

    @OneToMany(mappedBy = "project", fetch = FetchType.LAZY)
    private List<ProjectReview> projectReviews = new ArrayList<>();

    @OneToMany(mappedBy = "project", fetch = FetchType.LAZY)
    private List<AssignedUser> assignedUsers = new ArrayList<>();

    @OneToMany(mappedBy = "project", fetch = FetchType.LAZY)
    private List<UserReview> userReviews = new ArrayList<>();

    public Project(String name) {
        this.name = name;
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

    public List<AssignedUser> getAssignedUsers() {
        return assignedUsers;
    }
}
