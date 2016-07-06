package sk.badand.ersystem.domain;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;

/**
 * Created by abadinka on 28. 6. 2016.
 */
@RepositoryRestResource
public interface EmployeeRepository extends JpaRepository<Employee, Long> {
}
