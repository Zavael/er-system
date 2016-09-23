import { Component, OnInit, Input } from '@angular/core';
import { ProjectReview } from '../models';

@Component({
    selector: 'review-list',
    templateUrl: 'app/components/review-list.component.html'
})
export class ReviewListComponent implements OnInit {
    @Input()
    reviews: ProjectReview[];

    constructor() { }

    ngOnInit() { }
}