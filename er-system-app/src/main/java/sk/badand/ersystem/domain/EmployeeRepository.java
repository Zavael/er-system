package sk.badand.ersystem.domain;

import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by abadinka on 28. 6. 2016.
 */
public interface EmployeeRepository extends JpaRepository<Employee, Long> {
}
