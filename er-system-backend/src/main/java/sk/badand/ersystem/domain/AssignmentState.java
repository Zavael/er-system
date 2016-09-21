package sk.badand.ersystem.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * Created by abadinka on 20. 9. 2016.
 */
@Entity
public class AssignmentState {

    @Id
    @GeneratedValue
    private Long id;
    private String name;
    private String text;
    private String description;

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getText() {
        return text;
    }

    public String getDescription() {
        return description;
    }

    public AssignmentState() {
    }

    public AssignmentState(String name, String text, String description) {
        this.name = name;
        this.text = text;
        this.description = description;
    }
}
