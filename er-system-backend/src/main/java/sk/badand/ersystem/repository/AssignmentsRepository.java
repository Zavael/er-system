package sk.badand.ersystem.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import sk.badand.ersystem.domain.AssignedPerson;
import sk.badand.ersystem.domain.compositeKeys.ProjectReviewerId;

/**
 * Created by abadinka on 21. 9. 2016.
 */
public interface AssignmentsRepository extends JpaRepository<AssignedPerson, ProjectReviewerId> {
}
