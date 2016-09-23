import { Component, OnInit } from '@angular/core';
import { Project } from '../models';
import { ProjectService } from '../services';
import { Router, ActivatedRoute } from '@angular/router';

@Component({
    selector: 'project-list',
    templateUrl: 'app/components/project-list.component.html'
})
export class ProjectListComponent implements OnInit {
    projects: Project[];

    constructor(
        private projectService: ProjectService,
        private router: Router,
        private route: ActivatedRoute) {
        this.projectService.getAllProjects().subscribe(
            data => this.projects = data,
            error => console.error(error)
        );
    }

    ngOnInit() { console.debug("init"); }

    onSelect(project: Project) {
        this.router.navigate(['/projects', project.id]);
    }
}