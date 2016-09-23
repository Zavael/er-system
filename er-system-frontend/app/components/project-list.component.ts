import { Component, OnInit } from '@angular/core';
import { Project } from '../models';
import { ProjectService } from '../services';

@Component({
    selector: 'project-list',
    templateUrl: 'app/components/project-list.component.html'
})
export class ProjectListComponent implements OnInit {
    projects: Project[];
    selectedProject: Project;

    constructor(private projectService: ProjectService) {
        this.projectService.getAllProjects().subscribe(
            data => this.projects = data,
            error => console.error(error)
        );
    }

    ngOnInit() { console.debug("init"); }

    onSelect(project: Project) {
        this.selectedProject = project;
    }

    onBackEvent() {
        this.selectedProject = null;
    }
}