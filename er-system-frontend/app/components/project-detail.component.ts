import { Component, OnInit, Input, Output, EventEmitter } from '@angular/core';
import { Project, ProjectReview } from '../models';
import { ProjectService } from '../services';

@Component({
    selector: 'project-detail',
    templateUrl: 'app/components/project-detail.component.html'
})
export class ProjectDetailComponent implements OnInit {
    @Input()
    project: Project;
    @Output() onBack = new EventEmitter();

    constructor(private projectService: ProjectService) { }

    ngOnInit() { }

    goBack() {
        this.onBack.emit();
    }

    onNewReviewEvent(project: Project) {
        console.debug("updated project: ", project);
        this.project = project;
        //this.projectService.getProjectDetail(this.project);
    }
}