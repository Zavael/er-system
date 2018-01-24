import {Component} from '@angular/core';
import { Person } from '../models';
import { RegisterService } from '../services/register.service';

@Component({
  selector: 'register',
  templateUrl: './register.component.html',
  providers: [RegisterService]
})
export class RegisterComponent {
  newPerson: Person = new Person();
  registered: boolean = false;

  /**
   *
   */
  constructor(private registerService: RegisterService) {

  }

  onSubmit() {
    this.registerService.sendPerson(this.newPerson).subscribe(
      data => {
        this.registered = true;
        this.newPerson = new Person();
      },
      error => console.log(error)
    );
  }

}