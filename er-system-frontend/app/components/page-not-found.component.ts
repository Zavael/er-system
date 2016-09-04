import { Component, OnInit } from '@angular/core';

@Component({
    moduleId: module.id,
    selector: 'page-not-found',
    template: '<div class="ui center aligned column">Page not found.</div>'
})
export class PageNotFoundComponent implements OnInit {
    constructor() { }

    ngOnInit() { }
}