package sk.badand.ersystem.domain;

import com.fasterxml.jackson.annotation.JsonView;
import sk.badand.ersystem.domain.compositeKeys.ProjectReviewerRevieweeId;
import sk.badand.ersystem.views.PersonView;

import javax.persistence.*;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by abadinka on 20. 9. 2016.
 */
@Entity
@IdClass(ProjectReviewerRevieweeId.class)
public class PersonReview {

    @Id
    private long projectId;

    @Id
    private long reviewerId;

    @Id
    private long revieweeId;

    @Column(nullable = false, length = 2048)
    private String review;

    @ManyToOne
    @JoinColumn(name = "reviewerId", insertable = false, updatable = false)
    private Person reviewer;

    @ManyToOne
    @JoinColumn(name = "revieweeId", insertable = false, updatable = false)
    private Person reviewee;

    @ManyToOne
    @JoinColumn(name = "projectId", insertable = false, updatable = false)
    private Project project;

    @OneToMany(mappedBy = "personReview")
    private List<PersonReviewOpinion> opinions;

    public PersonReview() {
    }

    public String getReview() {
        return review;
    }

    @JsonView(ProjectReview.class)
    public Person getReviewer() {
        return reviewer;
    }

    @JsonView(ProjectReview.class)
    public Person getReviewee() {
        return reviewee;
    }

    @JsonView(PersonView.class)
    public Project getProject() {
        return project;
    }

    public List<PersonReviewOpinion> getAgreements() {
        return opinions.stream()
                .filter(opinion -> opinion.isAgreement())
                .collect(Collectors.toList());
    }

    public List<PersonReviewOpinion> getDisagreements() {
        return opinions.stream()
                .filter(opinion -> !opinion.isAgreement())
                .collect(Collectors.toList());
    }
}
