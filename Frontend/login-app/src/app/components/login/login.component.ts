import { Component, Inject, OnInit } from '@angular/core';
import { ReactiveFormsModule } from '@angular/forms';
import { LoginService } from 'src/app/services/login.service';


@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

  credentials = {
    userName:'',
    password:''
  }

  
  constructor(private loginService:LoginService) { }

  ngOnInit(): void {
    console.log("checking console");
  }

  onSubmit(){

    if((this.credentials.userName != '' && this.credentials.userName != null) 
    || (this.credentials.password != '' && this.credentials.password != null)){
       console.log("Form was correctly submitted");
          this.loginService.doLogin(this.credentials).subscribe(
            (response:any) =>{
              console.log(response);
                 //console.log(response.token);
                 this.loginService.loginUser(response.token);
                 window.location.href = "/dashboard";
            },
            error =>{
              console.log(error);
            }
          );
    } else{
      console.log("Fields are empty")
    }
  }

}
