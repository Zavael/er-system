import { Component, OnInit, Input, Output, EventEmitter } from '@angular/core';
import { Project, Review } from '../models';

@Component({
    selector: 'project-detail',
    templateUrl: './project-detail.component.html'
})
export class ProjectDetailComponent implements OnInit {
    @Input()
    project: Project;
    @Output() onBack = new EventEmitter();

    constructor() { }

    ngOnInit() { }

    goBack() {
        this.onBack.emit();
    }

    onNewReviewEvent(review: Review) {
        console.debug("new review: ", review);
    }
}