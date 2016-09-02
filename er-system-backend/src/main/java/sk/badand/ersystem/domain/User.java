package sk.badand.ersystem.domain;

import javax.persistence.*;
import java.util.List;
import java.util.Set;

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
    private Set<ProjectTeam> projectTeams;

    @OneToMany(mappedBy = "user")
    private List<ProjectReview> projectReviews;

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

    public String getUserName() {
        return userName;
    }

    public String getPassword() {
        return password;
    }
}
