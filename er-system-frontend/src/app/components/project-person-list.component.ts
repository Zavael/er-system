import { Component, OnInit, Input } from '@angular/core';
import { AssignedPerson } from '../models';

@Component({
    selector: 'project-person-list',
    templateUrl: './project-person-list.component.html'
})
export class ProjectPersonListComponent implements OnInit {
    @Input()
    assignedPersons: AssignedPerson[];

    constructor() { }

    ngOnInit() {

     }
}