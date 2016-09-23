package sk.badand.ersystem.domain;

import sk.badand.ersystem.domain.compositeKeys.ProjectReviewerOpinionistId;
import sk.badand.ersystem.domain.compositeKeys.ProjectReviewerRevieweeOpinionistId;

import javax.persistence.*;

/**
 * Created by abadinka on 23. 9. 2016.
 */
@Entity
@IdClass(ProjectReviewerRevieweeOpinionistId.class)
public class PersonReviewOpinion {

    @Id
    private long projectId;

    @Id
    private long reviewerId;

    @Id
    private long revieweeId;

    @Id
    private long opinionistId;

    @Column(nullable = false)
    private boolean agreement;

    @ManyToOne
    @JoinColumns({
            @JoinColumn(name = "projectId", insertable = false, updatable = false),
            @JoinColumn(name = "reviewerId", insertable = false, updatable = false),
            @JoinColumn(name = "revieweeId", insertable = false, updatable = false),
    })
    private PersonReview personReview;

    @ManyToOne
    @JoinColumn(name = "opinionistId", insertable = false, updatable = false)
    private Person opinionist;

    public long getOpinionistId() {
        return opinionistId;
    }

    public boolean isAgreement() {
        return agreement;
    }
}
