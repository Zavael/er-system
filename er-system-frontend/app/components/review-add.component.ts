import {Component, OnInit, OnDestroy, Input, Output, EventEmitter } from '@angular/core';
import { Review, Project, User } from '../models';
import { LoginService } from '../services';

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

    constructor(private loginService: LoginService) { }

    addReview() {
        this.onNewReview.emit(this.review);
    }

    ngOnInit() {
        console.log('ngOnInit');
        this.review.user = this.loginService.user;
    }
    ngOnDestroy() { console.log('ngOnDestroy'); }
}