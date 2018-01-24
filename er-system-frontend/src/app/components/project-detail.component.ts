import { Component, OnInit, Input, Output, EventEmitter } from '@angular/core';
import { Project, ProjectReview } from '../models';
import { ProjectService } from '../services';
import { Router, ActivatedRoute, Params } from '@angular/router';

@Component({
    selector: 'project-detail',
    templateUrl: './project-detail.component.html'
})
export class ProjectDetailComponent implements OnInit {
    project: Project;

    constructor(
        private projectService: ProjectService,
        private route: ActivatedRoute,
        private router: Router) { }

    ngOnInit() {
        this.route.params.forEach((params: Params) => {
            let id = +params['id']; // (+) converts string 'id' to a number
            this.projectService.getProjectDetail(id).subscribe(
                project => this.project = project,
                error => console.error(error));
        });
    }

    goBack(){
        this.router.navigate(['/projects']);
    }

}