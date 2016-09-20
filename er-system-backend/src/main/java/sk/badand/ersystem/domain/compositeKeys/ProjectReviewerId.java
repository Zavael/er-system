package sk.badand.ersystem.domain.compositeKeys;

import java.io.Serializable;
import java.util.Objects;

/**
 * Created by abadinka on 20. 9. 2016.
 */
public class ProjectReviewerId implements Serializable {
    private long projectId;
    private long userId;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ProjectReviewerId that = (ProjectReviewerId) o;
        return projectId == that.projectId &&
                userId == that.userId;
    }

    @Override
    public int hashCode() {
        return Objects.hash(projectId, userId);
    }
}
