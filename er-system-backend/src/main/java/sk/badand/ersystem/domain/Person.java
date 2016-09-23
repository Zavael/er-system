package sk.badand.ersystem.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonView;
import sk.badand.ersystem.views.PersonView;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by abadinka on 27. 6. 2016.
 */
@Entity
public class Person {

    @Id
    @GeneratedValue
    private Long id;

    @Column(nullable = false)
    private String firstName;

    @Column(nullable = false)
    private String surname;

    @Column(nullable = false)
    private String userName;

    @Column(nullable = false)
    private String password;

    @OneToMany(mappedBy = "person")
    private List<AssignedPerson> assignments = new ArrayList<>();

    @OneToMany(mappedBy = "reviewer")
    private List<ProjectReview> projectReviews = new ArrayList<>();

    @OneToMany(mappedBy = "reviewer")
    private List<PersonReview> personReviews = new ArrayList<>();

    @OneToMany(mappedBy = "reviewee")
    private List<PersonReview> ownReviews = new ArrayList<>();

    public Person(String firstName, String surname, String userName, String password) {
        this.firstName = firstName;
        this.surname = surname;
        this.userName = userName;
        this.password = password;
    }

    public Person() {
    }

    public String getFirstName() {
        return firstName;
    }

    public String getSurname() {
        return surname;
    }

    @JsonView(PersonView.class)
    public List<ProjectReview> getProjectReviews() {
        return projectReviews;
    }

    @JsonView(PersonView.class)
    public List<PersonReview> getOwnReviews() {
        return ownReviews;
    }

    @JsonView(PersonView.class)
    public List<PersonReview> getPersonReviews() {
        return personReviews;
    }

    public String getUserName() {
        return userName;
    }

    @JsonIgnore
    public String getPassword() {
        return password;
    }

    public Long getId() {
        return id;
    }
}
