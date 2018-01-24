import { Injectable } from '@angular/core';
import { Headers } from '@angular/http'

@Injectable()
export class HeadersService {

    constructor() { }

    getJsonHeaders(token?: string) {
        var headers = new Headers();
        headers.append('Content-Type', 'application/json');
        if (token)
            headers.append('Authorization', 'Bearer ' + token)
        return { headers: headers };
    }

    get publicUrl(): string {
        return "http://localhost:4200/";
    }

    get apiUrl(): string {
        return "http://localhost:8080/api/";
    }
}