import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { User } from '../user';
import { UserserviceService } from '../_service/userservice.service';

@Component({
  selector: 'app-register-user',
  templateUrl: './register-user.component.html',
  styleUrls: ['./register-user.component.css']
})
export class RegisterUserComponent implements OnInit {
  user:User = new User();
  message: Object;
  constructor(private service:UserserviceService, private router:Router) { }

  ngOnInit(): void {
  }

  
  public userRegister(){
    console.log(this.user)
    this.service.registerUser(this.user).subscribe(data=>{
      alert("Successfully User is registerd")
     },error=>alert("Sorry User not register"));
   }

   dosubmit(){
     this.router.navigate(['/home']);
   }

}

