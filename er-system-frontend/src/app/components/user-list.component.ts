import { Component, OnInit, Input } from '@angular/core';
import { User } from '../models';

@Component({
    selector: 'user-list',
    templateUrl: './user-list.component.html'
})
export class UserListComponent implements OnInit {
    @Input()
    users: User[];

    constructor() { }

    ngOnInit() { }
}