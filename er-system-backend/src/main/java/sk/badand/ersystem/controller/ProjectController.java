package sk.badand.ersystem.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import sk.badand.ersystem.domain.Project;
import sk.badand.ersystem.service.ProjectService;

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
    public List<Project> getProjects(){
        return projectService.findAllProjects();
    }
}
