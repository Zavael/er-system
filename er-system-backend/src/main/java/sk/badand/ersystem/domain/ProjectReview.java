package sk.badand.ersystem.domain;

import com.fasterxml.jackson.annotation.JsonView;
import sk.badand.ersystem.domain.compositeKeys.ProjectReviewerId;
import sk.badand.ersystem.views.PersonView;
import sk.badand.ersystem.views.ProjectView;

import javax.persistence.*;
import java.util.List;
import java.util.stream.Collectors;

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

    @OneToMany(mappedBy = "projectReview")
    private List<ProjectReviewOpinion> opinions;

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

    public List<ProjectReviewOpinion> getAgreements() {
        return opinions.stream()
                .filter(opinion -> opinion.isAgreement())
                .collect(Collectors.toList());
    }

    public List<ProjectReviewOpinion> getDisagreements() {
        return opinions.stream()
                .filter(opinion -> !opinion.isAgreement())
                .collect(Collectors.toList());
    }
}
