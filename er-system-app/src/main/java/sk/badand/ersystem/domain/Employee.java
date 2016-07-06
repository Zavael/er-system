package sk.badand.ersystem.domain;

import javax.persistence.*;
import java.util.List;

/**
 * Created by abadinka on 27. 6. 2016.
 */
@Entity
public class Employee {

    @Id
    @GeneratedValue
    private Long id;

    @Column(nullable = false)
    private String firstName;

    @Column(nullable = false)
    private String surname;

//    @ManyToOne(optional = true)
//    private Project project;

    @OneToMany(mappedBy = "employee")
    private List<ProjectReview> projectReviews;

    public Employee(String firstName, String surname) {
        this.firstName = firstName;
        this.surname = surname;
    }

    public Employee() {
    }

    public String getFirstName() {
        return firstName;
    }

    public String getSurname() {
        return surname;
    }

    public List<ProjectReview> getProjectReviews() {
        return projectReviews;
    }
}
