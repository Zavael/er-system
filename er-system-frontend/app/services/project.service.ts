import { Injectable } from '@angular/core';
import { Http } from '@angular/http';
import { HeadersService } from '../services';
import { Project, designation, paragraph } from '../models';
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
			projects.push(project);
		}
		return projects;
	}
}