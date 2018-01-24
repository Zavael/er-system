package sk.badand.ersystem.domain;

import com.fasterxml.jackson.annotation.JsonView;
import sk.badand.ersystem.domain.compositeKeys.ProjectPersonId;
import sk.badand.ersystem.domain.compositeKeys.ProjectReviewerId;
import sk.badand.ersystem.views.ProjectView;
import sk.badand.ersystem.views.PersonView;

import javax.persistence.*;

/**
 * Created by abadinka on 20. 9. 2016.
 */
@Entity
@IdClass(ProjectPersonId.class)
public class AssignedPerson {

    @Id
    private Long personId;

    @Id
    private Long projectId;

    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    private AssignmentState state;

    private boolean isSupervisor;
    private String position;

    @ManyToOne
    @JoinColumn(name = "personId", insertable = false, updatable = false)
    private Person person;

    @ManyToOne
    @JoinColumn(name = "projectId", insertable = false, updatable = false)
    private Project project;

    public AssignedPerson() {
    }

    public AssignedPerson(Long personId, Long projectId, AssignmentState state, boolean isSupervisor, String position) {
        this.personId = personId;
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
    public Person getPerson() {
        return person;
    }

    @JsonView(PersonView.class)
    public Project getProject() {
        return project;
    }
}
