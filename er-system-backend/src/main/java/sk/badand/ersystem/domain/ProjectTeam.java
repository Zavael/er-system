package sk.badand.ersystem.domain;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

/**
 * Created by abadinka on 8. 8. 2016.
 */
@Entity
@IdClass(ProjectTeam.ProjectTeamId.class)
public class ProjectTeam {

    @Id
    private long projectId;

    @Id
    private long userId;

    @ManyToOne
    @JoinColumn(name = "userId", insertable = false, updatable = false)
    private User user;

    @ManyToOne
    @JoinColumn(name = "projectId", insertable = false, updatable = false)
    private Project project;

    @Column
    private String status;

    public class ProjectTeamId implements Serializable {
        private long projectId;
        private long userId;

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            ProjectTeamId that = (ProjectTeamId) o;
            return projectId == that.projectId &&
                    userId == that.userId;
        }

        @Override
        public int hashCode() {
            return Objects.hash(projectId, userId);
        }
    }
}
