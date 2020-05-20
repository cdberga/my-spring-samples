import { Component, OnInit } from '@angular/core';
import { AppService } from './app.service';
import { HttpClient } from '@angular/common/http';

@Component({
  templateUrl: './home.component.html'
})
export class HomeComponent {

  title = 'Demo';
  greeting: any;

  constructor(private app: AppService, private http: HttpClient) {
    http.get('http://localhost:9000').subscribe(data => this.greeting = data);
  }

  authenticated() { return this.app.authenticated; }

}