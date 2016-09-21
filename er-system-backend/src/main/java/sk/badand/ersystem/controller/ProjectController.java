package sk.badand.ersystem.controller;

import com.fasterxml.jackson.annotation.JsonView;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import sk.badand.ersystem.domain.Project;
import sk.badand.ersystem.service.ProjectService;
import sk.badand.ersystem.views.ProjectView;

import java.util.List;

/**
 * Created by abadinka on 20. 9. 2016.
 */
@RestController
@RequestMapping("/projects")
public class ProjectController {

    private final ProjectService projectService;

    public ProjectController(ProjectService projectService) {
        this.projectService = projectService;
    }

    @RequestMapping(method = RequestMethod.GET)
    @JsonView(ProjectView.class)
    public List<Project> getProjects(){
        return projectService.findAllProjects();
    }
}
