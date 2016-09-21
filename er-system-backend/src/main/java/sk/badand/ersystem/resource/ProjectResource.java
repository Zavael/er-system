package sk.badand.ersystem.resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import sk.badand.ersystem.domain.Project;
import sk.badand.ersystem.domain.ProjectReview;
import sk.badand.ersystem.service.ProjectReviewService;
import sk.badand.ersystem.service.ProjectService;

import javax.servlet.ServletException;

/**
 * Created by abadinka on 21. 9. 2016.
 */
@RestController
@RequestMapping("/api/projects")
public class ProjectResource {

    private final ProjectService projectService;
    private final ProjectReviewService projectReviewService;

    @Autowired
    public ProjectResource(ProjectService projectService, ProjectReviewService projectReviewService) {
        this.projectService = projectService;
        this.projectReviewService = projectReviewService;
    }

    @RequestMapping(method = RequestMethod.POST)
    public Project addProject(@RequestBody Project project) {
        return projectService.create(project);
    }

    @RequestMapping(path = "/{projectId}", method = RequestMethod.PUT)
    public Project updateProject(@PathVariable Long projectId, @RequestBody Project project) throws ServletException {
        if (projectId == null || !projectId.equals(project.getId())){
            throw new ServletException("Wrong attempt to save project. Path variable does not correspond to body entity.");
        }
        return projectService.update(project);
    }

    @RequestMapping(path = "/{projectId}/reviews", method = RequestMethod.POST)
    public ProjectReview addProjectReview(@PathVariable Long projectId, @RequestBody ProjectReview projectReview) throws ServletException {
        if (projectId == null || !projectReview.isReviewOf(projectId)){
            throw new ServletException("Wrong attempt to save project. Path variable does not correspond to body entity.");
        }
        return projectReviewService.addReview(projectReview);
    }


}
