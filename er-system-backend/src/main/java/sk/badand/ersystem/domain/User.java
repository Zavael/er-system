package sk.badand.ersystem.domain;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by abadinka on 27. 6. 2016.
 */
@Entity
public class User {

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

    @OneToMany(mappedBy = "user")
    private List<AssignedUser> assignments = new ArrayList<>();

    @OneToMany(mappedBy = "reviewer")
    private List<ProjectReview> projectReviews = new ArrayList<>();

    @OneToMany(mappedBy = "reviewer")
    private List<UserReview> userReviews = new ArrayList<>();

    @OneToMany(mappedBy = "reviewee")
    private List<UserReview> ownReviews = new ArrayList<>();

    public User(String firstName, String surname, String userName, String password) {
        this.firstName = firstName;
        this.surname = surname;
        this.userName = userName;
        this.password = password;
    }

    public User() {
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

    public List<UserReview> getOwnReviews() {
        return ownReviews;
    }

    public List<UserReview> getUserReviews() {
        return userReviews;
    }

    public String getUserName() {
        return userName;
    }

    public String getPassword() {
        return password;
    }

    public Long getId() {
        return id;
    }
}
