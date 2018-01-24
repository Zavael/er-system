package sk.badand.ersystem.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import sk.badand.ersystem.domain.PersonReviewOpinion;
import sk.badand.ersystem.domain.compositeKeys.ProjectReviewerRevieweeOpinionistId;

/**
 * Created by abadinka on 23. 9. 2016.
 */
public interface PersonReviewOpinionRepository extends JpaRepository<PersonReviewOpinion, ProjectReviewerRevieweeOpinionistId> {
}
