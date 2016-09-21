package sk.badand.ersystem.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import sk.badand.ersystem.domain.ProjectReview;
import sk.badand.ersystem.domain.compositeKeys.ProjectReviewerId;

/**
 * Created by abadinka on 21. 9. 2016.
 */
@Repository
public interface ProjectReviewRepository extends JpaRepository<ProjectReview, ProjectReviewerId> {
}
