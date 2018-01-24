import { Component, OnInit, Input } from '@angular/core';
import { Review } from '../models';

@Component({
    selector: 'review-list',
    templateUrl: './review-list.component.html'
})
export class ReviewListComponent implements OnInit {
    @Input()
    reviews: Review[];

    constructor() { }

    ngOnInit() { }
}