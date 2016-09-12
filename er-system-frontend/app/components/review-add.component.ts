import {Component, OnInit, OnDestroy, Input, Output, EventEmitter } from '@angular/core';
import { Review, Project, User } from '../models';
import { LoginService, ProjectService } from '../services';

@Component({
    selector: 'review-add',
    templateUrl: './app/components/review-add.component.html'
})

export class ReviewAddComponent implements OnInit, OnDestroy {
    @Input()
    project: Project;
    review: Review = new Review();

    @Output()
    onNewReview = new EventEmitter<Review>();

    constructor(private loginService: LoginService, private projectService: ProjectService) { }

    addReview() {
        console.log('adding review');
        this.onNewReview.emit(this.review);
        this.review.author = this.loginService.user;
        let proj = this.project;
        this.projectService.addReview(proj, this.review).subscribe(
            result => {
                console.log("review added");
                this.project = result;
            },
            error => {
                console.error(error);
            }
        );
        this.review = new Review();
    }

    ngOnInit() {
        console.log('ngOnInit');
        this.review.author = this.loginService.user;
    }
    ngOnDestroy() { console.log('ngOnDestroy'); }
}