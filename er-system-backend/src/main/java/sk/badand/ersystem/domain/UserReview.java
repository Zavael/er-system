package sk.badand.ersystem.domain;

import com.fasterxml.jackson.annotation.JsonBackReference;
import sk.badand.ersystem.domain.compositeKeys.ProjectReviewerId;
import sk.badand.ersystem.domain.compositeKeys.ProjectReviewerRevieweeId;

import javax.persistence.*;

/**
 * Created by abadinka on 20. 9. 2016.
 */
@Entity
@IdClass(ProjectReviewerRevieweeId.class)
public class UserReview {

    @Id
    private long projectId;

    @Id
    private long reviewerId;

    @Id
    private long revieweeId;

    @Column(nullable = false)
    private String review;

    @ManyToOne
    @JoinColumn(name = "reviewerId", insertable = false, updatable = false)
    private User reviewer;

    @ManyToOne
    @JoinColumn(name = "revieweeId", insertable = false, updatable = false)
    private User reviewee;

    @ManyToOne
    @JoinColumn(name = "projectId", insertable = false, updatable = false)
    private Project project;

    public UserReview() {
    }

    public String getReview() {
        return review;
    }

    public User getReviewer() {
        return reviewer;
    }

    public User getReviewee() {
        return reviewee;
    }

    public Project getProject() {
        return project;
    }
}
