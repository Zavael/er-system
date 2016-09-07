import { Component, OnInit, Input } from '@angular/core';
import { User } from '../models';

@Component({
    selector: 'user-list',
    templateUrl: 'app/components/user-list.component.html'
})
export class UserListComponent implements OnInit {
    @Input()
    users: User[];

    constructor() { }

    ngOnInit() { }
}