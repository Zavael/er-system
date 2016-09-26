package sk.badand.ersystem.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import sk.badand.ersystem.domain.PersonReview;
import sk.badand.ersystem.domain.compositeKeys.ProjectReviewerRevieweeId;

/**
 * Created by abadinka on 23. 9. 2016.
 */
public interface PersonReviewRepository extends JpaRepository<PersonReview, ProjectReviewerRevieweeId> {
}
