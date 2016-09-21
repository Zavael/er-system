package sk.badand.ersystem.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonView;
import sk.badand.ersystem.domain.compositeKeys.ProjectReviewerId;
import sk.badand.ersystem.views.ProjectView;
import sk.badand.ersystem.views.UserView;

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
    private long userId;

    @Column(nullable = false)
    private String review;

    @ManyToOne
    @JoinColumn(name = "userId", insertable = false, updatable = false)
    private User reviewer;

    @ManyToOne
    @JoinColumn(name = "projectId", insertable = false, updatable = false)
    private Project project;

    public ProjectReview() {
    }

    public ProjectReview(long projectId, long userId, String review) {
        this.projectId = projectId;
        this.userId = userId;
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
    public User getReviewer() {
        return reviewer;
    }

    @JsonView(UserView.class)
    public Project getProject() {
        return project;
    }
}
