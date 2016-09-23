import {Component, OnInit, OnDestroy, Input, Output, EventEmitter } from '@angular/core';
import { ProjectReview, Project } from '../models';
import { LoginService, ProjectService } from '../services';

@Component({
    selector: 'review-add',
    templateUrl: './app/components/review-add.component.html'
})

export class ReviewAddComponent implements OnInit, OnDestroy {
    @Input()
    project: Project;
    review: ProjectReview = new ProjectReview();

    @Output()
    onNewReview = new EventEmitter<Project>();

    constructor(private loginService: LoginService, private projectService: ProjectService) { }

    addReview() {
        console.log('adding review');
        this.review.reviewer = this.loginService.person;
        let proj = this.project;
        this.projectService.addReview(proj, this.review).subscribe(
            result => {
                console.log("review added");
                this.project = result;
                this.onNewReview.emit(this.project);
            },
            error => {
                console.error(error);
            }
        );
        this.review = new ProjectReview();
    }

    ngOnInit() {
        console.log('ngOnInit');
        this.review.reviewer = this.loginService.person;
    }
    ngOnDestroy() { console.log('ngOnDestroy'); }
}