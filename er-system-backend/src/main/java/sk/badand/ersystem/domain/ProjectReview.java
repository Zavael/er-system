package sk.badand.ersystem.domain;

import com.fasterxml.jackson.annotation.JsonView;
import sk.badand.ersystem.domain.compositeKeys.ProjectReviewerId;
import sk.badand.ersystem.views.ProjectView;
import sk.badand.ersystem.views.PersonView;

import javax.persistence.*;

/**
 * Created by abadinka on 27. 6. 2016.
 */
@Entity
@IdClass(ProjectReviewerId.class)
public class ProjectReview {

    @Id
    private long projectId;

    @Id
    private long personId;

    @Column(nullable = false, length = 2048)
    private String review;

    @ManyToOne
    @JoinColumn(name = "personId", insertable = false, updatable = false)
    private Person reviewer;

    @ManyToOne
    @JoinColumn(name = "projectId", insertable = false, updatable = false)
    private Project project;

    public ProjectReview() {
    }

    public ProjectReview(long projectId, long personId, String review) {
        this.projectId = projectId;
        this.personId = personId;
        this.review = review;
    }

    public boolean hasProject() {
        return project != null;
    }

    public boolean isReviewOf(long projectId) {
        return project != null && project.getId().equals(projectId);
    }

    public boolean hasReviewer() {
        return reviewer != null;
    }

    public String getReview() {
        return review;
    }

    @JsonView(ProjectView.class)
    public Person getReviewer() {
        return reviewer;
    }

    @JsonView(PersonView.class)
    public Project getProject() {
        return project;
    }
}
