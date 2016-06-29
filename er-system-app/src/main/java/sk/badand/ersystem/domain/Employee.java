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

//    @ManyToOne(optional = false)
//    private Project project;

    @OneToMany(mappedBy = "employee")
    private List<ProjectReview> projectReviews;
}
