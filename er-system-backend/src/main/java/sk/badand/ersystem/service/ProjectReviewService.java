package sk.badand.ersystem.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sk.badand.ersystem.domain.Project;
import sk.badand.ersystem.domain.ProjectReview;
import sk.badand.ersystem.repository.ProjectReviewRepository;

import javax.servlet.ServletException;

/**
 * Created by abadinka on 21. 9. 2016.
 */
@Service
public class ProjectReviewService {

    private final ProjectReviewRepository projectReviewRepository;

    @Autowired
    public ProjectReviewService(ProjectReviewRepository projectReviewRepository) {
        this.projectReviewRepository = projectReviewRepository;
    }

    public ProjectReview addReview(ProjectReview projectReview) throws ServletException {
        if (projectReview.hasProject() && projectReview.hasReviewer()){
            return projectReviewRepository.save(projectReview);
        }

        throw new ServletException("Project review in invalid state!");
    }
}
