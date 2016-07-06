package sk.badand.ersystem.domain;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

/**
 * Created by abadinka on 28. 6. 2016.
 */
@RepositoryRestResource
public interface ProjectRepository extends JpaRepository<Project, Long> {
}
