package sk.badand.ersystem.domain.compositeKeys;

import java.io.Serializable;
import java.util.Objects;

/**
 * Created by abadinka on 20. 9. 2016.
 */
public class ProjectReviewerRevieweeOpinionistId implements Serializable {
    private long projectId;
    private long reviewerId;
    private long revieweeId;
    private long opinionistId;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ProjectReviewerRevieweeOpinionistId that = (ProjectReviewerRevieweeOpinionistId) o;
        return projectId == that.projectId
                && opinionistId == that.opinionistId
                && revieweeId == that.revieweeId
                && reviewerId == that.reviewerId;
    }

    @Override
    public int hashCode() {
        return Objects.hash(projectId, opinionistId, revieweeId, reviewerId);
    }
}
