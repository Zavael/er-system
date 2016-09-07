import { Component, OnInit, Input } from '@angular/core';
import { Review } from '../models';

@Component({
    selector: 'reviews',
    templateUrl: 'app/components/reviews.component.html'
})
export class ReviewsComponent implements OnInit {
    @Input()
    reviews: Review[];

    constructor() { }

    ngOnInit() { }
}