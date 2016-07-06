package sk.badand.ersystem.domain;

import javax.persistence.*;
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

    @OneToMany(mappedBy = "projectId")
    private List<ProjectReview> projectReviews;

    public Project(String name) {
        this.name = name;
    }

    public Project() {
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
}
