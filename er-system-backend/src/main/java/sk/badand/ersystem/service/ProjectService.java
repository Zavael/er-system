package sk.badand.ersystem.service;

import org.springframework.stereotype.Service;
import sk.badand.ersystem.domain.Project;
import sk.badand.ersystem.domain.ProjectReview;
import sk.badand.ersystem.repository.ProjectRepository;

import java.util.List;

/**
 * Created by abadinka on 20. 9. 2016.
 */
@Service
public class ProjectService {

    private final ProjectRepository projectRepository;

    public ProjectService(ProjectRepository projectRepository) {
        this.projectRepository = projectRepository;
    }

    public List<Project> findAllProjects(){
        return projectRepository.findAll();
    }

    public Project update(Project project) {
        return projectRepository.save(project);
    }

    public Project create(Project project) {
        return projectRepository.save(project);
    }
}
