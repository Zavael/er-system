package sk.badand.ersystem.domain;

import sk.badand.ersystem.domain.compositeKeys.ProjectReviewerOpinionistId;

import javax.persistence.*;

/**
 * Created by abadinka on 23. 9. 2016.
 */
@Entity
@IdClass(ProjectReviewerOpinionistId.class)
public class ProjectReviewOpinion {

    @Id
    private long projectId;

    @Id
    private long reviewerId;

    @Id
    private long opinionistId;

    @Column(nullable = false)
    private boolean agreement;

    @ManyToOne
    @JoinColumns({
            @JoinColumn(name = "projectId", insertable = false, updatable = false),
            @JoinColumn(name = "reviewerId", insertable = false, updatable = false)
    })
    private ProjectReview projectReview;

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
