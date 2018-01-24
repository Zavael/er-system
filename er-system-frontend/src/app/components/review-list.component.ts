import { Component, OnInit, Input } from '@angular/core';
import { ProjectReview } from '../models';
import { LoginService, ProjectService } from '../services';

@Component({
    selector: 'review-list',
    templateUrl: './review-list.component.html'
})
export class ReviewListComponent implements OnInit {
    @Input()
    reviews: ProjectReview[];

    constructor(
        private loginService:LoginService,
        private projectService:ProjectService) { }

    ngOnInit() { }

    onUserAgree(){
        console.debug("onUserAgree");
        //this.projectService.add
    }

    onUserDisagree(){
        console.debug("onUserAgree");
    }
}