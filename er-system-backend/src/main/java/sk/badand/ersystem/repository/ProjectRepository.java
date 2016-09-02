package sk.badand.ersystem.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import sk.badand.ersystem.domain.Project;

/**
 * Created by abadinka on 2. 9. 2016.
 */
public interface ProjectRepository extends JpaRepository<Project, Long> {
}
