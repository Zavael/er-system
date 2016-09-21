package sk.badand.ersystem.domain;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonView;
import sk.badand.ersystem.domain.compositeKeys.ProjectReviewerId;
import sk.badand.ersystem.views.ProjectView;
import sk.badand.ersystem.views.UserView;

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

    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    private AssignmentState state;

    private boolean isSupervisor;
    private String position;

    @ManyToOne
    @JoinColumn(name = "userId", insertable = false, updatable = false)
    private User user;

    @ManyToOne
    @JoinColumn(name = "projectId", insertable = false, updatable = false)
    private Project project;

    public AssignedUser() {
    }

    public AssignedUser(Long userId, Long projectId, AssignmentState state, boolean isSupervisor, String position) {
        this.userId = userId;
        this.projectId = projectId;
        this.state = state;
        this.isSupervisor = isSupervisor;
        this.position = position;
    }

    public AssignmentState getState() {
        return state;
    }

    public boolean isSupervisor() {
        return isSupervisor;
    }

    public String getPosition() {
        return position;
    }

    @JsonView(ProjectView.class)
    public User getUser() {
        return user;
    }

    @JsonView(UserView.class)
    public Project getProject() {
        return project;
    }
}
