package sk.badand.ersystem.domain;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

/**
 * Created by abadinka on 27. 6. 2016.
 */
@Entity
@IdClass(ProjectReview.ProjectReviewId.class)
public class ProjectReview {

    @Id
    private long projectId;

    @Id
    private long userId;

    @Column
    private String review;

    @ManyToOne
    @JoinColumn(name = "userId", insertable = false, updatable = false)
    private User user;

    @ManyToOne
    @JoinColumn(name = "projectId", insertable = false, updatable = false)
    private Project project;


    public class ProjectReviewId implements Serializable {
        private long projectId;
        private long userId;

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            ProjectReviewId that = (ProjectReviewId) o;
            return projectId == that.projectId &&
                    userId == that.userId;
        }

        @Override
        public int hashCode() {
            return Objects.hash(projectId, userId);
        }
    }
}
