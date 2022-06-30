import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class LoginService {

  url='http://localhost:8400/auth';

  constructor(private http:HttpClient) { }

 doLogin(credentials:any){
  //generating token from server

   return this.http.post(`${this.url}/login`,credentials);

 }

 healthCheck(){
  
   return this.http.get(`${this.url}/health-check`);
 }



  loginUser(token:string){
    //use token to login user

    localStorage.setItem("token",token);
    return true;
  }

  isLoggedIn(){
    let token = localStorage.getItem("token");
    if(token == undefined || token == null || token === ""){
      return false;
    }

    return true;
  }

  logout(){
    localStorage.removeItem("token");
    return true;
  }

  getToken(){
    return localStorage.getItem("token");
  }


}
