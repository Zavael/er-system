package sk.badand.ersystem.controller;

import org.springframework.web.bind.annotation.RestController;
import sk.badand.ersystem.domain.ProjectRepository;

import javax.inject.Inject;

/**
 * Created by abadinka on 28. 6. 2016.
 */
@RestController
public final class ProjectController {

    private final ProjectRepository projectRepository;

    @Inject
    public ProjectController(ProjectRepository projectRepository) {
        this.projectRepository = projectRepository;
    }
}
