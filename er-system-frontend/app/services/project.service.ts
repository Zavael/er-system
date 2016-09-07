import { Injectable } from '@angular/core';
import { Http } from '@angular/http';
import { HeadersService } from '../services';
import { Project, User, Review, designation, paragraph } from '../models';
import {Observable} from 'rxjs/Rx';

@Injectable()
export class ProjectService {

    // constructor(private http: Http, private headerService: HeadersService) { }
    constructor(private http: Http) { }

    public getAllProjects() {
        // return this.http
        //     .get(this.headerService.publicUrl + '/projects', this.headerService.getJsonHeaders())
        //     .map(res => res.json());

        return Observable.create((subscriber) => {
			subscriber.next(this.getMockProjects());
		});
    }

	private getMockProjects(): Project[] {
		let projects: Project[] = [];
		for (var index = 0; index < 7; index++) {
			let project = new Project();
			project.name = designation();
			project.description = paragraph(50);
			project.assignedUsers = [];
			for (var i = 0; i < Math.floor(Math.random() * 15); i++) {
				let user = new User();
				user.userName = designation();
				user.password = '';
				user.position = i < 1 ? 'Project Manager' : i < 3 ? 'Senior Developer' : 'Junior Developer';
				project.assignedUsers.push(user);
			}
			project.projectReviews = [];
			for (var i = 0; i < Math.floor(Math.random() * 10); i++) {
				let review = new Review();
				review.userName = designation();
				review.content = paragraph(50);
				project.projectReviews.push(review);
			}
			projects.push(project);
		}
		return projects;
	}
}