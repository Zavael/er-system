package sk.badand.ersystem.domain.compositeKeys;

import java.io.Serializable;
import java.util.Objects;

/**
 * Created by abadinka on 20. 9. 2016.
 */
public class ProjectReviewerRevieweeId implements Serializable {
    private long projectId;
    private long reviewerId;
    private long revieweeId;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ProjectReviewerRevieweeId that = (ProjectReviewerRevieweeId) o;
        return projectId == that.projectId
                && revieweeId == that.revieweeId
                && reviewerId == that.reviewerId;
    }

    @Override
    public int hashCode() {
        return Objects.hash(projectId, revieweeId, reviewerId);
    }
}
