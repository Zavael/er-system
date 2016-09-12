package sk.badand.ersystem.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import sk.badand.ersystem.domain.Project;

import java.util.List;

/**
 * Created by abadinka on 2. 9. 2016.
 */
@Repository
public interface ProjectRepository extends JpaRepository<Project, Long> {

}
