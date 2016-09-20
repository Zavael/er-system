package sk.badand.ersystem.domain;

import sk.badand.ersystem.domain.compositeKeys.ProjectReviewerId;

import javax.persistence.*;

/**
 * Created by abadinka on 20. 9. 2016.
 */
@Entity
@IdClass(ProjectReviewerId.class)
public class AssignedUser {

    @Id
    private Long userId;

    @Id
    private Long projectId;

    @OneToOne(fetch = FetchType.EAGER, optional = false)
    private AssignmentState state;

    private boolean isSupervisor;

    @ManyToOne
    @JoinColumn(name = "userId", insertable = false, updatable = false)
    private User user;

    @ManyToOne
    @JoinColumn(name = "projectId", insertable = false, updatable = false)
    private Project project;
}
