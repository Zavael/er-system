import {Component} from '@angular/core';
import { User } from '../models/user';
import { RegisterService } from '../services/register.service';

@Component({
  selector: 'register',
  templateUrl: './register.component.html',
  providers: [RegisterService]
})
export class RegisterComponent {
  newUser: User = new User();
  registered: boolean = false;

  /**
   *
   */
  constructor(private registerService: RegisterService) {

  }

  onSubmit() {
    this.registerService.sendUser(this.newUser).subscribe(
      data => {
        console.debug('register success: ' + data);
        this.registered = true;
        this.newUser = new User();
      },
      error => console.log(error)
    );
  }

}