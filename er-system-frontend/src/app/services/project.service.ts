import { Injectable } from '@angular/core';
import { Http } from '@angular/http';
import { HeadersService, LoginService } from '../services';
import { Project, ProjectReview, designation, paragraph } from '../models';
import {Observable} from 'rxjs/Rx';
import { ErrorUtil } from '../utils';

@Injectable()
export class ProjectService {

	private errorUtil = new ErrorUtil();

    constructor(private http: Http, private headersService: HeadersService, private loginService: LoginService) { }

    public getAllProjects(): Observable<Project[]> {
		console.debug("getAllProjects");
		return this.http
			.get(this.headersService.publicUrl + '/projects', this.headersService.getJsonHeaders())
			.map(res => res.json())
			.catch(this.errorUtil.simpleHandler);
    }

    public getProjectDetail(id: number): Observable<Project> {
		console.debug("getProjectDetail", id);
		return this.http
			.get(this.headersService.publicUrl + '/projects/' + id, this.headersService.getJsonHeaders())
			.map(res => res.json())
			.catch(this.errorUtil.simpleHandler);
    }

	public addReview(project: Project, review: ProjectReview): Observable<Project> {
		console.debug("addReview", review);
		project.projectReviews.push(review);
		return this.http
			.put(this.headersService.apiUrl + '/projects/' + project.id, project, this.headersService.getJsonHeaders(this.loginService.token))
			.map(res => res.json)
			.catch(this.errorUtil.simpleHandler);
	}

	public addReviewAgreement(){
		
	}

	public addReviewDisgreement(){
		
	}

	// private getMockProjects(): Observable<Project[]> {
	// 	let projects: Project[] = [];
	// 	for (var index = 0; index < 7; index++) {
	// 		let project = new Project();
	// 		project.id = index;
	// 		project.name = designation();
	// 		project.description = paragraph(50);
	// 		project.assignedUsers = [];
	// 		for (var i = 0; i < Math.floor(Math.random() * 15); i++) {
	// 			let user = new User();
	// 			user.userName = designation();
	// 			user.password = '';
	// 			new AssignedState();
	// 			user.position = i < 1 ? 'Project Manager' : i < 2 ? 'Analytist' : i < 4 ? 'Senior Developer' : 'Junior Developer';
	// 			project.assignedUsers.push(user);
	// 		}
	// 		project.projectReviews = [];
	// 		for (var i = 0; i < Math.floor(Math.random() * 10); i++) {
	// 			let review = new ProjectReview();
	// 			review.reviewer = project.assignedUsers[Math.floor(Math.random() * project.assignedUsers.length)];
	// 			review.review = paragraph(50);
	// 			project.projectReviews.push(review);
	// 		}
	// 		projects.push(project);
	// 	}
	// 	return Observable.create((subscriber) => {
	// 		subscriber.next(projects);
	// 	});
	// }
}