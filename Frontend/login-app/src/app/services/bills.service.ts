import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class BillsService {

  url = "http://localhost:8700/members";

  constructor(private http:HttpClient) { }

  viewBills(memberId:string){
    return this.http.get(`${this.url}/viewBills/${memberId}`);
  }

  getClaims(claimId:string){
    return this.http.get(`${this.url}/getClaimStatus/${claimId}`);
  }

  setClaim(claimDetails:any){
    return this.http.post(`${this.url}/submitClaim/`,claimDetails);
  }


}
