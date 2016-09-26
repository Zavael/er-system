package sk.badand.ersystem.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import sk.badand.ersystem.domain.ProjectReviewOpinion;
import sk.badand.ersystem.domain.compositeKeys.ProjectReviewerOpinionistId;

/**
 * Created by abadinka on 23. 9. 2016.
 */
public interface ProjectReviewOpinionRepository extends JpaRepository<ProjectReviewOpinion, ProjectReviewerOpinionistId> {
}
